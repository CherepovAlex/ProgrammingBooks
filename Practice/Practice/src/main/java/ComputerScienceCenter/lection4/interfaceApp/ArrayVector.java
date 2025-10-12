package ComputerScienceCenter.lection4.interfaceApp;

public class ArrayVector implements Vector {
    double[] arr;

    ArrayVector(double x, double y, double z) {
        arr = new double[]{x, y, z};
    }

    @Override
    public double component(int n) {
        return arr[n];
    }

    @Override
    public double length() {
        return Math.sqrt(arr[0] * arr[0] + arr[1] * arr[1] + arr[2] * arr[2]);
    }

    @Override
    public Vector plus(Vector other) {
        return new ArrayVector(arr[0] + other.component(0),
                arr[1] + other.component(1),
                arr[2] + other.component(2));
    }

    @Override
    public String toString() {
        return "(" + arr[0] + ", " + arr[1] + ", " + arr[2] + ")";
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ArrayVector that = (ArrayVector) o;
//        return Arrays.equals(arr, that.arr);
//    }

    // лучше ручная работа
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector)) return false;
        Vector that = (Vector) o;
        return this.component(0) == that.component(0) &&
                this.component(1) == that.component(1) &&
                this.component(2) == that.component(2);
    }
}
