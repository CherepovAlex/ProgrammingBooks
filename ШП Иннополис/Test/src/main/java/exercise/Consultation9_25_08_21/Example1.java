package exercise.Consultation9_25_08_21;
// Дан путь к текстовому файлу. Нужно посчитать количество строк, слов и байт
import java.io.BufferedReader;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example1 {

    public static void main(String[] args) throws IOException {
        // если просто файл
        //Path fpathT = Paths.get("C:\\temp.txt");

        // если берём из аргументов командной строки
        Path fpath = Paths.get(args.length > 0 ? args[0] : "C:\\temp.txt");
        // инициализируем
        long lineCount = 0, words = 0, bytes = Files.exists(fpath) ? Files.size(fpath) : 0;
        // поток BufferedReader будет закрыт автоматически при выходе из блока try
        try (BufferedReader br = Files.newBufferedReader(fpath, StandardCharsets.UTF_8)) {
            String line; // берём каждую строку
            while ((line = br.readLine()) != null) {    // пока нет конца текста
                lineCount++;    // считаем количество строк
                // каждую строку по словам вносим в массив
                String[] toks = line.trim().isEmpty() ? new String[0] : line.trim().split("\\s+");
                // складываем в счетчик
                words += toks.length;
            }
        }
        System.out.printf("lineCounts = %d, words = %d, bytes =  %d", lineCount, words, bytes);
    }

}
