package exercise.Consultation10B_25_08_30;

import java.util.Random;
import java.util.Scanner;

//public static int[] generateRandomArray(int size, int minValue, int maxValue) {
//    Random random = new Random();
//    int[] array = new int[size];
//
//    for (int i = 0; i < size; i++) {
//        array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
//    }
//
//    return array;
//}

public class GenMassive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размера массива
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        // Ввод минимального и максимального значений
        System.out.print("Введите минимальное значение: ");
        int minValue = scanner.nextInt();

        System.out.print("Введите максимальное значение: ");
        int maxValue = scanner.nextInt();

        // Генерируем случайный массив
        int[] randomArray = generateRandomArray(size, minValue, maxValue);

        // Выводим полученный массив
        System.out.print("Случайный массив: ");
        printArray(randomArray);
    }

    // Метод для генерации случайного массива
    private static int[] generateRandomArray(int size, int minValue, int maxValue) {
        Random random = new Random();
        int[] array = new int[size];

        // Заполняем массив случайными числами
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt((maxValue - minValue) + 1) + minValue;
        }

        return array;
    }

    // Метод для печати массива
    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}