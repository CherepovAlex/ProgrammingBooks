package exercise.Vebinar16_25_08_20_Scanner_IO;
// Эта программа представляет собой побайтовый копировщик файлов
// Использует низкоуровневые потоки ввода-вывода (FileInputStream/FileOutputStream)
//Работает с любыми типами файлов (текстовыми, бинарными)
//Автоматически закрывает ресурсы с помощью try-with-resources
//Ведет логирование операций и ошибок
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// Низкая производительность при больших файлах
// Для улучшения производительности лучше использовать буферизированные потоки
// (BufferedInputStream/BufferedOutputStream).
public class Example8 {
    // Создаем статический final-логгер с именем класса для идентификации
    private static final Logger log = LoggerFactory.getLogger(Example8.class);

    public static void main(String[] args) {
        String inputPath = "C:\\input.txt";     // входной файл
        String outputPath = "C:\\output.txt";   // выходной файл
        // Try-with-resources - современная конструкция Java, которая автоматически закроет оба потока после
        // выполнения блока try, даже если возникнет исключение.
        try (FileInputStream inputStream = new FileInputStream(inputPath);
             FileOutputStream outputStream = new FileOutputStream(outputPath)) {
            // Запись в лог информационного сообщения об успешном открытии файлов.
            log.info("Files successfully opened: {}", inputPath);

            int data; // Объявление переменной для хранения прочитанных данных.
            while ((data = inputStream.read()) != -1) { // читает один байт и возвращает его как int.
                outputStream.write(data);   // Запись прочитанного байта, выводим в файл
                // Преобразование в char может некорректно работать с не-ASCII символами
                System.out.print((char) data); // преобразуем байт в символ и выводим
                // Важно: для бинарных файлов это может вывести "мусор".
            }
        // при наличии ресурсов происходит автоматическое закрытие потока
        } catch (IOException e) {
            // Запись сообщения об ошибке в лог с указанием пути к файлу и самого исключения.
            log.error("File operation error: {}", inputPath, e);
        } finally {
            // Сообщение уровня DEBUG записывается в лог.
            log.debug("Operation completed");
        }
    }
}