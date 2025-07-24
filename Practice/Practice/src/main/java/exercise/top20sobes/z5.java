package exercise.top20sobes;

// Напишите программу на Java для подсчета количества конкретных слов в строке, используя HashMap.

import java.util.HashMap;

public class z5 {

    public static void main(String[] args) {

        String st = "Current task posted for Java developers developers";

        String[] words = st.split(" ");

        HashMap<String, Integer> keyValue = new HashMap<String, Integer>();

        for (int i = 0; i <= words.length - 1; i++) {

            if (keyValue.containsKey(words[i])) {

                int counter = keyValue.get(words[i]);

                keyValue.put(words[i], counter + 1);

            } else {

                keyValue.put(words[i], 1);

            }

        }

        System.out.println(keyValue);

    }

}
