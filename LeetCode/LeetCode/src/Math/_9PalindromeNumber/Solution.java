package Math._9PalindromeNumber;

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
    // 1 version - оптимальн
    // time - O(log_10(n), space - O(1)
    public boolean isPalindrome1(int x) {
        // Отрицательные числа и числа, оканчивающиеся на 0 (кроме 0) не могут быть палиндромами
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        // Инициализируем переменную для хранения развернутой половины числа
        int reversedHalf = 0;
        // Разворачиваем вторую половину числа, пока исходное число больше развернутой половины
        while (x > reversedHalf) {
            // добавляем последнюю цифру исходного числа к развернутой половине
            reversedHalf = reversedHalf * 10 + x % 10;
            // Удаляем последнюю цифру из исходного числа
            x /= 10;
            // Выводим отладочную информацию
            // System.out.println(reversedHalf + " " + x);
        }
        // Проверяем для четного и нечетного количества цифр
        return x == reversedHalf || x == reversedHalf / 10;
    }

     // 2 version, time - O(n), space - O(n) - более читаемый, но использует дополнительную помять
     private static boolean checkPalindrome(String num) {
        // Устанавливает указатели на начало и коней строки
        int left = 0;
        int right = num.length() - 1;

        // Проверяем симметричность, двигаясь к центру
        while (left < right) {
            // Если симметричные символы не равны - не палиндром
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            // сдвигаем указатели к центру
            left++;
            right--;
        }
        // Все симметричные пары совпали - палиндром
        return true;
    }

    public boolean isPalindrome2(int x) {
        // Отрицательные числ не могут быть палиндромом
        if (x < 0) return false;
        // Преобразуем чисо в строку
        String num = x + "";
        // Проверяем, является ли строка палиндромом
        return checkPalindrome(num);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isPalindrome1(12321);
        System.out.println();
        s.isPalindrome1(123321);
    }
}
