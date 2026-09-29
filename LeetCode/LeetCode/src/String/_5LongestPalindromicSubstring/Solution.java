package String._5LongestPalindromicSubstring;

// 5. Самая длинная палиндромная подстрока
//Дана строка s. Найдите самую длинную палиндромную подстроку в s.
// Ограничения:
//1 <= s.length <= 1000
//s состоят только из цифр и английских букв.
// Example 1:
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
//Example 2:
//Input: s = "cbbd"
//Output: "bb"
public class Solution {

    // The most time- and memory-efficient approach is Manacher's algorithm.
    // Time: O(n), Space: O(n)
    public String longestPalindrome(String s) {

        // Transform the string by inserting special characters to handle even-length palindromes.
        // step 1
        StringBuilder sb = new StringBuilder("^#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append('#');
        }
        sb.append('$');
        String t = sb.toString();

        // Now we have a string like: ^ # b # a # b # a # d # $
        // step 2
        int n = t.length();
        int[] p = new int[n]; // Array of palindrome radii
        int center = 0, right = 0; // Current center and rightmost boundary of the known palindrome

        // step 3
        for (int i = 1; i < n - 1; i++) {

            // Mirror position relative to the current center
            int mirror = 2 * center - i;

            // If i is within the right boundary, use the previously computed value
            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Attempt to expand the palindrome centered at i
            while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i])) {
                p[i]++;
            }

            // If expansion goes beyond right boundary, update center and right
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // Find the maximum radius and its center index
        // step 4
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        // Compute the starting index of the palindrome in the original string
        int start = (centerIndex - maxLen) / 2;

        // Return the longest palindromic substring
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Solution().longestPalindrome(s)); // bab
    }
}