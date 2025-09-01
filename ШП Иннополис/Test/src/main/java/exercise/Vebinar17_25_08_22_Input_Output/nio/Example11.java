package exercise.Vebinar17_25_08_22_Input_Output.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// создать директорию и поддиректорию
public class Example11 {

    public static final String NEW_FOLDER = "C:\\newFolder";
    public static final String NEW_SUBFOLDER = NEW_FOLDER + "\\newSubFolder";

    public static void main(String[] args) {
        // создаём маршруты и объекты
        Path path1 = Paths.get(NEW_FOLDER);
        Path path2 = Paths.get(NEW_SUBFOLDER);
        // создаём директории и сразу обе
        try{
            Files.createDirectory(path1); // создаёт папку
            Files.createDirectory(path2); // создаёт папку
            Files.createDirectories(path2); // создаёт сразу все папки
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
