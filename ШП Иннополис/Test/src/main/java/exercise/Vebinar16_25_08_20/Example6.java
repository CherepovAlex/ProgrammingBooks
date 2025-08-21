package exercise.Vebinar16_25_08_20;

import java.io.FileInputStream;
import java.io.IOException;

public class Example6 {

    public static void main(String[] args) throws IOException {

        String path = "C:\\input.txt";

        FileInputStream fileStream = new FileInputStream(path);

        int oneByte = fileStream.read();

        while (oneByte >= 0) {
            System.out.print((char) oneByte);
            oneByte = fileStream.read();
        }
    }
}
