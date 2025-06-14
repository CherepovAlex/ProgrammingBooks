package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    public static String usersPath() {
        return "/users";
    }

    public static String userPath(String id) {
        return "/users/" + id;
    }

    public static String userPath(long id) {
        return userPath(Long.toString(id));
    }

}
