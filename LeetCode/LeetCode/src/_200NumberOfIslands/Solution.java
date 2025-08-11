package _200NumberOfIslands;

// Дано m x n двумерное двоичное поле grid,
// представляющее собой карту из '1' (суша) и '0' (вода). Верните количество островов.
//Остров окружён водой и образован соединением соседних участков суши по горизонтали или вертикали.
// Можно предположить, что все четыре края сетки окружены водой.
// Example 1:
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]]
//Output: 1
//Example 2:
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]]
//Output: 3
public class Solution {
    // time O(mxn), space O(1)
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    callBFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    // алгоритм Depth-First Search (DFS)
    private void callBFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';   // помечаем как посещённый
        callBFS(grid, i + 1, j); // up
        callBFS(grid, i - 1, j); // down
        callBFS(grid, i, j - 1); // left
        callBFS(grid, i, j + 1); // right
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(new Solution().numIslands(grid));
    }
}
