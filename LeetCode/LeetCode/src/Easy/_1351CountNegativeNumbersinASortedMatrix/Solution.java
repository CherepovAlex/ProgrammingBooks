package Easy._1351CountNegativeNumbersinASortedMatrix;

// Дана m x n матрица grid, отсортированная в порядке неубывания как по строкам, так и по столбцам.
// Необходимо вернуть количество отрицательных чисел в grid.
// Example 1:
//Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//Output: 8
//Explanation: There are 8 negatives number in the matrix.
//Example 2:
//Input: grid = [[3,2],[1,0]]
//Output: 0
public class Solution {
    // простой перебор всех элементов
    // time  O(m*n)
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            for (int num : row) {
                if (num < 0) count++;
            }
        }
        return count;
    }
    // time O(m + n) - значительно быстрее для больших матриц, space O(1)
    // оптимизированный алгоритм с использованием свойств отсортированной матрицы
    public int countNegatives2(int[][] grid) {
        // Получаем размеры матрицы: количество строк
        int totalRows = grid.length;
        // количество столбцов
        int totalCols = grid[0].length;
        // счётчик отрицательных чисел, начинаем с первой строки, начинаем с последнего столбца
        int count = 0, row = 0, col = totalCols - 1;
        // Начинаем с верхнего правого угла матрицы
        while (row < totalRows && col >= 0) {
            // Если текущий элемент отрицательный: все элементы ниже в этом столбце тоже отрицательные (из-за сортировки)
            if (grid[row][col] < 0) {
                // Переходим на столбец влево
                col--;
                // Увеличиваем счётчик на количество оставшихся строк
                count += totalRows - row;
                // Если текущий элемент неотрицательный:
            } else {
                // Переходим на строку ниже
                row++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{4, 3, 2, -1},
                                   {3, 2, 1, -1},
                                   {1, 1, -1, -2},
                                   {-1, -1, -2, -3}};
        System.out.println(new Solution().countNegatives(nums));
    }
}
