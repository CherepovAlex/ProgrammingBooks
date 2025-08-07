package _1920BuildArrayFromPermutation;
// Для заданной перестановки с отсчётом от нуля nums (с отсчётом от 0),
// создайте массив ans такой же длины, где ans[i] = nums[nums[i]] для каждого 0 <= i < nums.length и верните его.
//Перестановка с отсчётом от нуля nums — это массив различных целых чисел от 0 до nums.length - 1 (включительно).
// Example 1:
//Input: nums = [0,2,1,5,3,4]
//Output: [0,1,2,4,5,3]
//Explanation: The array ans is built as follows:
//ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
//    = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
//    = [0,1,2,4,5,3]
//Example 2:
//Input: nums = [5,0,1,2,3,4]
//Output: [4,5,0,1,2,3]
//Explanation: The array ans is built as follows:
//ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
//    = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
//    = [4,5,0,1,2,3]
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
        System.out.println(Arrays.toString(new Solution().buildArray(nums1)));
    }
}
