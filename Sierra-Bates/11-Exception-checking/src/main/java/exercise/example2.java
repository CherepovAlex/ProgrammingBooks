package exercise;

public class example2 {

    void method1() {
        Foo x = new Foo();
        try {
            Foo f = x.doRiskyThing();
            int b = f.getNum();
        } catch (Exception ex) {
            System.out.println("Fault!");
        }
        System.out.println("We got it!");
    }

    void method2() {
        Foo x = new Foo();
        try {
            Foo f = x.doRiskyThing();
            int b = f.getNum();
        } catch (Exception ex) {
            System.out.println("We did it!");
        }
        System.out.println("Fault!");
    }

}

class Foo {
    int num;

    public Foo doRiskyThing() {
        return new Foo();
    }

    public int getNum() {
        return 0;
    }
}