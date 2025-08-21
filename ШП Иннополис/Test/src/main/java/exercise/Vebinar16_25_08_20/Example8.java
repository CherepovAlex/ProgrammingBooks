package exercise.Vebinar16_25_08_20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example8 {
    private static final Logger log = LoggerFactory.getLogger(Example7.class);

    public static void main(String[] args) {
        String inputPath = "C:\\input.txt";
        String outputPath = "C:\\output.txt";

        try (FileInputStream inputStream = new FileInputStream(inputPath);
             FileOutputStream outputStream = new FileOutputStream(outputPath)) {
            log.info("Files successfully opened: {}", inputPath);

            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);   // выводим в файл
                System.out.print((char) data); // преобразуем байт в символ и выводим
            }

        // при наличии ресурсов происходит автоматическое закрытие потока
        } catch (IOException e) {
            log.error("File operation error: {}", inputPath, e);
        } finally {
            log.debug("Operation completed");
        }
    }
}