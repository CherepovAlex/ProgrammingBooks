package exercise.Vebinar17_25_08_22_Input_Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example2 {

    public static void main(String[] args) {
        // представление пути в java
        Path path = Paths.get("C:\\input.txt");
        // статические методы для создания потоков
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            // работа с файлом
        } catch (IOException e) {
            e.printStackTrace(); // обработка Exception
        }
    }
}
