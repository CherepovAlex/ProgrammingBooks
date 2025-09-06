package exercise.Consultation11G_25_09_04;

// Задача 2: Интерфейсы «Летающий» и «Плавающий»
//Создайте интерфейсы Flyable (с методом fly()) и Swimmable (с методом swim()). Создайте класс Duck (Утка), который
// реализует оба интерфейса. Продемонстрируйте работу методов.
public class Example2 {

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.fly();
        duck.swim();

        Flyable flyable = duck;
        Swimmable swimmable = duck;
        flyable.fly();
        // flyable.swim(); not work
        swimmable.swim();
    }

}

interface Flyable {
    void fly();

}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }

    @Override
    public void swim() {
        System.out.println("Duck is swimming");
    }
}