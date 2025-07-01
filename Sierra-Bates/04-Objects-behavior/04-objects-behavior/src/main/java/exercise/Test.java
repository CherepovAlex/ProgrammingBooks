package exercise;

public class Test {

    int calcArea(int height, int width) {
        return height * width;
    }

    public static void main(String[] args) {
        Test test = new Test();
        int a = test.calcArea(7, 12);

        short c = 7;

        test.calcArea(c, 15);

        // int d = test.calcArea(57);

        test.calcArea(2, 3);

        long t = 42;

        // int f = test.calcArea(t, 17);

        // int g = test.calcArea();

        // test.calcArea();

        // byte h = test.calcArea(4, 20);

        // int j = test.calcArea(2, 3, 5);
    }

}
