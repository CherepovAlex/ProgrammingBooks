package exercise.Vebinar16_25_08_20;
// программа читает файл побайтово (как последовательность байтов) и выводит в консоль
// бинарное представление каждого байта (в виде последовательности нулей и единиц).
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// вам передан файл
// прочитайте и распечатайте все его содержимое в виде последовательности байтов
// распечатайте в консоли только выходные данные
public class Example10 {

    public static void main(String[] args) {
        // Создает строку с путем к файлу input.txt на диске C:
        String path = "C:\\input.txt";
        // создает поток для чтения байтов из указанного файла
        try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read(); // читает один байт из файла
            // Возвращает int (0-255) если байт прочитан, или -1 если достигнут конец файла
            while (oneByte >= 0) {  // словие: пока прочитанное значение ≥ 0 (то есть не -1, не конец файла)
// форматированный вывод строки с пробелом после нее // конвертирует число в строку с двоичным представлением
                System.out.printf("%s ", Integer.toBinaryString(oneByte)); // байт 65 (буква 'A') - "1000001"
                oneByte = in.read(); // Считывает следующий байт из файлаб, обновляет значение переменной
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
