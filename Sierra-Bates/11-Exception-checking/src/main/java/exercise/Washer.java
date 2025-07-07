package exercise;

public class Washer {
    Laundry laundry = new Laundry();

    public void foo() throws ClothingException, Exception {
        laundry.doLaundry();
    }

    public static void main(String[] args) throws Exception {
        Washer a = new Washer();
        a.foo();
    }
}

class ClothingException extends Exception {
    public ClothingException(String message) {
        super(message);
    }
}