package exercise.top20sobes;

// Напишите программу на Java для переворота последовательности символов в строке
// без использования встроенной в String функции reverse().

import java.util.Scanner;

public class z2_1 {

    public static void main(String[] args) {

        String st;

        Scanner scannerQ = new Scanner(System.in);

        System.out.println("Введите вашу строку:");

        st = scannerQ.nextLine();

        String[] temp = st.split("");    //используем метод split для вывода строки в обратном порядке

        for (int x = temp.length - 1; x >= 0; x--) {

            System.out.print(temp[x] + "");

        }


    }

}
