package exercise.Vebinar13_25_08_08;

// не нужно знать реализацияю, чтобы использовать ADT (abstract dat type)
public abstract class Dog {
    //Dog();
    abstract String getName();
    abstract void bark();
    abstract void sleep();
}

abstract class Computer {
    // Computer();
    abstract void turnOn();
    abstract void turnOff();
    abstract void getSpecs();
}
