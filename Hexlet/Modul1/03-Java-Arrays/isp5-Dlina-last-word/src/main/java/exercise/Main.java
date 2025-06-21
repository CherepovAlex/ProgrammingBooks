// Реализуйте публичный статический метод getLastWordLength(), который возвращает длину последнего слова
// переданной на вход строки. Словом считается любая последовательность, не содержащая пробелов.
// Убрать лишние пробелы поможет метод строки trim()
package exercise;
public class Main {
    // BEGIN
    public static int getLastWordLength(String text) {

        var words = text.trim().split(" ");
        var lastWord = words[words.length - 1];

        return lastWord.length();
    }

    // END
    public static void main(String[] args) {
        Main.getLastWordLength(""); // 0

        Main.getLastWordLength("man in BlacK"); // 5

        Main.getLastWordLength("hello, world!  "); // 6
    }
}