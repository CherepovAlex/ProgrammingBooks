package Tree._662MaximumWidthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// Максимальная ширина двоичного дерева
//Для root бинарного дерева верните максимальную ширину данного дерева.
//Максимальная ширина дерева — это максимальная ширина среди всех уровней.
//Ширина одного уровня определяется как расстояние между конечными узлами (крайним левым и крайним правым ненулевыми
// узлами), при этом нулевые узлы между конечными узлами, которые присутствовали бы в полном двоичном дереве,
// доходящем до этого уровня, также учитываются при расчёте длины.
//гарантируется, что ответ будет находиться в диапазоне 32-битного целого числа со знаком.
// Example 1:
//Input: root = [1,3,2,5,3,null,9]
//Output: 4
//Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
//Example 2:
//Input: root = [1,3,2,5,null,null,9,6,null,7]
//Output: 7
//Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
//Example 3:
//Input: root = [1,3,2,5]
//Output: 2
//Explanation: The maximum width exists in the second level with length 2 (3,2).
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

// Вспомогательный класс для хранения пары (узел, индекс)
class Pair {
    TreeNode node;  // Узел дерева
    int index;      // Индекс узла в полном двоичном дереве

    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class Solution {
    // BFS (обход в ширину); time O(n), space O(n)
    public int widthOfBinaryTree(TreeNode root) {
        // Базовый случай: если дерево пустое, ширина равна 0
        if (root == null) return 0;

        // Очередь для обхода дерева в ширину, хранит пары (узел, индекс
        Queue<Pair> queue = new LinkedList<>();
        // Добавляем корень с индексом 0
        queue.offer(new Pair(root, 0));
        // Переменная для хранения максимальной ширины
        int maxWidth = 0;

        // Пока очередь не пуста, обрабатываем уровни
        while (!queue.isEmpty()) {
            // Количество узлов на текущем уровне
            int levelSize = queue.size();
            // Индекс первого узла на текущем уровне
            int firstIndex = queue.peek().index;
            // Индекс последнего узла на текущем уровне
            int lastIndex = firstIndex;

            // Обрабатываем все узлы текущего уровня
            for (int i = 0; i < levelSize; i++) {
                // Извлекаем текущий узел из очереди
                Pair current = queue.poll();
                // Обновляем индекс последнего узла
                lastIndex = current.index;

                // Если у узла есть левый потомок, добавляем его в очередь
                // Индекс левого потомка = 2 * индекс_родителя + 1
                if (current.node.left != null) {
                    queue.offer(new Pair(current.node.left, 2 * lastIndex + 1));
                }

                // Если у узла есть правый потомок, добавлем его в очередь
                // Индекс правого потомка = 2 * индекс_родителя + 2
                if(current.node.right != null) {
                    queue.offer(new Pair(current.node.right, 2 * lastIndex + 2));
                }
            }

            // Вычисляем ширину текущего уровня и одновляем максимум
            // Ширина = lastIndex - firstIndex + 1
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }
        // Возвращаем максимальную ширину
        return maxWidth;
    }

    public int widthOfBinaryTree2(TreeNode root) {
        // Базовый случай: если дерево пустое, ширина равна 0
        if (root == null) return 0;

        // Очередь для узлов дерева
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        // Очередь для индексов узлов
        Queue<Integer> indexQueue = new LinkedList<>();
        // добавляем корень и его индекс (0) в соответствующие очереди
        nodeQueue.offer(root);
        indexQueue.offer(0);
        // Переменная для хранения максимальной длина
        int maxWidth = 0;

        // Пока есть узлы для обработки
        while (!nodeQueue.isEmpty()) {
            // Количество узлов в текущем уровне
            int levelSize = nodeQueue.size();
            // Индекс первого узла на текущем уровне
            int firstIndex = indexQueue.peek();
            // Индекс последнего узла на текущем уровне
            int lastIndex = firstIndex;


            for (int i = 0; i < levelSize; i++ ) {
                // извлекаем текущий узел и его индекс
                TreeNode currentNode = nodeQueue.poll();
                int currentIndex = indexQueue.poll();
                // Обновляем индекс последнего узла
                lastIndex = currentIndex;

                // Если есть левый потомок, добавляем его с индексом 2 * currentIndex + 1
                if (currentNode.left != null) {
                    nodeQueue.offer(currentNode.left);
                    indexQueue.offer(2 * currentIndex + 1);
                }

                // Если есть правый потомок, добавляем его с индексом 2 * currentIndex + 2
                if (currentNode.right != null) {
                    nodeQueue.offer(currentNode.right);
                    indexQueue.offer(2 * currentIndex + 2);
                }
            }

            // Вычисляем ширину текущего уровня
            int currentwidth = lastIndex - firstIndex + 1;
            // Обновляем максимальную ширину
            maxWidth = Math.max(maxWidth, currentwidth);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(9)));
        System.out.println(new Solution().widthOfBinaryTree(root)); // 4
    }
}
