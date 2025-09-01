package exercise.Vebinar17_25_08_22_Input_Output.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

// Копировать файл
public class Example12 {

    public static void main(String[] args) throws IOException {
        // создаём маршруты и объекты
        Path sourceFile = Paths.get("C:\\test.txt");
        Path targetFile = Paths.get("C:\\test_copy.txt");
        // копируем файл                  // если файл есть, то будет заменен
        Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);

    }

}
