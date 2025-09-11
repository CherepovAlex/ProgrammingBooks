package exercise.Vebinar22_25_09_10_Exceptions;

// кастомное своё исключение
public class MyException extends Exception {
    String s;
    private int detail;

    // первым параметром в кастомных исключениях обычно передают сообщение
    public MyException(String s) {
        this.s = s;
    }

    public MyException(int a) {
        detail = a;
    }

    public String toString() {
        return "MyException[" + detail + "]";
    }
}
