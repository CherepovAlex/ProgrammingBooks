package exercise;

public class TestBox {

    Integer i;
    int j;

    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();
    }

    private void go() {
        j = 1;
        System.out.println(j);
        System.out.println(i);
    }

}
