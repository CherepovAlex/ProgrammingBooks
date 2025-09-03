package exercise.Consultation10B_25_09_03;

/*
Задача №1: Нахождение числа в отсортированном списке
Формулировка задачи:Напишите программу, которая находит определённое целое число в отсортированном массиве чисел.
Если число присутствует, программа должна вернуть его индекс; если же оно отсутствует — вывести сообщение об ошибке.
[1, 3, 5, 7, 9]
 */

import java.util.Arrays;

import static java.util.Arrays.binarySearch;

//public static int binarySearch(int[] arr, int target) {
//    int left = 0, right = arr.length - 1;
//
//    while (left <= right) {
//        int mid = left + (right - left) / 2;
//
//        if (arr[mid] == target) return mid;
//        else if (arr[mid] > target) right = mid - 1;
//        else left = mid + 1;
//    }
//
//    return -1;
//}


public class Binar {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9}; // Отсортированный массив
        int targetNumber = 5;                // Целевое число для поиска

        int index = binarySearch(sortedArray, targetNumber); // Выполнение бинарного поиска

        if (index != -1) {
            System.out.println("Индекс числа " + targetNumber + ": " + index);
        } else {
            System.out.println(targetNumber + " не найден в массиве.");
        }
    }}

//    // Классический бинарный поиск
//    private static int binarySearch(int[] arr, int target) {
//        int left = 0;          // Левая граница поиска
//        int right = arr.length - 1; // Правая граница поиска
//
//        while (left <= right) {
//            int mid = left + (right - left) / 2; // Серединный индекс
//
//            if (arr[mid] == target) {
//                return mid; // Нашли число!
//            } else if (arr[mid] < target) {
//                left = mid + 1; // Продолжаем поиск справа
//            } else {
//                right = mid - 1; // Продолжаем поиск слева
//            }
//        }
//
//        return -1; // Число не найдено
//    }
//}