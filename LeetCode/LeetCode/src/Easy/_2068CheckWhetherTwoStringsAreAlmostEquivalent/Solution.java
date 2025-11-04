package Easy._2068CheckWhetherTwoStringsAreAlmostEquivalent;

// 2068. Проверьте, почти ли эквивалентны две строки
//Две строки word1 и word2 считаются почти эквивалентными, если разница между частотами встречаемости каждой
// буквы от 'a' до 'z' в строках word1 и word2 составляет не более 3
//Даны две строки word1 и word2, каждая длиной n, верните true если word1 и word2 являются почти эквивалентными,
// или false в противном случае.
//Частота буквы x — это количество её повторений в строке.
// Example 1:
//Input: word1 = "aaaa", word2 = "bccb"
//Output: false
//Explanation: There are 4 'a's in "aaaa" but 0 'a's in "bccb".
//The difference is 4, which is more than the allowed 3.
//Example 2:
//Input: word1 = "abcdeef", word2 = "abaaacc"
//Output: true
//Explanation: The differences between the frequencies of each letter in word1 and word2 are at most 3:
//- 'a' appears 1 time in word1 and 4 times in word2. The difference is 3.
//- 'b' appears 1 time in word1 and 1 time in word2. The difference is 0.
//- 'c' appears 1 time in word1 and 2 times in word2. The difference is 1.
//- 'd' appears 1 time in word1 and 0 times in word2. The difference is 1.
//- 'e' appears 2 times in word1 and 0 times in word2. The difference is 2.
//- 'f' appears 1 time in word1 and 0 times in word2. The difference is 1.
//Example 3:
//Input: word1 = "cccddabba", word2 = "babababab"
//Output: true
//Explanation: The differences between the frequencies of each letter in word1 and word2 are at most 3:
//- 'a' appears 2 times in word1 and 4 times in word2. The difference is 2.
//- 'b' appears 2 times in word1 and 5 times in word2. The difference is 3.
//- 'c' appears 3 times in word1 and 0 times in word2. The difference is 3.
//- 'd' appears 2 times in word1 and 0 times in word2. The difference is 2.
public class Solution {
    // O(n) - time, O(1) - space
    public boolean checkAlmostEquivalent(String word1, String word2) {
        // Создаём два массива для подсчета частот букв в каждой строке
        // Размер 26, так как английский алфавит содержит 26 букв
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Подсчитываем частоты для первой строки
        // Проходим по каждому символу в word1
        for (char c : word1.toCharArray()) {
            // Увеличиваем счетчик для соответствующей буквы
            // 'a' имеет код 97, вычитывая 97 получаем индекс от 0 до 25
            freq1[c - 'a']++;
        }

        // Подсчитываем частоты для второй строки
        // Аналогично проходим по каждому символй в word2
        for (char c : word2.toCharArray()) {
            // Увеличиваем счетчик для соответствующей буквы
            freq2[c - 'a']++;
        }

        // Проверяем разницу частот для каждой буквы алфавита
        // Проходим по всем 26 буквам
        for (int i = 0; i < 26; i++) {
            // Вычисляем абсолютную разницу между частотами
            // Math.abs() возвращает модуль числа
            int diff = Math.abs(freq1[i] - freq2[i]);

            // Если разница больше 3, строки не почти эквивалентны
            if (diff > 3) {
                return false;
            }
        }

        // Ели для всех букв разница <= 3, возвращаем true
        return true;
    }

    public static void main(String[] args) {
        String word1 = "abcdeef";
        String word2 = "abaaacc";
        System.out.println(new Solution().checkAlmostEquivalent(word1, word2));
    }
}
