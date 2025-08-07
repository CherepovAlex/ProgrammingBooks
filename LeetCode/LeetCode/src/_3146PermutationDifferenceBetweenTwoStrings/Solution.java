package _3146PermutationDifferenceBetweenTwoStrings;

import java.util.HashMap;
import java.util.Map;

// Вам даны две строки s и t такие, что каждый символ встречается в s не более одного раза, а t является перестановкой s.
//Разность перестановок между s и t определяется как сумма абсолютных разностей между
// индексом вхождения каждого символа в s и индексом вхождения того же символа в t.
//Найдите разницу в перестановках между s и t.
// Example 1:
//Input: s = "abc", t = "bac"
//Output: 2
//Explanation:
//For s = "abc" and t = "bac", the permutation difference of s and t is equal to the sum of:
//The absolute difference between the index of the occurrence of "a" in s and the index of the occurrence of "a" in t.
//The absolute difference between the index of the occurrence of "b" in s and the index of the occurrence of "b" in t.
//The absolute difference between the index of the occurrence of "c" in s and the index of the occurrence of "c" in t.
//That is, the permutation difference between s and t is equal to |0 - 1| + |1 - 0| + |2 - 2| = 2.
//Example 2:
//Input: s = "abcde", t = "edbac"
//Output: 12
//Explanation: The permutation difference between s and t is equal to |0 - 3| + |1 - 2| + |2 - 4| + |3 - 1| + |4 - 0| = 12.
public class Solution {
    // time O(n*n)
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
    // time O(n)
    public int findPermutationDifference1(String s, String t) {
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        // fill the map: symbol -> its position in t
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), i);
        }
        // go on s and count diff
        for (int i = 0; i < s.length(); i++) {
            sum += abs(i - map.get(s.charAt(i)));
        }

        return sum;
    }

    public static void main(String[] args) {
        String s = "abc", t = "bac";
        System.out.println(new Solution().findPermutationDifference(s, t));
    }
}
