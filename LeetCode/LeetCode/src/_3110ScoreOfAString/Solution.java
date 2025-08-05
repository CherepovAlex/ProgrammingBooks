package _3110ScoreOfAString;

public class Solution {

    public int scoreOfString(String s) {
        if (s == null || s.length() <= 1) return 0;

        int score = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int diff = chars[i] - chars[i - 1];
            score += (diff < 0 ? -diff : diff);
        }
        return score;
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(new Solution().scoreOfString(s));
    }
}
