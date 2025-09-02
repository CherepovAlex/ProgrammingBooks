package Easy._1941CheckIfAllCharactersHaveEqualNumberOfOccurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Для строки s верните true, если s является хорошей строкой, или false в противном случае.
//Строка s является хорошей, если все символы, встречающиеся в s, имеют одинаковое количество вхождений
// (то есть одинаковую частоту).
// Example 1:
//Input: s = "abacbc"
//Output: true
//Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.
//Example 2:
//Input: s = "aaabb"
//Output: false
//Explanation: The characters that appear in s are 'a' and 'b'.
//'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.
public class Solution {
    // time O(n), space O(k)
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();  // для подсчета частот символов
        for (int i = 0; i < s.length(); i++) {  // Цикл для подсчета частот
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);   // Увеличиваем счетчик
            } else {
                map.put(ch, 1);                 // Первое вхождение символа
            }
        }           // Создание множества из значений частот
        Set<Integer> set = new HashSet<Integer>(map.values());
        if (set.size() == 1) {  // Проверка, все ли частоты одинаковы:
            return true;
        }
        return false;
    }

    public boolean areOccurrencesEqual2(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Подсчет частот с использованием getOrDefault
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Проверка без создания отдельного HashSet
        int firstFrequency = -1;
        for (int count : frequencyMap.values()) {
            if (firstFrequency == -1) {
                firstFrequency = count;  // Запоминаем первую частоту
            } else if (count != firstFrequency) {
                return false;  // Нашли несовпадение - сразу возвращаем false
            }
        }

        return true;  // Все частоты одинаковы
    }

    public static void main(String[] args) {
        String str = "abacbc";
        System.out.println(new Solution().areOccurrencesEqual(str));
    }

}
