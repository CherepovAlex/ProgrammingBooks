package ComputerScienceCenter.lection4.interfaceApp;

public class ZeroVector1 extends AbstractVector{

    public static final ZeroVector1 INSTANCE = new ZeroVector1();

    private ZeroVector1() {}

    @Override
    public double component(int n) {return 0;}

    @Override
    public double length() {return 0;}

    @Override
    public Vector plus(Vector other) {return other;}
}
