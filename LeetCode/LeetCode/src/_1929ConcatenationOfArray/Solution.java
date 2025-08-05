package _1929ConcatenationOfArray;

import java.util.Arrays;

public class Solution {

    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 1};
        Solution s = new Solution();
        s.getConcatenation(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
