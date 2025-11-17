package Easy._2180CountIntegersWithEvenDigitSum;

// Для заданного положительного целого числа num верните количество положительных целых чисел меньше или равно num
// сумма цифр которых чётная.
// Сумма цифр положительного целого числа — это сумма всех его цифр.
// Example 1:
//Input: num = 4
//Output: 2
//Explanation:
//The only integers less than or equal to 4 whose digit sums are even are 2 and 4.
//Example 2:
//Input: num = 30
//Output: 14
//Explanation:
//The 14 integers less than or equal to 30 whose digit sums are even are
//2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26, and 28.
public class Solution {
    // time O(log(num)), space O(1)
    public int countEven(int num) {
        // Получаем сумму цифр числп num
        int sum = digitSum(num);

        // Если сумма цифр четная, то количество чисел = num / 2
        // Если сумма цифр не четная, то количество чисел = (num - 1) / 2
        return (sum % 2 == 0) ? num / 2 : (num - 1) / 2;

//        счетный вариант
//        int count = 0;
//        for (int i = 1; i <=num ; i++) {
//            if (digitSum(num) % 2 == 0)
//                count++;
//        }
    }

    // Вспомогательный метод для вычисления суммы цифр числа
    private int digitSum(int n) {
        int sum = 0;    // Инициализируем переменную для хранения суммы

        // Пока число не равно 0, продожаем суммировать цифры
        while (n > 0) {
            sum += n % 10;  // Добавляем последнюю цифру числа к сумме
            n /= 10;        // Удаляем последнуюю цифру из числа
        }
        return sum; // Возвращаем сумму всех цифр
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countEven(4));
    }
}
