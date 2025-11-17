package ru.yandex;

import java.util.HashMap;
import java.util.Map;

public class Main_ {
    public static void main(String[] args) {
        LRUCache2 lRUCache = new LRUCache2(2);
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

class LRUCache2 {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final DoublyLinkedList list;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // Перемещаем узел в начало списка (самый недавно использованный)
        list.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node existingNode = cache.get(key);

        if (existingNode != null) {
            // Если ключ уже существует, обновляем значение и перемещаем в начало
            existingNode.value = value;
            list.moveToHead(existingNode);
            return;
        }

        // Если кэш заполнен, удаляем самый старый элемент (из конца списка)
        if (cache.size() >= capacity) {
            Node tail = list.removeTail();
            cache.remove(tail.key);
        }

        // Добавляем новый элемент
        Node newNode = new Node(key, value);
        list.addToHead(newNode);
        cache.put(key, newNode);
    }


    // Внутренний класс для узла двусвязного списка
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Внутренний класс для свусвязного списка
    private static class DoublyLinkedList {
        private Node head;
        private Node tail;

        DoublyLinkedList() {
            // Создаём фиктивные узлы для упрощения логики
            head = new Node(0, 0);
            tail = new Node(0, 0);
            this.head = head;
            this.tail = tail;
        }

        void addToHead(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void moveToHead(Node node) {
            remove(node);
            addToHead(node);
        }

        Node removeTail() {
            Node node = tail.prev;
            if (node == head) {
                return null;    // Список пуст
            }
            remove(node);
            return node;
        }
    }

}


