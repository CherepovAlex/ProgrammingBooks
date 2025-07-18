package exercise;

import java.util.ArrayList;
import java.util.List;

public class App {
    // BEGIN (write your solution here)
    public static List<Integer> mix(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        if (list.size() % 2 != 0) {
            for (int i = 0; i <= list.size() / 2; i++) {
                newList.add(list.get(i));

                if (i != (list.size() - 1 - i)) {
                    newList.add(list.get(list.size() - 1 - i));
                }
            }
        } else {
            for (int i = 0; i < list.size() / 2; i++) {
                newList.add(list.get(i));
                if (i != (list.size() - 1 - i)) {
                    newList.add(list.get(list.size() - 1 - i));
                }
            }
        }
        return newList;
    }
    // END

    public static void main(String[] args) {
        var coll = List.of(1, 2, 3, 4, 5, 6);
        var result = App.mix(coll);
        System.out.println(result); // [1, 6, 2, 5, 3, 4]

        var coll2 = List.of(1, 2, 3, 4, 5);
        var result2 = App.mix(coll2);
        System.out.println(result2); // [1, 5, 2, 4, 3]
    }
}
