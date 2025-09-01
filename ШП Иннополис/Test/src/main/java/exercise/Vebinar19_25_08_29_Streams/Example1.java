package exercise.Vebinar19_25_08_29_Streams;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Example1 {

    public static void main(String[] args) {

        // решение через циклы
        LinkedHashSet<Integer> numbers = null;
        numbers.add(2);
        numbers.add(-10);
        numbers.add(54);
        // TODO создать и заполнить List<Integer> result
        var result = new ArrayList<Integer>();
        for (Integer number : numbers) {
            if (result.size() >= 2) { // в результате должно быть 2 элемента
                break;
            }   // проверка числа на наличие в диапазоне 10 .. 20
            if (10 <= number && number <= 20) {
                result.add(number);
            }
        }

        // решение через stream
        numbers.stream()
                .filter(number -> 10 <= number && number <= 20) // фильтрация по диапазону
                .distinct()         // уникальность - элементы
                .limit(2)   // ограничить 2 элементами
                .forEach(number -> System.out.println(number));
    }
}
