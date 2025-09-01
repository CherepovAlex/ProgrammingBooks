package exercise.Vebinar16_25_08_20_Scanner_IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// вам передан файл
// прочитайте и распечатайте все его содержимое в виде последовательности байтов
// распечатайте в консоли только выходные данные
public class Example10 {

    public static void main(String[] args) {

        String path = "C:\\input.txt";

        try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();

            while (oneByte >= 0) { // -1 означает конец файла (EOF - End Of File)
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
