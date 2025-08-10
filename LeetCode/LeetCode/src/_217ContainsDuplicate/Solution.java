package _217ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

//Для заданного целочисленного массива nums верните true, если какое-либо значение встречается
// в массиве как минимум дважды, и верните false, если все элементы различны.
// Example 1:
//Input: nums = [1,2,3,1]
//Output: true
//Explanation:
//The element 1 occurs at the indices 0 and 3.
//Example 2:
//Input: nums = [1,2,3,4]
//Output: false
//Explanation:
//All elements are distinct.
//Example 3:
//Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {return false;}
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(new Solution().containsDuplicate(nums));
                int[] nums1 = new int[]{1, 2, 3, 4};
        System.out.println(new Solution().containsDuplicate(nums1));
    }
}
