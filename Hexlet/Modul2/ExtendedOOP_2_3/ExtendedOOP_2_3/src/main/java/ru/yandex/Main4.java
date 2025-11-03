package ru.yandex;

class Animal1 {
    public void makeSound() {
        System.out.println("Животное издаёт звук");
    }
}

class Dog1 extends Animal1 {
    @Override
    public void makeSound() {
        System.out.println("Собака лает");
    }
}

public class Main4 {
    public static void main(String[] args) {
        Animal1 animal1 = new Dog1();
        animal1.makeSound();        // Вывод: Собака лает
    }
}
