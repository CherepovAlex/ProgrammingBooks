package exercise.Vebinar16_25_08_20;

public class Example4 {

    public static void main(String[] args) {
        String name = "Alex";
        Double height = 2.565;
        // %s - выводит строковый аргумент
        System.out.printf("Name: %s%n", name);

        // %f - выводит аргумент с плавающей запятой
        System.out.printf("Heigh: %f%n", height);

        // %.2f - выводит аргумент с плавающей запятой с точностью до 2 цифр
        System.out.printf("Height: %.2f", height);

    }

}
