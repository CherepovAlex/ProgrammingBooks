package _13RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // time O(n), space O(n)
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        int result = 0;
        int i, j;

        for (i = 0, j = 1; j < chars.length; i++, j++) {
            if (map.get(chars[i]) >= map.get(chars[j])) {
                result += map.get(chars[i]);
            } else {
                result -= map.get(chars[i]);
            }
        }
        result += map.get(chars[i]);
        return result;
    }

    // time O(n), space O(1)
    public int romanToInt1(String s) {
        int result = 0;
        int prev = getValue(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int curr = getValue(s.charAt(i));
            if (prev >= curr) {
                result += prev;
            } else {
                result -= prev;
            }
            prev = curr;
        }
        result += prev;
        return result;
    }

    private int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new Solution().romanToInt1(s));
    }
}
