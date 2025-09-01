package exercise.Vebinar17_25_08_22_Input_Output.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// создать файл с названием test.txt
public class Example10 {

    public static void main(String[] args) {
        // пишем адрес, где будет создан файл
        Path path = Paths.get("test.txt");

        try { // создаём файл
            Path createdFile = Files.createFile(path);

            System.out.println("File created successfully: " + createdFile);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());

        }
    }

}
