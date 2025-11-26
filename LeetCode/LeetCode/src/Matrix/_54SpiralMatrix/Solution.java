package Matrix._54SpiralMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Задача 54. Спиральная матрица
//Для m на n matrix верните все элементы matrix в порядке спирали.
// Example 1:
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
//Example 2:
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]

public class Solution {
    // time O(mxn), space O(1)
    public List<Integer> spiralOrder(int[][] matrix) {

        // Создаем список для хранения результата
        List<Integer> nums = new LinkedList<>();

        // Проверка на пустую матрицу или нулевые размеры
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return nums;
        }

        // Инициализация границ матрицы
        int top = 0, down = matrix.length - 1; // верхняя строка, нижняя строка
        int left = 0, right = matrix[0].length - 1; // левый столбец, правый столбец

        // будем двигаться пока есть элементы для обхода
        while (true) {
            // двигаемся вправо от left до right
            for (int i = left; i <= right; i++) {
                nums.add(matrix[top][i]);   // Добавляем элементы верхней строки
            }
            top++;                          // Сдвигаем верхнюю границу вниз (уже обработали эту строку)
            if (left > right || top > down) break;  // Проверка завершения (границы пересеклись)

            // двигаемся вниз от top до down
            for (int i = top; i <= down; i++) {
                nums.add(matrix[i][right]); // Добавляем элементы правого столбца
            }
            if (left > right || top > down) break; // Проверка завершения
            right--;                        // Сдвигаем правую границу влево (уже обработали этот столбец)

            // двигаемся влево по нижней строке: от right до left
            for (int i = right; i >= left; i--) {
                nums.add(matrix[down][i]); // Добавляем элементы нижней строки
            }
            if (left > right || top > down) break; // Проверка завершения
            down--;                         // Сдвигаем нижнюю границу вверх (уже обработали эту строку)

            // двигаемся вверх по левому столбцу: от down до top
            for (int i = down; i >= top; i--) {
                nums.add(matrix[i][left]);  // Добавляем элементы левого столбца
            }
            left++;                         // Сдвигаем левую границу вправо (уже обработали этот столбец)

            if (left > right || top > down) break; // Проверка завершения

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

            // Проверка нужно ли движение влево (если есть строки)
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
