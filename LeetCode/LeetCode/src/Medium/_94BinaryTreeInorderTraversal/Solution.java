package Medium._94BinaryTreeInorderTraversal;
// Для root бинарного дерева верните последовательность обхода его узлов в прямом порядке.
// Example 1:
//Input: root = [1,null,2,3]
//Output: [1,3,2]
//Explanation:
//Example 2:
//Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
//Output: [4,2,6,5,7,1,3,9,8]
//Explanation:
//Example 3:
//Input: root = []
//Output: []
//Example 4:
//Input: root = [1]
//Output: [1]

import java.util.*;

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

class Solution {
    // version 1 time O(n) space O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();  // Стек для хранения узлов
        List<Integer> res = new ArrayList<>();  // Результирующий список
        if (root == null) return res;           // Обработка пустого дерева

        TreeNode current = root;                // Текущий узел

        while (!stack.isEmpty() || current != null) {
            // Идем до самого левого узла, попутно добавляя все узлы в стек
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // Достаем узел из стека (самый левый из необработанных)
            current = stack.pop();
            res.add(current.val);   // Добавляем значение в результат

            current = current.right; // Переходим к правому поддереву
        }
        return res;
    }

    // version 2
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();   // Результирующий список
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.val);               // Добавляем значение в результат
        inorderHelper(node.right, result);
    }

    // version 3
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();   // Результирующий список
        Deque<TreeNode> stack = new ArrayDeque<>(); // двусторонняя очередь для хранения узлов

        TreeNode current = root;                    // Текущий узел

        while (current != null || !stack.isEmpty()) {
            while (current != null) {   // Идем до самого левого узла, попутно добавляя все узлы в стек
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();      // Достаем узел из очереди (самый левый из необработанных)
            result.add(current.val);    // Добавляем значение в результат
            current = current.right;    // Переходим к правому поддереву
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode cur = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(new Solution().inorderTraversal(cur));
    }
}