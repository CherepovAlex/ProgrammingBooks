package exercise.Vebinar16_25_08_20;
// демонстрирует безопасное открытие и закрытие файла
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class Example7 {

    // Создаем логгер с именем класса для идентификации
    private static final Logger log = LoggerFactory.getLogger(Example7.class);

    public static void main(String[] args) {
        // Определение пути к файлу (двойной обратный слеш - экранирование в Java)
        String path = "C:\\input.txt";
        // Объявление переменной для файлового потока с инициализацией null
        FileInputStream fileInputStream = null;
        // попытка выполнить код, который может вызвать исключение
        try { // Создание FileInputStream для чтения файла по указанному пути
            fileInputStream = new FileInputStream(path);
            // Логирование успешного открытия файла (уровень INFO)
            log.info("File successfully opened: {}", path); // {} - placeholder для подстановки значения переменной path
            // обработка исключений типа IOException
        } catch (IOException e) {
            log.error("Fault open file: {}", path, e);
//            альтернативные способы обработки ошибок (вывод в консоль)
//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace(); // вывод полного stack trace
        } finally { // код в finally выполнится в любом случае
            log.debug("Blog finally completed"); // Логирование отладочного сообщения о входе в блок finally (уровень DEBUG)

            // Безопасное закрытие потока. Проверка, что поток был успешно создан (не равен null)
            if (fileInputStream != null) {
                try {   // Закрытие файлового потока и освобождение ресурсов
                    fileInputStream.close();
                    log.debug("Stream successfully closed"); // Логирование успешного закрытия потока
                } catch (IOException e) {
                    log.error("Error closing stream", e);   // Логирование ошибки закрытия потока
                }
            }
        }
    }
}
