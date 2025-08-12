package Easy._557ReverseWordsInAStringIII;

// Данную строку s нужно перевернуть посимвольно в каждом слове предложения,
// сохранив пробелы и исходный порядок слов.
//Example 1:
//Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
//Example 2:
//Input: s = "Mr Ding"
//Output: "rM gniD"
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                word.append(c);
            } else {
                sb.append(word.reverse()); // Когда встречаем пробел, переворачиваем накопленное слово
                sb.append(' ');
                word.setLength(0);      // Очищаем буфер для следующего слова
            }
        }   // Добавляем последнее слово (после него нет пробела)
        sb.append(word.reverse());

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new Solution().reverseWords(s));
    }
}
