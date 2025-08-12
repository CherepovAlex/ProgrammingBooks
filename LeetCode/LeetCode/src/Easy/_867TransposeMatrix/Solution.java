package Easy._867TransposeMatrix;

import java.util.Arrays;

// Для двумерного целочисленного массива matrix верните транспонированнуюперевернутуюматрицу matrix.
// Транспонированная матрица — это матрица, у которой главная диагональ переставлена местами,
// а индексы строк и столбцов поменялись местами.
//Example 1:
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[1,4,7],[2,5,8],[3,6,9]]
//Example 2:
//Input: matrix = [[1,2,3],[4,5,6]]
//Output: [[1,4],[2,5],[3,6]]
public class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(new Solution().transpose(matrix)));
    }
}
