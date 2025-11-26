package BreadthFirstSearch._404SumOfLeftLeaves;
// 404. Сумма оставшихся листьев
//Для root бинарного дерева верните сумму всех левых листьев
//Лист — это узел без дочерних элементов. Левый лист — это лист, который является левым дочерним элементом другого узла.
// Example 1:
//Input: root = [3,9,20,null,null,15,7]
//Output: 24
//Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
// Example 2:
//Input: root = [1]
//Output: 0
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
    // time O(n), space O(h)
    public int sumOfLeftLeaves(TreeNode root) {
        // Проверяем, является ли корень null (пустое дерево)
        if (root == null) return 0; // Возвращаем 0 для пустого дерева

        int sum = 0;    // Инициализируем переменныю для накопления суммы

        // Проверяем, существует ли левый потомок и является ли он листом
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;   // Добавляем значение левого листа к сумме
        }

        // Рекурсивно вызываем функцию для левого поддерева и добавляем результат
        sum += sumOfLeftLeaves(root.left);
        // Рекурсивно вызываем функцию для правого поддерева и добавляем результат
        sum += sumOfLeftLeaves(root.right);

        return sum; // Возвращаем общую сумму левых листьев
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new Solution().sumOfLeftLeaves(root)); // 24
    }
}
