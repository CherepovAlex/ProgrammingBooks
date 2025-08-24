package exercise.Vebinar17_25_08_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Example3 {

    public static void main(String[] args) {
        // Files предоставляет служебные методы для простого манипулирования файлами
        Path inPath = Paths.get("D:\\input.txt");
        Path outPath = Paths.get("D:\\output.txt");

        try (BufferedReader br = Files.newBufferedReader(inPath)) {
            // помещаем всё прочитанное содержимое inPath (читаем все строки)
            List<String> lines = Files.readAllLines(inPath);
            // записываем содержимое lines в outPath
            Files.write(outPath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
