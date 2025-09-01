package exercise.Vebinar16_25_08_20_Scanner_IO;

import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) {
        // System.in объявляет входной поток данных из консоли
        Scanner scanner = new Scanner(System.in);

        // считывает всю строку
        String name = scanner.nextLine();

        // считывает строку перед следующим разделителем
        String name1 = scanner.next();

        // Основные разделители (whitespace characters):
        // Пробел ( ), Табуляция (\t), Перевод строки (\n), Возврат каретки (\r), Перевод формата (\f)

        // Если ввести: "Hello World Java"
        String first = scanner.next();  // "Hello"
        String second = scanner.next(); // "World"
        String third = scanner.next();  // "Java"

        // теперь разделитель - запятая
        scanner.useDelimiter(","); // теперь разделитель - запятая

        // чтение других типов данных
        int firstNum = scanner.nextInt();
        double secondNum = scanner.nextDouble();
        // числа могут быть разделены последовательностью пробельных символов (выше)
        // если вводится не число, то будет исключение

        scanner.close();

    }

}
