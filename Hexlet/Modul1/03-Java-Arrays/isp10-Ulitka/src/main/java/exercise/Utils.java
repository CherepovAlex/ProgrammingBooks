package exercise;

import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Utils {
    public static int[] flatten(int[][] items) {
        return Stream.of(items)
                .flatMapToInt(row -> IntStream.of(row))
                .toArray();
    }

}
