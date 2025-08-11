package Easy._389FindTheDifference;
// Вам даны две строки s и t.
//Строка t генерируется путем случайного перемешивания строки s с последующим добавлением
// еще одной буквы в случайном месте.
//Верните букву, которая была добавлена в t.
// Example 1:
//Input: s = "abcd", t = "abcde"
//Output: "e"
//Explanation: 'e' is the letter that was added.
//Example 2:
//Input: s = "", t = "y"
//Output: "y"
public class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            sum ^= t.charAt(i);
        }
        return (char)sum;
    }

    public static void main(String[] args) {
        String s1 = "abcd", t1 = "abcde";
        System.out.println(new Solution().findTheDifference(s1, t1));
    }
}
