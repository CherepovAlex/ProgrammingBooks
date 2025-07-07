package exercise;

public class Foo1 {
    public void go() {
        Laundry laundry = new Laundry();
        try {
            laundry.doLaundry();
        } catch (PantsException pex) {
            System.out.println("pex");
        } catch (LingerieException lex) {
            System.out.println(("lex"));
        }
    }
}

class Laundry {
    public void doLaundry() throws PantsException, LingerieException {
        System.out.println("do laundry");
    }
}

class PantsException extends Exception {
}

class LingerieException extends Exception {
}
