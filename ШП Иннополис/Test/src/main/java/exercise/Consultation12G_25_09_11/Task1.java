package exercise.Consultation12G_25_09_11;

import java.io.FileInputStream;

public class Task1 {
    // Задача 1 Базовое понимание Checked/Unchecked
    public static void main(String[] args) throws Exception {
        // 1 example
        FileInputStream fileInputStream = new FileInputStream("file.txt");

    }
}

// Exception in thread "main" java.io.FileNotFoundException: file.txt (�� ������� ����� ��������� ����)
//	at java.base/java.io.FileInputStream.open0(Native Method)
//	at java.base/java.io.FileInputStream.open(FileInputStream.java:213)
//	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:152)
//	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:106)
//	at exercise.Consultation12G_25_09_11.Task1.main(Task1.java:9)