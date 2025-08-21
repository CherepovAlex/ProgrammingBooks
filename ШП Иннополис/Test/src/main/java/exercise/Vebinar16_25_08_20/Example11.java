package exercise.Vebinar16_25_08_20;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// прочитайте файл и запишите все его содержимое, пропуская любые знаки препинания
// пропустить: , . ! ?
public class Example11 {

    public static void main(String[] args) {

        String inputPath = "C:\\input.txt";
        String outputPath = "C:\\output.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {

            int data = 0;
            while ((data = in.read()) >= 0) {
                if (!symbols.contains((char) data)) out.write(data);   // выводим в файл
            }

            // при наличии ресурсов происходит автоматическое закрытие потока
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
