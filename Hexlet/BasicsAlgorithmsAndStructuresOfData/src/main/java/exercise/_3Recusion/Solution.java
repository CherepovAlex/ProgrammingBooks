package exercise._3Recusion;

public class Solution {

    public static int run(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        if (x ==0) {return y;}
        if (y ==0) {return x;}
        if (x == y) {return x;}

//        return run(y, x % y); // 1 вариант

        if (x > y) {            // 2 вариант
            return run(x - y, y);
        } else {
            return run(x, y - x);
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.run(38, 28)); // 2
        System.out.println(Solution.run(129, 90)); // 3
        System.out.println(Solution.run(0, 5)); // 5
    }
}
