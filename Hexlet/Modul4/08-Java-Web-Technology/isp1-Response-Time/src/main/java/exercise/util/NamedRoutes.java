package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    public static String productsPath() {
        return "/products";
    }

    public static String productPath(Long id) {
        return productPath(String.valueOf(id));
    }

    public static String productPath(String id) {
        return "/products/" + id;
    }
}
