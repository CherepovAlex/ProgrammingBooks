package io.hexlet;

import io.hexlet.exception.InvalidEmailException;
import io.hexlet.exception.PasswordsNotMatchException;
import io.hexlet.exception.RegistrationException;
import io.hexlet.exception.UserExistsException;
import io.hexlet.model.User;
import io.hexlet.util.EmailValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
    // BEGIN (write your solution here)
    public static void registerUser(List<User> users, Map<String, String> data) throws RegistrationException {
        String email = data.get("email");
        String password = data.get("password");
        String confirmation = data.get("confirmation");

        if (!EmailValidator.isValid(email)) {
            throw new InvalidEmailException();
        }

        if (!password.equals(confirmation)) {
            throw new PasswordsNotMatchException();
        }

        boolean userExitsts = users.stream()
                .anyMatch(user -> user.getEmail().equals(email));
        if (userExitsts) {
            throw new UserExistsException();
        }

        users.add(new User(email,password));
    }

    public static void main(String[] args) {

        var users = new ArrayList<User>();
        var data = List.of(
                new User("gconibeer0@whitehouse.gov", "zJ4C"),
                new User("fmellsop1@examiner.com", "kG5T125"),
                new User("cbafford2@cafepress.com", "gE3pG4Y")
        );
        users.addAll(data);

        var registrationData = Map.of(
                "email", "gconibeer0@whitehouse.gov",
                "password", "qwerty",
                "confirmation", "qwerty"
        );

        try {
            App.registerUser(users, registrationData);
        } catch (RegistrationException e) {
            var message = "Произошла ошибка при регистрации: " + e.getMessage();
            System.out.println(message);
        }
    }
    // END
}
