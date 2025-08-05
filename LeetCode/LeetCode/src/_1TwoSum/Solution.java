package _1TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        // time O(n) space O(n)
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw  new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(nums, 17)));
    }
}
