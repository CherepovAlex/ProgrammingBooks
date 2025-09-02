package Easy._1822SignOfTheProductOfAnArray;

public class Solution {
// Реализуйте функцию signFunc(x), которая возвращает:
//1 если x является положительным.
//-1 если x отрицательно.
//0 если x равно 0.
//Вам дан целочисленный массив nums. Пусть product будет произведением всех значений в массиве nums.
//ВозвратsignFunc(product).
// Example 1:
//Input: nums = [-1,-2,-3,-4,3,2,1]
//Output: 1
//Explanation: The product of all values in the array is 144, and signFunc(144) = 1
//Example 2:
//Input: nums = [1,5,0,2,-3]
//Output: 0
//Explanation: The product of all values in the array is 0, and signFunc(0) = 0
//Example 3:
//Input: nums = [-1,1,-1,1,-1]
//Output: -1
//Explanation: The product of all values in the array is -1, and signFunc(-1) = -1
    // time O(n), space O(1)
    public int arraySign(int[] nums) {
        int negCount = 0;                       // Счетчик отрицательных чисел

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) return 0;         // Если встретили 0 - сразу возвращаем 0
            if (nums[i] < 0) negCount++;        // Увеличиваем счетчик отрицательных чисел
        }
        if (negCount % 2 == 0) return 1;        // Четное количество отрицательных = положительный результ
        return -1;                              // Нечетное количество отрицательных = отрицательный результат
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, 3, 2, 1};
        System.out.println(new Solution().arraySign(nums));
    }
}

