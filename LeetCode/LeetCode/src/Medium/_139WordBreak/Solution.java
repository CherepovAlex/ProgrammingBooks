package Medium._139WordBreak;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Данная строка s и словарь строк wordDict возвращают true в том случае, если s можно разделить на
// последовательность из одного или нескольких слов из словаря, разделённых пробелами.
//Обратите внимание, что одно и то же слово в словаре может использоваться в сегментации несколько раз.
//Example 1:
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
//Example 2:
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//Note that you are allowed to reuse a dictionary word.
//Example 3:
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
public class Solution {
    Set<String> dict;
    HashMap<String, Boolean> cache = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        return helper(s);
    }
    private boolean helper(String s) {
        if (s == null || s.length() == 0) return true;
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        int n = s.length();
        for (int i = 1; i <= n; i++) {
            String Left = s.substring(0, i);
            String Right = s.substring(i, n);
            if (dict.contains(Left) && helper(Right)) {
                cache.put(s, true);
                return true;
            }
        }
        cache.put(s, false);
        return false;
    }
    // time O(n * n), space O(n)
    public boolean wordBreak1(String s, List<String> wordDict) {
        int n = s.length();
        // Создаём множество для быстрого поиска слов
        Set<String> wordSet = new HashSet<>(wordDict); // преобразуем список в множество для O(1) поиска слов

        // dp[i] = true, если подстрока s[0:i] может быть разбита на слова
        boolean[] dp = new boolean[n + 1]; // массив для хранения результатов:
        dp[0] = true; // пустая строка всегда может быть разбита // может быть разбита на слова
                      // база ДП: пустая строка всегда может быть разбита
        for (int i = 1; i <= n ; i++) { // перебираем все возможные окончания подстрок
            for (int j = 0; j < i; j++) { // ищем все возможные точки разбиения
                // если подстрока s[0:j] может быть разбита И // Можно ли разбить подстроку s[0:j] (dp[j] = true)
                // подстрока s[j;i] содержится в словаре      // Содержится ли подстрока s[j:i] в словаре
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;       // если нашли валидное разбиение, помечаем и выходим
                    break; // переходим к следующей позиции
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(new Solution().wordBreak(s, wordDict));
    }

}
