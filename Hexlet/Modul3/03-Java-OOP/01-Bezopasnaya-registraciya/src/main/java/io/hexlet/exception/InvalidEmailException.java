package io.hexlet.exception;

public class InvalidEmailException extends RegistrationException {
    public InvalidEmailException() {
        super("Invalid email format");
    }
}
