package exercise;

public class TestException {
    public static void main(String[] args) {
        String test = "No";
        try {
            System.out.println("Start try");
            doRisky(test);
            System.out.println("End try");
        } catch (ScaryException se) {
            System.out.println("Scare exception");
        } finally {
            System.out.println("finally");
        }
        System.out.println("End of main");
    }

    private static void doRisky(String test) throws ScaryException {
        System.out.println("Start danger method");
        if ("yes".equals(test)) {
            throw new ScaryException();
        }
        System.out.println("End danger method");
        return;
    }
}

class ScaryException extends Exception {
    public ScaryException() {}
}
