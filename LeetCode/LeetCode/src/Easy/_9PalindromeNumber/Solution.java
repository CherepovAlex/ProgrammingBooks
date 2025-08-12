package Easy._9PalindromeNumber;

//Для заданного целого числа x верните true, если x является палиндромом, и false в противном случае.
//Пример 1:
//Входные данные: x = 121
//Выходные данные: true
//Пояснение: 121 читается как 121 слева направо и справа налево.
//Пример 2:
//Входные данные: x = -121
//Выходные данные: false
//Пояснение: Слева направо читается как -121. Справа налево читается как 121-. Следовательно, это не палиндром.
//Пример 3:
//Входные данные: x = 10
//Выходные данные: false
//Пояснение: Читаем 01 справа налево. Следовательно, это не палиндром.
public class Solution {
    // 1 version
    // time - O(log_10(n), space - O(1)
    public boolean isPalindrome(int x) {
        // Отрицательные числа и числа, оканчивающиеся на 0 (кроме 0) не могут быть палиндромами
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;
        // Разворачиваем вторую половину числа
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
            System.out.println(reversedHalf + " " + x);
        }
        // Для четного и нечетного количества цифр
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isPalindrome(12321);
        System.out.println();
        s.isPalindrome(123321);
    }
}

// 2 version, time - O(n), space - O(n)
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