package String._58LengthOfLastWord;
// 58. Длина последнего слова
// Дана строка s, состоящая из слов и пробелов. Верните длину последнего слова в строке.
//Слово — это максимальная подстрока, состоящая только из символов, не являющихся пробелами.
// Example 1:
//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.
//Example 2:
//Input: s = "   fly me   to   the moon  "
//Output: 4
//Explanation: The last word is "moon" with length 4.
//Example 3:
//Input: s = "luffy is still joyboy"
//Output: 6
//Explanation: The last word is "joyboy" with length 6.
public class Solution {
    // space O(n)
    public int lengthOfLastWord(String s) {
        // Разделяем строку на массив подстрок по пробелам
        String[] strs = s.split(" ");
        // Возвращаем длину последнего элемента массива
        return strs[strs.length - 1].length();
    }
    // time O(n), space O(1)
    public int lengthOfLastWord1(String s) {
        // Инициализируем счетчик длины последнего слова
        int lenght = 0;
        // Проходим по строке с конца к началу
        for (int i = s.length() - 1; i >= 0; i--) {
             // Если текущий символ не пробел, увеличиваем счетчик
            if (s.charAt(i) != ' ') {
                lenght++;
            // Если встретили пробел И уже насчитали длину слова
            } else if (lenght > 0) {
                // Возвращаем длину, так как нашли конец последнего слова
                return lenght;
            }
        }
        return lenght; // Возвращаем длину (для случая, когда в строке только одно слово)
    }

    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(new Solution().lengthOfLastWord1(str));
    }

}
