package Recursion._10RegularExpressionMatching;

public class Solution {
    // time O(n * m), space O(min(n, m)), n,m - length of s, p
    public boolean isMatch(String s, String p) {
        // dp[j] будет означать: можно ли сопоставить префикс s длины i с префиксом p длины j
        // Используем два массива для текущей и предыдущей строки DP
        // Создаем два массива для хранения предыдущей и текущей строки DP таблицы
        boolean[] prev = new boolean[p.length() + 1];
        boolean[] curr = new boolean[p.length() + 1];

        // Базовый случай: пустая строка и пустой шаблон совпадают
        prev[0] = true;

        // Инициализация для случая, когда строка пустая, а шаблон содержит '*'
        // Заполняем первую строку DP (случай пустой строки s)
        for (int j = 1; j <= p.length(); j++) {
            // Если текущий символ в шаблоне '*', можно пропустить предыдущий символ
            if (p.charAt(j - 1) == '*') {
                // '*' может означать 0 вхождений предыдущего символа
                prev[j] = prev[j - 2];
                // Проверяем возможность совпадения без символа перед '*'
            }
        }
        // Основной цикл по символам строки s
        // Заполняем таблицу DP по строкам (по символам строки s)
        for (int i = 1; i <= s.length(); i++) {
            // Непустая строка не может совпасть с пустым шаблоном
            // curr[0] всегда false для i > 0 (непустая строка с пустым шаблоном)
            curr[0] = false;
            // Вложенный цикл по символам шаблона p
            for (int j = 1; j <= p.length(); j++) {
                // Текущий символ шаблона
                char patternChar = p.charAt(j - 1);
                // Обработка символа '*'
                if (patternChar == '*') {
                    // Вариант 1: '*' означает 0 вхождений предыдущего символа
                    boolean zeroOccurrences = curr[j - 2];

                    // Вариант 2: '*' означает одно или более вхождений предыдущего символа
                    char prevPatternChar = p.charAt(j - 2);
                    // Проверяем совпадение текущего символа s с символом перед '*'
                    boolean oneOrMoreOccurrences = prev[j] &&
                        (prevPatternChar == '.' || prevPatternChar == s.charAt(i - 1));
                    // Объединяем оба варианта
                    curr[j] = zeroOccurrences || oneOrMoreOccurrences;
                }
                // Обработка точки или совпадающего символа
                else if (patternChar == '.' || patternChar == s.charAt(i - 1)) {
                    // Точка совпадает с любым символом, или символы совпадают
                    curr[j] = prev[j - 1];
                }
                else {
                    // Символы не совпадают и не точка
                    curr[j] = false;
                }
            }

            // Переключаем массивы для следующей итерации по i
            // Меняем массивы местами для следующей итерации
            boolean[] temp = prev;
            prev = curr;
            curr = temp;

            // Обнуляем новый curr (старый prev) для следующей итерации
            // Необязательно обнулять весь массив, только ячейки которые будут использоваться
            // Но для безопасности можно обнулить первую ячейку
            curr[0] = false;
        }

        // Ответ находится в prev[p.length()] после последней итерации
        return prev[p.length()];
    }
    // Оптимизации:
    //Память O(min(n,m)): Используем только два массива вместо всей матрицы.
    //Время O(n×m): Проходим по всем комбинациям символов строки и шаблона.
    //Минимум операций: Только необходимые проверки без рекурсивных вызовов.
    //Логика DP:
    //prev[j] = можно ли сопоставить s[0..i-1] с p[0..j-1]
    //curr[j] = можно ли сопоставить s[0..i] с p[0..j-1]
    //Переходы обрабатывают три случая: *, ., обычный символ

    public static void main(String[] args) {
        String s = "aa", p = "a";
        System.out.println(new Solution().isMatch(s, p));
        String s1 = "aa", p1 = "a*";
        System.out.println(new Solution().isMatch(s1, p1));
        String s2 = "ab", p2 = ".*";
        System.out.println(new Solution().isMatch(s2, p2));
    }

}


class Solution2 {
    // time O(n * m), space O(min(n, m)), n,m - length of s, p
    public boolean isMatch(String s, String p) {
        // dp[j] will mean: can we match the prefix of s of length i with the prefix of p of length j
        // We use two arrays for current and previous DP rows
        // Create two arrays to store previous and current rows of the DP table
        boolean[] prev = new boolean[p.length() + 1];
        boolean[] curr = new boolean[p.length() + 1];

        // Base case: empty string and empty pattern match
        prev[0] = true;

        // Initialization for the case when the string is empty but the pattern contains '*'
        // Fill the first DP row (case of empty string s)
        for (int j = 1; j <= p.length(); j++) {
            // If the current character in the pattern is '*', we can skip the previous character
            if (p.charAt(j - 1) == '*') {
                // '*' can mean 0 occurrences of the previous character
                prev[j] = prev[j - 2];
                // Check the possibility of matching without the character before '*'
            }
        }
        // Main loop over characters of string s
        // Fill the DP table row by row (by characters of string s)
        for (int i = 1; i <= s.length(); i++) {
            // A non-empty string cannot match an empty pattern
            // curr[0] is always false for i > 0 (non-empty string with empty pattern)
            curr[0] = false;
            // Nested loop over characters of pattern p
            for (int j = 1; j <= p.length(); j++) {
                // Current pattern character
                char patternChar = p.charAt(j - 1);
                // Processing the '*' character
                if (patternChar == '*') {
                    // Option 1: '*' means 0 occurrences of the previous character
                    boolean zeroOccurrences = curr[j - 2];

                    // Option 2: '*' means one or more occurrences of the previous character
                    char prevPatternChar = p.charAt(j - 2);
                    // Check if the current s character matches the character before '*'
                    boolean oneOrMoreOccurrences = prev[j] &&
                        (prevPatternChar == '.' || prevPatternChar == s.charAt(i - 1));
                    // Combine both options
                    curr[j] = zeroOccurrences || oneOrMoreOccurrences;
                }
                // Processing dot or matching character
                else if (patternChar == '.' || patternChar == s.charAt(i - 1)) {
                    // Dot matches any character, or characters match
                    curr[j] = prev[j - 1];
                }
                else {
                    // Characters do not match and it's not a dot
                    curr[j] = false;
                }
            }

            // Switch arrays for the next iteration over i
            // Swap arrays for the next iteration
            boolean[] temp = prev;
            prev = curr;
            curr = temp;

            // Reset the new curr (old prev) for the next iteration
            // It is not mandatory to clear the whole array, only cells that will be used
            // But for safety, we can reset the first cell
            curr[0] = false;
        }

        // The answer is in prev[p.length()] after the last iteration
        return prev[p.length()];
    }
    // Optimizations:
    //Memory O(min(n,m)): We use only two arrays instead of the whole matrix.
    //Time O(n×m): We iterate over all combinations of string and pattern characters.
    //Minimal operations: Only necessary checks without recursive calls.
    //DP Logic:
    //prev[j] = can we match s[0..i-1] with p[0..j-1]
    //curr[j] = can we match s[0..i] with p[0..j-1]
    //Transitions handle three cases: *, ., regular character

    public static void main(String[] args) {
        String s = "aa", p = "a";
        System.out.println(new Solution().isMatch(s, p));
        String s1 = "aa", p1 = "a*";
        System.out.println(new Solution().isMatch(s1, p1));
        String s2 = "ab", p2 = ".*";
        System.out.println(new Solution().isMatch(s2, p2));
    }

}
