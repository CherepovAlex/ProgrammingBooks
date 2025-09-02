package Easy._1859SortingTheSentence;

import java.util.LinkedHashMap;
import java.util.Map;

// Предложение — это список слов, разделённых одним пробелом, без пробелов в начале и в конце. Каждое слово состоит из
// строчных и прописных букв английского алфавита.
//Предложение можно переставить, добавив к каждому слову позицию слова с индексом 1, а затем изменив порядок слов
// в предложении.
//Например, предложение "This is a sentence" можно переставить так, что получится "sentence4 a3 is2 This1" или
// "is2 sentence4 This1 a3".
//Дано перетасованное предложение s, содержащее не более 9 слов. Восстановите и верните исходное предложение.
// Example 1:
//Input: s = "is2 sentence4 This1 a3"
//Output: "This is a sentence"
//Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
//Example 2:
//Input: s = "Myself2 Me1 I4 and3"
//Output: "Me Myself and I"
//Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.
public class Solution {
    // time O(n log n)
    public String sortSentence(String s) {
        String[] words = s.split(" "); // Разбивает входную строку на массив слов по пробелам.

        Map<Integer, String> map = new LinkedHashMap<>(); // Создает LinkedHashMap для хранения пар (номер, слово).
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length(); // Извлекает последний символ каждого слова как номер
            int num = Integer.parseInt(String.valueOf(words[i].charAt(len - 1)));
            map.put(num, words[i].substring(0, len - 1)); // сохраняет слово без последнего символа.
        }

        String[] result = new String[words.length]; // Помещает слова в массив result на соответствующие позиции.
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            int index = entry.getKey();
            result[index - 1] = entry.getValue();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
            if(i != result.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    // time O(n)
    public String sortSentence1(String s) {
        String[] words = s.split(" ");

        // Создаём массив для результата
        String[] result = new String[words.length];

        for (String word : words) {
            // Извлекаем номер из конца слова
            int lastIndex = word.length() - 1;
            // Находим позицию последней цифры (на случай многозначных чисел)
            while (lastIndex >= 0 && Character.isDigit(word.charAt(lastIndex))){
                lastIndex--;
            }

            // Извлекаем номер и слово
            int num = Integer.parseInt(word.substring(lastIndex + 1));
            String cleanWord = word.substring(0, lastIndex + 1);

            // Помещаем слово на правильую позицию
            result[num - 1] = cleanWord;
        }

        // Собираем результат в строку
        return String.join(" ", result);

    }

    public static void main(String[] args) {
        String str = "is2 sentence4 This1 a3";
        System.out.println(new Solution().sortSentence(str));
    }

}
