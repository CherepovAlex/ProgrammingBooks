package exercise.Consultation11G_25_09_04;

import java.util.Arrays;
import java.util.List;

//Задача 4: Stream API — обработка списка заказов
//Дан список заказов Order с полями productName (название товара) и cost (стоимость).
//Вывести названия всех товаров, которые стоят больше 1000 рублей.
//Создать новый список из названий этих товаров, отсортированный по алфавиту.
public class Example4 {

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Laptop", 70000.0),
                new Order("Phone", 50000.0),
                new Order("Book", 500.0),
                new Order("Headphones", 3000.0));

        List<String> expensiveProducts = orders.stream()
                .filter(order -> order.getCost() > 1000)
                .map(Order::getProductName)
                .sorted()
                .toList();
        System.out.println("Expensive Products: " + expensiveProducts);
    }

}

class Order {
    private String productName;
    private double cost;

    public Order(String productName, double cost) {
        this.productName = productName;
        this.cost = cost;
    }

    public String getProductName() {
        return productName;
    }

    public double getCost() {
        return cost;
    }
}