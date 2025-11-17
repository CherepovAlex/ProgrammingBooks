package ru.yandex;
// Вытеснение давно используемого (Least recently used, LRU)
//- в первую очередь вытесняется элемент неиспользованный дольше всех.

import java.util.LinkedList;
import java.util.Objects;

public class Main {
    public static void main(String args[]) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}

// TODO: HashMap + custom linked List
class LRUCache {

    private LinkedList<Pair> cache = new LinkedList<Pair>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    // O(n) -> O(1)
    public int get(int key) {
        for (Pair pair : cache) {
            if (pair.getKey() == key) {
                cache.remove(pair);
                cache.addFirst(new Pair(pair.getKey(), pair.getValue()));
                return pair.getValue();
            }
        }
        return -1;
    }
    // O(n) -> O(1)
    public void put(int key, int value) {
        for (Pair pair : cache) {
            if (pair.getKey() == key) {
                cache.remove(pair);
                cache.addFirst(new Pair(key, value));
            }
        }

        if (cache.size() >= capacity) {
            cache.removeLast();
        }

        cache.addFirst(new Pair(key, value));
    }
}

class Pair {
    private int key;
    private int value;

    public Pair(int key, int value) {
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
        Pair pair = (Pair) o;
        return key == pair.key && value == pair.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}