package exercise;

import java.util.ArrayList;
import java.util.List;

class App {
    // BEGIN
    public static List<String> removeDuplicates(List<String> words) {
        var uniqWords = new ArrayList<String>();

        for (var word : words) {
            if (!uniqWords.contains(word)) {
                uniqWords.add(word);
            }
        }
        return uniqWords;
    }
    // END
    public static void main(String[] args) {
        var words = List.of("a", "a", "b", "c", "c");
        var uniqWords = App.removeDuplicates(words);
        System.out.println(uniqWords); // => [a, b, c]
    }
}
