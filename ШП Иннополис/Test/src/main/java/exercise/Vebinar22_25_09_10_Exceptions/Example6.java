package exercise.Vebinar22_25_09_10_Exceptions;

public class Example6 {
    public static void main(String[] args) {
        hereWillBeTrouble();
    }

    // допустимо без catch если есть finally, но смысла в не мало
    private static void hereWillBeTrouble() throws ArithmeticException {
        String someText = "z";
        try {
            someText = "234";
        } finally {
            someText = "Finally";
        }
    }
}
