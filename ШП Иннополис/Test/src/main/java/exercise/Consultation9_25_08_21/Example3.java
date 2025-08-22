package exercise.Consultation9_25_08_21;
// программа читает текстовый файл в формате CSV (Comma-Separated Values) построчно и
// выводит его содержимое на экран.
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
// Импорт классов из NIO (New Input/Output) API для современной работы с файлами
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
// чтение файла в формате .csv
// BufferedReader - позволяет эффективно читать текст из файла
public class Example3 {

    public static void main(String[] args) throws IOException {
        // Создание объекта Path, который представляет путь к файлу
        // get - статический метод для создания пути
        Path src = Paths.get("C:\\credit_calculator.csv");
        // автоматически закроет BufferedReader после выполнения блока
        // создает BufferedReader для чтения файла, указывает кодировку UTF-8 для правильного чтения символов
        try (BufferedReader bf = Files.newBufferedReader(src, StandardCharsets.UTF_8)) {
            String line;
            // читает следующую строку из файла, условие продолжения цикла (пока есть что читать)
            while ((line = bf.readLine()) != null) {    // пока нет конца текста
                System.out.println(line);
            }
        }
        System.out.print("Конец");
    }

}
