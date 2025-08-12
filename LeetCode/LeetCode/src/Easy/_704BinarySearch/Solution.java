package Easy._704BinarySearch;

// Дан массив целых чисел nums, отсортированный в порядке возрастания, и целое число target.
// Напишите функцию для поиска target в nums. Если target существует, верните его индекс.
// В противном случае верните -1.
// Вы должны написать алгоритм со сложностью выполнения O(log n) за время.
// Example 1:
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
//Example 2:
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
public class Solution {
    // time O(log n)
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Предотвращает переполнение
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1; // Ищем в правой половине
            } else {
                high = mid - 1; // Ищем в левой половине
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println(new Solution().search(nums1, target1));
        int[] nums2 = new int[]{-1,0,3,5,9,12};
        int target2 = 2;
        System.out.println(new Solution().search(nums2, target2));
    }
}
