// Реализуйте публичный статический метод countUniqChars(), который принимает на вход строку и считает,
// сколько символов (без учёта повторяющихся символов) использовано в этой строке. Например, в строке "yy"
// используется всего один символ — 'y'. А в строке "111yya!" — используется четыре символа: '1', 'y', 'a' и '!'.
// Подсказки
// Чтобы разбить строку на массив символов, можно использовать метод строк toCharArray()
// Для проверки вхождения значения в массив используйте метод ArrayUtils.contains()
package exercise;

import org.apache.commons.lang3.ArrayUtils;

public class Main {
    public static int countUniqChars(String text) {
        var chars = text.toCharArray();
        var uniqChars = new char[chars.length];

        var count = 0;
        for (var current : chars) {
            if (!ArrayUtils.contains(uniqChars, current)) {
                uniqChars[count] = current;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var text1 = "yyab";
        System.out.println(Main.countUniqChars(text1)); // 3

        var text2 = "You know nothing Jon Snow";
        System.out.println(Main.countUniqChars(text2)); // 13

        var text3 = "";
        System.out.println(Main.countUniqChars(text3)); // 0
    }
}