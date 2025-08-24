package exercise.Vebinar16_25_08_20;
// Эта программа читает и выводит на экран содержимое текстового файла input.txt,
// расположенного по пути C:\input.txt
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Example9 {

    public static void main(String[] args) throws IOException {
        // Создает строку с путем к файлу, \\ - экранирование обратного слеша в Java-строках
        String path = "C:\\input.txt";
        // создает поток для чтения из указанного файла, Автоматическое управление ресурсами
        // FileInputStream - класс для чтения байтов из файла
        // InputStream - абстрактный класс, родитель всех классов входных потоков
        try (InputStream fileStream = new FileInputStream(path)) {
            // читает один байт из файла, возвращает значение байта (0-255) или -1 если достигнут конец файла
            int oneByte = fileStream.read();
            // Условие:пока прочитанный байт не равен -1(конец файла), >= 0 означает, что байт успешно прочитан
            while (oneByte >= 0) {  // преобразует числовое значение байта в символ
                System.out.print((char) oneByte);
                // чтение следующего байта для следующей итерации цикла
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // finally не будет
        // т.к. потоки при наличиии ресурсов автоматически закрываются
    }
}
