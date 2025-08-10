package _219ContainsDuplicateII;

import java.util.HashMap;
import java.util.Map;

// Дан целочисленный массив nums и целое число k.
// Верните true если есть два различных индекса i и j в массиве таких,
// что nums[i] == nums[j] и abs(i - j) <= k.
// Example 1:
//Input: nums = [1,2,3,1], k = 3
//Output: true
//Example 2:
//Input: nums = [1,0,1,1], k = 1
//Output: true
//Example 3:
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
public class Solution {
    // time O(n), space O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && abs(i - map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    private int abs(int x) {
        return x < 0 ? -x : x;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().containsNearbyDuplicate(nums, 3));
        int[] nums1 = {1, 2, 3, 1, 2, 3};
        System.out.println(new Solution().containsNearbyDuplicate(nums1, 2));
    }

}
