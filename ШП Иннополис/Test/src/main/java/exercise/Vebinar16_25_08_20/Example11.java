package exercise.Vebinar16_25_08_20;
// Эта программа выполняет роль фильтра для текстового файла

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// прочитайте файл и запишите все его содержимое, пропуская любые знаки препинания
// пропустить: ',' '.' '!' '?'
public class Example11 {

    public static void main(String[] args) {
        // Определение путей к входному и выходному файлам
        String inputPath = "C:\\input.txt";
        String outputPath = "C:\\output.txt";

        List<Character> symbols = new ArrayList<>(); // Создается пустой список symbols
        Collections.addAll(symbols, '.', ',', '!', '?');
        // В него добавляются 4 знака препинания, которые нужно удалять
        // try-with-resources гарантирует автоматическое закрытие потоков
        // InputStream - для чтения из входного файла, OutputStream - для записи в выходной файл
        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {
            int data = 0; // читает очередной байт из файла и возвращает его числовое значение
            while ((data = in.read()) >= 0) { // пока не достигнут конец файла (когда read() возвращает -1)
                if (!symbols.contains((char) data)) // преобразует числовое значение в символ
                    out.write(data);                // выводим в файл
            }
            // при наличии ресурсов происходит автоматическое закрытие потока
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
