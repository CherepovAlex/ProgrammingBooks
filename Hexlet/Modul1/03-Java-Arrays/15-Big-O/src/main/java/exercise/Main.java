// Реализуйте публичный статический метод getIntersectionOfSortedArrays(), который принимает на вход два
// отсортированных массива целых чисел и находит их пересечение. Пересечение двух массивов A и B — это массив
// только с теми элементами A и B, которые одновременно принадлежат обоим массивам, без дублей.
//Алгоритм
//Поиск пересечения двух неотсортированных массивов — операция, в рамках которой выполняется вложенный цикл
// с полной проверкой каждого элемента первого массива на вхождение во второй.
//Сложность данного алгоритма O(n * m) (произведение n и m), где n и m — размерности массивов. Если массивы
// отсортированы, то можно реализовать алгоритм, сложность которого уже O(n + m), что значительно лучше.
//Суть алгоритма довольно проста. В коде вводятся два указателя (индекса) на каждый из массивов. Начальное значение
// каждого указателя 0. Затем идёт проверка элементов, находящихся под этими индексами в обоих массивах. Если они
// совпадают, то значение заносится в результирующий массив, а оба индекса инкрементируются. Если значение в
// первом массиве больше, чем во втором, то инкрементируется указатель второго массива, иначе — первого.
// Подсказки
//При работе вам может понадобиться метод Arrays.copyOf(), который позволяет скопировать первые несколько элементов массива
//Как скопировать массив
package exercise;

import java.util.Arrays;

public class Main {
    // BEGIN
    public static int[] getIntersectionOfSortedArrays(int[] numbers1, int[] numbers2) {
        var size1 = numbers1.length;
        var size2 = numbers2.length;

        var elementsCount = Math.min(size1, size2);
        var result = new int[elementsCount];

        var i1 = 0;
        var i2 = 0;
        var index = 0;

        while (i1 < size1 && i2 < size2) {
            // Если элементы совпадают
            if (numbers1[i1] == numbers2[i2]) {
                // и если такой же элемент еще не был добавлен в массив
                if (index == 0 || numbers1[i1] != result[index - 1]) {
                    // Добавляем его в результат
                    result[index] = numbers1[i1];
                    index++;
                    // Если такой элемент уже есть в результате, то ничего не добавляем
                }
                // Перемещаем указатели в обоих массивах в любом случае
                i1++;
                i2++;

            } else if (numbers1[i1] > numbers2[i2]) {
                i2++;
            } else {
                i1++;
            }
        }

        return Arrays.copyOf(result, index);
    }

    // END
    public static void main(String[] args) {

        int[] numbers1 = {10, 11, 24};
        int[] numbers2 = {10, 13, 14, 18, 24, 30};
        var result1 = Main.getIntersectionOfSortedArrays(numbers1, numbers2);
        System.out.println(Arrays.toString(result1)); // => [10, 24]

        int[] numbers3 = {10, 11, 24};
        int[] numbers4 = {-2, 3, 4};
        var result2 = Main.getIntersectionOfSortedArrays(numbers3, numbers4);
        System.out.println(Arrays.toString(result2)); // => []

        int[] numbers5 = {10, 10, 13, 14, 18, 24, 24, 30};
        int[] numbers6 = {10, 10, 11, 24, 24};
        int[] result3 = Main.getIntersectionOfSortedArrays(numbers5, numbers6);
        System.out.println(Arrays.toString(result3)); // => {10, 24};
    }
}