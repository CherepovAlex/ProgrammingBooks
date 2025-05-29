package io.hexlet.exception;

public class PasswordsNotMatchException extends RegistrationException {
    public PasswordsNotMatchException() {
        super("Password and password confirmation do not match");
    }
}
