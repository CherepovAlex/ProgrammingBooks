package exercise.Consultation10G_25_08_28;

import java.util.*;

//* Задача 2 — Уникальные элементы и порядок (Set: HashSet, LinkedHashSet, TreeSet)
// * Цель: дан список чисел (с повторениями). Получить:
// * Множество без дубликатов (порядок не важен) — HashSet.
// * Множество в порядке вставки — LinkedHashSet.
// * Отсортированное множество — TreeSet.
public class Example2 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(4, 5, 2, 7, 12, 0, 2, 7, 1, 7, 7, 7, 7);

        Set<Integer> unique = new HashSet<>(numbers);

        Set<Integer> uniqueL = new LinkedHashSet<>(numbers);

        Set<Integer> uniqueT = new TreeSet<>(numbers);

        System.out.println("HashSet :" + unique);

        System.out.println("LinkedHashSet :" + uniqueL);

        System.out.println("TreeSet :" + uniqueT);


    }
}
