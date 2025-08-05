package Arrays;

import java.util.Arrays;

public class Solution3 {

    // O(n)
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int squareLeft = nums[left]  * nums[left];
            int squareRight = nums[right]  * nums[right];

            if (squareLeft > squareRight) {
                result[i] = squareLeft;
                left++;
            } else {
                result[i] = squareRight;
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(new Solution3().sortedSquares(nums1)));

        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(new Solution3().sortedSquares(nums2)));

    }

}
