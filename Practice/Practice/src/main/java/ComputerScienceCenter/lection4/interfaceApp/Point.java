package ComputerScienceCenter.lection4.interfaceApp;

public class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point<" + x + "," + y + '>';
    }

    public static void main(String[] args) {
        Point p = new Point(3, 4);
        System.out.println(p);

        Vector v1 = ZeroVector.INSTANCE;
        Vector v2 = new ArrayVector(1, 2, 3);
        Vector v3 = new FieldVector(4, 5, 6);

        Vector sum = v1.plus(v2).plus(v3);
        System.out.println(sum.component(0) + "," +
                sum.component(1) + "," +
                sum.component(2));

        // проблема
        Vector zero1 = ZeroVector.INSTANCE;
        Vector zero2 = new ArrayVector(0, 0, 0);
        Vector zero3 = new FieldVector(0, 0, 0);

        System.out.println(zero2.equals(zero1));    // true
        System.out.println(zero2.equals(zero3));    // true
        System.out.println(zero1.equals(zero2));    // false

        // проход по всем константам
        for(Weekday weekday : Weekday.values()) {
            System.out.println(weekday + " (" + weekday.getShortName() + ") " +
                    (weekday.isWeekend() ? "relax and enjoy" : "work!"));
        }

        System.out.println(new Point(3, 4).workingHours(Weekday.TUESDAY));

    }

    // метод, использующий енамы
    String workingHours(Weekday weekday) {
        return switch (weekday) {
            case MONDAY, FRIDAY -> "9:30-13:00";
            case TUESDAY, THURSDAY -> "14:00-17:30";
            case WEDNESDAY, SATURDAY, SUNDAY -> "weekend";
        };
    }
}


