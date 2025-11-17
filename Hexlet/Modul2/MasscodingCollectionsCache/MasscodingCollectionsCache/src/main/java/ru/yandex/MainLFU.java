package ru.yandex;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainLFU {
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1); // cache=[1, ], cnt(1) = 1
        lfu.put(2, 2); // cache=[2,1], cnt(2) = 1, cnt(1) = 1
        lfu.get(1);    // return 1
        // cache=[1,2], cnt(2) = 1, cnt(1) = 2
        lfu.put(3, 3); // 2 is the LFU key because cnt(2) = 1 is the smallest, invalidate 2
        // cache=[3,1], cnt(3) = 1, cnt(1) = 2
        lfu.get(2);    // returns -1 (not found)
        lfu.get(3);    // return 3
        // cache=[3,1], cnt(3) = 2, cnt(1)=2
        lfu.put(4, 4); // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);    // return -1 (not found)
        lfu.get(3);    // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);    // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}

class LFUCache {
    Map<Pair1, Integer> map = new HashMap<>();
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        Pair1 newPair = new Pair1(key, value);
        int cnt = map.getOrDefault(newPair, 0);
        map.put(newPair, ++cnt);

        if (capacity == map.size()) {
            var min = Integer.MAX_VALUE;
            Pair1 minPair = null;
            for (Map.Entry<Pair1, Integer> entry : map.entrySet()) {
                if (min < entry.getValue()) {
                    min = entry.getValue();
                    minPair = entry.getKey();
                }
            }
            if (minPair != null) {
                map.remove(minPair);
            }
        }

        int cnt1 = map.getOrDefault(newPair, 0);
        map.put(newPair, ++cnt1);
    }

    public void get(int key) {

    }

}

class Pair1 {
    private int key;
    private int value;

    public Pair1(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pair1 pair = (Pair1) o;
        return key == pair.key && value == pair.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}