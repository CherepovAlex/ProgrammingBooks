package Easy._125ValidPalindrome;
// Фраза является палиндромом, если после преобразования всех заглавных букв в строчные и
// удаления всех небуквенно-цифровых символов она читается одинаково как слева направо, так и справа налево.
// Буквенно-цифровые символы включают буквы и цифры.
//Для заданной строки s верните true, если это палиндром, или false в противном случае.
// Example 1:
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//Example 2:
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
public class Solution {
    // time O(n), space O(m)
    public boolean isPalindrome(String s) {
        // ранний выход для пустой строки (не обязательно, но улучшает читаемость)
        if (s.isEmpty()) {
            return true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            // time O(1)
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        String result = sb.toString();
        return checkPalindrome(result);
    }

    public boolean checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        // O(m)
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            // O(1)
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";
        System.out.println(new Solution().isPalindrome(s1));
        System.out.println(new Solution().isPalindrome(s2));
        System.out.println(new Solution().isPalindrome(s3));
    }

}
