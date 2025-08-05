package _2769FindTheMaximumAchievableNumber;

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
