package exercise.in_out_classes;

public class MyOuter {

    private int x;  // внешний содержит приватную переменную

    MyInner inner = new MyInner();

    public void doStuff() {
        inner.go();     // вызываем метод внутреннего класса
    }

    class MyInner {

        void go() {     // метод внутреннего класса
                        // использует переменную внешнего класса как свою
            x = 42;

        }
    }
}
