package ru.yandex;

public class Main {
    public static void main(String[] args) {
        // Создаём объект класса Person
        Person person = new Person();
        person.name = "Иван";
        person.age = 25;
        person.introduce(); // Вывод: Привет, меня зовут Иван и мне 25 лет

        BankAccount account = new BankAccount();
        account.setBalance(1000);   // Установить баланс
        System.out.println("Баланс: " + account.getBalance());  // Получить баланс
    }
}

class Person {
    String name;    // Поле класса
    int age;

    // Метод класса
    public void introduce() {
        System.out.println("Привет, меня зовут " + name + " и мне " + age + " лет.");
    }
}

class BankAccount {
    private double balance;     // Поле скрыто

    // Геттер для получения значения
    public double getBalance() {
        return balance;
    }

    // Сеттер для изменения значения с проверкой
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Баланс не может быть отрицательным.");
        }
    }
}
