package Arrays._12MoveZeroes;

import java.util.Arrays;

// Дан целочисленный массив nums. Переместите все 0 в конец массива,
// сохранив относительный порядок ненулевых элементов.
// Обратите внимание, что это нужно делать на месте, без создания копии массива.
// Example 1:
//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
//Example 2:
//Input: nums = [0]
//Output: [0]
public class Solution12 {
    // time O(n), space O(1)
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int index = 0;
        // bring all not 0 elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        // fill not 0 positions
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 3, 12};    // [1,3,12,0,0]
        new Solution12().moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {0};    // [0]
        new Solution12().moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
