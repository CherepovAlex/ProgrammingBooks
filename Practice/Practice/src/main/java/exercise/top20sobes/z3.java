package exercise.top20sobes;

// Напишите программу на Java для того, чтобы поменять местами значения,
// хранящиеся в двух переменных с помощью третьей переменной

import java.util.Scanner;

public class z3 {

    public static void main(String[] args) {

        // ITVDN.com 3 из ТОП 20 тестовых заданий на интервью для Java разработчика

        int a, b, temp;

        System.out.println("Введите значения a и b");

        Scanner scannerQ = new Scanner(System.in);

        a = scannerQ.nextInt();

        b = scannerQ.nextInt();

        System.out.println("До обмена значениями " + a + b);

        temp = a;

        a = b;

        b = temp;

        System.out.println("После обмена значениями " + a + b);


    }
}
