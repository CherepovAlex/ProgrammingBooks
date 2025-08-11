package Easy._2299StrongPasswordCheckerII;

// Пароль считается надёжным, если он соответствует всем следующим критериям:
//-В нём не менее 8 символов.
//-Он содержит как минимум одну строчную букву.
//-В нём есть как минимум одна заглавная буква.
//-Он содержит как минимум одну цифру.
//-Он содержит как минимум один специальный символ.
//  -- Специальными символами являются символы из следующей строки: "!@#$%^&*()-+".
//-В нём не содержится 2 одинаковых символов в соседних позициях (то есть "aab" нарушает это условие, а "aba" — нет).
//Для строки password верните true, если это надежный пароль. В противном случае верните false.
// Example 1:
//Input: password = "IloveLe3tcode!"
//Output: true
//Explanation: The password meets all the requirements. Therefore, we return true.
//Example 2:
//Input: password = "Me+You--IsMyDream"
//Output: false
//Explanation: The password does not contain a digit and also contains 2 of the same character in adjacent positions. Therefore, we return false.
//Example 3:
//Input: password = "1aB!"
//Output: false
//Explanation: The password does not meet the length requirement. Therefore, we return false.
public class Solution {

    public boolean strongPasswordCheckerII(String password) {
        return sizeConstraint(password) &&
                hasAtLeastOneUpperCaseLetter(password) &&
                hasAtLeastOneLowerCaseLetter(password) &&
                hasAtLeastOneDigit(password) &&
                hasSpecialCharacter(password) &&
                hasNoPairs(password);

    }

    private final boolean sizeConstraint(String s) {
        return s.length() > 7;
    }

    private final boolean hasAtLeastOneUpperCaseLetter(String s) {
        return !s.equals(s.toLowerCase());
    }

    private final boolean hasAtLeastOneLowerCaseLetter(String s) {
        return !s.equals(s.toUpperCase());
    }

    private final boolean hasAtLeastOneDigit(String s) {
        for (char character : s.toCharArray()) {
            if (character < 58 && character > 47) {
                return true;
            }
        }
        return false;
    }

    private final boolean hasSpecialCharacter(String s) {
        for (char character : "!@#$%^&*()-+".toCharArray()) {
            if (s.indexOf(character) > -1) {
                return true;
            }
        }
        return false;
    }

    private final boolean hasNoPairs(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "!Aa1a1a1";
        System.out.println(new Solution().strongPasswordCheckerII(str1));
    }
}
