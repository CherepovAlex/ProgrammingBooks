package exercise.Consultation12G_25_09_11;

public class Task2 {

    public static void main(String[] args) {
        throwIllegalArgument();
    }

    public static void throwIllegalArgument() {
        throw new IllegalArgumentException("This is unchecked exception!");
    }

}

// Exception in thread "main" java.lang.IllegalArgumentException: This is unchecked exception!
//	at exercise.Consultation12G_25_09_11.Task2.throwIllegalArgument(Task2.java:10)
//	at exercise.Consultation12G_25_09_11.Task2.main(Task2.java:6)