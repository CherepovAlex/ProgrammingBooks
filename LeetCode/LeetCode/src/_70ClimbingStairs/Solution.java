package _70ClimbingStairs;

import java.util.HashMap;
import java.util.Map;

// Вы поднимаетесь по лестнице. Чтобы добраться до вершины, нужно сделать n шагов.
// Каждый раз вы можете подняться либо на 1 ступеней, либо на 2 ступеней.
// Сколькими различными способами можно подняться на вершину?
// Example 1:
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//Example 2:
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
public class Solution {
    private final Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        return stairs(0, n);
    }

    private int stairs(int current, final int target) {
        if (current == target) {
            return 1;
        }
        if (current > target) {
            return 0;
        }
        if (map.containsKey(current)) {
            return map.get(current);
        }
        map.put(current, stairs(current + 1, target) + stairs(current + 2, target));
        return map.get(current);
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(new Solution().climbStairs(n));
        int n1 = 4;
        System.out.println(new Solution().climbStairs(n1));

    }
}
