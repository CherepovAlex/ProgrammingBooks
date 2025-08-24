package exercise.Vebinar17_25_08_22;

import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) {
        // открывает стандартный поток ввода System.in
        // открывает стандартный поток вывода System.out
        // стандартная ошибка System.err для выпуска исключения и завершения работы программы

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(line);
    }

}
