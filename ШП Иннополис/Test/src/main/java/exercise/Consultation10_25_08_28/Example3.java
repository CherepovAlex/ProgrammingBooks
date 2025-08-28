package exercise.Consultation10_25_08_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// 1.Реализовать алгоритм сортировки слиянием
//2.Пусть дан произвольный список целых чисел, удалить из него четные числа
//3.Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
//Формат сдачи: файл с расширением java или ссылка на гит с подписанными ФИ и номером группы.
public class Example3 {

    public static void main(String[] args) {

        // 1.Реализовать алгоритм сортировки слиянием
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(MergeSort.mergeSort(array)));

        //2.Пусть дан произвольный список целых чисел, удалить из него четные числа
        //38, 27, 43, 3, 9, 82, 10

        List<Integer> list = new ArrayList<>(List.of(38, 27, 43, 3, 9, 82, 10));

        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            int number = iter.next();
            if (number % 2 == 0) {
                iter.remove();
            }
        }
        System.out.println("List after remove even numbers: " + list);

        //3.Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

        List<Integer> list2 = new ArrayList<>(List.of(10, 20, 30));

        int min = list2.get(0);
        int max = list2.get(0);
        int sum = 0;

        for (int num : list2) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            sum += num;
        }
        System.out.println("Average value: " + (float) sum/list2.size());
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}

class MergeSort {

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) return array;

        int mid = array.length / 2;

        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);

    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, k = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }
}
