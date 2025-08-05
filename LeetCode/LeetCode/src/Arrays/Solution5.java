package Arrays;

import java.util.Arrays;

public class Solution5 {
    // time O(m + n) space O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // ref to last element nums1
        int j = n - 1;  // ref to last element nums2
        int k = m + n - 1;  // ref to last position in nums1

        // merge from end, from max to min elements
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
        Solution5 s = new Solution5();
        s.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = new int[]{1};
        int[] nums4 = new int[]{};
        int m1 = 1, n1 = 0;
        Solution5 s1 = new Solution5();
        s1.merge(nums3, m1, nums4, n1);
        System.out.println(Arrays.toString(nums3));
    }
}
