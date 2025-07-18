package exercise._02ArrayList;

import java.util.List;

public class App {

    public static String getOrDefault(List<String> items, int index, String defaultValue) {
        if (index >= items.size() || index < 0) {
            return defaultValue;
        }

        return items.get(index);
    }

    public static void main(String[] args) {
        var capitals = List.of("london", "berlin", "tokio");

        App.getOrDefault(capitals, 1, ""); // "berlin"
        App.getOrDefault(capitals, 2, ""); // "tokio"
        App.getOrDefault(capitals, 5, ""); // ""
        App.getOrDefault(capitals, -2, ""); // ""
    }

}


