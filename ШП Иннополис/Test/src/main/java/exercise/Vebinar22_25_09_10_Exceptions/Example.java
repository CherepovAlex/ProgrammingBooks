package exercise.Vebinar22_25_09_10_Exceptions;

public class Example {
    public static void main(String[] args) {
        try {
            // вызывает validateInput()
            validateInput("abc");
        } catch (InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    // проверяет входящую строку на пустоту или null
    // если так, то выбрасывает InvalidInputException с сообщением
    public static void validateInput(String input) throws InvalidInputException {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException("Input cannot be null or empty");
        }
    }
}
