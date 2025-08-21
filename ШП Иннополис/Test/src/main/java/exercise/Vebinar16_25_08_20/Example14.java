package exercise.Vebinar16_25_08_20;

import java.io.*;
import java.util.Scanner;

// Получить число из потока
// прочитать файл и извлечь все целые числа в отдельный файл
// получить только те числа, которые не являются частью слова
// вывести только выходные данные программы
public class Example14 {

    public static void main(String[] args) {
        String inputPath = "C:\\input.txt";
        String outputPath = "C:\\output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter out = new PrintWriter(new FileOutputStream(outputPath))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt())
                    out.println(scanner.nextInt());
                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
