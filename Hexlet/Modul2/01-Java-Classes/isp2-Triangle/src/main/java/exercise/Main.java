package exercise;

// BEGIN
import lombok.Getter;

@Getter
public class Main {

    private double sideA;
    private double sideB;
    private double sideC;

    Main(int sideA, int sideB, int sideC) {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Такой треугольник не может существовать");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private static boolean isValidTriangle(double sideA, double sideB, double sideC) {
        return sideA + sideB > sideC
                && sideB + sideC > sideA
                && sideC + sideA > sideB;
    }
}
// END



