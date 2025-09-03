package exercise.Consultation10B_25_08_30;

/*Программа для нахождения наибольшего общего делителя (НОД) двух натуральных чисел.
Пример ввода:
Введите первое число: 36
Введите второе число: 24
*/
import java.util.Scanner;

//public static int gcd(int a, int b) {
//    while(b != 0) {
//        int temp = b;
//        b = a % b;
//        a = temp;
//    }
//    return Math.abs(a);
//}

public class Nod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод первых двух чисел
        System.out.print("Введите первое число: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int secondNumber = scanner.nextInt();

        // Получаем НОД с помощью евклидова алгоритма
        int gcdResult = findGCD(firstNumber, secondNumber);

        // Выводим результат
        System.out.println("Наибольший общий делитель чисел " + firstNumber + " и " + secondNumber + " равен: " + gcdResult);
    }

    // Метод для нахождения НОД по алгоритму Евклида
    private static int findGCD(int a, int b) {
        while (b != 0) {
            int remainder = a % b; // Остаток от деления
            a = b;                 // Текущее число становится новым первым числом
            b = remainder;         // Остаток становится новым вторым числом
        }
        return Math.abs(a);         // Возвращаем модуль числа (на случай отрицательных значений)
    }
}