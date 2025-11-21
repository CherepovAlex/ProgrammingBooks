package HashTable._1TwoSum;
// 1. Учитывая массив целых чисел nums и целое число target, верните индексы двух чисел таким образом, чтобы они в сумме равнялись target.
//Вы можете предположить, что для каждого ввода будет ровно одно решение и что вы не будете использовать один и тот же элемент дважды.
//Вы можете вернуть ответ в любом порядке.
//Пример 1:
//Входные данные: nums = [2,7,11,15], target = 9
//Выходные данные: [0,1]
//Пояснение: Поскольку nums[0] + nums[1] == 9, мы возвращаем [0, 1].
//Пример 2:
//Входные данные: nums = [3,2,4], target = 6
//Выходные данные: [1,2]
//Пример 3:
//Входные данные: nums = [3,3], target = 6
//Выходные данные: [0,1]
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // time O(n) space O(n)
    public int[] twoSum(int[] nums, int target) {
        // Создаём HashMap для хранения чисел и их индексов
        // Ключ - число из массива, значение - его индекс
        Map<Integer,Integer> map = new HashMap<>();
        // Проходим по всем элементам массива
        for (int i = 0; i < nums.length; i++) {
            // Вычисляем число, которое в сумме с текущим даст target
            int complement = target - nums[i];
            // Проверяем, есть ли complement в нашей карте
            if (map.containsKey(complement)) {
                // Если нашли complement, возвращаем индексы обоих чисел
                // map.get(complement) - индекс complement, i - индекс текущего числа
                return new int[]{map.get(complement), i};
            } else {
                // Если complement не найден, добавляем текущее число и его индекс в карту
                map.put(nums[i], i);
            }
        }
        throw  new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        System.out.println(Arrays.toString(new Solution().twoSum(nums, 17))); // [0, 3]
    }
}
