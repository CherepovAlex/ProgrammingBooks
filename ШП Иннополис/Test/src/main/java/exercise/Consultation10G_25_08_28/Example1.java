package exercise.Consultation10G_25_08_28;

import java.util.*;
import java.util.stream.Collectors;

// Задача 1 собрать частоту появления каждого слова (без учета регистра) и вывести топ-5 самых частых слов.
public class Example1 {

    public static void main(String[] args) {
        List<String> text = Arrays.asList("Of course, here is the translation::\n",
                "The weather is beautiful today, so I decided to take a walk in the park. The sun's rays are warming the earth after the cool morning..\n",
                "Artificial intelligence continues to develop, opening new possibilities for science and creativity. The future is already arriving..\n",
                "Cooking dinner requires attention to detail. Fresh ingredients are the key to a delicious and healthy meal for the whole family.");

        Map<String, Integer> words = new HashMap<>();

        for(String t : text) {
            String[] word = t.toLowerCase().split("\\s+");
            for (String w : word) {
                words.put(w, words.getOrDefault(w, 0) + 1);
            }
        }
        System.out.println("Frequencies: " + words);
//        words.forEach((word, count) -> System.out.println(word + " -> " + count));

        List<Map.Entry<String, Integer>> top5 = words.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toList());

        top5.forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

    }

}
