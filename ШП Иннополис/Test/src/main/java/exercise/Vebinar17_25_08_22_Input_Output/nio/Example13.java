package exercise.Vebinar17_25_08_22_Input_Output.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

// перенос файл в папку
public class Example13 {
    // задаём маршруты
    private static final String SOURCE_PATH = "C:\\test_copy.txt";
    private static final String TARGET_PATH = "C:\\newSubFolder\\test1.txt";

    public static void main(String[] args) throws IOException {
        // создаём объекты
        Path sourcePath = Paths.get(SOURCE_PATH);
        Path targetPath = Paths.get(TARGET_PATH);
        // выполняем перенос
        Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

    }

}
