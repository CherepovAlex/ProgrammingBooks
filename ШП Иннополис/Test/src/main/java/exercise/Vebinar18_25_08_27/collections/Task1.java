package exercise.Vebinar18_25_08_27.collections;
// написать метод, показывающий количество повторов слова

import java.util.*;

public class Task1 {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("elefant");
        words.add("elefant");
        words.add("cat");
        words.add("mouse");
        words.add("cat");
        words.add("dog");
        words.add("cat");
        words.add("mouse");

        System.out.println(words);

        // Вызов метода подсчета и вывод результата
        System.out.println("Result counting: " + wordsCount(words));

    }

    private static Map<String, Integer> wordsCount(Collection<String> words) {

        Map<String, Integer> result = new HashMap<>();
        for (String str : words) {
            int counter = 1;               // Всегда устанавливаем счетчик в 1
            if (result.containsKey(str)) {
                counter = result.get(str); // Получаем текущее значение
                counter++;                 // Увеличиваем на 1
            }
            result.put(str, counter);      // Обновляем значение в мапе
        }
        return result;
    }
}
