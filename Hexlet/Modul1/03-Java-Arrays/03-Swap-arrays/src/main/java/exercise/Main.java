//Допишите публичный статический метод swap(), который принимает на вход массив целых чисел и меняет местами
// первый и последний элемент в переданном массиве. Если массив содержит меньше двух элементов, то он не меняется.
//Подсказки: количество элементов остаётся прежним, поэтому ArrayUtils можно не использовать
package exercise;

import java.util.Arrays;

public class Main {
    public static void swap(int[] numbers) {
        // BEGIN
        var length = numbers.length;
        if (length < 2) {
            return;
        }
        var lastIndex = length - 1;
        var temp = numbers[lastIndex];
        numbers[lastIndex] = numbers[0];
        numbers[0] = temp;
        // END
    }

    public static void main(String[] args) {
        int[] numbers1 = {3};
        Main.swap(numbers1);
        System.out.println(Arrays.toString(numbers1)); // => [3]

        int[] numbers2 = {1, 2, 3, 4};
        Main.swap(numbers2);
        System.out.println(Arrays.toString(numbers2)); // => [4, 2, 3, 1]
    }
}