package exercise.Vebinar22_25_09_10_Exceptions;

// создаём проверяемое исключение, т.к. наследуется от Exception
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
