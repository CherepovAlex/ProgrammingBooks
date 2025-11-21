package Tree._199BinaryTreeRightSideView;
// 199. Вид справа на двоичное дерево
// Учитывая root бинарного дерева, представьте, что вы стоите на правой стороне дерева, и верните значения узлов,
// которые вы видите, в порядке сверху вниз.
// Example 1:
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
//Explanation:
//Example 2:
//Input: root = [1,2,3,4,null,null,null,5]
//Output: [1,3,4,5]
//Explanation:
//Example 3:
//Input: root = [1,null,3]
//Output: [1,3]
//Example 4:
//Input: root = []
//Output: []
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    // BFS (обход в ширину) с сохранением последнего элемета на каждом уровне
    // time O(n), space O(n)
    public List<Integer> rightSideView(TreeNode root) {
        // Создаём список для хранения результат - правого вида дерева
        List<Integer> result = new ArrayList<>();

        // Проверяем базовый случай: если дерево пустое, возвращаем пустой список
        if (root == null) {
            return result;
        }

        // Создаём очередь для обхода дерева в ширину (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        // Добавляем корневой узел в очередь
        queue.offer(root);

        // Пока в очереди есть узлы для обработки
        while (!queue.isEmpty()) {
            // Получаем количество узлов на текущем уровне
            int levelSize = queue.size();
            // Переменная для хранения поселднего узла на текущем уровне
            TreeNode lastNode = null;

            // Обрабатываем все узлы текущего уровня
            for (int i = 0; i < levelSize; i++) {
                // Извлекаем узел из начала очереди
                TreeNode currentNode = queue.poll();
                // Обновляем последний узел текущего уровня
                lastNode = currentNode;

                // Если у текущего узла есть левй потомок, добавляем его в очередь
                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                // Если у текущго узла есть правый потомок, добавляем его в очередь
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            // После обработки всех узлов уровня, добавляем значение последнего узла в результат
            // Это будет правый вид для данного уровня
            result.add(lastNode.val);
        }
        // Врзвращаем итоговый список - вид справа на двоичное дерево
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(5), null), null), new TreeNode(3));
        System.out.println(new Solution().rightSideView(root));
    }
}
