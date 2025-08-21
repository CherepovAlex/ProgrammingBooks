package exercise.Vebinar16_25_08_20;

import java.util.Scanner;

public class Example3 {

    public static void main(String[] args) {
        // ввод из консоли
        Scanner input = new Scanner(System.in);
        // вводим слова
        String firstWord = input.next("\\w+");
        String secondWord = input.next("\\w+");
        // вводим числа
        int numInt = input.nextInt();
        double numDouble1 = input.nextDouble();
        double numDouble2 = input.nextDouble();
        // skip to the line end, очистка буфера
        input.nextLine();
        // вводим ещё слово
        String thirdWord = input.nextLine();

        int sum = (int) (numInt + numDouble1 + numDouble2);

        System.out.println(firstWord + " " + secondWord + " " + thirdWord + " " + sum);
    }
}
// Ввод:
// java rocks
//5 12,5 -7,5
//end

// Вывод:
//java rocks end 10