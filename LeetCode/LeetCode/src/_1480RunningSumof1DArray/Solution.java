package _1480RunningSumof1DArray;

import java.util.Arrays;

public class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.runningSum(new int[]{1,2,3,4})));
    }
}
