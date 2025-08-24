package exercise.Vebinar16_25_08_20;
// программа читает текстовый файл C:\input.txt и выводит его содержимое в консоль.
import java.io.FileReader;
import java.io.IOException;

// с потоками символов в программе работают FileReader и FileWriter
public class Example13 {

    public static void main(String[] args) {
        // Двойной обратный слэш \\ нужен, потому что одиночный \ является escape-символом в Java
        String path = "C:\\input.txt"; // Указывает путь к файлу input.txt на диске C:
        try {
            // Scanner reader = new Scanner(new FileInputStream(path));
            // Открывает поток для чтения из файла по указанному пути
            FileReader reader = new FileReader(path); // для чтения символьных потоков из файлов
            int integer = reader.read(); // Метод read() возвращает код прочитанного символа как int
            while (integer >= 0) { // Если достигнут конец файла, возвращает -1, означает "пока прочитан валидный символ"
                // Преобразует числовой код символа обратно в символ с помощью приведения типа (char)
                System.out.print((char) integer);
                integer = reader.read(); // Чтение следующего символа для продолжения цикла
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
