// Реализуйте публичный статический метод getMirrorMatrix(), который принимает двумерный массив (матрицу) целых чисел.
// Метод должен возвращать двумерный массив, изменённый таким образом, что правая половина матрицы становится
// зеркальной копией левой половины, симметричной относительно вертикальной оси матрицы. Для простоты условимся,
// что матрица всегда имеет чётное количество столбцов и количество столбцов всегда равно количеству строк.
package exercise;

import java.util.Arrays;

public class Main {
    // BEGIN
    // Создаёт зеркальную копию одномерного массива (отражает элементы относительно центра).
    public static int[] getMirrorRow(int[] row) {
        var size = row.length;
        var mirroredRow = new int[size];

        for (var i = 0; i < size / 2; i++) {
            mirroredRow[i] = row[i];
            // Копирует тот же элемент i в зеркальную позицию size - i - 1.
            mirroredRow[size - i - 1] = row[i];
        }
        return mirroredRow;
    }
    // Создаёт зеркальную копию двумерного массива (каждую строку отражает через getMirrorRow).
    public static int[][] getMirrorMatrix(int[][] matrix) {
        var size = matrix.length;
        var mirroredMatrix = new int[size][size];

        var index = 0;
        for (var row : matrix) {
            // Получает зеркальную строку через getMirrorRow.
            var mirroredRow = getMirrorRow(row);
            // Записывает зеркальную строку в новую матрицу.
            mirroredMatrix[index] = mirroredRow;
            index++;
        }

        return mirroredMatrix;
    }
    // END

    public static void main(String[] args) {
        int[][] matrix = {
                {11, 12, 13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34},
                {41, 42, 43, 44},
        };

        var mirroredMatrix = Main.getMirrorMatrix(matrix);
        System.out.println(Arrays.deepToString(mirroredMatrix)); //=>
        // [
        //     [11, 12, 12, 11],
        //     [21, 22, 22, 21],
        //     [31, 32, 32, 31],
        //     [41, 42, 42, 41],
        //  ]
    }
}