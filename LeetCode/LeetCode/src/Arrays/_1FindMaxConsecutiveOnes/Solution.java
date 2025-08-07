package Arrays._1FindMaxConsecutiveOnes;

public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            } else count = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(new Solution().findMaxConsecutiveOnes(nums));
        int[] nums1 = new int[]{1, 0, 1, 1, 0, 1};
        System.out.println(new Solution().findMaxConsecutiveOnes(nums1));
    }
}
