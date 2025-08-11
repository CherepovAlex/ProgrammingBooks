package Easy._1929ConcatenationOfArray;
// Дан целочисленный массив nums длиной n, и вам нужно создать массив ans длиной 2n,
// где ans[i] == nums[i] и ans[i + n] == nums[i] для 0 <= i < n (нумерация с нуля).
//В частности, ans — это конкатенация двух nums массивов.
//Возвращает массив ans.
// Example 1:
//Input: nums = [1,2,1]
//Output: [1,2,1,1,2,1]
//Explanation: The array ans is formed as follows:
//- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
//- ans = [1,2,1,1,2,1]
//Example 2:
//Input: nums = [1,3,2,1]
//Output: [1,3,2,1,1,3,2,1]
//Explanation: The array ans is formed as follows:
//- ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
//- ans = [1,3,2,1,1,3,2,1]
import java.util.Arrays;

public class Solution {
    // version 1
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }

    // version 2
    public int[] getConcatenation1(int[] nums) {
        int[] ans = new int[nums.length * 2];
        System.arraycopy(nums, 0, ans, 0, nums.length);
        System.arraycopy(nums, 0, ans, nums.length, nums.length);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 1};
        System.out.println(Arrays.toString(new Solution().getConcatenation(nums1)));
    }
}
