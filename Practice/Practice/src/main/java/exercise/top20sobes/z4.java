package exercise.top20sobes;

// Напишите программу на Java, чтобы поменять местами значения, хранящиеся в двух переменных,
// без использования третьей переменной.

import java.util.Scanner;

public class z4 {

    public static void main(String args[]) {

        int a, b;

        System.out.println("Введите нужные значения a и b");

        Scanner scannerQ = new Scanner(System.in);


        a = scannerQ.nextInt();

        b = scannerQ.nextInt();


        System.out.println("До обмена значениями\na = " + a + "\nb = " + b);


        a = a + b;

        b = a - b;

        a = a - b;


        System.out.println("После обмена значениями без промежуточной переменной\na = " + a + "\nb = " + b);

    }

}
