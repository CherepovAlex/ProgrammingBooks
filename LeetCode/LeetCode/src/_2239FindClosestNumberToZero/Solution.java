package _2239FindClosestNumberToZero;

// Дан целочисленный массив nums размером n, верните число со значением ближайшим к 0 в nums.
// Если существует несколько ответов, верните число с наибольшим значением.
public class Solution {

    public int findClosestNumber(int[] nums) {

        int minValue;
        minValue = 100_001;
        for (int num : nums) {
            if ((minValue < num && -minValue > num) || (minValue > num && -minValue < num)) {
                minValue = num;
            } else if (num == minValue || -num == minValue) {
                minValue = minValue < num ? num : minValue;
            }
        }
        return minValue;
    }

    public static void main(String[] args) {
        int[] nums1 = {-4, -2, 1, 4, 8};
        int[] nums2 = {2, -1, 1};
        System.out.println(new Solution().findClosestNumber(nums1));
        System.out.println(new Solution().findClosestNumber(nums2));
    }

}
