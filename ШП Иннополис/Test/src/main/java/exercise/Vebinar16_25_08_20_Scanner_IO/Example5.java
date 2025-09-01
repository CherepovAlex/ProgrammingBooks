package exercise.Vebinar16_25_08_20_Scanner_IO;

import java.util.Scanner;

// Напишите программу, которая считывает три числа.
// Выведите среднее значение из трёх, отформатированное до второй цифры после запятой
public class Example5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double first = scanner.nextDouble();
        double second = scanner.nextDouble();
        double third = scanner.nextDouble();

        double sumAbs = first + second + third;
        double avg = sumAbs / 3;

        System.out.printf("%.2f", avg);

    }

}
