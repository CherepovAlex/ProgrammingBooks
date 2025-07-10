package exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class t4 {
    public static void main(String[] args) {
        String testString = buildTestString();
        String filename = "output.txt";
        writeToFile(testString, filename);
    }
//        String filename = "C:\\Users\\Alex\\Music\\output.txt";
//        String filename = "/Users/Alex/Music/output2.txt";
    public static String buildTestString() {
        "TEST".repeat(400);
        StringBuilder sb = new StringBuilder(4 * 100);
        for (int i = 0; i < 100; i++) {
            sb.append("TEST");
        }
        return sb.toString();
    }

    public static void writeToFile(String content, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("Запись в файл успешно завершена: " + filename);
        } catch (IOException e) {
            System.err.println("Произошла ошибка при записи в файл : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
