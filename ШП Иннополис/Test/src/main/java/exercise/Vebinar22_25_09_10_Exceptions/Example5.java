package exercise.Vebinar22_25_09_10_Exceptions;

public class Example5 {

    public static void main(String[] args) {
        hereWillBeTrouble();
    }

    // можно в сигнатуре прописать throws, чтобы не обрабатывать
    // throws обозначает, что метод может выбросить исключение
    private static void hereWillBeTrouble() throws ArithmeticException {
        System.out.println("All before...");
        int oops = 42/0;
        System.out.println("All after");
    }

}
