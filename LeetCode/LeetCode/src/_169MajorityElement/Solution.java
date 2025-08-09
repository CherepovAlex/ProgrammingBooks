package _169MajorityElement;

import java.util.HashMap;
import java.util.Map;

// Дан массив nums размером n, верните большинство элементов.
// Элемент, встречающийся чаще всего, — это элемент, который встречается более ⌊n / 2⌋ раз.
// Можно предположить, что элемент, встречающийся чаще всего, всегда присутствует в массиве.
// Example 1:
//Input: nums = [3,2,3]
//Output: 3
//Example 2:
//Input: nums = [2,2,1,1,1,2,2]
//Output: 2
public class Solution {
    // time O(n) space O(n)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int majority = nums.length / 2;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majority) {
                result = entry.getKey();
            }
        }
        return result;
    }

    //  time O(n) space O(1)
    public int majorityElement1(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public int majorityElement3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        int majority = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majority) {
                return entry.getKey(); // ранний возврат
            }
        }
        return -1; // никогда не выполнится по условию задачи
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        System.out.println(new Solution().majorityElement(nums));
        int[] nums1 = new int[]{1};
        System.out.println(new Solution().majorityElement(nums1));
    }
}
