package exercise.Vebinar20_25_09_03_AbstractClassNInterfaces.AbstractInter;

public class TestInterfaceDefault {
    public static void main(String[] args) {
        Drawable d = new Rectangle();
        d.draw(); // drawing rectangle - переопределенный метод
        d.msg(); // default method - дефолтное поведение
        System.out.println(Drawable.cube(3)); // static-метод
    }
}
