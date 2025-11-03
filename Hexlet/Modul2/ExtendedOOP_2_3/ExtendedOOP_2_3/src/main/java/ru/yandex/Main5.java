package ru.yandex;

class Animal2 {
    String voice() {
        return "??";
    }
}

class Dog2 extends Animal2 {
    @Override
    String voice() {
        return "woof";
    }
}

public class Main5 {
    public static void main(String[] args) {
        Animal2 a = new Dog2();
        System.out.println(a.voice());  // "woof" - выбирается в рантайме
    }
}
