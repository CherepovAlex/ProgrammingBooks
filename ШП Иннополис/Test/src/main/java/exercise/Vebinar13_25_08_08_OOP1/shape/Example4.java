package exercise.Vebinar13_25_08_08_OOP1.shape;

public class Example4 {
    public static void main(String[] args) {
        // полиморфизм во время выполнения (Runtime) - переопредение метода (overriding)
        // у наследника делаем свою реализацию, иную логику
        Shape shape = new Circle();
    }
    // перегрузка метода (overloading)
    int sum(int a, int b, int c) {return a + b + c;}
    double sum(Double a, Double b) {return a + b;}
}
