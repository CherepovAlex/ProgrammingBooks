package Counting._387FirstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.Map;

// 387. Первый уникальный символ в строке
// Дана строка s. Найдите в ней первый неповторяющийся символ и верните его индекс.
// Если такого символа нет, верните -1.
// Example 1:
//Input: s = "leetcode"
//Output: 0
//Explanation:
//The character 'l' at index 0 is the first character that does not occur at any other index.
//Example 2:
//Input: s = "loveleetcode"
//Output: 2
//Example 3:
//Input: s = "aabb"
//Output: -1
public class Solution {
    // time O(n), space O(1)
    // Метод с использованием HashMap для подсчета частот символов
    public int firstUniqChar(String s) {
        // Создаем HashMap для хранения частоты каждого символа
        Map<Character, Integer> map = new HashMap<>();
        // Первый проход: подсчитываем частоту каждого символа в строке
        for (int i = 0; i < s.length(); i++) {
            // Получаем текущий символ по индексу i
            char ch = s.charAt(i);
            // Обновляем счетчик для данного символа
            // getOrDefault возвращает текущее значение или 0, если символа еще нет
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // Второй проход: ищем первый символ с частотой 1
        for (int i = 0; i < s.length(); i++) {
            // Если частота текущего символа равна 1, возвращаем его индекс
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        // Если уникальных символов нет, возвращаем -1
        return -1;
    }
    // time O(n), space O(1)
    // Более оптимальный метод с использованием массива фиксированного размера
    public int firstUniqChar2(String s) {
        // Создаем массив для подсчета частот (256 элементов для ASCII символов)
        int[] freq = new int[256];
        // Первый проход: увеличиваем счетчик для каждого символа
        for (int i = 0; i < s.length(); i++) {
            // char автоматически преобразуется в int (ASCII код)
            freq[s.charAt(i)]++;
        }
        // Второй проход: ищем первый символ с частотой 1
        for (int i = 0; i < s.length(); i++) {
            // Проверяем частоту текущего символа
            if (freq[s.charAt(i)] == 1) {
                return i;
            }
        }
        // Если уникальных символов нет, возвращаем -1
        return -1;
    }
    // Рекомендации:
    //Для большинства случаев используйте второй метод - он быстрее и использует меньше памяти.
    //Если нужна абсолютная универсальность для любых Unicode символов, лучше использовать метод с HashMap.
    //Для LeetCode второй метод предпочтительнее, так как ограничения обычно предполагают ASCII символы.
    //Оба решения имеют временную сложность O(n) и пространственную сложность O(1)
    // (поскольку размер структур данных фиксирован и не зависит от n).

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new Solution().firstUniqChar(s));
    }
}
