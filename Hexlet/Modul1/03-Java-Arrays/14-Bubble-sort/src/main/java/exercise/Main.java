// Алгоритм - сортировка пузырьком.
// Реализуйте публичный статический метод bubbleSort(), который сортирует переданный массив целых чисел,
// используя алгоритм пузырьковой сортировки. Метод изменяет переданный массив. Постарайтесь не подглядывать
// в текст теории и попробуйте воспроизвести алгоритм по памяти.
package exercise;

import java.util.Arrays;

public class Main {

    public static void bubbleSort(int[] items) {
        var stepsCount = items.length - 1;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < stepsCount; i++) {
                if (items[i] > items[i + 1]) {
                    var temp = items[i + 1];
                    items[i + 1] = items[i];
                    items[i] = temp;
                    swapped = true;
                }
            }
            stepsCount--;
        } while (swapped);
    }

    public static void main(String[] args) {
        int[] numbers = {3, 2, 10, -2, 0};
        Main.bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers)); // =>[-2, 0, 2, 3, 10]

        int[] numbers1 = {};
        Main.bubbleSort(numbers1);
        System.out.println(Arrays.toString(numbers1)); // => []

        int[] numbers2 = {3, 10, 4, 3};
        Main.bubbleSort(numbers2);
        System.out.println(Arrays.toString(numbers2)); // => [3, 3, 4, 10]
    }
}