// Матрицу можно представить в виде двумерного массива. Например, массив new
// int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}} — это отображение матрицы:
//1 2 3
//4 5 6
//7 8 9
//Реализуйте публичный статический метод buildSnailPath(), который принимает на вход матрицу целых чисел
// и возвращает массив элементов матрицы по порядку следования от левого верхнего элемента по часовой стрелке
// к внутреннему. Движение по матрице напоминает улитку.
// Он работает рекурсивно: на каждом шаге берёт первую строку, поворачивает оставшуюся матрицу на 90°
// против часовой стрелки и повторяет процесс.
package exercise;
import java.util.Arrays;
import static exercise.Utils.flatten;
public class Main {
    // BEGIN
    // поворот матрицы на 90° влево
    public static int[][] rotate(int[][] matrix) {
        // Сохраняем количество строк
        var rowsCount = matrix.length;
        if (rowsCount == 0) {
            return new int[0][0];
        }
        // Создаём новую матрицу с перевёрнутыми размерами: [столбцы][строки]
        var columnsCount = matrix[0].length;
        var rotatedMatrix = new int[columnsCount][rowsCount];
        // Эта логика поворачивает матрицу на 90° влево.
        //Для каждого элемента новой матрицы находим соответствующий элемент из старой.
        for (var row = 0; row < columnsCount; row++) {
            rotatedMatrix[row] = new int[rowsCount];
            for (var column = 0; column < rowsCount; column++) {
                rotatedMatrix[row][column] = matrix[column][columnsCount - row - 1];
            }
        }
        System.out.println(Arrays.deepToString(rotatedMatrix));
        return rotatedMatrix;
    }

    public static int[] buildSnailPath(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        var head = matrix[0];
        var tail = Arrays.copyOfRange(matrix, 1, matrix.length);

        int[][] result = {
                head,
                buildSnailPath(rotate(tail)),
        };

        return flatten(result);
    }

    // END
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        var result = Main.buildSnailPath(matrix);
        System.out.println(Arrays.toString(result));
// => [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}