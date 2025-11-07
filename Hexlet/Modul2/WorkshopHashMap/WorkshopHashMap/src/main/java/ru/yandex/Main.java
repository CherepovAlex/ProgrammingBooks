package ru.yandex;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // here is what is in store in the months and years to come
        Map<String, Integer> map = new HashMap<>();
        map.put("here", 1);
        map.put("is", 2);
        map.put("what", 1);
        map.put("in", 2);
        map.put("store", 1);
        map.put("the", 1);
        map.put("months", 1);
        map.put("and", 1);
        map.put("years", 1);
        map.put("to", 1);
        map.put("come", 1);

        System.out.println("the word 'is' occurs " + map.get("is") + " times.");
        // the word 'is' occurs 2 times

        Map<String, String> map2 = new HashMap<>();
        map2.put("key", "one");
        map2.put("idx", "two");
        map2.put(null, null);



    }
}
