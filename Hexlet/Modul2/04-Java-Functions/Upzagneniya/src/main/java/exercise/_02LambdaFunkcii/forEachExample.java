package exercise._02LambdaFunkcii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class forEachExample {

    public static void main(String[] args) {
        var codes = new HashMap<String, Integer>();
        codes.put("usa", 1);
        codes.put("france", 33);
        codes.put("germany", 49);

        // 1 вариант
        var entries = codes.entrySet();
        for (var entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // 2 вариант
        codes.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });

        // List 1 вариант
        var temperatures = List.of(20, 25, 18, 19, 22, 17, 20);
        temperatures.forEach((value) -> {
            System.out.println(value);
        });

        // List 2 вариант
        temperatures.forEach(value -> System.out.println(value));

        var temperatures2 = new ArrayList<Integer>();
        temperatures2.addAll(List.of(-2, 5, 2));

        temperatures2.replaceAll(value -> {
            return value + 273;
        });

        System.out.println(temperatures2);  // => [271, 278, 275]

        // альтернативный вариант для одного выражения
        temperatures2.replaceAll(value -> value + 273);

        // в теле лямбда-функции можно использовать данные из внешнего контекста
        var temperatures3 = List.of(20, 25, 18, 19, 22, 17, 20);
        var n = 2;
        temperatures3.forEach((value) -> {
                    System.out.println(value * n);
                }
        );
        // но значение n изменять нельзя

    }
}
