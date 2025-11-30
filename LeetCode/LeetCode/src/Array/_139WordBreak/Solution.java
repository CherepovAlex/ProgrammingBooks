package Array._139WordBreak;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// 139. Перенос слова
// Данная строка s и словарь строк wordDict возвращают true в том случае, если s можно разделить на
// последовательность из одного или нескольких слов из словаря, разделённых пробелами.
// Обратите внимание, что одно и то же слово в словаре может использоваться в сегментации несколько раз.
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
    Set<String> dict; // Множество для хранения словаря
    HashMap<String, Boolean> cache = new HashMap<>(); // Кэш для запоминания результатов вычислений (мемоизация)

    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);// Инициализируем множество словарем
        return helper(s); // Запускаем рекурсивную функцию
    }
    private boolean helper(String s) {
        if (s == null || s.length() == 0) return true;// Базовый случай: пустая строка может быть разбита
        if (cache.containsKey(s)) {// Проверяем, не вычисляли ли мы уже результат для этой строки
            return cache.get(s);
        }
        int n = s.length();// Перебираем все возможные точки разбиения
        for (int i = 1; i <= n; i++) {
            String Left = s.substring(0, i);// Левая часть строки (первые i символов)
            String Right = s.substring(i, n);// Правая часть строки (оставшиеся символы)
            if (dict.contains(Left) && helper(Right)) {// Если левая часть есть в словаре И правая часть может быть разбита
                cache.put(s, true);// Сохраняем положительный результат в кэш
                return true;
            }
        }
        cache.put(s, false); // Если ни одно разбиение не сработало, сохраняем отрицательный результат
        return false;
    }
    // Рекурсивное решение (wordBreak):
    //Время: O(n²) с мемоизацией
    //Память: O(n) для кэша + O(n) для стека вызовов
    //Недостатки: Рекурсия может привести к переполнению стека для длинных строк

    // Оптимальным решением по времени и памяти является решение с динамическим программированием
    // time O(n * n), space O(n)
    public boolean wordBreak1(String s, List<String> wordDict) {
        // Инициируем переменную с длиной слова s
        int n = s.length();
        // Создаём множество для быстрого поиска слов
        Set<String> wordSet = new HashSet<>(wordDict); // преобразуем список в множество для O(1) поиска слов

        // dp[i] = true, если подстрока s[0:i] (первые i символов) может быть разбита на слова
        boolean[] dp = new boolean[n + 1]; // массив для хранения результатов:
        // Базовый случай: пустая строка всегда может быть разбита
        dp[0] = true; // пустая строка всегда может быть разбита // может быть разбита на слова
                      // база ДП: пустая строка всегда может быть разбита
        for (int i = 1; i <= n ; i++) { // перебираем все возможные окончания подстрок
            for (int j = 0; j < i; j++) { // ищем все возможные точки разбиения
                // если подстрока s[0:j] может быть разбита И // Можно ли разбить подстроку s[0:j] (dp[j] = true)
                // подстрока s[j;i] содержится в словаре      // Содержится ли подстрока s[j:i] в словаре
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                     // Нашли валидное разбиение для s[0:i]
                    dp[i] = true;       // если нашли валидное разбиение, помечаем и выходим
                    break; // переходим к следующей позиции
                }
            }
        }
        // Возвращаем результат для всей строки s[0:n]
        return dp[n];
    }
    // Оптимальное решение (wordBreak1):
    //Время: O(n²) - два вложенных цикла
    //Память: O(n) - массив dp размером n+1
    //Преимущества: Итеративное, нет риска переполнения стека
    // Оптимальное решение предпочтительнее из-за лучшей производительности и отсутствия риска переполнения стека.

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(new Solution().wordBreak(s, wordDict));
    }

}
