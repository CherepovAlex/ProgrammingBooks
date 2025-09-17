package exercise.Consultation12G_25_09_11;

import java.util.Scanner;
// Задача 5 Решение практических задач
public class Task7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter number: ");
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);

                System.out.print("Enter divisor: ");
                input = scanner.nextLine();
                int divisor = Integer.parseInt(input);

                int result = number / divisor;
                System.out.println("Result: " + result);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: you entered not number. Try again.");
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero impossible. Try again.");
            }
        }
        scanner.close();
        System.out.println("Program finished correctly");
    }
}
