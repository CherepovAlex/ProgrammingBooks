package exercise.Vebinar16_25_08_20;

// буферизированные потоки нужны для того, что читать информацию по частям
// повышают производительность
import java.io.*;
// Написать каждую третью строчку
// прочитать файл и запишите все строки, число которых делится на 3, в отдельный файл
// номера строк начинаются с единицы
public class Example15 {

    public static void main(String[] args) {
        // Двойной обратный слеш \\ нужен для экранирования в строке Java.
        String inputPath = "C:\\input.txt";   // задаются пути к входному
        String outputPath = "C:\\output.txt"; // и выходному файлам
            // создает буферизированный читатель для файла - низкоуровневый читатель файла
        try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
            // буферизированный писатель для вывода - низкоуровневый писатель файла
             PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {

            int counter = 1;    // заводим счетчик строк
            String line = in.readLine();    // переменная для чтения строк
            while (line != null) {  // пока не конец файла
                if (counter % 3 == 0) { // если строка 3 по порядку
                    out.println(line);  // то запишем в файл
                }
                counter++;          // обновляем счетчик
                line = in.readLine();   // читаем очередную строку
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
