package Array._2529MaximumCountOfPositiveIntegerAndNegativeInteger;

// 2529. Максимальное количество положительных и отрицательных целых чисел
//Дан массив nums, отсортированный в неубывающем порядке. Верните максимальное значение между количеством положительных
// и количеством отрицательных целых чисел
//Другими словами, если количество положительных целых чисел в nums равно pos, а количество отрицательных целых чисел
// равно neg, то верните максимальное значение из pos и neg.
// Обратите внимание, что 0 не является ни положительным, ни отрицательным.
// Example 1:
//Input: nums = [-2,-1,-1,1,2,3]
//Output: 3
//Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
//Example 2:
//Input: nums = [-3,-2,-1,0,0,1,2]
//Output: 3
//Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.
//Example 3:
//Input: nums = [5,20,66,1314]
//Output: 4
//Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.
public class Solution {
    // time O(log n), space O(1)
    public int maximumCount(int[] nums) {
        // Находим индекс первого неотрицательного числа (первого числа >= 0)
        int firstNonNegative = findFirstNonNegative(nums);

        // Находим индекс первого положительного числа (первого числа > 0)
        int firstPositive = findFirstPositive(nums);

        // Количество отрицательных чисел равно индексу первого неотрицательного числа
        int negCount = firstNonNegative;

        // Количество положительных чисел равно общей длине минус индекс первого положительного числа
        int posCount = nums.length - firstPositive;

        // Возвращаем максимальное из двух количеств
        return Math.max(negCount, posCount);
    }

    // Бинарный поиск первого числа >= 0
    private int findFirstNonNegative(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Бинарный поиск для нахождения первого числа > 0
    private int findFirstPositive(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // time O(n), space O(1)
    public int maximumCount1(int[] nums) {
        // Инициализируем счетчики для отрицательных и положительных чисел
        int negCount = 0;
        int posCount = 0;

        // Проходим по всем элементам массива
        for (int num : nums) {
            if (num < 0) {
                // Увеличиваем счетчик отрицательных чисел, если число отрицательное
                negCount++;
            } else if (num > 0) {
                // Увеличиваем счетчик положительных чисел, если число положительное
                posCount++;
            }
            // Числа равные 0 игнорируем
        }

        // Возвращаем максимальное значение из двух счетчиков
        return Math.max(negCount, posCount);
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1, -1, 1, 2, 3};
        System.out.println(new Solution().maximumCount(nums));  // 3
    }
}
