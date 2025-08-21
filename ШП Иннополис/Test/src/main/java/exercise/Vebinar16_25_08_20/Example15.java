package exercise.Vebinar16_25_08_20;

// буферизированные потоки нужны для того, что читать информацию по частям
// повышают производительность

import java.io.*;

// Написать каждую третью строчку
// прочитать файл и запишите все строки, число которых делится на 3, в отдельный файл
// номера строк начинаются с единицы
public class Example15 {

    public static void main(String[] args) {
        String inputPath = "C:\\input.txt";
        String outputPath = "C:\\output.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {

            int counter = 1;    // заводим счетчик строк
            String line = in.readLine();    // переменную для чтения трок
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
