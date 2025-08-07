package _2769FindTheMaximumAchievableNumber;
// Даны два целых числа, num и t. Число x является достижимым,
// если оно может стать равным num после применения следующей операции не более t раз:
// Увеличьте или уменьшите x на 1, и одновременно увеличьте или уменьшите num на 1.
// Верните максимальное возможное значение x.
// Example 1:
//Input: num = 4, t = 1
//Output: 6
//Explanation:
//Apply the following operation once to make the maximum achievable number equal to num:
//Decrease the maximum achievable number by 1, and increase num by 1.
//Example 2:
//Input: num = 3, t = 2
//Output: 7
//Explanation:
//Apply the following operation twice to make the maximum achievable number equal to num:
//Decrease the maximum achievable number by 1, and increase num by 1.

public class Solution {
    // time O(1) space O(1)
    public int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.theMaximumAchievableX(4, 1));
        System.out.println(s.theMaximumAchievableX(3, 2));
    }

}
