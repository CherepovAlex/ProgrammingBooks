package exercise;

public class MathMethods {
    public static void main(String[] args) {

        double r1 = Math.random();
        int r2 = (int) (Math.random() * 5);

        int x = Math.abs(-240);         // 240
        double d = Math.abs(240.45);    // 240.45

        int x1 = Math.round(-24.8f); // -25
        int y = Math.round(24.45f);  // 24

        int x2 = Math.min(24, 240);  // 24
        double y1 = Math.min(90876.5, 90876.49);    // 90876.49

        int x3 = Math.max(24, 240);  // 240
        double y2 = Math.max(90876.5, 90876.49);    // 90876.5
    }
}
