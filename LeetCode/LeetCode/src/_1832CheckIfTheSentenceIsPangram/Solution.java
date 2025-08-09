package _1832CheckIfTheSentenceIsPangram;

import java.util.HashSet;
import java.util.Set;

// панграмма — это предложение, в котором каждая буква английского алфавита встречается хотя бы один раз.
//Дана строка sentence, содержащая только строчные буквы английского алфавита.
// Верните true, если sentence является панграм, или false в противном случае.
// Example 1:
//Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
//Output: true
//Explanation: sentence contains at least one of every letter of the English alphabet.
//Example 2:
//Input: sentence = "leetcode"
//Output: false
public class Solution {
    // time O(n), space O(1)
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            set.add(c);
        }
        if (set.size() < 26) {
            return false;
        }
        return true;
    }

    public boolean checkIfPangram1(String sentence) {
        boolean[] seen = new boolean[26];
        for (char c : sentence.toCharArray()) {
            seen[c - 'a'] = true;
        }
        for (boolean b : seen) {
            if (!b) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String sentence = "abcdefghijklmnopqrstuv";
        System.out.println(new Solution().checkIfPangram(sentence));
    }
}
