package exercise;

public class Main2 implements MyInterface{

    public static void main(String[] args) {
        var ob = new Main2();
        ob.myOne();
        ob.myTwo();
        MyInterface.myThree();
    }
    public void myTwo(){
            System.out.println("two");
    }
}

interface MyInterface {
    default void myOne() { System.out.println("one"); }

    void myTwo();

    static void myThree() {
        System.out.println("three");
    }
}