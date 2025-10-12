package ComputerScienceCenter.lection4.b;

import ComputerScienceCenter.lection4.a.AbstractGreeter;

public class Foo {
}

class WorldGreeter extends AbstractGreeter {
    public WorldGreeter(String recipient) {
        super("World");
    }
    void test(AbstractGreeter other) {
        this.hello();
        super.hello();
        // other.hello(); не получится.
    }
}