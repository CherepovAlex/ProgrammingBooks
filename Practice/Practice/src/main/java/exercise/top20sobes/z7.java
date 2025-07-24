package exercise.top20sobes;

import java.util.Scanner;

// Напишите программу на Java, чтобы узнать, является ли число простым или нет.
public class z7 {

    public static void main(String[] args) {

        int tempNumber, number;

        boolean numberIsPrime = true;

        Scanner scannerQ = new Scanner(System.in);

        number = scannerQ.nextInt();

        scannerQ.close();

        for (int x = 2; x <= number / 2; x++) {

            tempNumber = number % x;

            if (tempNumber == 0) {

                numberIsPrime = false;

                break;

            }

        }

        if (numberIsPrime)

            System.out.println(number + " число является простым");

        else

            System.out.println(number + " число не является простым");


    }

}
