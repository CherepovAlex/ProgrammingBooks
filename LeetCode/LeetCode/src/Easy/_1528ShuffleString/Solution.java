package Easy._1528ShuffleString;

// Вам дана строка s и целочисленный массив indicesтой же длины.
// Строка s будет перемешана таким образом, что символ в позиции ith переместится
// в позицию indices[i] в перемешанной строке.
//Верните перетасованную строку.
// Example 1:
//Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
//Output: "leetcode"
//Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
//Example 2:
//Input: s = "abc", indices = [0,1,2]
//Output: "abc"
//Explanation: After shuffling, each character remains in its position.
public class Solution {
    // time O(n*n)
    public String restoreString(String s, int[] indices) {
        if (s == null || s.isEmpty()) return "";
        if (s.length() != indices.length) return "";
        char[] ch = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            ch[indices[i]] = s.charAt(i);
        }
        StringBuilder result = new StringBuilder();
        for (char c : ch) {
            result.append(c);
        }
        return result.toString();
    }
    // time O(n*n)
    public String restoreString1(String s, int[] indices) {
        if (s == null || s.isEmpty()) return "";
        if (s.length() != indices.length) return "";
        char[] chars = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            int pos = indices[i];
            chars[pos] = s.charAt(i);
        }
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            result.append(aChar);
        }
        return result.toString();
    }
    // time O(n)
    public String restoreString2(String s, int[] indices) {
        char[] arr = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            arr[indices[i]] = s.charAt(i);
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(new Solution().restoreString(str, indices));
    }

}
