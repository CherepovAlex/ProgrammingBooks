// Реализуйте публичные статические методы rotateLeft() и rotateRight(), которые поворачивают матрицу влево
// (против часовой стрелки) и соответственно вправо (по часовой стрелке). Матрица представляет собой
// двумерный массив целых чисел. Методы должны возвращать новую матрицу, не изменяя исходную.
package exercise;
import java.util.Arrays;
public class Main {
    // BEGIN
    public static int[][] rotate(int[][] matrix, String direction) {
        var rowsCount = matrix.length;
        var columnsCount = matrix[0].length;
        var rotatedMatrix = new int[columnsCount][rowsCount];

        for (var row = 0; row < columnsCount; row++) {
            rotatedMatrix[row] = new int[rowsCount];
            for (var coll = 0; coll < rowsCount; coll++) {
                rotatedMatrix[row][coll] = direction.equals("left")
                        ? matrix[coll][columnsCount - row - 1]
                        : matrix[rowsCount - coll - 1][row];
            }
        }

        return rotatedMatrix;
    }

    public static int[][] rotateLeft(int[][] matrix) {
        return rotate(matrix, "left");
    }

    public static int[][] rotateRight(int[][] matrix) {
        return rotate(matrix, "right");
    }

    // END
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 0, 1, 2},
        };

        var rotatedLeft = Main.rotateLeft(matrix);
        System.out.println(Arrays.deepToString(rotatedLeft)); // =>
        // [
        //   [4, 8, 2],
        //   [3, 7, 1],
        //   [2, 6, 0],
        //   [1, 5, 9],
        // ]

        var rotatedRight = Main.rotateRight(matrix);
        System.out.println(Arrays.deepToString(rotatedRight)); // =>
        // [
        //   [9, 5, 1],
        //   [0, 6, 2],
        //   [1, 7, 3],
        //   [2, 8, 4],
        // ]
    }
}