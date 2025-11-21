package Tree._515FindLargestValueInEachTreeRow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
// Для root бинарного дерева верните массив наибольших значений в каждой строке дерева (с индексацией от 0).
// Example 1:
//Input: root = [1,3,2,5,3,null,9]
//Output: [1,3,9]
//Example 2:
//Input: root = [1,2,3]
//Output: [1,3]
public class Solution {
    // time O(n), space O(h)
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // Создает пустой список для результатов
        traverseDFS(root, result, 0); // Вызывает вспомогательный метод с начальным уровнем 0
        return result;    // озвращает заполненный список
    }

    private void traverseDFS(TreeNode node, List<Integer> result, int level) {
        if (node == null) return;   // Базовый случай
        // каждый уровень обрабатывается отдельно
        if (level == result.size()){
            // Если достигли нового уровня - добавляем значение
            result.add(node.val); // Добавляем первый элемент уровня
        } else {
            // Если уровень уже существует - обновляем максимум
            result.set(level, Math.max(result.get(level), node.val)); // Обновляем максимум
        }
        // Рекурсивный обход в глубину (DFS)
        traverseDFS(node.left, result, level+1);  // Рекурсия влево
        traverseDFS(node.right, result, level+1); // Рекурсия вправо

    }

    // Итеративная версия (BFS) - более оптимальная для этой задачи
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                max = Math.max(max, currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(max);
        }

        return result;
    }

    public static void main(String[] args) {
        // Создаем дерево: [1,3,2,5,3,null,9]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(new Solution().largestValues(root));
    }

}
