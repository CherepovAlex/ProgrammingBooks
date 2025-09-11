package exercise.Vebinar22_25_09_10_Exceptions;
// Пример, как правильно объявлять методы, которые могут выбрасывать собственнык исключения
// и как перехватывать их при вызовк этих методов

// класс, который использует собственное исключение
public class Example_ {
    // Метод, который может выбросить собственное исключение
    public static void doSomething(int value) throws CustomException {
        if (value < 0) {
            throw new CustomException("Value could be bigger or equals noll (0)");
        }
    }

    public static void main(String[] args) {
        try {
            // Вызываем метод, который может выбросить исключение
            doSomething(-5);
        } catch (CustomException e) {
            // обрабатываем исключение
            System.out.println("Error: " + e.getMessage());
        }

    }
}
