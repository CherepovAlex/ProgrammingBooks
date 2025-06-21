// Реализуйте публичный статический метод chunk(), который принимает на вход массив строк и число, задающее размер
// чанка (куска). Метод должен вернуть двумерный массив, состоящий из чанков указанной размерности.
package exercise;
import java.util.Arrays;
public class Main {
    // BEGIN
    public static String[][] chunk(String[] words, int size) {

        var wordsCount = words.length;
        //п.1: Приводим к double, делим: 4 / 3 = 1.33
        //Math.ceil округляет вверх → 2
        //chunksCount = 2
        var chunksCount = (int) Math.ceil((double) wordsCount / size);
        // инициализируем массив с chunksCount строками и 0 столбцами. Потом в цикле заполним.
        var chunks = new String[chunksCount][0];
        var index = 0;
        // идём по массиву words с шагом, равным размеру чанка.
        for (var i = 0; i < wordsCount; i += size) {
            // Если выходим за границы — берём максимум допустимого.
            var to = i + size > wordsCount ? wordsCount : i + size;
            // используем Arrays.copyOfRange для копирования от i до to (невключительно)
            chunks[index] = Arrays.copyOfRange(words, i, to);
            index++;
        }
        // System.out.println(Arrays.deepToString(result));
        return chunks;
    }
    // END

    public static void main(String[] args) {
        String[] words = {"one", "two", "three", "four"};

        var chunks1 = Main.chunk(words, 2);
        System.out.println(Arrays.deepToString(chunks1));
        // => [["one", "two"], ["three", "four"]]

        var chunks2 = Main.chunk(words, 3);
        System.out.println(Arrays.deepToString(chunks2));
        // => [["one", "two", "three"], ["four"]]
    }
}