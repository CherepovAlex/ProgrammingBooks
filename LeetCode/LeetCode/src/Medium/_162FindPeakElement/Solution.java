package Medium._162FindPeakElement;

// Пиковый элемент — это элемент, который строго больше своих соседей.
//Дан целочисленный массив с индексацией от 0nums, найдите максимальный элемент и верните его индекс.
// Если в массиве несколько максимальных элементов, верните индекс любого из них.
//Вы можете представить, что nums[-1] = nums[n] = -∞. Другими словами, элемент всегда считается строго большим,
// чем соседний элемент, находящийся за пределами массива.
//Вы должны написать алгоритм, который выполняется за O(log n) времени.
// Example 1:
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index number 2.
//Example 2:
//Input: nums = [1,2,1,3,5,6,4]
//Output: 5
//Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
public class Solution {
    // time O(log n)
    public int findPeakElement(int[] nums) {
        // Если массив пустой, возвращаем -1
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // Инициализируем левую и правую границы поиска
        int left = 0;
        int right = nums.length - 1;

        // Выполняем бинарный поиск пока границы не сойдутся
        while (left < right) {
            // Находим средний индекс
            int mid = left + (right - left) / 2;

            // Сравниваем средний элемент с его правым соседом
            if (nums[mid] > nums[mid + 1]) {
                // Если средний элемент больше правого соседа,
                // значит пик находится в левой половине (включая mid)
                right = mid;
            } else {
                // Если средний элемент меньше или равен правому соседу,
                // значит пик находится в правой половину (исключая mid)
                left = mid + 1;
            }
        }
        // Когда left == right, мы нашли пиковый элемент
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().findPeakElement(nums));
    }
}
