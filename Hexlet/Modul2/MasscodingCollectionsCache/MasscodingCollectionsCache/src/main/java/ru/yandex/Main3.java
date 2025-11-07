package ru.yandex;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Main3 {
    private final int capacity;
    private final Map<Integer, Integer> keyToValue;                 // ключ -> значение
    private final Map<Integer, Integer> keyToFrequency;             // ключ -> частота использования
    private final Map<Integer, LinkedHashSet<Integer>> frequencyToKeys; // частота -> набор ключей
    private int minFrequency;                                       // минимальная частота в кэше

    public Main3(int capacity) {
        if (capacity <= 0) {throw new IllegalArgumentException("Емкость кэша должна быть положительной");}
        this.capacity = capacity;
        this.keyToValue = new HashMap<>();
        this.keyToFrequency = new HashMap<>();
        this.frequencyToKeys = new HashMap<>();
        this.minFrequency = 0;
        frequencyToKeys.put(1, new LinkedHashSet<>());
    }

    // Получение значения из кэша
    public Integer get(Integer key) {
        if (!keyToValue.containsKey(key)) {
            System.out.println("Промах! Ключ " + key + " не найден в кэше");
            return null;
        }

        // Увеличиваем частоту использования
        increaseFrequency(key);
        int value = keyToValue.get(key);
        int frequency = keyToFrequency.get(key);

        System.out.println("Попадание! Ключ " + key + " = " + value + " (частота: " + frequency + ")");
        return value;
    }

    // Добавление значения в кэш
    public void put(Integer key, Integer value) {
        if (capacity == 0) return;

        if (keyToValue.containsKey(key)) {
            // Если ключ уже существует, обновляем значение и увеличиваем частоту
            keyToValue.put(key, value);
            increaseFrequency(key);
            System.out.println("Обновлен ключ " + key + " = " + value);
        } else {
            // Если кэш полный, удаляем самый редко используемый элемент
            if (keyToValue.size() >= capacity) {
                evict();
            }

            // Добавляем новый элемент с частотой 1
            keyToValue.put(key, value);
            keyToFrequency.put(key, 1);
            frequencyToKeys.get(1).add(key);
            minFrequency = 1;

            System.out.println("Добавлен ключ " + key + " = " + value + " (начальная частота: 1)");
        }
    }

    // Увеличение частоты использования ключа
    private void increaseFrequency(Integer key) {
        int currentFrequency = keyToFrequency.get(key);

        // Удаляем ключ из текущего набора частот
        frequencyToKeys.get(currentFrequency).remove(key);

        // Если это был последний ключ с минимальной частотой, обновляем minFrequency
        if (currentFrequency == minFrequency && frequencyToKeys.get(currentFrequency).isEmpty()) {
            minFrequency++;
        }

        // Увеличиваем частоту
        int newFrequency = currentFrequency + 1;
        keyToFrequency.put(key, newFrequency);

        // Добавляем ключ в набор для новой частоты
        frequencyToKeys.computeIfAbsent(newFrequency, k -> new LinkedHashSet<>()).add(key);
    }

    // Удаление самого редко используемого элемента
    private void evict() {
        // Получаем набор ключей с минимальной частотой
        LinkedHashSet<Integer> minFreqKeys = frequencyToKeys.get(minFrequency);

        // Удаляем первый ключ из набора (самый старый среди редко используемых)
        Integer keyToRemove = minFreqKeys.iterator().next();
        minFreqKeys.remove(keyToRemove);

        // Удаляем из всех хранилищ
        keyToValue.remove(keyToRemove);
        keyToFrequency.remove(keyToRemove);

        System.out.println(">>> Вытеснен ключ: " + keyToRemove + " (частота: " + minFrequency + ")");

        // Если набор пустой, удаляем запись о частоте
        if (minFreqKeys.isEmpty()) {
            frequencyToKeys.remove(minFrequency);
            // minFrequency будет обновлен при следующем добавлении или доступе
        }
    }

    // Получение текущего размера кэша
    public int size() {
        return keyToValue.size();
    }

    // Проверка наличия ключа
    public boolean contains(Integer key) {
        return keyToValue.containsKey(key);
    }

    // Получение частоты использования ключа
    public Integer getFrequency(Integer key) {
        return keyToFrequency.get(key);
    }

    // Вывод текущего состояния кэша
    public void printCache() {
        System.out.println("=== ТЕКУЩЕЕ СОСТОЯНИЕ LFU-КЭША ===");
        System.out.println("Размер: " + size() + "/" + capacity);
        System.out.println("Минимальная частота: " + minFrequency);
        System.out.println("Данные (ключ=значение[частота]): ");

        // Сортируем ключи по частоте для наглядности
        keyToValue.keySet().stream()
            .sorted((k1, k2) -> keyToFrequency.get(k2) - keyToFrequency.get(k1))
            .forEach(key -> System.out.println("  " + key + "=" + keyToValue.get(key) +
                     "[" + keyToFrequency.get(key) + "]"));

        System.out.println("Распределение по частотам: ");
        frequencyToKeys.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> System.out.println("  Частота " + entry.getKey() + ": " + entry.getValue()));
        System.out.println("=================================");
    }

    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ LFU-КЭША (емкость: 3) ===\n");

        Main3 cache = new Main3(3);

        // Заполняем кэш начальными значениями
        System.out.println("1. Заполняем кэш:");
        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);
        cache.printCache();

        // Симулируем разную частоту доступа
        System.out.println("\n2. Симулируем доступ к данным:");
        cache.get(1);  // частота 1 -> 2
        cache.get(1);  // частота 2 -> 3
        cache.get(2);  // частота 1 -> 2
        cache.get(3);  // частота 1 -> 2
        cache.printCache();

        // Добавляем новый элемент - должен вытеснить элемент с наименьшей частотой
        System.out.println("\n3. Добавляем новый ключ 4:");
        cache.put(4, 400);
        cache.printCache();

        // Продолжаем работу с кэшом
        System.out.println("\n4. Дальнейшая работа:");
        cache.get(1);  // частота 3 -> 4
        cache.get(4);  // частота 1 -> 2
        cache.get(4);  // частота 2 -> 3
        cache.printCache();

        // Добавляем еще один элемент
        System.out.println("\n5. Добавляем ключ 5:");
        cache.put(5, 500);
        cache.printCache();

        // Проверяем доступ к вытесненным элементам
        System.out.println("\n6. Проверяем вытесненные элементы:");
        cache.get(2);  // должен быть вытеснен
        cache.get(3);  // должен быть вытеснен
    }

}