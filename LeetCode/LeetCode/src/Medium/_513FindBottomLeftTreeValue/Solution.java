package Medium._513FindBottomLeftTreeValue;

import java.util.LinkedList;
import java.util.Queue;

// Для root бинарного дерева верните крайнее левое значение в последней строке дерева.
// Example 1:
//Input: root = [2,1,3]
//Output: 1
//Example 2:
//Input: root = [1,2,3,4,null,5,6,null,null,7]
//Output: 7
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
    // time O(n), space O(w)
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(); // Создается очередь для обхода дерева в ширину (BFS)
        queue.offer(root);                          // Корень дерева помещается в очередь
        while (!queue.isEmpty()) {                  // Пока в очереди есть элементы, извлекаем их и обрабатываем
            root = queue.poll();    // Берем следующий элемент из очереди (важно: это последний элемент текущего уровня)
            if (root.right != null) { // Добавление правого потомка: Сначала правый, потом левый - это ключевой момент!
                queue.offer(root.right);
            }
            if (root.left != null) { // Добавление левого потомка: Левый добавляется после правого
                queue.offer(root.left);
            }
        }
        return root.val;    // После завершения цикла возвращаем значение последнего обработанного узла
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(new Solution().findBottomLeftValue(treeNode));
    }

}
