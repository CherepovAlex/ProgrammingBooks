package exercise._04ListsInAction;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<String> getProductsByPrice(List<Product> products, int minPrice, int maxPrice) {
        var newList = new ArrayList<String >();

        for (var product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                newList.add(product.getTitle());
            };
        }

        return newList;
    }

    public static void main(String[] args) {
        var products = List.of(
                new Product("bread", 5),
                new Product("milk", 10),
                new Product("fish", 30)
        );

        var result = App.getProductsByPrice(products, 10, 30);
        System.out.println(result); // => ["milk", "fish"]
    }

}

final class Product {

    private String title;
    private int price;

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
}