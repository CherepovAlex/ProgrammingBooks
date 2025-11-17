package io.hexlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import static java.nio.file.Files.createFile;

// реализовать "try with resources"
public class Main {
    public static void main(String[] args) throws IOException {
        String filepath = "src/main/java/example.txt";
        createFile(Path.of(filepath));

        InputStream input = null;
        Throwable primaryException = null;

        try {
            System.out.println("Попытка чтения файла");
            input = new FileInputStream(filepath);
            int data;
            while ((data = input.read()) != -1) {
                System.out.println((char) data);
            }
            // Происходит ошибка во время чтения и обработки данных из файла, ArithmeticException
            int a = 42 / 0;

        } catch (Throwable t) {
//            System.out.println("Во время чтения файла возникла ошибка:\n" + e.getMessage());
            primaryException = t;
            throw t;
        } finally {
            if (input != null) {
                try {
                    // Происходит ошибка во время закрытия ресурса, например, FileNotFoundException
                    input.close(); throw new FileNotFoundException("ресурс не может быть закрыт");
                } catch (Throwable closeException) {
//                    System.out.println(e.getMessage());
                    primaryException.addSuppressed(closeException);
                }
            }
        }
    }
}