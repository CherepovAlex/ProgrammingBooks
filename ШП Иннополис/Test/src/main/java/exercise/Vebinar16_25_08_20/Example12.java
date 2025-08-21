package exercise.Vebinar16_25_08_20;

import java.io.*;

public class Example12 {

    public static void main(String[] args) {

        String input = "C://input.txt";
        String output = "C://output.txt";

        try (InputStream in = new FileInputStream(input);
             OutputStream out = new FileOutputStream(output)) {

            int oneByte = 0;

            while ((oneByte = in.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
