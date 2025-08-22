package exercise.Vebinar16_25_08_20;
// программа выполняет фильтрацию целых чисел из текстового файла.
import java.io.*;
import java.util.Scanner;
// Получить число из потока
// прочитать файл и извлечь все целые числа в отдельный файл
// получить только те числа, которые не являются частью слова
// вывести только выходные данные программы
public class Example14 {

    public static void main(String[] args) {
        // \\ - экранирование обратного слеша в путях Windows
        String inputPath = "C:\\input.txt";         // путь к входному файлу
        String outputPath = "C:\\output.txt";       // путь к выходному файлу
        // Ресурсы автоматически закроются после выполнения блока try
            // создает сканер для чтения из файла input.txt
        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             // создает писатель для записи в файл output.txt
             PrintWriter out = new PrintWriter(new FileOutputStream(outputPath))) {
            // Пока в сканере есть следующие токены (слова/числа), продолжать чтение
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) // проверяет, является ли следующий токен целым числом
                    out.println(scanner.nextInt()); //читает это число и out.println() записывает его в файл
                scanner.next(); // Читает следующий токен (слово или число), чтобы продвинуть сканер вперед
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
