package Arrays;

public class Solution7 {

    // time O(n)
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1;  // unique elements must be 1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        Solution7 s = new Solution7();
        System.out.println(s.removeDuplicates(nums));

        int[] nums1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Solution7 s1 = new Solution7();
        System.out.println(s1.removeDuplicates(nums1));
    }

}
