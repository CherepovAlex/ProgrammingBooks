package String._2490CircularSentence;
// 2490. Замкнутое предложение
//Предложение — это список слов, разделённых одним пробелом, без пробелов в начале и в конце.
//Например, "Hello World", "HELLO", "hello world hello world" — все это предложения.
//Слова состоят только из прописных и строчных букв английского алфавита. Прописные и строчные буквы английского
// алфавита считаются разными.
// Предложение является Замкнутым, если:
//Последняя буква каждого слова в предложении совпадает с первой буквой следующего за ним слова.
//Последний символ последнего слова равен первому символу первого слова.
//Например, "leetcode exercises sound delightful", "eetcode", "leetcode eats soul"  — все это замкнутые предложения.
// Однако "Leetcode is cool", "happy Leetcode", "Leetcode" и "I like Leetcode"не являются замкнутыми предложениями.
//Для строки sentence верните true, если она циклическая. В противном случае верните false.
// Example 1:
//Input: sentence = "leetcode exercises sound delightful"
//Output: true
//Explanation: The words in sentence are ["leetcode", "exercises", "sound", "delightful"].
//- leetcode's last character is equal to exercises's first character.
//- exercises's last character is equal to sound's first character.
//- sound's last character is equal to delightful's first character.
//- delightful's last character is equal to leetcode's first character.
//The sentence is circular.
//Example 2:
//Input: sentence = "eetcode"
//Output: true
//Explanation: The words in sentence are ["eetcode"].
//- eetcode's last character is equal to eetcode's first character.
//The sentence is circular.
//Example 3:
//Input: sentence = "Leetcode is cool"
//Output: false
//Explanation: The words in sentence are ["Leetcode", "is", "cool"].
//- Leetcode's last character is not equal to is's first character.
//The sentence is not circular.
public class Solution {
    // time O(n), space O(1)
    public boolean isCircularSentence(String sentence) {
        // Проверяем, что последний символ строки равен первому символу
        if (sentence.charAt(sentence.length() - 1) != sentence.charAt(0)) return false;
        // Проходим по всем символам строки
        for (int i = 0; i < sentence.length(); i++) {
            // Если текущий символ - пробел
            if (sentence.charAt(i) == ' ') {
                // Проверяем, что последняя буква предыдущго слова равна первой букве следующего слова
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
        }
        // если все проверки пройдены, предложенние является замкнутым
        return true;
    }

    public static void main(String[] args) {
        String sentence = "leetcode exercises sound delightful";
        String sentence2 = "Leetcode is cool";
        System.out.println(new Solution().isCircularSentence(sentence));
        System.out.println(new Solution().isCircularSentence(sentence2));
    }
}
