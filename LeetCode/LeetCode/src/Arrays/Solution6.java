package Arrays;

public class Solution6 {

    // time O(n)
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        Solution6 s = new Solution6();
        System.out.println(s.removeElement(nums, val));

        int[] nums1 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val1 = 2;
        Solution6 s1 = new Solution6();
        System.out.println(s1.removeElement(nums1, val1));
    }
}
