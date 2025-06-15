//Реализуйте публичный статический метод mult(), который принимает на вход массив целых чисел и возвращает
// произведение всех элементов массива.
package exercise;
public class Main {
    // BEGIN
    public static int mult(int[] numbers) {
        var result = 1;
        for (int number : numbers) {
            result *= number;
        }
        return result;
    }
    // END
    public static void main(String[] args) {
        int[] numbers1 = {1, 4, 3, 4, 5};
        System.out.println(Main.mult(numbers1)); // 240

        int[] numbers2 = {1, 4, -3, 2};
        System.out.println(Main.mult(numbers2)); // -24

        int[] numbers3 = {1, -3, 5, 4, -3, 0};
        System.out.println(Main.mult(numbers3)); // 0
    }
}