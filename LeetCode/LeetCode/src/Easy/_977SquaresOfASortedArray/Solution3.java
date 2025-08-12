package Easy._977SquaresOfASortedArray;

import java.util.Arrays;

// Дан целочисленный массив nums, отсортированный в неубывающем порядке.
// Верните массив квадратов каждого числа отсортированный в неубывающем порядке.
// Example 1:
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
//Example 2:
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
public class Solution3 {
    // time O(n), space O(n)
    public int[] sortedSquares(int[] nums) {
        if (nums == null) return null;
        if (nums.length == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n]; // Создаем результирующий массив
        int left = 0, right = n - 1;    // Инициализируем два указателя

        for (int i = n - 1; i >= 0; i--) {  // Идем с конца результирующего массива
            int squareLeft = nums[left] * nums[left];      // Квадрат левого элемента
            int squareRight = nums[right] * nums[right];   // Квадрат правого элемента

            if (squareLeft > squareRight) { // Если левый квадрат больше
                result[i] = squareLeft;     // Записываем его в текущую позицию
                left++;                     // Сдвигаем левый указатель вправо
            } else {
                result[i] = squareRight;    // Иначе записываем правый квадрат
                right--;                    // Сдвигаем правый указатель влево
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(new Solution3().sortedSquares(nums1)));

        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(new Solution3().sortedSquares(nums2)));

    }
}
