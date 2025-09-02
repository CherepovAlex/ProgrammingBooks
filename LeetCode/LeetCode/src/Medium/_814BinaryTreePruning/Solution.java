package Medium._814BinaryTreePruning;
// Для root бинарного дерева верните то же дерево, в котором каждое поддерево (данного дерева),
// не содержащее 1, удалено.
//Поддерево узла node — это node плюс все узлы, являющиеся потомками node.
//Example 1:
//Input: root = [1,null,0,0,1]
//Output: [1,null,0,null,1]
//Explanation:
//Only the red nodes satisfy the property "every subtree not containing a 1".
//The diagram on the right represents the answer.
//Example 2:
//Input: root = [1,0,1,0,0,0,1]
//Output: [1,null,1,null,1]
//Example 3:
//Input: root = [1,1,0,1,1,0,1,0]
//Output: [1,1,0,1,1,null,1]
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
    // time O(n), space O(h)
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;  // Базовый случай: пустое дерево
        containsOne(root);      // Запуск рекурсивной проверки
        return root;        // Возврат измененного дерева
        // return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode node) {
        if (node == null) return false;     // Базовый случай: достигнут конец ветки

         // Рекурсивно проверяем левое и правое поддеревья
        boolean left_contains = containsOne(node.left);
        boolean right_contains = containsOne(node.right);

        // Удаляем поддеревья, если они не содержат единиц
        if (!left_contains) node.left = null;
        if (!right_contains) node.right = null;

        // Возвращаем true, если текущий узел = 1 ИЛИ левое/правое поддерево содержит 1
        return node.val == 1 || left_contains || right_contains;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(0, new TreeNode(0), new TreeNode(1))
        );
        System.out.println(new Solution().pruneTree(root));
    }
}
