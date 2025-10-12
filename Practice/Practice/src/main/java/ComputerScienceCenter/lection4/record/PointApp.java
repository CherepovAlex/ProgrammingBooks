package ComputerScienceCenter.lection4.record;

record Point(int x, int y) {
    void print() {
        System.out.println("Point<" + x + "," + y + ">");
    }
}

public class PointApp {
    public static void main(String[] args) {
        Point p = new Point(3, 4);
        process(p);
    }

    private static void process(Object obj) {
        if (obj instanceof Point) {
            Point point = (Point) obj;
            point.print();
        }

        // аналогично java 17
        if (obj instanceof Point point) {
            point.print();
        }
    }
}
