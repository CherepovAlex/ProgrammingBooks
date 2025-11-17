package Medium._979DistributeCoinsInBinaryTree;
// Распределение монет в двоичном дереве
//Вам дано root двоичного дерева с n узлами, где в каждом node дерева есть node.val монет. Всего в дереве n монет.
//За один ход мы можем выбрать два соседних узла и переместить одну монету из одного узла в другой. Ход может быть
// сделан от родительского узла к дочернему или от дочернего узла к родительскому.
//Верните то минимальное количество ходов, необходимое для того, чтобы на каждом узле было ровно по одной монете.
// Example 1:
//Input: root = [3,0,0]
//Output: 2
//Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
//Example 2:
//Input: root = [0,3,0]
//Output: 3
//Explanation: From the left child of the root, we move two coins to the root [taking two moves]. Then, we move one
// coin from the root of the tree to the right child.
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
public class Solution {
    // Объявляем переменную для подсчета общего количества ходов
    private int moves;
    // time O(n), space O(h)
    public int distributeCoins(TreeNode root) {
        // Инициализируем счетчик ходов нулем
        moves = 0;
        // Запускаем рекурсивный обход дерева
        dfs(root);
        // Возвращаем общее количество ходов
        return moves;
    }

    // Рекурсивная функция для обхода дерева в глубину
    private int dfs(TreeNode node) {
        // Базовый случай: если узел null, возвращаем 0
        if (node == null) {
            return 0;
        }
        // Рекурсивно обходим левое поддерево и получаем баланс монет
        int leftBalance = dfs(node.left);
        // Рекурсивно обходим правое поддерево и получаем баланс монет
        int rightBalance = dfs(node.right);

        // Обновляем общее количество ходов, добавляя абсолютные значения балансов
        moves += Math.abs(leftBalance) + Math.abs(rightBalance);

        // Возвращает общий баланс для текущего узла:
        // (текущие монеты - 1) + баланс левого поддерева + баланс правого поддерева
        return node.val - 1 + leftBalance + rightBalance;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, null, null);
        System.out.println(new Solution().distributeCoins(root));
    }
}
