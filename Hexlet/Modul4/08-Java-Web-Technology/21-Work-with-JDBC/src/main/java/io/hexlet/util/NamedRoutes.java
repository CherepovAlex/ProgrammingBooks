package io.hexlet.util;

public class NamedRoutes {
    public static String rootPath() {return "/";}
    public static String carsPath() {return "/cars";}
    public static String buildCarPath() {return "/cars/build";}
    public static String carPath(Long id) {return carPath(String.valueOf(id));}
    public static String carPath(String id) {return "/cars/" + id;}
}

