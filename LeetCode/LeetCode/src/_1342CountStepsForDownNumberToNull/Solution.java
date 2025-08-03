package _1342CountStepsForDownNumberToNull;

public class Solution {

    public int numberOfSteps(int num) {
        int steps = 0;
        // 1 version
        while(num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            steps++;
        }

        // 2 version
        while(num > 0) {
            if ((num & 1) == 0) {   // num: xxxxxxx0 or xxxxxxx1 bitmask: 00000001
                num >>= 1; // num = num >> 1;
            } else {
                num--;
            }
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.numberOfSteps(48);
    }
}
