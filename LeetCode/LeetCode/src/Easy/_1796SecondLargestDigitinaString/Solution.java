package Easy._1796SecondLargestDigitinaString;

import java.util.*;

// Учитывая буквенно-цифровую строку s, верните вторую по величине цифру, которая появляется в s,
// или -1 если она не существует.
//Буквенно-цифровая строка — это строка, состоящая из строчных букв английского алфавита и цифр.
// Example 1:
//Input: s = "dfa12321afd"
//Output: 2
//Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
//Example 2:
//Input: s = "abc1111"
//Output: -1
//Explanation: The digits that appear in s are [1]. There is no second largest digit.
public class Solution {

    public int secondHighest(String s) {
        Set<Integer> set = new HashSet<>();         // Создаем Set для хранения уникальных цифр
        for (int i = 0; i < s.length(); i++) {      // Проходим по всем символам строки
            char ch = s.charAt(i);                  // Получаем текущий символ
            if (Character.isDigit(ch)) {            // Проверяем, является ли символ цифрой
                set.add(Character.getNumericValue(ch)); // Добавляем числовое значение в Set
            }
        }
        List<Integer> list = new ArrayList<>(set);  // Преобразуем Set в ArrayList
        Collections.sort(list);                     // Сортируем список по возрастанию
        if (list.size() < 2) return -1;             // Если меньше 2 уникальных цифр, возвращаем -1
        return list.get(list.size() - 2);          // Берем предпоследний элемент (второй по величине)
    }
    // time O(n), space O(1)
    public int secondHighest1(String s) {
        int firstMax = -1;  // Наибольшая цифра
        int secondMax = -1; // Вторая по величине цифра

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int digit = Character.getNumericValue(ch);

                // Если цифра больше текущего максимума
                if (digit > firstMax) {
                    secondMax = firstMax;   // Старый максимум становится вторым
                    firstMax = digit;       // Новый максимум
                }
                // Если цифра между первым и вторым максимумом
                else if (digit > secondMax && digit < firstMax) {
                    secondMax = digit;
                }
            }
        }
        return secondMax;
    }

    public int secondHighest2(String s) {
        int first = -1;
        int second = -1;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int num = c - '0';  // Более эффективно, чем Character.getNumericValue()

                if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        String str1 = "dfa12321afd";
        System.out.println(new Solution().secondHighest(str1));

    }
}
