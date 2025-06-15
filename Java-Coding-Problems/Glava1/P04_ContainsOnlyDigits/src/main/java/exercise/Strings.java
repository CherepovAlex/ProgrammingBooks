package exercise;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean containsOnlyDigitsV1(String str) {
        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsOnlyDigitsV2(String str) {
        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return false;
        }
        return str.matches("[0-9]+");
    }

    public static boolean containsOnlyDigitsV3(String str) {
        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return false;
        }
        return !str.chars()
                .anyMatch( x -> !Character.isDigit(x));
    }
}
