package _9PalindromeNumber;

public class Solution {
    // 1 version
    // O(log_10(n), O(1) - space
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
            System.out.println(reversedHalf + " " + x);
        }
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isPalindrome(12321);
        System.out.println();
        s.isPalindrome(123321);
    }
}

// 2 version
//     private static boolean checkPalindrome(String num) {
//        int left = 0;
//        int right = num.length() - 1;
//        while (left < right) {
//            if (num.charAt(left) != num.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
//
//    public boolean isPalindrome(int x) {
//        if (x < 0) return false;
//
//        String num = x + "";
//
//        return checkPalindrome(num);
//    }