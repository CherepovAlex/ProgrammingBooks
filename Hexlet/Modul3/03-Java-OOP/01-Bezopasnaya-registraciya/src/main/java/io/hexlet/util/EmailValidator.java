package io.hexlet.util;

import java.util.regex.Pattern;

public class EmailValidator {
    public static boolean isValid(String email) {
        var pattern = Pattern.compile("\\S+@\\S+\\.\\S+");
        var matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
