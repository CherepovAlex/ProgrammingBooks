package ru.yandex;

import java.util.*;

// Для решения задачи можно воспользоваться дополнительной структурой данных на выбор:
// ArrayList, LinkedList, HashMap
public class Main {
    public static void main(String[] args) {

        // 1) Дан список целых чисел с дубликатами, вывести только уникальные значения списка на экран
        // 1, 3, 5, 3, 7, 9, 0, 2, 0, 4, 6, 1, 8, 8
        // time O(n^2), space O(n)
        List<Integer> numbers = List.of(1, 3, 5, 3, 7, 9, 0, 2, 0, 4, 6, 1, 8, 8);
        var newList = new ArrayList<Integer>();
        for (var num : numbers) {
            if (!newList.contains(num)) {
                newList.add(num);
                System.out.print(num + " ");
            }
        }
        System.out.println();

        // time O(n)
        numbers.stream()
                .distinct()
                .forEach(num -> System.out.print(num + " "));

        System.out.println();

        // time O(n)
        var map = new HashMap<Integer, Integer>();
        for (var number : numbers) {
            Integer count = map.getOrDefault(number, 1);
            map.put(number, ++count);
        }

        for (Integer num : numbers) {
            if (map.get(num) == 1)
                System.out.print(num + " ");
        }
    }
}
