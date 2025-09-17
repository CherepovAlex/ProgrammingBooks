package exercise.Consultation12G_25_09_11;

public class Task3 {

    public static void main(String[] args) {
        int result = 10 / 0;

    }

    public static void throwIllegalArgument() {
        throw new IllegalArgumentException("This is unchecked exception!");
    }

}

// Exception in thread "main" java.lang.ArithmeticException: / by zero
//	at exercise.Consultation12G_25_09_11.Task3.main(Task3.java:6)