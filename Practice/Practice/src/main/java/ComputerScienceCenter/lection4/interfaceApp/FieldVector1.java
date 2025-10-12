package ComputerScienceCenter.lection4.interfaceApp;

public class FieldVector1 extends AbstractVector{
    double x, y, z;

    FieldVector1(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double component(int n) {
        switch (n) {
            case 0: return x;
            case 1: return y;
            case 2: return z;
            default: throw new IllegalArgumentException();
        }
    }

    @Override
    public double length() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    @Override
    public Vector plus(Vector other) {
        return null;
    }

}