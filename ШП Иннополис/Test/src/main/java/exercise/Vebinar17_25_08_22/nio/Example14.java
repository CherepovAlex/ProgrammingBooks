package exercise.Vebinar17_25_08_22.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// прочитать и вывести содержимое файла
public class Example14 {

    public static void main(String[] args) {
        // задаём объект и путь для чтения
        Path path = Paths.get("C:\\test.txt");
        // создает BufferedReader для чтения файла, указывает кодировку UTF-8 для корректного чтения текста
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            // Объявление переменной для хранения текущей прочитанной строки
            String currentLine;
            // reader.readLine() читает очередную строку из файла
            // Проверяет, не является ли прочитанная строка null (конец файла)
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
