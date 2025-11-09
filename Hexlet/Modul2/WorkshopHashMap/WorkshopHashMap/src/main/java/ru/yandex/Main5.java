package ru.yandex;

public class Main5 {
    // bucket[0] -> Node(null, 1) -> Node("Aa", 2) -> Node("0", 3)
    // при добавление 8го элемента список преобразуется в к-ч дерево
    // кол-во бакетов увеличится в 2 раза, когда загрузка станет 75% (loadfactor)
    // bucket[1] -> null
    // bucket[2] -> Node("bar", 77)
    // bucket[3] -> null
    // bucket[4] -> Node("Hello", 4)
    // bucket[5] -> null
    // ...
    // bucket[10] -> null
    // bucket[11] -> Node("hello", -8)
    // bucket[12] -> null
    // bucket[13] -> null
    // bucket[14] -> null
    // bucket[15] -> null

    public static void main(String[] args) {

        // map.put(null, 1);
        // map.put("Aa", 2);
        // map.put("0", 2);
        // map.put("hello", -8);
        // map.put("Hello", 4);

        String key = "hello";   // добавляем элемент
        // String key = "bar";
        // String key = "Aa";
        // String key = "0";
        System.out.println(key);

        int keyHash = hash(key);
        int length = 16;
        int result = keyHash & (length - 1);
        System.out.println(result); // 0

        String key2 = "0";       // добавлявем ещё элемент
        System.out.println(key2);

        int keyHash2 = hash(key2);
        int length2 = 16;
        int result2 = keyHash2 & (length2 - 1);
        System.out.println(result2); // 0

    }

    public static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
