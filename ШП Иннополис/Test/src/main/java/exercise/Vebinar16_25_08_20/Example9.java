package exercise.Vebinar16_25_08_20;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Example9 {

    public static void main(String[] args) throws IOException {

        String path = "C:\\input.txt";

        try (InputStream fileStream = new FileInputStream(path)) {

            int oneByte = fileStream.read();

            while (oneByte >= 0) {
                System.out.print((char) oneByte);
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // finally не будет
        // т.к. потоки при наличиии ресурсов автоматически закрываются
    }

}
