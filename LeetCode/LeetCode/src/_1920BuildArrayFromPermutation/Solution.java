package _1920BuildArrayFromPermutation;

import java.util.Arrays;

public class Solution {

    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 2, 1, 5, 3, 4};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.buildArray(nums1)));
    }
}
