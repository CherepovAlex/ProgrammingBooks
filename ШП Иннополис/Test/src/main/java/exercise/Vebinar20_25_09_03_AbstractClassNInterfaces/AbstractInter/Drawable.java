package exercise.Vebinar20_25_09_03_AbstractClassNInterfaces.AbstractInter;

// если вам нужно переопределить метод по умолчанию, подумайте о своём дизайне

public interface Drawable {
    void draw();

    // доступны, начиная с Java 8
    // метод уже реализован внутри самого интерфейса, в классе переопределять не будем
    default void msg() {
        System.out.println("default method");
    }
    // и также добавить статический метод, который также не нужно реализовывать в классе
    static int cube(int x) {
        return x * x * x;
    }
}
