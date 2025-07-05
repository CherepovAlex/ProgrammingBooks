package exercise.junior;

public class Palindrome {
    public static void main(String[] args) {
        String str = "radar";
        System.out.println(isPalindrome(str)); // true

        str = "hello";
        System.out.println(isPalindrome(str)); // false
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
