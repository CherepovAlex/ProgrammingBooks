package exercise.Consultation12G_25_09_11;

// Задача 4. Иерархия и полморфизм в catch-блоках
public class Task6 {

    public static void main(String[] args) {

        try {
            dangerousMethod();
        } catch (ArithmeticException e) {
            System.out.println("Worked arithmetic error " + e.getMessage());
        } catch (RuntimeException e) { // потомок арифметик исключения
            System.out.println("Worked error of time running " + e.getMessage());
        } catch (Exception e) { // стоит последним
            System.out.println("Worked general exception " + e.getClass().getSimpleName());
        }
        // catch (Throwable e) {...} можно поёмать все исключения
    }

    public static void dangerousMethod() {
        if (Math.random() > 0.5) {
            throw new ArithmeticException("Division by zero!");
        } else {
            throw new ArrayIndexOutOfBoundsException("Exit from bounds of array");
        }
    }

}
