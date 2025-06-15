// Реализуйте публичный статический метод calculateSum(), который принимает в качестве аргумента массив целых чисел.
// Метод высчитывает и возвращает сумму всех элементов массива, которые делятся без остатка на 3 (три).
// В случае пустого массива метод должен вернуть 0.
package exercise;
public class Main {
    // BEGIN
    public static int calculateSum(int[] numbers) {
        var sum = 0;

        for (var i = 0; i < numbers.length; i++) {
            var number = numbers[i];
            if (number % 3 == 0) {
                sum += number;
            }
        }
        return sum;
    }
    // END

    public static void main(String[] args) {
        int[] numbers = {8, 9, 21, 19, 18, 22, 7};
        System.out.println(Main.calculateSum(numbers)); // 48
    }
}