package Medium._33SearchinRotatedSortedArray;
// Модифицированный бинарный поиск
// Дан целочисленный массив nums, отсортированный в порядке возрастания (с отличными значениями).
//Перед передачей в вашу функцию nums возможно, будет повернут влево по неизвестному индексу k (1 <= k < nums.length),
// так что результирующий массив будет
// [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (с индексацией от 0).
// Например, [0,1,2,4,5,6,7] может быть повернут влево на 3 индексов и стать [4,5,6,7,0,1,2].
//Для массива nums после возможного поворота и целого числа target верните индекс target, если он есть в nums,
// или -1, если его там нет в nums.
//Вы должны написать алгоритм со сложностью выполнения O(log n) за время.
// Example 1:
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//Example 2:
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
//Example 3:
//Input: nums = [1], target = 0
//Output: -1
public class Solution {
    /*
    4, 5, 6, 7, 0, 1, 2; target = 0
    left side of the pivot is 4 <= x <= 7 true
    right side of the pivot is 0 <= x <= 2 false

    6, 7, 0, 1, 2, 4, 5; target = 3
    1 <= 5 == true
    6 <= 1 == false

    time O(2*logn)
     */
    // time O(logn), space O(1)
    public int search(int[] nums, int target) {

        int n = nums.length, low = 0, high = n - 1;
        // Начало цикла бинарного поиска. Цикл продолжается, пока диапазон поиска не станет пустым.
        while (low <= high) {
            int mid = low + (high - low) / 2; // Вычисление среднего индекса, предотвращает переполнение
            if (nums[mid] == target) { // Если средний элемент равен целевому значению
                return mid;            // то сразу возвращаем его индекс.
            }
            // Ключевая проверка: определяет, находится ли левая половина [low, mid] в отсортированном порядке (без разрыва)
            if (nums[low] <= nums[mid]) {
                // Если левая половина отсортирована:
                // Если target находится в диапазоне [nums[low], nums[mid]), ищем в левой половине
                // Иначе ищем в правой половине
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                // Если левая половина НЕ отсортирована (значит, правая половина отсортирована).
            } else { // Если правая половина отсортирована:
                // Если target находится в диапазоне (nums[mid], nums[high]], ищем в правой половине
                // Иначе ищем в левой половине
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        } // Если цикл завершился, но target не найден, возвращаем -1.
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(new Solution().search(nums, target));

    }

}
