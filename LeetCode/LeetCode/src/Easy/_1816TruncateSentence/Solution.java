package Easy._1816TruncateSentence;

// Предложение — это список слов, разделённых одним пробелом, без пробелов в начале и в конце.
// Каждое слово состоит только из прописных и строчных букв английского алфавита (без знаков препинания).
//Например, "Hello World", "HELLO", и "hello world hello world" — все это предложения.
//Вам дано предложение s и целое число k. Вы хотите обрезать s так, чтобы в предложении осталось только первое k
//  слово. Верните s после обрезания.
// Example 1:
//Input: s = "Hello how are you Contestant", k = 4
//Output: "Hello how are you"
//Explanation:
//The words in s are ["Hello", "how" "are", "you", "Contestant"].
//The first 4 words are ["Hello", "how", "are", "you"].
//Hence, you should return "Hello how are you".
//Example 2:
//Input: s = "What is the solution to this problem", k = 4
//Output: "What is the solution"
//Explanation:
//The words in s are ["What", "is" "the", "solution", "to", "this", "problem"].
//The first 4 words are ["What", "is", "the", "solution"].
//Hence, you should return "What is the solution".
//Example 3:
//Input: s = "chopper is not a tanuki", k = 5
//Output: "chopper is not a tanuki"
public class Solution {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" "); // Разделяем строку по пробелам на массив слов
        StringBuilder sb = new StringBuilder(); // Создаем StringBuilder для сборки результата
        int index = 0; // Индекс для прохода по массиву слов
        while (k != 0) { // Пока не соберем k слов
            sb.append(words[index] + " "); // Добавляем слово и пробел
            index++; // Переходим к следующему слову
            k--; // Уменьшаем счетчик оставшихся слов
        }
        return sb.toString().trim();
    }

    public String truncateSentence1(String s, int k) {
        // Разделяем строку на слова
        String[] words = s.split(" ");

        // Если k больше или равно количеству слов, возвращаем исходную строку
        if (k >= words.length) {
            return s;
        }

        // Создаем StringBuilder с начальной емкостью для оптимизации
        StringBuilder sb = new StringBuilder();

        // Добавляем первые k слов
        for (int i = 0; i < k; i++) {
            sb.append(words[i]);
            // Добавляем пробел только если это не последнее слово
            if (i < k - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Hello how are you Contestant";
        int k = 4;
        System.out.println(new Solution().truncateSentence(str, k));
    }
}
