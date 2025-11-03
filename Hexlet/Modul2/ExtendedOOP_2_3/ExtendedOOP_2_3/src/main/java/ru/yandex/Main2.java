package ru.yandex;

// Основной класс
public class Main2 {
    public static void main(String[] args) {
        Dog dog = new Dog("Шарик");
        dog.name = "Бобик";
        dog.eat();  // Метод из родительского класса
        dog.bark(); // Метод из дочернего класса
    }
}

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " есть.");
    }

    public void feed() {
        System.out.println("Feed");
    }
}

// Дочерний класс
class Dog extends Animal {
    public Dog(String name) {
        super(name);    // Вызов конструктора родительского класса
    }

    public void bark() {
        System.out.println(name + " лает.");
    }
}
