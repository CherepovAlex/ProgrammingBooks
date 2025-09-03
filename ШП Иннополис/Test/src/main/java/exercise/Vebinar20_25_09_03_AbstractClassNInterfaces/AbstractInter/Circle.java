package exercise.Vebinar20_25_09_03_AbstractClassNInterfaces.AbstractInter;

// класс, реализующий дочерний интерфейс, также должен обеспечивать реализацию родительского интерфейса

public class Circle implements Printable{
    @Override
    public void print() {
        System.out.println("Hello");
    }

    @Override
    public void show() {
        System.out.println("Welcome");
    }
}
