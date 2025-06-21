// Операция умножения двух матриц А и В представляет собой вычисление результирующей матрицы С,
// где каждый элемент C(ij) равен сумме произведений элементов в соответствующей строке первой матрицы A(ik)
// и элементов в столбце второй матрицы B(kj).
//Две матрицы можно перемножать только в том случае, если количество столбцов в первой матрице совпадает
// с количеством строк во второй матрице. Это значит, что первая матрица обязательно должна быть согласованной
// со второй матрицей. В результате операции умножения матрицы размера M×N на матрицу размером N×K является
// матрица размером M×K.
//Реализуйте публичный статический метод multiply(), который принимает на вход две матрицы c целыми числами,
// и возвращает новую матрицу — результат их произведения.
package exercise;
import java.util.Arrays;
public class Main {
    // BEGIN
    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        var rowsCountA = matrixA.length;       // Количество строк в A
        var rowsCountB = matrixB.length;       // Количество строк в B
        var columnsCountB = matrixB[0].length; // Количество столбцов в B
        var multipliedMatrix = new int[rowsCountA][0]; // Создаётся новая матрица с размерами: [строки A] x [столбцы B].
        // C[i][j] = A[i][0]*B[0][j] + A[i][1]*B[1][j] + ... + A[i][n]*B[n][j]
        for (var row = 0; row < rowsCountA; row++) {
            multipliedMatrix[row] = new int[columnsCountB];
            for (var column = 0; column < columnsCountB; column++) {
                var sum = 0;
                for (var i = 0; i < rowsCountB; i++) {
                    sum += matrixA[row][i] * matrixB[i][column];
                }
                multipliedMatrix[row][column] = sum;
            }
        }
        return multipliedMatrix;
    }
    // END
    public static void main(String[] args) {
        int[][] matrixA = {
                {2, 5},
                {6, 7},
                {1, 8},
        };
        int[][] matrixB = {
                {1, 2, 1},
                {0, 1, 0},
        };
        var multipliedMatrix = Main.multiply(matrixA, matrixB);
        System.out.println(Arrays.deepToString(multipliedMatrix)); // =>
// [
//   [2, 9, 2],
//   [6, 19, 6],
//   [1, 10, 1],
// ]
    }
}