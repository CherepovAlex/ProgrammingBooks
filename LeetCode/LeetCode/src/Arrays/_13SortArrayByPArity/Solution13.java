package Arrays._13SortArrayByPArity;

import java.util.Arrays;

// Дан целочисленный массив nums. Переместите все чётные числа в начало массива, а затем все нечётные числа.
//Верните любой массив, удовлетворяющий этому условию.
// Example 1:
//Input: nums = [3,1,2,4]
//Output: [2,4,3,1]
//Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
//Example 2:
//Input: nums = [0]
//Output: [0]
public class Solution13 {
    // time O(n)
    public int[] sortArrayByParity(int[] nums) {
        // указатель на последний элемент
        int j = nums.length - 1;
        // идем по всему массиву с начала пока не встретимся с указателем
        for (int i = 0; i < j; i++) {
            // если встречаем нечетный элемент
            if ((nums[i] & 1) != 0) {
                // ищем с конца четный элемент
                while (nums[j] % 2 != 0 && j > i) {
                    j--;
                }
                // как нашли, так меняем с найденным нечётным
                if (j > i) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2, 4};
        int[] nums2 = {0};
        System.out.println(Arrays.toString(new Solution13().sortArrayByParity(nums1))); // [2,4,3,1]
        System.out.println(Arrays.toString(new Solution13().sortArrayByParity(nums2))); // [0]
    }
}
