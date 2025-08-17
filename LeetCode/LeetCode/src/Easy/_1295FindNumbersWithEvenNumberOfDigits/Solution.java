package Easy._1295FindNumbersWithEvenNumberOfDigits;

// Дан массив nums целых чисел. Определите, в скольких из них содержится чётное число цифр.
// Example 1:
//Input: nums = [12,345,2,6,7896]
//Output: 2
//Explanation:
//12 contains 2 digits (even number of digits).
//345 contains 3 digits (odd number of digits).
//2 contains 1 digit (odd number of digits).
//6 contains 1 digit (odd number of digits).
//7896 contains 4 digits (even number of digits).
//Therefore only 12 and 7896 contain an even number of digits.
//Example 2:
//Input: nums = [555,901,482,1771]
//Output: 1
//Explanation:
//Only 1771 contains an even number of digits.
public class Solution {
    // time O(n) space
    public int findNumbers(int[] nums) {
        int countEven = 0;

        for (var num : nums) {
            int digitCount = countDigits(num);
            if (digitCount % 2 == 0) {
                countEven++;
            }
        }
        return countEven;
    }

    private int countDigits(int num) {
        if (num == 0) return 1;

        int count = 0;
        num = Math.abs(num);

        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    public int findNumbers2(int[] nums) {
        int countEven = 0;

        for (int num : nums) {
            // Для чисел в диапазоне [10,99] или [1000,9999] или [100000,999999] и т.д.
            if ((num >= 10 && num <= 99) ||
                    (num >= 1000 && num <= 9999) ||
                    (num >= 100000 && num <= 999999)) {
                countEven++;
            }
        }
        return countEven;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12, 345, 2, 6, 7896};
        System.out.println(new Solution().findNumbers(nums));
    }
}
