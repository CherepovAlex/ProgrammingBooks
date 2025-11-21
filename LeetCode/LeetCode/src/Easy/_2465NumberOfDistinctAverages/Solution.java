package Easy._2465NumberOfDistinctAverages;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 2465. Количество различных средних значений
//Вам дан нумерация с 0 целочисленный массив nums чётной длины.
//Пока nums не пуст, вы должны повторять:
//Найдите минимальное число в nums и удалите его.
//Найдите максимальное число в nums и удалите его.
//Вычислите среднее арифметическое двух удалённых чисел.
//Среднее двух чисел a и b равно (a + b) / 2.
//Например, среднее значение 2 и 3 равно (2 + 3) / 2 = 2.5.
//Верните количество отличныхсредних значений, рассчитанных с помощью описанного выше процесса.
//Обратите внимание, что при равенстве минимального или максимального значения любое из них может быть удалено.
// Example 1:
//Input: nums = [4,1,4,0,3,5]
//Output: 2
//Explanation:
//1. Remove 0 and 5, and the average is (0 + 5) / 2 = 2.5. Now, nums = [4,1,4,3].
//2. Remove 1 and 4. The average is (1 + 4) / 2 = 2.5, and nums = [4,3].
//3. Remove 3 and 4, and the average is (3 + 4) / 2 = 3.5.
//Since there are 2 distinct numbers among 2.5, 2.5, and 3.5, we return 2.
//Example 2:
//Input: nums = [1,100]
//Output: 1
//Explanation:
//There is only one average to be calculated after removing 1 and 100, so we return 1.
public class Solution {
    // time O(n log n), space O(n)
    public int distinctAverages(int[] nums) {
        // Сортируем массив для удобства доступа к минимальным и максимальным элементам
        Arrays.sort(nums);

        // Используем HashSet для хранения уникальных средних значений
        Set<Double> averages = new HashSet<>();

        // Два указателя: left идёт с начала, right - с конца массива
        int left = 0;
        int right = nums.length - 1;

        // Пока указатели не встретятся
        while (left < right) {
            // Вычисляем среднее арифметическое текущей пары (min + max)
            double average = (nums[left] + nums[right]) / 2.0;

            // Добавляем среденее в множество (дубликаты игнорируются автоматически)
            averages.add(average);

            // Перемещаем указатели к следующей паре
            left++;
            right--;
        }

        // Возвращаем количество уникальных средний значений
        return averages.size();
    }

    public static void main(String[] args) {
        int[] nums = {4,1,4,0,3,5};
        System.out.println(new Solution().distinctAverages(nums));
    }
}
