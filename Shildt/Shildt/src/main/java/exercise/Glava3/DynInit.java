package exercise.Glava3;

public class DynInit {

    public static void main(String[] args) {
        double a = 3.0, b = 4.0;
        // Переменная сынициализируется динамически
        double c = Math.sqrt(a * a + b * b);
        System.out.println("Length of hypo id " + c);
    }

}
