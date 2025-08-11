package Easy._88MergeSortedArray;
// Вам даны два целочисленных массива nums1 и nums2, отсортированных в порядке неубывания,
// а также два целых числа m и n, обозначающие количество элементов в nums1 и nums2 соответственно.
//Объедините nums1 и nums2 в один массив, отсортированный в порядке возрастания.
//Функция не должна возвращать окончательный отсортированный массив,
// вместо этого он должен быть сохранён внутри массива nums1.
// Для этого nums1 имеет длину m + n, где первые m элементы обозначают элементы,
// которые следует объединить, а последние n элементы имеют значение 0 и должны игнорироваться.
// nums2 имеет длину n.
// Example 1:
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//Example 2:
//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].
//Example 3:
//Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//Output: [1]
//Explanation: The arrays we are merging are [] and [1].
//The result of the merge is [1].
//Note that because m = 0, there are no elements in nums1.
//The 0 is only there to ensure the merge result can fit in nums1.
import java.util.Arrays;

public class Solution5 {
    // time O(m + n) space O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // ref to last element nums1
        int j = n - 1;  // ref to last element nums2
        int k = m + n - 1;  // ref to last position in nums1

        // merge from end, from max to min elements
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
        Solution5 s = new Solution5();
        s.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = new int[]{1};
        int[] nums4 = new int[]{};
        int m1 = 1, n1 = 0;
        Solution5 s1 = new Solution5();
        s1.merge(nums3, m1, nums4, n1);
        System.out.println(Arrays.toString(nums3));
    }
}
