package exercise.junior;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        List<String> tags = List.of("action", "adventure", "strategy", "simulation", "sports",
                "racing", "puzzle", "strategy", "simulation", "sports");
        String result = "";
        List<String> newTags = new ArrayList<>(tags);
        Collections.sort(newTags);
        for (int i = 0; i < newTags.size() - 1; i++) {
            if (!newTags.get(i).equals(newTags.get(i + 1))) {
                result = result + newTags.get(i) + ", ";
            }
        }

        System.out.println(result + newTags.get(newTags.size() - 1));
    }
}