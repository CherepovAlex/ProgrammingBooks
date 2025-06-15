package exercise;

import java.util.Arrays;

public class Utils {
    public static int[] uniq(int[] coll) {
        return Arrays.stream(coll)
                .distinct()
                .toArray();
    }
}
