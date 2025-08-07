package _58LengthOfLastWord;

// Дана строка s, состоящая из слов и пробелов. Верните длину последнего слова в строке.
//Слово — это максимальная подстрока, состоящая только из символов, не являющихся пробелами.
// Example 1:
//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.
//Example 2:
//Input: s = "   fly me   to   the moon  "
//Output: 4
//Explanation: The last word is "moon" with length 4.
//Example 3:
//Input: s = "luffy is still joyboy"
//Output: 6
//Explanation: The last word is "joyboy" with length 6.
public class Solution {

    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        return strs[strs.length - 1].length();
    }
    // time O(n), space O(1)
    public int lengthOfLastWord1(String s) {
        int lenght = 0;
        // go from end of str
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                lenght++;
            } else if (lenght > 0) {
                return lenght;
            }
        }
        return lenght;
    }

    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(new Solution().lengthOfLastWord1(str));
    }

}
