package exercise.top20sobes;

// Напишите программу на Java для переворота последовательности символов в строке
// без использования встроенной в String функции reverse().

import java.util.Scanner;

public class z2_2 {

    public static void main(String[] args) {

        String mainString, reverseString = "";

        System.out.println("Введите нужную строку, чтобы получить перевернутую:");

        Scanner scannerQ = new Scanner(System.in);

        mainString = scannerQ.nextLine();

        int stringLength = mainString.length();

        for (int x = stringLength - 1; x >= 0; x--) {

            reverseString = reverseString + mainString.charAt(x);   //используем встроенный метод charAt()
                                                                    // чтобы перевернуть строку

        }

        System.out.println(reverseString);

    }

}
