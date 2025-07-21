package exercise.junior;

// У вас есть переменная tags, которая содержит входные пользовательские данные.
//
// tags - список из элементов строк.
//
// Напишите код, который считает количество тегов в списке tags и записывает отсортированный
// результат в том порядке в котором теги были найдены через запятую в переменную result.

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        List<String> tags = List.of("action", "adventure", "strategy", "simulation", "sports", "racing",
                "puzzle", "strategy", "simulation", "sports");
        String result = "";

        List<String> uniqueTags  = new ArrayList<>();  // новый
        List<Integer> counts  = new ArrayList<>();    // количество

        // Подсчитываем количество каждого тега
        for (String tag : tags) {
            int index = uniqueTags.indexOf(tag);
            if (index == -1) {
                // Если тег встречается впервые, добавляем его в список уникальных тегов
                uniqueTags.add(tag);
                counts.add(1);
            } else {
                // Если тег уже встречался, увеличиваем счетчик
                counts.set(index, counts.get(index) + 1);
            }
        }

        result = uniqueTags.get(0) + ": " + counts.get(0);
        for (int i = 1; i < counts.size(); i++) {
            result += ", " + uniqueTags.get(i) + ": " + counts.get(i);
        }

        System.out.println(result);
    }
}