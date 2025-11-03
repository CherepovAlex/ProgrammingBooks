package ru.yandex;

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }
}

public class Main3 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(2, 3));       // Вывод: 5
        System.out.println(calculator.add(2.5, 3.5));   // Вывод: 6.0
    }
}

