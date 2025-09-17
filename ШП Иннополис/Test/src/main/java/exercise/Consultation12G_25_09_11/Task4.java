package exercise.Consultation12G_25_09_11;

public class Task4 {
    // Задача 2 Обработка исключения (try-catch-finally)
    public static void main(String[] args) {
        try {
            System.out.println("Block start: try");
            int[] numbers = new int[3];
            numbers[5] = 100;
            System.out.println("This line will not running because early was exception");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catch exception: " + e.getMessage());
            System.out.println("We worked with problem exit from array index");
        } catch (Exception e) {
            System.out.println("Catch general exception: " + e);
        } finally {
            System.out.println("Block finally running always");
        }
        System.out.println("After code");
    }
}
