package Easy._1572MatrixDiagonalSum;
//Для квадратной матрицы mat найдите сумму диагоналей.
//Учитывайте только сумму всех элементов на главной диагонали и
// всех элементов на дополнительной диагонали, которые не являются частью главной диагонали.
// Input: mat = [[1,2,3],
//              [4,5,6],
//              [7,8,9]]
//Output: 25
//Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
//Notice that element mat[1][1] = 5 is counted only once.
//Example 2:
//Input: mat = [[1,1,1,1],
//              [1,1,1,1],
//              [1,1,1,1],
//              [1,1,1,1]]
//Output: 8
//Example 3:
//Input: mat = [[5]]
//Output: 5
public class Solution {
    // time O(n), space O(1)
    public int diagonalSum(int[][] mat) {
        int len = mat.length; // вводим длину матрицы = количество строк
        int sum = 0;    // счетчик суммы элементов на диагонали

        for (int i = 0; i < len; i++) {
            sum += mat[i][i];               // складываем элементы на главное диагонали
            sum += mat[len - 1 - i][i];     // складываем элементы на второй главное диагонали
        }
        if (len % 2 != 0) {                 // если длина нечетная, то убираем средний элемент
            sum -= mat[len / 2][len / 2];   // он будет дублироваться в обеих суммах
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(new Solution().diagonalSum(mat));
    }
}
