package exercise.Attestation;

import java.util.Objects;

class Product {
    private String productName;
    private int price;

    public Product(String productName, int price) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Стоимость продукта не может быть отрицательным числом");
        }
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        if (productName.isBlank()) {
            System.out.println("Название продукта не может быть пустой строкой, оно должно быть");
        } else {
            this.productName = productName;
        }
    }

    public void setPrice(int price) {
        if (price < 0) {
            System.out.println("Стоимость продукта не может быть отрицательным числом");
        } else {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price);
    }
}