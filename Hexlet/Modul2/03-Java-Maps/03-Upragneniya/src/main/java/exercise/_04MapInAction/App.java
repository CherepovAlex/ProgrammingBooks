package exercise._04MapInAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        var text = "java and javascript are different languages";

        var index = App.buildIndex(text);
        System.out.println(index); // => {a=[and, are], d=[different], j=[java, javascript], l=[languages]}

        var index2 = App.buildIndex("");
        System.out.println(index2); // => {}

    }

    private static Map<Character, List<String>> buildIndex(String text) {

        var index = new HashMap<Character, List<String>>();

        if (text.isEmpty()) {
            return index;
        }

        var words = text.split(" ");

        for (var word : words) {
            var firstChar = word.charAt(0);
            var innerWords = index.getOrDefault(firstChar, new ArrayList<String>());
            innerWords.add(word);
            index.put(firstChar, innerWords);
        }

        return index;
    }
}
