package Easy._520DetectCapital;

// Мы считаем правильным использование заглавных букв в слове в одном из следующих случаев:
//Все буквы в этом слове заглавные, например "USA".
//Все буквы в этом слове не заглавные, например "leetcode".
//В этом слове заглавной является только первая буква, как в "Google".
//Для строки word верните true, если в ней правильно использованы заглавные буквы.
// Example 1:
//Input: word = "USA"
//Output: true
//Example 2:
//Input: word = "FlaG"
//Output: false
public class Solution {
    public boolean detectCapitalUse(String word) {
        return allCaps(word) || allLower(word) || titleCase(word);
    }

    private boolean allCaps(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count == str.length();
    }

    private boolean allLower(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {
                count++;
            }
        }
        return count == str.length();
    }

    private boolean titleCase(String str) {
        char ch = str.charAt(0);
        String subStr = str.substring(1);
        return Character.isUpperCase(ch) && allLower(subStr);
    }

    public static void main(String[] args) {
        String str1 = "USA";
        System.out.println(new Solution().detectCapitalUse(str1));
    }
}
