package exercise.Consultation11G_25_09_04;

import java.util.List;
import java.util.Arrays;

// Задача 3: Лямбда-выражения для сортировки
//Формулировка задания:
//Создайте список строк List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");.
// Отсортируйте этот список:
//1.	По длине строки (от самой короткой к самой длинной).
//2.	В алфавитном порядке.
//Используйте лямбда-выражения в качестве компаратора.
public class Example3 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        System.out.println("1. Sorting by length");

        // 1 version - lambda's
        names.sort((a, b) -> b.length() - a.length());
        System.out.println("By length: " + names);

        // 2 version - streams
        names.stream()
                .sorted((k, v) -> Integer.compare(k.length(), v.length()))
                //.sorted(Comparator.comparingInt(String::length)) аналогично
                .forEach(System.out::println);

        System.out.println("2. Sorting by name");

        // 1 version - lambda's
        names.sort((k, v) -> k.compareTo(v));
        //.sort(String::compareTo) аналогично
        System.out.println("By alphabet: " + names);

        // 2 version - streams
        names.stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }
}
