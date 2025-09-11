package exercise.Vebinar22_25_09_10_Exceptions;

import java.awt.datatransfer.MimeTypeParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example4 {
    public static void main(String[] args) {
        new Example4().input();
    }

    // исключения можно писать через | (или)
    public String input() {
        String s = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s = reader.readLine();
            if (s.equals("")) {
                // первым параметром в кастомных исключениях обычно передают сообщение
                // throw служит для генерации исключений
                throw new MyException("String can not be empty!");
            }
        } catch (IOException | MyException e) {
            System.out.println(e.getMessage());
        }
        return s;
    }
}
