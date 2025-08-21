package exercise.Vebinar16_25_08_20;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class Example7 {

    // Создаем логгер
    private static final Logger log = LoggerFactory.getLogger(Example7.class);

    public static void main(String[] args) {
        String path = "C:\\input.txt";
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(path);
            log.info("File successfully opened: {}", path);

        } catch (IOException e) {
            log.error("Fault open file: {}", path, e);

//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace(); // вывод полного stack trace
        } finally { // код в finally выполнится в любом случае
            log.debug("Blog finally completed");

            // Безопасное закрытие потока
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    log.debug("Stream successfully closed");
                } catch (IOException e) {
                    log.error("Error closing stream", e);
                }
            }
        }
    }
}
