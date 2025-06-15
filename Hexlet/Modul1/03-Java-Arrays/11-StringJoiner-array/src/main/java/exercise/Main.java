// Реализуйте публичный статический метод makeCensored(), который заменяет каждое вхождение указанного слова
// (из списка переданных) в предложении на последовательность $#%! , возвращает полученную строку. Аргументы:
// - Текст
// - Массив стоп-слов
// Словом считается любая непрерывная последовательность символов, включая любые спецсимволы (без пробелов).
// Подсказки
// - Разбить строку на массив слов можно при помощи метода split()
// - Чтобы обратно собрать строку из массива, вам может понадобиться метод join() или класс StringJoiner
// - Для проверки вхождения строки в массив используйте метод ArrayUtils.contains()
package exercise;
import org.apache.commons.lang3.ArrayUtils;
// uncomment the line below if you want to use StringJoiner;
// import java.util.StringJoiner;
public class Main {
    // BEGIN
    public static String makeCensored(String text, String[] stopWords) {
        var words = text.split(" ");
        var wordsCount = words.length;

        var censoredWords = new String[wordsCount];

        for (var i = 0; i < wordsCount; i++) {
            var word = words[i];
            var newWord = ArrayUtils.contains(stopWords, word) ? "$#%!" : word;
            censoredWords[i] = newWord;
        }
        return String.join(" ", censoredWords);
        // Alternative solution with StringJoiner
        // var words = text.split(" ");
        // var result = new StringJoiner(" ");

        // for (var word : words) {
        //     var newWord = ArrayUtils.contains(stopWords, word) ? "$#%!" : word;
        //     result.add(newWord);
        // }
        // return result.toString();
    }

    // END
    public static void main(String[] args) {
        var text1 = "When you play the game of thrones, you win or you die";
        String[] stopWords1 = {"die", "play"};
        var result1 = Main.makeCensored(text1, stopWords1);
        System.out.println(result1);
        // => "When you $#%! the game of thrones, you win or you $#%!"

        var text2 = "chicken chicken? chicken! chicken";
        String[] stopWords2 = {"?", "chicken"};
        var result2 = Main.makeCensored(text2, stopWords2);
        System.out.println(result2);
        // => "$#%! chicken? chicken! $#%!"

        String[] words = {"hello", "world"};
        ArrayUtils.contains(words, "hello"); // true
        ArrayUtils.contains(words, "Jack"); // false
    }
}