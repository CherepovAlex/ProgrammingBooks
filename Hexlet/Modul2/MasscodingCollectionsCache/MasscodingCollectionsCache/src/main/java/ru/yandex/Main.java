package ru.yandex;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Кэш — это временное хранилище данных для быстрого доступа к часто используемой информации.
// Практическая часть: Создаем простой LRU-кэш
// LRU (Least Recently Used) — алгоритм, при котором удаляются реже всего используемые элементы.
public class Main {

    private final int capacity;
    private final Map<Integer, Integer> cacheMap;
    private final Deque<Integer> accessOrder;

    public Main(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity mus be positive");
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.accessOrder = new LinkedList<>();
    }

    // Получение значения из кэша
    public Integer get(Integer key) {
        if (!cacheMap.containsKey(key)) {
            System.out.println("Key" + key + " is not found in cache");
            return null;
        }
        // Обновляем порядок доступа - перемещаем ключ в конец
        accessOrder.remove(key);
        accessOrder.addLast(key);

        System.out.println("Got key " + key + " = " + cacheMap.get(key));
        return cacheMap.get(key);
    }

    // Добавление значения в кэш
    public void put(Integer key, Integer value) {
        if (cacheMap.containsKey(key)) {
            accessOrder.remove(key);         // Если ключ уже существует, обновляем значение и порядок
        } else {
            if (cacheMap.size() >= capacity) // Если кэш полный, удаляем самый старый элемент
                evict();
        }
        cacheMap.put(key, value);   // Добавляем новый элемент
        accessOrder.addLast(key);
        System.out.println("Add key " + key + " = " + value);
    }

    // Удаление самого старого элемента (LRU стратегия)
    private void evict() {
        Integer oldestKey = accessOrder.pollFirst();
        if (oldestKey != null) {
            cacheMap.remove(oldestKey);
            System.out.println(">>> Remove key: " + oldestKey);
        }
    }

    // Получение текущего размера кэша
    public int size() {
        return cacheMap.size();
    }

    // Проверка наличия ключа
    public boolean contains(Integer key) {
        return cacheMap.containsKey(key);
    }

    // Удаление конкретного ключа
    public void remove(Integer key) {
        if (cacheMap.containsKey(key)) {
            cacheMap.remove(key);
            accessOrder.remove(key);
            System.out.println("Remove key: " + key);
        }
    }

    // Очистка всего кэша
    public void clear() {
        cacheMap.clear();
        accessOrder.clear();
        System.out.println("Cache totally clean");
    }

    // Вывод текущего состояния кэша
    public void printCache() {
        System.out.println("=== Current cache state ===");
        System.out.println("Size: " + size() + "/" + capacity);
        System.out.println("Access order: " + accessOrder);
        System.out.println("Data: " + cacheMap);
        System.out.println("=============================");
    }


    public static void main(String[] args) {
        System.out.println("=== CREATE AND SHOW LRU-CACHE ===\n");

        // Создаем кэш емкостью 3 элемента
        Main cache = new Main(3);

        // Заполняем кэш
        System.out.println("1. Fill the cache:");
        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);
        cache.printCache();

        // Доступ к существующему элементу
        System.out.println("\n2. Get to key 1:");
        cache.get(1);
        cache.printCache();

        // Добавляем новый элемент - должен вытеснить самый старый (2)
        System.out.println("\n3. Add new key 4:");
        cache.put(4, 400);
        cache.printCache();

        // Пытаемся получить вытесненный элемент
        System.out.println("\n4. Try to get remove key 2:");
        cache.get(2);

        // Работа с существующими элементами
        System.out.println("\n5. Work with exist elements:");
        cache.get(3);
        cache.get(4);
        cache.printCache();

        // Добавляем еще один элемент
        System.out.println("\n6. Add key 5:");
        cache.put(5, 500);
        cache.printCache();

        // Демонстрация удаления
        System.out.println("\n7. Delete key 4:");
        cache.remove(4);
        cache.printCache();

        // Очистка кэша
        System.out.println("\n8. Clear the cache:");
        cache.clear();
        cache.printCache();
    }
}
