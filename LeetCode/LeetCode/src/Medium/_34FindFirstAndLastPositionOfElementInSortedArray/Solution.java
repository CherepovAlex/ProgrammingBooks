package Medium._34FindFirstAndLastPositionOfElementInSortedArray;

import java.util.Arrays;

// 34. Найдите первую и последнюю позиции элемента в отсортированном массиве
// Дан массив целых чисел nums, отсортированный в порядке неубывания. Найдите начальную и конечную позиции заданного
// значения target.
// Если target не найден в массиве, верните [-1, -1].
// Вы должны написать алгоритм со сложностью выполнения O(log n) за время.
// Example 1:
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//Example 2:
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
//Example 3:
//Input: nums = [], target = 0
//Output: [-1,-1]
public class Solution {
    // time O(log n), space O(1)
    public int[] searchRange(int[] nums, int target) {
        // Ищем первую позицию элемента target в массиве
        int first = findFirstPosition(nums, target);
        // Ищем последнюю позицию элемента target в массиве
        int last = findLastPosition(nums, target);
        // Возвращаем массив с найденными позициями
        return new int[]{first, last};
    }

    private int findFirstPosition(int[] nums, int target) {
        // Инициализируем левую границу поиска
        int left = 0;
        // Инициализируем правую границу поиска
        int right = nums.length - 1;
        // Инициализируем переменную для хранения результатов
        int first = -1;

        // Пока левая граница не превысила правую
        while (left <= right) {
            // Находим средниц индекс между left и right
            int mid = left + (right - left) / 2;

            // Если средний элемент равен целевому значению
            if (nums[mid] == target) {
                // Сохраняем позицию как первую найденную
                first = mid;
                // Сдвигаем правую границу для поиска более раннего вхождения
                right = mid - 1;
            }
            // Если средний элемент меньше целевого значения
            else if (nums[mid] < target) {
                // Сдвигаем левую границу вправо
                left = mid + 1;
            }
            // Если средний элемент больше целевого значения
            else {
                // Сдвигаем правую границу влево
                right = mid - 1;
            }
        }
        // Возвращаем первую позицию элемента ( или -1 если не найден)
        return first;
    }

    private int findLastPosition(int[] nums, int target) {
        // Инициализируем левую границу поиска
        int left = 0;
        // Инициализируем правую границу поиска
        int right = nums.length - 1;
        // Инициализируем переменную для хранения результата
        int last = -1;

        // пока левая граница не превысила правую
        while (left <= right) {
            // Находим средний индекс между left и right
            int mid = left + (right - left) / 2;

            // Если средний элемент равен целевому значению
            if (nums[mid] == target) {
                // Сохраняем позицию как последнюю найденную
                last = mid;
                // Сдвигаем левую границу для поиска более позднего вхождения
                left = mid + 1;
            }
            // Если средний элемент меньше целевого значения
            else if (nums[mid] < target) {
                // Сдвигаем левую границе вправо
                left = mid + 1;
            }
            // Если средний элемент больше целевого значения
            else {
                // Сдвигаем правую границу влево
                right = mid - 1;
            }
        }
        // Возвращаем последнюю позицию элементы (или -1 если не найден)
        return last;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        System.out.println(Arrays.toString(new Solution().searchRange(nums, target)));
    }
}
