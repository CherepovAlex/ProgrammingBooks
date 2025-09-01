package exercise.Vebinar19_25_08_29_Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example6 {

    public static void main(String[] args) {

        // WordCount
        List<String> names = List.of("Sam", "Peter", "Sam", "Andrei");

        // version 1
        // Императивный подход, Производительность	Медленнее (O(n²))
        Set<String> unique = new HashSet<>(names); //  создаёт множество уникальных значений из списка
        for (String key : unique) { //  подсчитывает, сколько раз каждый уникальный элемент встречается в исходном списке
            System.out.print(key + ": " + Collections.frequency(names, key) + ", ");
        }
        System.out.println();
        // version 2
        // Декларативный подход, Производительность Быстрее (O(n))
        Map<String, Long> result = names.stream() //  создаёт поток из списка
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //  группирует элементы по ключу
                            // использует сам элемент как ключ группировки
                                                    // подсчитывает количество элементов в каждой группе
        System.out.println(result);
    }

}
