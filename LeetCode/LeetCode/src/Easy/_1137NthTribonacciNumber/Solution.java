package Easy._1137NthTribonacciNumber;

import java.util.HashMap;
import java.util.Map;

// Последовательность Трибоначчи Tn определяется следующим образом:
//T0 = 0, T1 = 1, T2 = 1, а Tn+3 = Tn + Tn+1 + Tn+2 для n >= 0.
//При заданных n верните значение Tn.
// Example 1:
//Input: n = 4
//Output: 4
//Explanation:
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
//Example 2:
//Input: n = 25
//Output: 1389537
public class Solution {
    private final Map<Integer, Integer> map = new HashMap<>();

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n, tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3));
        return map.get(n);
    }

    public static void main(String[] args) {
        int n = 25;
        System.out.println(new Solution().tribonacci(n));
    }
}
