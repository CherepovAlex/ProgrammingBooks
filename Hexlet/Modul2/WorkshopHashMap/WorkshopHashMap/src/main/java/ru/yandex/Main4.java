package ru.yandex;

public class Main4 {
    public static void main(String[] args) {
        String key = "hello";
        System.out.println(key);

        int keyHash = hash(key);
        int length = 16;
        int result = keyHash & (length - 1);
        System.out.println(result); // 11

        String key2 = "bar";
        System.out.println(key2);

        int keyHash2 = hash(key2);
        int result2 = keyHash2 & (length - 1);
        System.out.println(result2); // 2
    }

    public static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
