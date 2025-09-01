package exercise.Vebinar17_25_08_22_Input_Output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

// нужно прочитать текстовый файл, отсортировать его строки
// и записать в другой текстовый файл
// использовать пути и классы файлов
public class Example4 {

    public static void main(String[] args) {

        Path path = Paths.get("C:\\input.txt");
        Path output = Paths.get("C:\\output.txt");
        // без ресурсов
        try {
            List<String> lines = Files.readAllLines(path);
            // не используйте для больших файлов
            Collections.sort(lines); // сортировка строк
            Files.write(output, lines);
            System.out.println("Files successfully wrote.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
