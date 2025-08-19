package Easy._1464MaximumProductOfTwoElementsInAnArray;

import java.util.Arrays;

// Дан массив целых чисел nums. Вам нужно выбрать два разных индекса i и j этого массива.
// Верните максимальное значение (nums[i]-1)*(nums[j]-1).
// Example 1:
//Input: nums = [3,4,5,2]
//Output: 12
//Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
//Example 2:
//Input: nums = [1,5,4,5]
//Output: 16
//Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
//Example 3:
//Input: nums = [3,7]
//Output: 12
public class Solution {
    // time O(n * log n), space O(1)
    public int maxProduct(int[] nums) {

        Arrays.sort(nums);
        int firstMax = nums[nums.length - 1];
        int secondMax = nums[nums.length - 2];
        int result = (firstMax - 1) * (secondMax - 1);

        return result;
    }

    public int maxProduct2(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 2};
        System.out.println(new Solution().maxProduct(nums));
    }
}
