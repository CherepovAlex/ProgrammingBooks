package exercise.Consultation9_25_08_21;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
// скопировать большой файл, показывая прогресс в процентах
public class Example2 {

    public static void main(String[] args) throws IOException {

        Path src = Paths.get("C:\\FastComputer.exe");
        Path dst = Paths.get("C:\\FastComputer_copy.exe");

        long total = Files.size(src);
        long copyed = 0;

        try (InputStream in = Files.newInputStream(src);    // если существует          // обрезать до 0 перед записью
             OutputStream out = Files.newOutputStream(dst, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            byte[] buffer = new byte[8192]; // буфер копирования
            int r;  // количество прочитанных байт в текущей операции
            int lastPct = -1; // переменная текущего прогресса
            while ((r = in.read(buffer)) != -1) {
                out.write(buffer, 0, r);
                copyed += r;
                int pct = (int) ((copyed * 100 / total));
                if (pct != lastPct && pct % 2 == 0) {
                    System.out.printf("Percent: %d%%%n", pct);
                    lastPct = pct;
                }
            }
        }
        System.out.println("Copy finished!");
    }
}
