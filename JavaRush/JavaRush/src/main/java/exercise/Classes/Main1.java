package exercise.Classes;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        List<Integer> data = List.of(1, 1, 3, 2, 4, 5, 2, 3);

        String result = "";
        List<Integer> newData = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            if (!newData.contains(data.get(i))) {
                newData.add(data.get(i));
            }
        }
        Collections.sort(newData);
        for (int i = 0; i < newData.size(); i++) {
            if (i != newData.size() - 1) {
                result += newData.get(i) + ", ";
            } else {
                result += newData.get(i);
            }
        }

//        // Используем TreeSet для автоматической сортировки и удаления дубликатов
//        Set<Integer> uniqueSorted = new TreeSet<>(data);
//
//        // Используем String.join для соединения элементов
//        String result = String.join(", ", uniqueSorted.stream()
//                .map(String::valueOf)
//                .toArray(String[]::new)
//                );

        System.out.println(result);
    }

}