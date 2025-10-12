package ComputerScienceCenter.lection4.interfaceApp;

/**
 * Represents an immutable 3D-Vector
 */
public interface Vector {
    /**
     * Returns a vector component
     *
     * @param n component number, must be 0 (X), 1 (Y) or 2 (Z)
     * @return a value of the corresponding vector component
     */
    double component(int n);

    /**
     *
     * @return a vector length
     */
    double length();

    /**
     * Sums two vectors
     *
     * @param other a vector to add to this vector
     * @return a result of addiction
     */
    Vector plus(Vector other);

    /**
     * Returns a string representation of vector
     * which looks like (X, Y, X)
     * @return string of vector
     */
    @Override
    String toString();

    // метод по умолчанию
    /**
     * @return a vector length
     */
    default double length1() {
        double x = component(0);
        double y = component(1);
        double z = component(2);
        return Math.sqrt(x*x + y*y + z*z);
    }

    // фабричный метод
    /**
     * Returns a vector having the supplied components.
     * @param x x component
     * @param y y component
     * @param z z component
     * @return
     */
    static Vector of(double x, double y, double z) {
        if (x == 0 && y == 0 && z == 0) {
            return ZeroVector.INSTANCE;
        }
        return new ArrayVector(x, y, z);
    }

    // анонимный класс вместо ZeroVector
    Vector ZERO = new AbstractVector() {
        @Override
        public double component(int n) {return 0;}

        @Override
        public double length() {return 0;}

        @Override
        public Vector plus(Vector other) {return other;}

        @Override
        public String toString() {return "(0, 0, 0)";}
    };
}
