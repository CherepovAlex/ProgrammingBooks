package ru.yandex;

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    // bucket[0] -> Node(null, "zero")
    // bucket[1] -> null
    // bucket[2] -> null
    // bucket[3] -> null
    // bucket[4] -> null
    // bucket[5] -> null
    // ...
    // bucket[13] -> null
    // bucket[14] -> null
    // bucket[15] -> null

    public static void main(String[] args) {
        // 1) Что выведется на экран и что произойдёт - прокомментируйте

        Map<String, String> map = new HashMap<>();

        map.put(null, null);
        map.put(null, "zero");

        System.out.println(map.get(null)); // zero

    }
}
