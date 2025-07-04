package exercise;

public class Duck {

    private int size;
    private static int duckCount = 0;

    public Duck(int size) {
        duckCount++;
    }

    public static void main(String[] args) {

//        System.out.println("Размер утки равен" + size);

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
