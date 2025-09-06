package exercise.Consultation11G_25_09_04;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

// Задача 5: Комбинированная задача «Умный склад» (Уровень: Сложно)
//1.	Создайте абстрактный класс Product с полем weight (вес) и абстрактным методом String getDescription().
//2.	Создайте интерфейс Expirable с методом boolean isExpired(), который проверяет, просрочен ли товар.
//3.	Создайте класс Food (еда), который наследует Product и реализует Expirable. Добавьте поле expiryDate
// (срок годности). Реализуйте методы.
//4.	В main создайте список разных продуктов (включая еду с разными сроками).
//5.	Используя Stream API:
//o	Найдите все просроченные продукты.
//o	Выведите их описание и вес.
//o	Посчитайте общий вес просроченных продуктов.
public class Example5 {

    public static void main(String[] args) {

        List<Product> warehouse = Arrays.asList(
                new Food(0.5, LocalDate.of(2023, 10, 1)),
                new Electornics(5.2),
                new Food(1.0, LocalDate.of(2026, 12, 1)),
                new Food(0.3, LocalDate.of(2023, 9, 1))
        );

        List<Product> expiredProducts = warehouse.stream()
                .filter(product -> product instanceof Expirable)
                .map(product -> (Expirable) product)
                .filter(Expirable::isExpired)
                .map(product -> (Product) product)
                .toList();

        System.out.println("Expired products: ");
        expiredProducts.forEach(product ->
                System.out.println(product.getDescription() + " Weight: " + product.getWeight() + " kg"));

        double totalWeight = expiredProducts.stream()
                .mapToDouble(Product::getWeight)
                .sum();
        System.out.println("Total weight with expired date: " + totalWeight + " kg");
    }
}

abstract class Product {
    private double weight;

    public Product(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public abstract String getDescription();
}

interface Expirable {
    boolean isExpired();
}

class Food extends Product implements Expirable {
    private LocalDate expiryDate;

    public Food(double weight, LocalDate expiryDate) {
        super(weight);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public String getDescription() {
        return "Food (ready before: " + expiryDate + ")";
    }
}

class Electornics extends Product {
    public Electornics(double weight) {
        super(weight);
    }

    @Override
    public String getDescription() {
        return "Electronics";
    }
}