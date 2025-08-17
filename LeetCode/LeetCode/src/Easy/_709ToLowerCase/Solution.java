package Easy._709ToLowerCase;

// Дана строка s. Верните строку, в которой все заглавные буквы заменены на такие же строчные.
// Example 1:
//Input: s = "Hello"
//Output: "hello"
//Example 2:
//Input: s = "here"
//Output: "here"
//Example 3:
//Input: s = "LOVELY"
//Output: "lovely"
public class Solution {
    public String toLowerCase(String s) {
        String result = "";
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result += (char) (c + 32);
            } else {
                result += c;
            }
        }
        return result;
    }

    public String toLowerCase1(String s) {
        return s.toLowerCase();
    }

    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(new Solution().toLowerCase(str));
    }
}
