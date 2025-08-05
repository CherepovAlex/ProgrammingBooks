package _13RomanToInteger;
// Римские цифры обозначаются семью различными символами: I, V, X, L, C, D и M.
//Значение Символ: I 1, V 5, X 10, L 50, C 100, D 500, M 1000
//Например, 2 записывается как II римскими цифрами — это просто две единицы, сложенные вместе.
// 12 записывается как XII, то есть просто X + II. Число 27 записывается как XXVII, то есть XX + V + II.
//Римские цифры обычно записываются слева направо в порядке убывания.
// Однако цифра четыре записывается не как IIII. Вместо этого число четыре записывается как IV.
// Поскольку единица стоит перед пятёркой, мы вычитаем её, получая четыре.
// Тот же принцип применим к числу девять, которое записывается как IX. Вычитание используется в шести случаях:
//I можно поставить перед V (5) и X (10), чтобы получилось 4 и 9.
//X можно поставить перед L (50) и C (100), чтобы получилось 40 и 90.
//C можно поставить перед D (500) и M (1000), чтобы получилось 400 и 900.
//Данное римское число необходимо преобразовать в целое число.
//Пример 1:
//Ввод: s = «III»
//Вывод: 3
//Пояснение: III = 3.
//Пример 2:
//Входные данные: s = «LVIII»
//Выходные данные: 58
//Пояснение: L = 50, V = 5, III = 3.
//Пример 3:
//Ввод: s = "MCMXCIV"
//Вывод: 1994
//Пояснение: M = 1000, CM = 900, XC = 90 и IV = 4.
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // time O(n), space O(n)
    public int romanToInt(String s) {
        // Создаем хэш-таблицу для соответствия символов и их значений
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // Преобразуем строку в массив символов
        char[] chars = s.toCharArray();
        int result = 0;
        int i, j;

        // Проходим по строке, сравнивая текущий и следующий символы
        for (i = 0, j = 1; j < chars.length; i++, j++) {
            if (map.get(chars[i]) >= map.get(chars[j])) {
                // Если текущий символ больше или равен следующему, прибавляем его значение
                result += map.get(chars[i]);
            } else {
                // Иначе вычитаем его значение (случай типа IV, IX и т.д.)
                result -= map.get(chars[i]);
            }
        }
        // Добавляем значение последнего символа
        result += map.get(chars[i]);
        return result;
    }

    // time O(n), space O(1)
    public int romanToInt1(String s) {
        int result = 0;
        // Получаем значение первого символа
        int prev = getValue(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int curr = getValue(s.charAt(i));
            if (prev >= curr) {
                result += prev;
            } else {
                result -= prev;
            }
            prev = curr;
        }
        result += prev;
        return result;
    }

    private int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new Solution().romanToInt1(s));
    }
}
