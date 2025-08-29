package Easy._1748SumOfUniqueElements;

import java.util.HashMap;
import java.util.Map;

// Вам дан целочисленный массив nums.
// Уникальные элементы массива — это элементы, которые встречаются в массиве ровно один раз.
//Верните сумму всех уникальных элементов nums.
// Example 1:
//Input: nums = [1,2,3,2]
//Output: 4
//Explanation: The unique elements are [1,3], and the sum is 4.
//Example 2:
//Input: nums = [1,1,1,1,1]
//Output: 0
//Explanation: There are no unique elements, and the sum is 0.
//Example 3:
//Input: nums = [1,2,3,4,5]
//Output: 15
//Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
public class Solution {
    // time O(n), space O(n)
    public int sumOfUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Используем HashMap для подсчета частот
        Map<Integer, Integer> map = new HashMap<>();
        // Подсчет частот с помощью getOrDefault (более эффективно)
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        // Суммирование уникальных элементов
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }
        return sum;
    }

    public int sumOfUnique1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Используем HashMap для подсчета частот
        Map<Integer, Integer> map = new HashMap<>();
        // Подсчет частот с помощью getOrDefault (более эффективно)
        for (Integer number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
            // frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // Суммирование уникальных элементов
        int sum = 0;
        for (Map.Entry<Integer, Integer> pairs : map.entrySet()) {
            if (pairs.getValue() == 1) {
                sum += pairs.getKey();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};
        System.out.println(new Solution().sumOfUnique(nums));
    }

}
