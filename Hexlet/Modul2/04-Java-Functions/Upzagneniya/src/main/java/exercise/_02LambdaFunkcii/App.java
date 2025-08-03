package exercise._02LambdaFunkcii;

import java.util.Map;

public class App {

    // BEGIN
    public static void printBalance(Map<String, Integer> stock, int minBalance) {
        stock.forEach((key, value) -> {
            if (value < minBalance) {
                System.out.println(key);
            }
        });
    }
    // END

    public static void main(String[] args) {
        var products = Map.of(
                "Apple", 5,
                "Lemon", 9,
                "Pear", 15
        );

        App.printBalance(products, 10); // =>
        // Apple
        // Lemon
    }
}
