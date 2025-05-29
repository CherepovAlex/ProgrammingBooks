package io.hexlet.exception;

public class UserExistsException extends RegistrationException {
    public UserExistsException() {
        super("A user with the same email address already exists");
    }
}
