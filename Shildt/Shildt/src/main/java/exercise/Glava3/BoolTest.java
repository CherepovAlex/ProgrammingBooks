package exercise.Glava3;

public class BoolTest {
    public static void main(String[] args) {
        boolean b;
        b = false;
        System.out.println("b equals " + b);
        b = true;
        System.out.println("b equals " + b);
        // Значение boolean может управлять оператором if
        if (b) System.out.println("It is does.");
        b = false;
        if (b) System.out.println("It is not does.");
        // Результатом операции отношения является значение boolean.
        System.out.println("10 > 9 equal " + (10 > 9));
    }
}
