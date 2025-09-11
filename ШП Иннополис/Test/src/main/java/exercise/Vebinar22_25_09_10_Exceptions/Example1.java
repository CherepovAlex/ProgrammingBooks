package exercise.Vebinar22_25_09_10_Exceptions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Example1 {

    public static void main(String[] args) {

        // runtime - может быть не число
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // int number = Integer.parseInt(reader.readLine()); // ???

        // runtime - деление на 0
        int upperNumber = 4;
        int downNumber = 0;
        System.out.println("Result: " + (upperNumber / downNumber)); // ???

        // runtime - выход за границы массива
        int[] resultArray = new int[2];
        resultArray[2] = 0; // ???

        hereWillBeTrouble(42, 0);

    }

    // Exception in thread "main" java.lang.StacjOverflowError
    // стек вызовов переполнился, т.к. мы не указали условие выхода из рекурсии
    static void notGood() {
        System.out.println("Not again!");
        notGood();
    }

    // Exception in thread "main" java.lang.ArithmeticException: / by zero
//         at Main.hereWillBeTrouble(Main.java:8)
//         at Main.main(Main.java:3)
    public static void hereWillBeTrouble(int a, int b) {
        System.out.println("All before...");
        int oops = a / b;
        System.out.println(oops);
        System.out.println("All after...");
    }
}
