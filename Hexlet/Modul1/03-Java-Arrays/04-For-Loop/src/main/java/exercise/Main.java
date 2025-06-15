//Реализуйте публичный статический метод addPrefix(), который принимает на вход массив строк и строковый префикс,
// и возвращает новый массив, в котором к каждому элементу исходного массива добавляется переданный префикс.
// После префикса автоматически добавляется пробел.

package exercise;
import java.util.Arrays;
public class Main {
    // BEGIN
    public static String[] addPrefix(String[] names, String prefix) {
        var length = names.length;
        String[] namesWithPrefix = new String[length];

        for (var i = 0; i < length; i++) {
            namesWithPrefix[i] = prefix + " " + names[i];
        }
        return namesWithPrefix;
    }
    // END

    public static void main(String[] args) {
        String[] names = {"John", "Smit", "Karl"};
        var namesWithPrefix = Main.addPrefix(names, "Mr.");
        System.out.println(Arrays.toString(namesWithPrefix));
        // => ["Mr. John", "Mr. Smit", "Mr. Karl"]
        System.out.println(Arrays.toString(names));
        // исходный массив не меняется
        // => ["John", "Smit", "Karl"]
    }
}