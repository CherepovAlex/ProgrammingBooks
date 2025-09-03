package exercise.Consultation10B_25_09_03;

import java.util.HashSet;

public class Mnojestva1 {
    public static void main(String[] args) {
        // Создаем TreeSet
        HashSet<String> treeSet = new HashSet<>();

        // Добавляем элементы
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Cherry");
        treeSet.add("Apple"); // повторный элемент игнорируется

        // Печать всего набора
        System.out.println(treeSet); // гарантированно: [Apple, Banana, Cherry]
    }
}