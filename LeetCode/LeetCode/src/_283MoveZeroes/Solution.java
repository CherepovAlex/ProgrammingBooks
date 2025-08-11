package _283MoveZeroes;

import java.util.Arrays;

// Дан целочисленный массив nums. Переместите все 0 в конец массива, сохранив относительный порядок ненулевых элементов.
//Обратите внимание, что это нужно делать на месте, без создания копии массива.
// Example 1:
//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
//Example 2:
//Input: nums = [0]
//Output: [0]
public class Solution {
    // time O(n)
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int nonZeroIndex = 0;
        // bring all not 0 elements in start
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != nonZeroIndex) {
                    nums[nonZeroIndex] = nums[i];
                }
                nonZeroIndex++;
            }
        }
        // fill not 0 positions
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
