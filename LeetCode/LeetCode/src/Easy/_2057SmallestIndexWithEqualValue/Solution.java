package Easy._2057SmallestIndexWithEqualValue;

// Для целочисленного массива с индексацией от 0 nums верните самый меньший индекс i такого nums,
// что i mod 10 == nums[i], или -1 если такого индекса не существует.
//x mod y обозначает остаток при делении x на y.
// Example 1:
//Input: nums = [0,1,2]
//Output: 0
//Explanation:
//i=0: 0 mod 10 = 0 == nums[0].
//i=1: 1 mod 10 = 1 == nums[1].
//i=2: 2 mod 10 = 2 == nums[2].
//All indices have i mod 10 == nums[i], so we return the smallest index 0.
//Example 2:
//Input: nums = [4,3,2,1]
//Output: 2
//Explanation:
//i=0: 0 mod 10 = 0 != nums[0].
//i=1: 1 mod 10 = 1 != nums[1].
//i=2: 2 mod 10 = 2 == nums[2].
//i=3: 3 mod 10 = 3 != nums[3].
//2 is the only index which has i mod 10 == nums[i].
//Example 3:
//Input: nums = [1,2,3,4,5,6,7,8,9,0]
//Output: -1
//Explanation: No index satisfies i mod 10 == nums[i].
public class Solution {
    // time O(n), space O(1)
    public int smallestEqual(int[] nums) {
        if (nums == null) return -1;

        for (int index = 0; index < nums.length; index++) { // Проходим по всем элементам массива от начала до конца
            if (index % 10 == nums[index]) {             // Проверяем условие: остаток от деления i на 10 равен значению nums[i]
                return index ;                       // Если условие выполняется, сразу возвращаем текущий индекс
            }
        }
        return -1;                               // Если ни один элемент не удовлетворяет условию, возвращаем -1
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        System.out.println(new Solution().smallestEqual(nums));
    }
}
