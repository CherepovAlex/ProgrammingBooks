package _338CountingBits;

import java.util.Arrays;

// Для заданного целого числа n верните массив ans длиной n + 1 такой, что для каждого i (0 <= i <= n),
// ans[i] будет количество 1' в двоичном представлении i.
// Example 1:
//Input: n = 2
//Output: [0,1,1]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
//Example 2:
//Input: n = 5
//Output: [0,1,1,2,1,2]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
public class Solution {
    // time O(n*log(n)),
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            int oneCount = countOnes(binary);
            ans[i] = oneCount;
        }
        return ans;
    }
    // time O(n)
    // Ключевая идея основана на следующих наблюдениях:
    // Для четного числа i количество единиц такое же, как у i/2
    // Для нечетного - на одну единицу больше, чем у i/2
    public int[] countBits1(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0; // Базовый случай
        for (int i = 1; i <= n; i++) {
            // // Количество единиц в числе i равно количеству единиц в i/2 плюс младший бит i
            ans[i] = ans[i >> 1] + (i & 1);
        // эквивалентно делению на 2 + дает младший бит числа (0 для четных, 1 для нечетных)
        }
        return ans;
    }


    private int countOnes(String num) {
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 5;
        System.out.println(Arrays.toString(new Solution().countBits(n1)));
        System.out.println(Arrays.toString(new Solution().countBits(n2)));
    }
}
