package Easy._1768MergeStringsAlternately;

// Вам даны две строки word1 и word2.
// Объедините строки, добавляя буквы в порядке чередования, начиная с word1.
// Если одна строка длиннее другой, добавьте дополнительные буквы в конец объединённой строки.
//
//Возвращает объединенную строку.
// Example 1:
//Input: word1 = "abc", word2 = "pqr"
//Output: "apbqcr"
//Explanation: The merged string will be merged as so:
//word1:  a   b   c
//word2:    p   q   r
//merged: a p b q c r
//Example 2:
//Input: word1 = "ab", word2 = "pqrs"
//Output: "apbqrs"
//Explanation: Notice that as word2 is longer, "rs" is appended to the end.
//word1:  a   b
//word2:    p   q   r   s
//merged: a p b q   r   s
//Example 3:
//Input: word1 = "abcd", word2 = "pq"
//Output: "apbqcd"
//Explanation: Notice that as word1 is longer, "cd" is appended to the end.
//word1:  a   b   c   d
//word2:    p   q
//merged: a p b q c   d
public class Solution {
    // time O(n+m), space O(n+m)
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, n = word1.length(), m = word2.length();
        // Чередуем символы пока обе строки имеют символы
        while (i < n && i < m) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
            i++;
        }
        // Добавляем оставшиеся символы из более длинной строки
        if (i < n) result.append(word1.substring(i));
        if (i < m) result.append(word2.substring(i));
        return result.toString();
    }

    public String mergeAlternately1(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int min = Math.min(len1, len2);
        String longerString = "";
        if (min == len1) longerString = word2;
        if (min == len2) longerString = word1;
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            sb.append(chars1[i]);
            sb.append(chars2[i]);
        }
        sb.append(longerString.substring(min));
        return sb.toString();
    }


    public static void main(String[] args) {
        String str1 = "abc", str2 = "pqr";
        System.out.println(new Solution().mergeAlternately(str1, str2)); // apbqcr

        String str3 = "ab", str4 = "pqrs";
        System.out.println(new Solution().mergeAlternately(str3, str4)); // apbqrs
    }

}
