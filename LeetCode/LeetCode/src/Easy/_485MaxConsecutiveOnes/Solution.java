package Easy._485MaxConsecutiveOnes;

// Дан двоичный массив nums. Верните максимальное количество последовательных 1's в массиве.
// Example 1:
//Input: nums = [1,1,0,1,1,1]
//Output: 3
//Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
//Example 2:
//Input: nums = [1,0,1,1,0,1]
//Output: 2
public class Solution {
    // time O(n) space O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0, count = 0;
        for (int num : nums) {
            count = num == 1 ? count + 1 : 0;
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(new Solution().findMaxConsecutiveOnes(nums));
    }
}
