package Tree._958CheckCompletenessOfABinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// По root бинарного дерева определите, является ли оно полным бинарным деревом.
//В полном двоичном дереве каждый уровень, кроме, возможно, последнего, полностью заполнен, а все узлы на последнем
// уровне расположены как можно левее. На последнем уровне может быть от 1 до 2h узлов включительно h.
// Example 1:
//Input: root = [1,2,3,4,5,6]
//Output: true
//Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
//Example 2:
//Input: root = [1,2,3,4,5,null,7]
//Output: false
//Explanation: The node with value 7 isn't as far left as possible.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {this.val = val;}

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    // BFS: обход в ширину, time O(n), space O(n)
    public boolean isCompleteTree(TreeNode root) {
        // Создаём очередь для обхода в ширину (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        // Добавляем корневой узел в очередь
        queue.offer(root);
        // Флаг, который указывает, что мы встретили первый null-узел
        boolean foundNull = false;

        // Пока очередь не пуста, продолжаем обход
        while (!queue.isEmpty()) {
            // Извлекаем текущий узел из начала очереди
            TreeNode currentNode = queue.poll();

            // Если текущий узел равен null
            if (currentNode == null) {
                // Устанавливаем флаг, что мы нашли первый null
                foundNull = true;
            } else {
                // Если мы уже встречали null, но теперь видим не-null узел - дерево не полное
                if (foundNull) {
                    return false;
                }
                // Добавляем левого и правого потомка в очередь (даже если они null)
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            }
        }
        // Если дошли до конца без нарушений - дерево полное
        return true;
    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null));
        System.out.println(new Solution().isCompleteTree(root));
    }
}
