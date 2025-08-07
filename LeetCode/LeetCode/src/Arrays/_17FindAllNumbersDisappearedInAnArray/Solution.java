package Arrays._17FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Дан массив nums из n целых чисел, где nums[i] находится в диапазоне [1, n],
// верните массив всех целых чисел в диапазоне [1, n] которые не встречаются в nums.
// Example 1:
//Input: nums = [4,3,2,7,8,2,3,1]
//Output: [5,6]
//Example 2:
//Input: nums = [1,1]
//Output: [2]
public class Solution {
    // time O(n), space O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // помечаем присутствующие числа
        for (int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0){
                nums[index] = -nums[index];
            }
        }
        // собираем отсутствующие числа
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 3, 2, 7, 8, 2, 3, 1};    // [5,6]
        int[] nums2 = new int[]{1, 1}; // [2]
        System.out.println(new Solution().findDisappearedNumbers(nums1));
        System.out.println(new Solution().findDisappearedNumbers(nums2));
    }
}
