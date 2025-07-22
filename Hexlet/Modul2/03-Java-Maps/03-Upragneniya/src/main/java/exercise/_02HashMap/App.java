package exercise._02HashMap;

import java.util.Map;

public class App {

    static Map<String, Double> products = Map.of(
            "Coffee", 30.0,
            "Bread", 10.0,
            "Milk", 20.0
    );

    public static void main(String[] args) {

        var discounts = Map.of(
                "Bread", 10.0,
                "Salmon", 20.0
        );

        // Скидка на хлеб 10 процентов
        App.getPriceWithDiscount(discounts, "Bread"); // 9.0

        // На молоко сегодня скидок нет
        App.getPriceWithDiscount(discounts, "Milk"); // 20.0

        App.getPriceWithDiscount(discounts, "Olives"); // null
    }

    private static Double getPriceWithDiscount(Map<String, Double> discounts, String product) {
        // Проверяем, есть ли продукт в списке продуктов
        if (!products.containsKey(product)) {
            return null;
        }

        // Получаем цену продукта
        Double price = products.get(product);

        // Проверяем, есть ли скидка на этот продукт
        if (discounts.containsKey(product)) {
            Double discount = discounts.get(product);
            // Вычисляем цену со скидкой
            return price * (1 - discount / 100);
        }

        // Если скидки нет, возвращаем обычную цену
        return price;
    }

}
