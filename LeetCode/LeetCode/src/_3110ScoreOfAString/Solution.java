package _3110ScoreOfAString;
// Вам дана строка s. Оценка строки определяется как сумма абсолютных разностей
// между ASCII значениями соседних символов.
//Верните оценку за s.
// Example 1:
//Input: s = "hello"
//Output: 13
//Explanation:
//ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111.
// So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| =
// 3 + 7 + 0 + 3 = 13.
//Example 2:
//Input: s = "zaz"
//Output: 50
//Explanation:
//ASCII values of the characters in s are: 'z' = 122, 'a' = 97.
// So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.

public class Solution {
    // time O(n), space O(n)
    public int scoreOfString(String s) {
        if (s == null || s.length() <= 1) return 0;

        int score = 0;
//        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            int diff = s.charAt(i) - s.charAt(i - 1);
//            score += (diff < 0 ? -diff : diff);
            score += Math.abs(diff);
        }
        return score;
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(new Solution().scoreOfString(s));
    }
}
