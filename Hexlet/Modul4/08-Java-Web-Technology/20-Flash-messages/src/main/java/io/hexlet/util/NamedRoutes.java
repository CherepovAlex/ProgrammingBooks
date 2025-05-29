package io.hexlet.util;

public class NamedRoutes {

    public static String homePath() {return "/";}
    public static String coursesPath() {return "/courses";}
    public static String buildCoursesPath() {
        return "/courses/build";
    }

    public static String coursePath(Long id) {return coursePath(String.valueOf(id));}
    public static String coursePath(String id) {return "/courses/" + id;}

    public static String editCoursePath(Long id) { return editCoursePath(String.valueOf(id)); }
    public static String editCoursePath(String id) { return "/courses/" + id + "/edit"; }

    public static String updateCoursePath(Long id) {return updateCoursePath(String.valueOf(id));}
    public static String updateCoursePath(String id) { return "/courses/" + id + "/update"; }

    public static String deleteCoursePath(Long id) {return deleteCoursePath(String.valueOf(id));}
    public static String deleteCoursePath(String id) { return "/courses/" + id + "/delete"; }


}
