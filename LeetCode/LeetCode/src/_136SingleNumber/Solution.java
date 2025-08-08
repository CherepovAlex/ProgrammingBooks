package _136SingleNumber;

import java.util.HashMap;
import java.util.Map;

// Дан непустой массив целых чисел nums, в котором каждый элемент встречается дважды,
// кроме одного. Найдите этот единственный элемент.
//Вы должны реализовать решение с линейной сложностью выполнения и использовать
// только постоянное дополнительное пространство
// Example 1:
//Input: nums = [2,2,1]
//Output: 1
//Example 2:
//Input: nums = [4,1,2,1,2]
//Output: 4
//Example 3:
//Input: nums = [1]
//Output: 1
public class Solution {
    // version 1
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
    // version 2
    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 2, 1};
        System.out.println(new Solution().singleNumber(nums1)); //  1
    }
}
