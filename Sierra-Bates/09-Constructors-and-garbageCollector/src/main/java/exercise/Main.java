package exercise;

public class Main {

    public void doStufff() {
        boolean b = true;
        go(4);
    }

    public void go(int x) {
        int z = x + 24;
        crazy();
    }

    public void crazy() {
        char c = 'a';
    }

    public class StackRef {
        public void foof() {
            barf();
        }

        public void barf() {
            Main m = new Main();
        }
    }


    public static void main(String[] args) {
        Duck d1 = new Duck();
        d1.setSize(42);

        Duck d2 = new Duck(42);
    }
}

class Duck {
    int size;

    public Duck() {
        System.out.println("Кря");
    }

    public Duck(int duckSize) {
        System.out.println("Кря");
        if (duckSize == 0) {
            size = 27;
        } else {
            size = duckSize;
        }
        System.out.println("Размер равен" + size);
    }

    public void setSize(int newSize) {
        size = newSize;
    }
}

class Mushroom {
    public Mushroom (int size){};
    public Mushroom() {}
    public Mushroom(boolean isMagic) {}
    public Mushroom(boolean isMagic, int size) {}
    public Mushroom(int size, boolean isMagic) {}

}