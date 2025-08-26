package Medium._54SpiralMatrix;
// Для m x n matrix верните все элементы matrix в порядке спирали.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Example 1:
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
//Example 2:
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
public class Solution {
    // time O(mxn), time O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new LinkedList<>();

        // Проверка на пустую матрицу
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return nums;
        }

        int top = 0, down = matrix.length - 1; // верхняя строка, нижняя строка
        int left = 0, right = matrix[0].length - 1; // левый столбец, праввый столбец
        // будем двигаться
        while (true) {
            // двигаемся вправо
            for (int i = left; i <= right; i++) {
                nums.add(matrix[top][i]);
            }
            top++;
            if (left > right || top > down) break;
            // двигаемся вниз
            for (int i = top; i <= down; i++) {
                nums.add(matrix[i][right]);
            }
            if (left > right || top > down) break;
            right--;
            // двигаемся влево
            for (int i = right; i >= left; i--) {
                nums.add(matrix[down][i]);
            }
            if (left > right || top > down) break;
            down--;
            // двигаемся вверх
            for (int i = down; i >= top; i--) {
                nums.add(matrix[i][left]);
            }
            left++;
            if (left > right || top > down) break;
        }
        return nums;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        // Проверка на пустую матрицу
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Движение вправо →
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Движение вниз ↓
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Проверка нужна ли движение влево (если есть строки)
            if (top <= bottom) {
                // Движение влево ←
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Проверка нужна ли движение вверх (если есть столбцы)
            if (left <= right) {
                // Движение вверх ↑
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Solution().spiralOrder(nums));
    }
}
