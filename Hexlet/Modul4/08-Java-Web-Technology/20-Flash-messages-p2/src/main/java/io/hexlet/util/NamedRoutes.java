package io.hexlet.util;

public class NamedRoutes {

    public static String rootPath() {return "/";}
    public static String homePath() {return "/";}

    public static String usersPath() {
        return "/users";
    }
    public static String userPath(Long id) {return userPath(String.valueOf(id));}
    public static String userPath(String id) {return "/users/" + id;}
    public static String buildUserPath() {return "/users/build";}
    public static String editUserPath(Long id) {return editUserPath(String.valueOf(id));}
    public static String editUserPath(String id) {return "/users/" + id + "/edit";}
    public static String deleteUserPath(Long id) {return deleteUserPath(String.valueOf(id));}
    public static String deleteUserPath(String id) {return "/users/" + id;}

    public static String buildSessionPath() {
        return "/sessions/build";
    }
    public static String sessionsPath() {return "/sessions";}
    public static String loginPath() {return "/";}
    public static String logoutPath() {
        return "/delete";
    }
}
