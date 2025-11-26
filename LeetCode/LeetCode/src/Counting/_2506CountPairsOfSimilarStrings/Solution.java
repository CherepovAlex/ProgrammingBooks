package Counting._2506CountPairsOfSimilarStrings;

import java.util.HashMap;
import java.util.Map;

// 2506. Подсчёт пар одинаковых строк
//Вам дан массив строк с индексацией от 0 words.
//Две строки похожи, если они состоят из одинаковых символов.
//Например, "abca" и "cba" похожи, потому что оба состоят из символов 'a', 'b', и 'c'.
//Однако "abacba" и "bcfd" не похожи, поскольку состоят из разных символов.
//Верните количество пар (i, j) таких, что 0 <= i < j <= word.length - 1 и две строки words[i] и words[j] похожи.
// Example 1:
//Input: words = ["aba","aabb","abcd","bac","aabc"]
//Output: 2
//Explanation: There are 2 pairs that satisfy the conditions:
//- i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'.
//- i = 3 and j = 4 : both words[3] and words[4] only consist of characters 'a', 'b', and 'c'.
//Example 2:
//Input: words = ["aabb","ab","ba"]
//Output: 3
//Explanation: There are 3 pairs that satisfy the conditions:
//- i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'.
//- i = 0 and j = 2 : both words[0] and words[2] only consist of characters 'a' and 'b'.
//- i = 1 and j = 2 : both words[1] and words[2] only consist of characters 'a' and 'b'.
//Example 3:
//Input: words = ["nba","cba","dba"]
//Output: 0
//Explanation: Since there does not exist any pair that satisfies the conditions, we return 0.
public class Solution {

    public int similarPairs1(String[] words) {
        // Создаём хэш-таблицу для подсчета количества строк с одинаковым набором символов
        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        // Проходим по всем словам в массиве
        for (String word : words) {
            // Создаём битовую маску для представления набора символов в слове
            int mask = 0;

            // Для каждого символа в слове устанавливаем соответствующий бит в маске
            for (char c: word.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }

            // Получаем текущее количество строк с такой же маской
            int currentCount = freqMap.getOrDefault(mask, 0);

            // Добавляем в общему счетчику количество уже существующих пар с такой маской
            count += currentCount;

            // Обновляем счетчик для данной маски
            freqMap.put(mask, currentCount + 1);
        }
        return count;
    }

    public int similarPairs(String[] words) {
        int count = 0;
        int n = words.length;

        // Проходим по всем парам (i, j), где i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Проверяем, состоят ли строки из одинаковых символов
                if (haveSameChars(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    // Вспопомгательная функция для проверки одинаковости наборов символов
    private boolean haveSameChars(String s1, String s2) {
        boolean[] chars1 = new boolean[26];
        boolean[] chars2 = new boolean[26];

        // Отмечаем присутствующие символы в первой строке
        for (char c : s1.toCharArray()) {
            chars1[c - 'a'] = true;
        }

        // Отмечаем присутствующие символы во второй строке
        for (char c: s2.toCharArray()) {
            chars2[c - 'a'] = true;
        }

        // Проверяем, что наборы символов идентичны
        for (int i = 0; i < 26; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Тестирование примера 1
        String[] words1 = {"aba", "aabb", "abcd", "bac", "aabc"};
//        System.out.println(solution.similarPairs(words1)); // Output: 2
        System.out.println(solution.similarPairs1(words1)); // Output: 2

        // Тестирование примера 2
        String[] words2 = {"aabb", "ab", "ba"};
//        System.out.println(solution.similarPairs(words2)); // Output: 3
        System.out.println(solution.similarPairs1(words2)); // Output: 2

        // Тестирование примера 3
        String[] words3 = {"nba", "cba", "dba"};
//        System.out.println(solution.similarPairs(words3)); // Output: 0
        System.out.println(solution.similarPairs1(words3)); // Output: 0

    }
}
