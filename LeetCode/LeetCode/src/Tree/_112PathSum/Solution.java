package Tree._112PathSum;

import java.util.Stack;

// Дано root двоичного дерева и целое число targetSum, верните true, если в дереве есть путь от корня до листа,
// сумма значений на котором равна targetSum.
//лист — это узел без дочерних элементов.
// Example 1:
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//Output: true
//Explanation: The root-to-leaf path with the target sum is shown.
//Example 2:
//Input: root = [1,2,3], targetSum = 5
//Output: false
//Explanation: There are two root-to-leaf paths in the tree:
//(1 --> 2): The sum is 3.
//(1 --> 3): The sum is 4.
//There is no root-to-leaf path with sum = 5.
//Example 3:
//Input: root = [], targetSum = 0
//Output: false
//Explanation: Since the tree is empty, there are no root-to-leaf paths.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    // time O(n) space O(n)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Проверка на пустое дерево. Если дерево пустое, сразу возвращаем false.
        if (root == null) {
            return false;
        }
        // Создаем два стека: один для хранения узлов (nodeStack), другой для хранения оставшихся сумм (sumStack).
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        // Помещаем корневой узел в стек узлов и вычисляем остаток суммы после вычитания значения корня.
        nodeStack.add(root);
        sumStack.add(targetSum - root.val);
        // Извлекаем текущий узел и соответствующую оставшуюся сумму из стеков.
        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            int currentSum = sumStack.pop();
            // Проверяем, является ли текущий узел листом (нет потомков) и достигли ли мы нулевой остаток суммы.
            if (currentNode.left == null && currentNode.right == null && currentSum == 0) {
                return true; // Если да, возвращаем true.
            }
            // Если есть левый потомок, добавляем его в стек узлов и вычисляем новый остаток суммы.
            if (currentNode.left != null) {
                nodeStack.add(currentNode.left);
                sumStack.add(currentSum - currentNode.left.val);
            }   // Аналогично для правого потомка.
            if (currentNode.right != null) {
                nodeStack.add(currentNode.right);
                sumStack.add(currentSum - currentNode.right.val);
            }
        }   // Если стек опустел и подходящий путь не найден, возвращаем false.
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) return true;
        return hasPathSum2(root.left, targetSum - root.val) ||
                hasPathSum2(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4,
                new TreeNode(11,
                        new TreeNode(7),
                        new TreeNode(2)), null),
                new TreeNode(8,
                        new TreeNode(13,
                                null,
                                null),
                        new TreeNode(4,
                                null,
                                new TreeNode(1))));
        System.out.println(new Solution().hasPathSum(root, 22));
    }
}
