package exercise;

public class MathUtils {
    // Статический метод для вычисления факториала числа

    public static int factorial(int number){
        if (number < 0){
            throw new IllegalArgumentException("Number must be non-negative");
        }

        int result = 1;
        for (int i = 2; i <= number; i++){
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 5;
        // Вызов статического метода
        int result = MathUtils.factorial(number);
        System.out.println("Factorial of " + number + " is " + result);
    }
}
