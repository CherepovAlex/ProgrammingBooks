// Вес Хэмминга — это количество единиц в двоичном представлении числа.
// Реализуйте публичный статический метод getHammingWeight(), который считает и возвращает вес Хэмминга.
// Метод принимает в качестве аргумента целое число.
package exercise;
public class Main {
    // BEGIN
    public static int getHammingWeight(int number) {

        var weight = 0;
        var digits = Integer.toBinaryString(number);

        for (var digit : digits.toCharArray()) {
            weight += Character.getNumericValue(digit);
        }

        return weight;
    }

    // END
    public static void main(String[] args) {
        Main.getHammingWeight(0); // 0
        Main.getHammingWeight(4); // 1
        Main.getHammingWeight(101); // 4
    }
}