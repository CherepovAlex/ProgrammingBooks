package exercise.Vebinar22_25_09_10_Exceptions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Example2 {

    public static void main(String[] args) {
        hereWillBeTrouble(42, 0);
    }

    public static void hereWillBeTrouble(int a, int b) {
        int oops = a;
        try {
            System.out.println("All before...");
            oops = a / b;
            System.out.println(oops);
            System.out.println("All after...");
        } catch (ArithmeticException e) {
            System.out.println("Say early you can't division by zero!");
            oops = 0;
        }
        System.out.println("Method worked");

        // shablon
//        statements
//        try {
//            code ...;
//        } catch (/*Exception-type e*/) {
//            code for dealing with e exception
//        }
//        more-statements

        // много блоков catch
//        try {
//            ...
//        } catch (IllegalArgumentException e) {
//            someCode();
//        } catch (SecurityException e) {
//            someCode();
//        } catch (IllegalAccessException e) {
//            someCode();
//        } catch (NoSuchFieldException e) {
//            someCode();
//        }


    }
}
