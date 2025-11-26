package Simulation._59SpiralMatrixII;

import java.util.Arrays;

// 59. Спиральная матрица II
//Для заданного положительного целого числа n создайте n x n matrix элементов, расположенных по спирали от 1 до n2.
// Example 1:
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
//Example 2:
//Input: n = 1
//Output: [[1]]
public class Solution {
    // time O(n*n), O(1)
    public int[][] generateMatrix(int n) {
        // Создаём матрицу n x n
        int[][] matrix = new int[n][n];

        // Определяем границы спирали
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        // Начальное значение для заполнения
        int num = 1;

        // Пока есть элементы для заполнения
        while (num <= n * n) {
            // Движение слева направо по верхней строке
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++; // Уменьшаем верхнюю границу

            // Движение сверху вниз по правому столбцу
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--; // Уменьшаем правую границу

            // Движение справа налево по нижней строке
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--; // Уменьшаем нижнюю границу

            // Движение снизу вверх по левому столбцу
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++; // Увеличиваем левую границу
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(new Solution().generateMatrix(n)));
    }
}
