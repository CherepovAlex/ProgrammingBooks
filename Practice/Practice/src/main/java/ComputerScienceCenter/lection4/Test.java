package ComputerScienceCenter.lection4;

import static java.util.Arrays.*;

public class Test {
    public static void main(String[] args) {
        int[] data = {5, 3, 1, 7, 2, 4, 6};
        sort(data);
        // System.out.println(toSring(data)); не сработает, т.к. ищет toString в нашем классе
        for (int d : data) {
            System.out.print(d + " ");
        }
    }
}
