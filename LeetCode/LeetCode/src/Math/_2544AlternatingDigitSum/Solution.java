package Math._2544AlternatingDigitSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2544. Сумма чередующихся цифр
//Вам дано положительное целое число n. Каждая цифра n имеет знак в соответствии со следующими правилами:
//Наиболее значимой цифре присваивается положительный знак.
//Каждая вторая цифра имеет знак, противоположный знаку соседних цифр.
//Верните сумму всех цифр с соответствующим знаком.
// Example 1:
//Input: n = 521
//Output: 4
//Explanation: (+5) + (-2) + (+1) = 4.
//Example 2:
//Input: n = 111
//Output: 1
//Explanation: (+1) + (-1) + (+1) = 1.
//Example 3:
//Input: n = 886996
//Output: 0
//Explanation: (+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0.
public class Solution {
    // time O(n), space O(1)
    public int alternateDigitSum(int n) {
        // Преобразуем число в строку для удобного доступа к цифрам
        String numStr = String.valueOf(n);

        // Инициализируем переменную для хранения суммы
        int sum = 0;

        // Проходим по каждой цифре числа
        for (int i = 0; i < numStr.length(); i++) {
            // Получаем текущую цифру как числовое знаение
            int digit = numStr.charAt(i) - '0';

            // Определяем знак: четные позиции (0, 2, 4 ...) - положительные
            // нечетные позиции (1, 3, 5 ...) - отрицательные
            // Поскольку индексы начинаются с 0, то i % 2 == 0 означает четную позицию
            if (i % 2 ==0) {
                // Добавляем цифру с положительным знаком
                sum += digit;
            } else {
                // Добавляем цифру с отрицательным знаком
                sum -= digit;
            }
        }
        //
        return sum;
    }

    public int alternateDigitSum1(int n) {
        // Создаём список для хранения цифр числа
        List<Integer> digits = new ArrayList<>();

        // Разбиваем число на цифры и сохраняем их в список
        while (n > 0) {
            // Получаем последнюю цифру числа
            digits.add(n % 10);
            // Убираем последнюю цифру из числа
            n /= 10;
        }
        // Переворачиваем список, так как цифры было добавлены в обратном порядке
        Collections.reverse(digits);

        // Инициализируем переменную для хранения суммы
        int sum = 0;

        // Проходим по цифрам и применяем чередующиеся знаки
        for (int i = 0; i < digits.size(); i++) {
            // Четные позиции (0, 2, 4 ...) - положительные
            if (i % 2 == 0) {
                sum += digits.get(i);
            } else {
                // Нечетные позиции (1, 3, 5 ...) - отрицательные
                sum -= digits.get(i);
            }
        }
        // Возвращаем итоговую сумму
        return sum;
    }

    public int alternateDigitSum2(int n) {
        // Преобразуем число в строку
        String s = String.valueOf(n);
        int sum = 0;

        // Однопроходный расчет суммы с чередующимися знаками
        for (int i = 0; i < s.length(); i++) {
            // Получаем цифру и умножаем на +1 или -1 в зависимости от позиции
            sum += (s.charAt(i) - '0') * (i % 2 == 0 ? 1 : -1);
        }

        return sum;
    }

    public static void main(String[] args) {
        int n = 521;
        System.out.println(new Solution().alternateDigitSum(n)); // 4
    }
}
