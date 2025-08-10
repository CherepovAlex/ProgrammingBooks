package _509FibonacciNumber;

import java.util.HashMap;
import java.util.Map;

// Числа Фибоначчи, обычно обозначаемые F(n), образуют последовательность, называемую последовательностью Фибоначчи,
// в которой каждое число является суммой двух предыдущих, начиная с 0 и 1. То есть
//F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2) при n> 1.
//Дано n, вычислите F(n).
// Example 1
//Input: n = 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
//Example 2:
//Input: n = 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
//Example 3:
//Input: n = 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
public class Solution {
    private final Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (cache.containsKey(n)) return cache.get(n);
        cache.put(n, fib(n - 1) + fib(n - 2));
        return cache.get(n);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().fib(n));
    }
}
