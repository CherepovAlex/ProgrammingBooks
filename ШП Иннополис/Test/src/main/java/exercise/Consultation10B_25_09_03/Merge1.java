package exercise.Consultation10B_25_09_03;

/*Задача №1: Сортировка списком покупок
Вы часто сталкиваетесь с ситуацией, когда ваш список продуктов записывается хаотично, и вам нужно организовать его в удобо читаемом виде.
Представьте, что продукты были внесены случайно, и теперь нужно их отсортировать по алфавиту.
["яблоки", "молоко", "хлеб", "сахар", "сыр"]
 */
import java.util.Arrays;

//public static void mergeSort(int[] arr) {
//    if (arr.length > 1) {
//        int middle = arr.length / 2;
//        int[] leftArray = new int[middle];
//        int[] rightArray = new int[arr.length - middle];
//
//        System.arraycopy(arr, 0, leftArray, 0, middle);
//        System.arraycopy(arr, middle, rightArray, 0, arr.length - middle);
//
//        mergeSort(leftArray);
//        mergeSort(rightArray);
//
//        merge(arr, leftArray, rightArray);
//    }
//}
//
//private static void merge(int[] result, int[] left, int[] right) {
//    int i = 0, j = 0, k = 0;
//
//    while (i < left.length && j < right.length) {
//        if (left[i] <= right[j]) {
//            result[k++] = left[i++];
//        } else {
//            result[k++] = right[j++];
//        }
//    }
//
//    while (i < left.length) result[k++] = left[i++];
//    while (j < right.length) result[k++] = right[j++];
//}

public class Merge1 {
    public static void main(String[] args) {
        String[] shoppingList = {"яблоки", "молоко", "хлеб", "сахар", "сыр"};

        mergeSort(shoppingList); // Применяем сортировку слиянием

        System.out.println("Отсортированный список продуктов:");
        for (String item : shoppingList) {
            System.out.println(item);
        }
    }

    // Реализация сортировки слиянием
    public static void mergeSort(String[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2; // Средняя точка массива

            // Создаем два новых массива для левых и правых частей
            String[] leftHalf = Arrays.copyOfRange(arr, 0, mid);
            String[] rightHalf = Arrays.copyOfRange(arr, mid, arr.length);

            // Рекурсивно применяем сортировку слиянием к обеим частям
            mergeSort(leftHalf);
            mergeSort(rightHalf);

            // Сливаем отсортированные части вместе
            merge(arr, leftHalf, rightHalf);
        }
    }

    // Метод слияния двух отсортированных массивов
    private static void merge(String[] arr, String[] left, String[] right) {
        int i = 0, j = 0, k = 0; // Индексы для трёх массивов

        // Сравниваем элементы обоих массивов и помещаем минимальный в итоговый массив
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Дополняем оставшиеся элементы
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}