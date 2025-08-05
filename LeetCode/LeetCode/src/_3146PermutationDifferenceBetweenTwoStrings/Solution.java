package _3146PermutationDifferenceBetweenTwoStrings;

public class Solution {

    public int findPermutationDifference(String s, String t) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += abs(i - t.indexOf(s.charAt(i)));
        }
        return sum;
    }

    private int abs(int num) {
        return num < 0 ? -num : num;
    }

    public static void main(String[] args) {
        String s = "abc", t = "bac";
        System.out.println(new Solution().findPermutationDifference(s, t));
    }

}
