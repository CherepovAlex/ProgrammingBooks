package Easy._2085CountCommonWordsWithOneOccurrence;

import java.util.HashMap;
import java.util.Map;

// Учитывая два массива строк words1 и words2, верните количество строк, которые появляются ровно один раз в
// каждом из двух массивов.
// Example 1:
//Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
//Output: 2
//Explanation:
//- "leetcode" appears exactly once in each of the two arrays. We count this string.
//- "amazing" appears exactly once in each of the two arrays. We count this string.
//- "is" appears in each of the two arrays, but there are 2 occurrences of it in words1. We do not count this string.
//- "as" appears once in words1, but does not appear in words2. We do not count this string.
//Thus, there are 2 strings that appear exactly once in each of the two arrays.
//Example 2:
//
//Input: words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
//Output: 0
//Explanation: There are no strings that appear in each of the two arrays.
//Example 3:
//
//Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
//Output: 1
//Explanation: The only string that appears exactly once in each of the two arrays is "ab".
public class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map = new HashMap<>(); // Создаем HashMap для подсчета частоты слов в первом массиве
        for (int i = 0; i < words1.length; i++) { // Проходим по всем словам первого массива и увеличиваем счетчик для каждого слова
            if (map.containsKey(words1[i])) {
                map.put(words1[i], map.get(words1[i]) + 1);
            } else {
                map.put(words1[i], 1);
            }
        }   //  Проходим по всем словам второго массива и умньшаем счетчик для каждого слова меньшего или равного 1
        for(String word : words2) {
            if (map.containsKey(word)) {
                if (map.get(word) <= 1) {
                    map.put(word, map.get(word) - 1);
                }
            }
        }
        int count = 0;  // Инициализируем счетчик для результата
        for (String word : words1) {    // Проходим по всем словам из первого HashMap
            if (map.get(word) == 0) {
                count++;                // Увеличиваем счетчик результата
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words1 = {"leetcode","is","amazing","as","is"};
        String[] words2 = {"amazing","leetcode","is"};
        System.out.println(new Solution().countWords(words1, words2));
    }
}
