package Medium._7ReverseInteger;

// Для 32-битного целого числа со знаком x верните x с переставленными цифрами.
// Если при перестановке x значение выходит за пределы диапазона
// 32-битных целых чисел со знаком [-2^31, 2^31 - 1], верните 0.
//Предположим, что среда не позволяет хранить 64-битные целые числа (со знаком или без знака).
// Example 1:
//Input: x = 123
//Output: 321
//Example 2:
//Input: x = -123
//Output: -321
//Example 3:
//Input: x = 120
//Output: 21
public class Solution {
    // version 1
    public int reverse(int x) {
        int reversed = 0;   // Инициализация переменной для хранения результата
        while (x != 0) {
            int pop = x % 10; // Получаем последнюю цифру
            x = x / 10;       // Удаляем последнюю цифру из x
            // Проверка на переполнение перед умножением и сложением
            // Перед умножением на 10 мы проверяем, не станет ли reversed больше Integer.MAX_VALUE / 10
            if (reversed > Integer.MAX_VALUE / 10 ||
                    // мы дополнительно проверяем, не превышает ли новая цифра Integer.MAX_VALUE % 10
                    (reversed == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            // Перед умножением на 10 мы проверяем, не станет ли reversed меньше Integer.MAX_VALUE / 10
            if (reversed < Integer.MIN_VALUE / 10 ||
                    // мы дополнительно проверяем, не меньше ли новая цифра Integer.MAX_VALUE % 10
                    (reversed == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            // Только после всех проверок безопасно обновляем значение reversed.
            reversed = reversed * 10 + pop;
        }
        return reversed;
    }

    // version 2
    public int reverse1(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        int res = 0;
        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }
            res = (res * 10) + digit;
        }

        return isNegative ? -res : res;
    }

    public static void main(String[] args) {
        int num = 1534236469;
        System.out.println(new Solution().reverse(num));
    }
}
