package exercise;

import java.util.ArrayList;
import java.util.List;

public class App {
    // BEGIN (write your solution here)
    public static List<Integer> mix(List<Integer> coll) {
        List<Integer> result = new ArrayList<>();

        var left = 0;
        var right = coll.size() - 1;

        while (left <= right) {
            result.add(coll.get(left));
            left++;

            if (left <= right) {
                result.add(coll.get(right));
                right--;
            }
        }
        return result;
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
