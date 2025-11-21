package BinarySearch._35SearchInsertPosition;
// Дан отсортированный массив различных целых чисел и целевое значение.
// Если целевое значение найдено, верните индекс.
// Если нет, верните индекс, по которому оно было бы вставлено, если бы его вставили по порядку.
// Вы должны написать алгоритм со сложностью выполнения O(log n) за время.
// Пример 1:
//Входные данные: nums = [1,3,5,6], target = 5
//Выходные данные: 2
//Пример 2:
//Входные данные: nums = [1,3,5,6], target = 2
//Выходные данные: 1
//Пример 3:
//Входные данные: nums = [1,3,5,6], target = 7
//Выходные данные: 4
public class Solution {
    // time O(log n)
    public int searchInsert(int[] nums, int target) {
        int left = 0;   // начальный индекс (0, начало массива)
        int right = nums.length - 1;    // конечный индекс (длина массива - 1, конец массива)

        while (left <= right) { // Цикл выполняется, пока левая граница не превысит правую
            int mid = left + (right - left) / 2;    // Вычисление среднего индекса: для избежания возможного
            if (nums[mid] == target) {              // переполнения при больших значениях индексов
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // это позиция, куда можно вставить целевое значение, сохраняя порядок сортировки.
        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        int target2 = 2;
        int target3 = 7;
        System.out.println(new Solution().searchInsert(nums1, target1));    // 2
        System.out.println(new Solution().searchInsert(nums1, target2));    // 1
        System.out.println(new Solution().searchInsert(nums1, target3));    // 4
    }

}
