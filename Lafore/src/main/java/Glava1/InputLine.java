package Glava1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputLine {

    public static void main(String[] args) throws IOException {
        String s = InputLine.getString();
        System.out.println(s);
    }

    // возвращает строку, введённую пользователем
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // возвращает символ в позиции 0
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    // возвращает пребразование строки к типу int
    public int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    // возвращает объект типа double (аналогично Float)
    public double getDouble() throws IOException {
        String s = getString();
        Double aDub = Double.valueOf(s);    // преобразование в объект типа Double
        return aDub.doubleValue();      // затем в объект типа double
    }



}
