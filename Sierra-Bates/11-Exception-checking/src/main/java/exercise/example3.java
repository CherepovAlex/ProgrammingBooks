package exercise;

public class example3 {

    void method1() {
        example3 x = new example3();
        try {
            if (x.turnOvenOn()) System.out.println("ku");;
            x.bake();
//        } catch (BakingException ex) {
//            ex.printStackTrace();
        } finally {
            turnOvenOff();
        }
    }

    void method2() {
        example3 x = new example3();
        try {
            turnOvenOn();
            x.bake();
            turnOvenOff();
//        } catch (BakingException ex) {
//            ex.printStackTrace();
            turnOvenOff();
        }  finally {}
    }


    private boolean turnOvenOff() {
        return false;
    }

    private boolean turnOvenOn() {
        return false;
    }

    public void bake() {
    }

}

