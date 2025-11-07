//package ru.yandex;
//
//import java.util.LinkedList;
//
//public class Main {
//    public static void main(String args[]) {
//        Main lRUCache = new Main(2);
//        lRUCache.put(1, 1); // cache is {1=1}
//        lRUCache.put(2, 2); // cache is {1=1, 2=2}
//        lRUCache.get(1);    // return 1
//        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//        lRUCache.get(2);    // returns -1 (not found)
//        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//        lRUCache.get(1);    // return -1 (not found)
//        lRUCache.get(3);    // return 3
//        lRUCache.get(4);    // return 4
//    }
//}
//
//class LRUCache {
//    private LinkedList<Pair> cache = new LinkedList<Pair>();
//    private int capacity;
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return 0;
//    }
//
//    public void put(int key, int value) {
//
//    }
//}
//
//class Pair {
//    private int key;
//    private int value;
//
//    public Pair(int key, int value) {
//        this.key = key;
//        this.value = value;
//    }
//}