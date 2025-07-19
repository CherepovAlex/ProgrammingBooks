package exercise.Glava6;

// Перегрузка методов,
class Overload {
    // Первый вариант метода.
    void ovlDemo() {
        System.out.println("No parameters");
    }

    // перегрузить метод ovlDemo с одним параметром типа int.
    // Второй вариант метода.
    void ovlDemo(int a) {
        System.out.println("One parameter: " + a);
    }

    // перегрузить метод ovlDemo с двумя параметрами типа int.
    // Третий вариант метода.
    int ovlDemo(int a, int b) {
        System.out.println("Two parameters: " + a + " " + b) ;
        return a + b;
    }

    // перегрузить метод ovlDemo с двумя параметрами типа double.
    // Четвертый вариант метода.
    double ovlDemo(double a, double b) {
        System.out.println("Two double parameters: " +
                            a + " "+ b);
        return a + b;
    }
}

public class OverloadDemo {
    public static void main(String args[])  {
        Overload ob = new Overload();
        int resl;
        double resD;

        // вызвать все варианты метода ovlDemo()
        ob.ovlDemo();
        System.out.println();

        ob.ovlDemo(2) ;
        System.out.println();

        resl = ob.ovlDemo(4, 6) ;
        System.out.println("Result of ob.ovlDemo(4, 6): " +
                            resl);
        System.out.println();

        resD = ob.ovlDemo(1.1, 2.32);
        System.out.println("Result of ob.ovlDemo(1.1, 2.32): " +
                            resD);
    }
}