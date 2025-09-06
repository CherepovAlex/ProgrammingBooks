package exercise.Consultation11G_25_09_04;

//Задача 1: Абстрактный класс «Фигура»
//Создайте абстрактный класс Shape (Фигура) с абстрактными методами calculateArea() (вычислить площадь)
// и calculatePerimeter() (вычислить периметр).
// Создайте два класса-наследника: Circle (Круг) и Rectangle (Прямоугольник).
// Реализуйте в них эти методы. В методе main создайте массив разных фигур и в цикле выведите информацию о площади
// и периметре каждой.
public class Example1 {
    public static void main(String[] args) {

        Shape[] shapes = {new Circle(5.0), new Rectangle(4, 5)};
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.calculateArea());
            System.out.println("Perimeter: " + shape.calculatePerimeter());
        }
    }
}

abstract class Shape {
    public abstract double calculateArea();

    public abstract double calculatePerimeter();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "area=" + calculateArea() +
                "perimeter=" + calculatePerimeter() +
                '}';
    }
}

class Rectangle extends Shape {
    private int length;
    private int width;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int a_side) {
        this.length = a_side;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "area=" + calculateArea() +
                "perimeter=" + calculatePerimeter() +
                '}';
    }
}