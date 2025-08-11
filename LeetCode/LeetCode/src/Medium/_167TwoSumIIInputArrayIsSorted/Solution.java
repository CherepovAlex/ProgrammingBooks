package Medium._167TwoSumIIInputArrayIsSorted;
import java.util.Arrays;
// Дан индексированный с 1 массив целых чисел numbers, который уже отсортирован в порядке неубывания.
// Найдите два числа, сумма которых равна определённому target числу.
// Пусть эти два числа будут numbers[index1] и numbers[index2], где 1 <= index1 < index2 <= numbers.length.
//Верните индексы двух чисел, index1 и index2, увеличенные на единицу в виде целочисленного массива [index1, index2]
// длиной 2.
//Тесты составлены таким образом, что существует ровно одно решение. Вы не можете использовать
// один и тот же элемент дважды. Ваше решение должно использовать только постоянное дополнительное пространство.
// Example 1:
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
//Example 2:
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
//Example 3:
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
public class Solution {
    // time O(n) space O(1)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{left + 1, right + 1};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(new Solution().twoSum(numbers, 9)));
    }
}
