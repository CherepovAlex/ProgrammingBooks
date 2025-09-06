package Medium._498DiagonalTraverse;

import java.util.Arrays;
// Для матрицы m x n mat верните массив всех элементов массива в диагональном порядке.

// Example 1:
//Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,4,7,5,3,6,8,9]
//Example 2:
//Input: mat = [[1,2],[3,4]]
//Output: [1,2,3,4]
public class Solution {
    // time O(m * n), time O(m * n)
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) return new int[]{}; // Проверка пустой матрицы
        if (mat[0].length == 0) return new int[]{}; // Проверка пустой первой строки

        int row = mat.length, col = mat[0].length;
        int y = 0, x = 0; // Начинаем с левого верхнего угла
        int[] arr = new int[row * col]; // Результирующий массив

        int index = 0;
        while (index < arr.length) {
            arr[index++] = mat[y][x];   // Добавляем текущий элемент

            int sum = y + x; // Сумма координат определяет направление
            boolean isEven = sum % 2 == 0;   // Четная сумма = движение вверх
            if (isEven) {
                if (x < col - 1 && y > 0) { // Можем двигаться вправо-вверх
                    x++;
                    y--;
                } else if (x < col - 1) { // Достигли верхней границы
                    x++;
                } else {    // Достигли правой границы
                    y++;
                }
            } else {    // Движение вниз-влево
                if (y < row - 1 && x > 0) { // Можем двигаться вниз-влево
                    x--;
                    y++;
                } else if (y < row - 1) {   // Достигли левой границы
                    y++;
                } else {    // Достигли нижней границы
                    x++;
                }
            }
        }

        return arr;
    }

    public int[] findDiagonalOrder1(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        int rows = mat.length;
        int cols = mat[0].length;
        int[] result = new int[rows * cols];

        int row = 0, col = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = mat[row][col];

            // Определяем направление: сумма координат четная = движение вверх
            boolean moveUp = (row + col) % 2 == 0;

            if (moveUp) {
                if (col == cols - 1) {
                    // Достигли правого края - двигаемся вниз
                    row++;
                } else if (row == 0) {
                    // Достигли верхнего края - двигаемся вправо
                    col++;
                } else {
                    // Обычное движение вверх-вправо
                    row--;
                    col++;
                }
            } else {
                if (row == rows - 1) {
                    // Достигли нижнего края - двигаемся вправо
                    col++;
                } else if (col == 0) {
                    // Достигли левого края - двигаемся вниз
                    row++;
                } else {
                    // Обычное движение вниз-влево
                    row++;
                    col--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(new Solution().findDiagonalOrder(nums)));
    }

}
