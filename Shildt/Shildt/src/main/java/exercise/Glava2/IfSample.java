package exercise.Glava2;

// Демонстрация работы оператора if

public class IfSample {
    public static void main(String[] args) {
        int x, y;
        x = 10;
        y = 20;
        if (x < y)
            System.out.println("Value x less y");
        x = x * 2;
        if (x == y)
            System.out.println("Now value x equals y");
        x = x * 2;
        if (x > y)
            System.out.println("Now value x more y");
        // Здесь ничего не отобразится
        if (x == y)
            System.out.println("This output you will not see");
    }
}
