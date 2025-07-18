package exercise._03IterateLists;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<Integer> replaceByZero(List<Integer> items) {
        var result = new ArrayList<Integer>();

        for (var item : items) {
            var processedItem = item > 0 ? item : 0;
            result.add(processedItem);
        }
        return result;
    }

    public static void main(String[] args) {
        var items = List.of(1, -2, 3, -5);

        var result = App.replaceByZero(items);
        System.out.println(result); // => [1, 0, 3, 0]

        // Исходный список не изменился
        System.out.println(items); // => [1, -2, 3, -5]
    }

}
