package exercise.Vebinar16_25_08_20;

import java.io.FileReader;
import java.io.IOException;

// с потоками символов в программе работают FileReader и FileWriter
public class Example13 {

    public static void main(String[] args) {

        String path = "C:\\input.txt";

        try {
            // Scanner reader = new Scanner(new FileInputStream(path));
            FileReader reader = new FileReader(path);
            int integer = reader.read();
            while (integer >= 0) {
                System.out.print((char) integer);
                integer = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
