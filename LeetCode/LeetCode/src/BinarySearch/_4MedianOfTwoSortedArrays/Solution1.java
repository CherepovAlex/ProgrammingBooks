package BinarySearch._4MedianOfTwoSortedArrays;

public class Solution1 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for optimization
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;  // Length of first (smaller) array
        int n = nums2.length;  // Length of second (larger) array
        int left = 0;          // Left boundary for binary search
        int right = m;         // Right boundary for binary search

        // Binary search for partition position in smaller array
        while (left <= right) {
            // Find middle point in first array
            int partition1 = (left + right) / 2;
            // Calculate corresponding point in second array
            int partition2 = (m + n + 1) / 2 - partition1;

            // Find maximum elements on left side of partition
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];

            // Find minimum elements on right side of partition
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            // Check if partition is correct
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If total number of elements is odd
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                }
                // If total number of elements is even
                else {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            }
            // If partition needs to be shifted left
            else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            }
            // If partition needs to be shifted right
            else {
                left = partition1 + 1;
            }
        }

        // This return will never be reached for valid inputs
        throw new IllegalArgumentException();
    }
}
