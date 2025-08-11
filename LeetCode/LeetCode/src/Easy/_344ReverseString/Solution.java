package Easy._344ReverseString;
import java.util.Arrays;
// Напишите функцию, которая переворачивает строку. Входная строка задаётся в виде массива символов s.
//Для этого необходимо изменить входной массив на месте с помощью O(1) дополнительной памяти.
// Example 1:
//Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
//Example 2:
//Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
public class Solution {
    // space O(1)
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};
        new Solution().reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
}
