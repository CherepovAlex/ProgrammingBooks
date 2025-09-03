package exercise.Vebinar20_25_09_03_AbstractClassNInterfaces.AbstractInter;

// методы по умолчанию (пример, msg()) не нуждаются в реализации

public class Rectangle implements Drawable{
    @Override
    public void draw() {
        System.out.println("drawing rectangle");
    }
}
