package Easy._724FindPivotIndex;

// Дан массив целых чисел nums. Вычислите индекс поворота этого массива.
//Индекс поворота — это индекс, при котором сумма всех чисел строго слева от индекса равна сумме всех чисел строго
// справа от индекса.
//Если индекс находится на левом краю массива, то левая сумма равна 0, потому что слева нет элементов.
// Это также относится к правому краю массива.
//Верните самый левый индекс поворота. Если такого индекса нет, верните -1.
// Example 1:
//Input: nums = [1,7,3,6,5,6]
//Output: 3
//Explanation:
//The pivot index is 3.
//Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
//Right sum = nums[4] + nums[5] = 5 + 6 = 11
//Example 2:
//Input: nums = [1,2,3]
//Output: -1
//Explanation:
//There is no index that satisfies the conditions in the problem statement.
//Example 3:
//Input: nums = [2,1,-1]
//Output: 0
//Explanation:
//The pivot index is 0.
//Left sum = 0 (no elements to the left of index 0)
//Right sum = nums[1] + nums[2] = 1 + -1 = 0
public class Solution {
    // time O(n), space O(1)
    public int pivotIndex(int[] nums) {
        int totalSum  = 0;
        for (int num : nums) {
            totalSum  += num;                 // Вычисляем общую сумму всех элементов массива
        }
        int leftSum = 0, rightSum = totalSum ;    // Инициализируем левую сумму как 0, правую - как общую сумму
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];            // Вычитаем текущий элемент из правой суммы
            if (leftSum == rightSum) {      // Если суммы равны, возвращаем текущий индекс
                return i;
            }
            leftSum += nums[i];             // Добавляем текущий элемент к левой сумме
        }
        return -1;                          // Если не нашли подходящий индекс
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(new Solution().pivotIndex(nums));
    }

}
