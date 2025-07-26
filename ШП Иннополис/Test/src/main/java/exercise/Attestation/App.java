package exercise.Attestation;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // покупатели
        Person[] persons = new Person[0];
        System.out.println("Введите покупателей в формате: \"Имя = Сумма; Имя2 = Сумма2\"");
        System.out.println("Завершите ввод нажатием Enter");

        String inputText = scanner.nextLine();
        if (!inputText.isEmpty()) {
            // Разделяем ввод на имя и деньги
            String[] buyers = inputText.split(";\\s*");
            for (String buyer : buyers) {
                String[] parts = buyer.trim().split("\\s*=\\s*");
                if (parts.length != 2) {
                    System.out.println("Неверный формат ввода. Используйте: \"Имя = Сумма\"");
                    continue;
                }
                // Создаём нового покупателя
                try {
                    Person person = new Person(parts[0], Integer.parseInt(parts[1]));
                    persons = Arrays.copyOf(persons, persons.length + 1);
                    persons[persons.length - 1] = person;
                } catch (NumberFormatException e) {
                    System.out.println("Сумма денег должна быть числом");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // ассортимент
        Product[] products = new Product[0];
        System.out.println("Введите продукты в формате: \\\"Продукт = Цена; Продукт2 = Цена2\\\"");
        System.out.println("Завершите ввод нажатием Enter");

        inputText = scanner.nextLine();
        if (!inputText.isEmpty()) {
            // Разделяем на товар и стоимость
            String[] goods = inputText.split(";\\s*");
            for (String good : goods) {
                String[] parts = good.trim().split("\\s*=\\s*");
                if (parts.length != 2) {
                    System.out.println("Неверный формат ввода. Используйте: \"Название = Цена\"");
                    continue;
                }
                // Создаём новый продукт
                try {
                    Product product = new Product(parts[0], Integer.parseInt(parts[1]));
                    products = Arrays.copyOf(products, products.length + 1);
                    products[products.length - 1] = product;
                } catch (NumberFormatException e) {
                    System.out.println("Цена должна быть числом");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());

                }
            }
        }
        // покупки
        System.out.println("Введите покупки в формате: \"Имя - Продукт\" (по одной на строку)");
        System.out.println("Для завершения введите END");

        while (true) {
            String buy = scanner.nextLine();        // ожидаем ввод "Клиент - продукт"
            if (buy.equalsIgnoreCase("END")) {
                break;
            }

            String[] parts = buy.split("\\s*-\\s*"); // разделяем ввод
            if (parts.length != 2) {
                System.out.println("Неверный формат: " + buy);
            }

            boolean foundPerson = false;
            boolean foundProduct = false;
            // перебираем покупателей
            for (var person : persons) {
                // ищем покупателя
                if (person.getName().equals(parts[0])) {
                    foundPerson = true;
                    // ищем в ассортименте введенный продукт
                    for (Product product : products) {
                        if (product.getProductName().equals(parts[1])) { // сравниваем наименование продуктов
                            foundProduct = true;
                            if (person.getMoney() >= product.getPrice()) {      // проверяем хватит ли денег
                                // добавляем продукт в корзину
                                Product[] newProducts = Arrays.copyOf(person.getProducts(), person.getProducts().length + 1);
                                newProducts[newProducts.length - 1] = product;
                                person.setProducts(newProducts);
                                // Уменьшаем деньги
                                person.setMoney(person.getMoney() - product.getPrice());
                                System.out.println(person.getName() + " купил(а) " + product.getProductName());
                            } else {
                                System.out.println(person.getName() + " не может позволить себе " + product.getProductName());
                            }
                            break;
                        }
                    }
                    break;
                }
            }
            if (!foundPerson) {
                System.out.println("Покупатель не найден: " + parts[0]);
            } else if (!foundProduct) {
                System.out.println("Продукт не найден: " + parts[1]);
            }
        }
        // вывод информации о покупателе
        for (Person person : persons) {
            if (person.getProducts().length == 0) {
                System.out.println(person.getName() + " - Ничего не куплено");
            } else {
                System.out.print(person.getName() + " - ");
                for (int i = 0; i < person.getProducts().length; i++) {
                    if (i > 0) System.out.print(", ");
                    System.out.println(person.getProducts()[i].getProductName());
                }
                System.out.println();
            }
        }
    }
}