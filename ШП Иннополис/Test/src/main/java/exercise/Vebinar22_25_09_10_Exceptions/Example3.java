package exercise.Vebinar22_25_09_10_Exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example3 {
    public static void main(String[] args) throws MyException {
        new Example3().input();
    }

    // исключения могут быть кастомными и указаны после сигнатуры
    public String input() throws MyException {
        String s = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (s.equals("")) {
            throw new MyException("String can not be empty!");
        }
        return s;
    }
}
