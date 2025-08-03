package exercise.isp3Scrabble;

import java.util.Map;
import java.util.HashMap;

class App {

    // BEGIN
    public static boolean scrabble(String letters, String word) {

        var charsCount = countByChars(letters);

        for (var current : word.toLowerCase().toCharArray()) {
            var count = charsCount.getOrDefault(current, 0);

            if (count == 0) {
                return false;
            }

            charsCount.put(current, count - 1);
        }

        return true;
    }

    private static Map<Character, Integer> countByChars(String letters) {
        var chars = new HashMap<Character, Integer>();

        for (var current : letters.toCharArray()) {
            var count = chars.getOrDefault(current, 0);
            chars.put(current, count + 1);
        }

        return chars;
    }
    // END

    public static void main(String[] args) {
        App.scrabble("rkqodlw", "world"); // true
        App.scrabble("avj", "java"); // false
        App.scrabble("avjafff", "java"); // true
        App.scrabble("", "hexlet"); // false
        App.scrabble("scriptingjava", "JavaScript"); // true
    }
}