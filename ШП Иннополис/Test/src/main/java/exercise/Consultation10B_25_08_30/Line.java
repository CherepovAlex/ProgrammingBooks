package exercise.Consultation10B_25_08_30;
import java.util.Scanner;
/*
Задача №1: Сумма чётных чисел в диапазоне. Напишите программу,
которая выводит сумму всех четных чисел в заданном диапазоне от A до B включительно.
Два целых числа a и b, где a ≤ b. Например, введённые вручную: 10 20 */

//public static int linearSearch(int[] arr, int target) {
//    for (int i = 0; i < arr.length; i++) {
//        if (arr[i] == target) return i;
//    }
//    return -1;
//}

public class Line {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите начальное число:");
        int start = scanner.nextInt(); // Число A
        System.out.println("Введите конечное число:");
        int end = scanner.nextInt();   // Число B
        // реализация линейного алгоритма
        int sum = 0;                   // Начальная сумма равна 0

        // Начинаем с первого четного числа в диапазоне
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {          // Проверяем, четное ли число?
                sum += i;               // Если да, добавляем к сумме
            }
        }
        System.out.println("Сумма четных чисел в диапазоне [" + start + ", " + end + "] равна: " + sum);
    }
}