package Easy._104MaximumDepthofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Для root бинарного дерева верните его максимальную глубину.
// Максимальная глубина двоичного дерева — это количество узлов на самом
// длинном пути от корневого узла до самого дальнего листового узла.
//Example 1:
//Input: root = [3,9,20,null,null,15,7]
//Output: 3
//Example 2:
//Input: root = [1,null,2]
//Output: 2
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
    // time O(n), space O(n) (или O(logn)
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;     // Базовый случай: пустое поддерево имеет глубину 0
        int left = maxDepth(root.left); // Рекурсивно вычисляем глубину левого поддерева
        int right = maxDepth(root.right); // Рекурсивно вычисляем глубину правого поддерева
        return Math.max(left, right) + 1; // Глубина текущего узла = максимум из глубин поддеревь
    }
    // Плюсы: нет риска переполнения стека для очень глубоких деревьев
    // Итеративное решение с использованием BFS (поиск в ширину)
    // time O(n), space O(n)
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;                  // 1. Если дерево пустое, глубина 0
        Queue<TreeNode> queue = new LinkedList<>();  // 2. Создаем очередь для BFS
        queue.offer(root);                           // 3. Добавляем корневой узел в очередь
        int res = 0;                                 // 4. Инициализируем счетчик глубины
        while (!queue.isEmpty()) {                   // 5. Пока очередь не пуста:
            int size = queue.size();                 // 6. Фиксируем текущий размер очереди
            for (int i = 0; i < size; i++) {         // 7. Обрабатываем все узлы текущего уровня
                TreeNode node = queue.poll();        // 8. Извлекаем узел из очереди
                if (node.left != null) queue.offer(node.left); // 9. Если есть левый потомок, добавляем его в очередь
                if (node.right != null) queue.offer(node.right); // 10. Если есть правый потомок, добавляем его в очередь
            }
            res++;                                   // 11.  Увеличиваем счетчик глубины после обработки
        }
        return res;
    }
    // Итеративное решение с использованием DFS (поиск в глубину) со стеком
    // time O(n), space O(n)
     public int maxDepth3(TreeNode root) {
         if (root == null) return 0;                // 1. Если дерево пустое, глубина 0
         Stack<TreeNode> stack = new Stack<>();     // 2. Стек для узлов
         Stack<Integer> depths = new Stack<>();     // 3. Стек для хранения глубин
         stack.push(root);                          // 4. Добавляем корень в стек
         depths.push(1);                       // 5. Начальная глубина = 1
         int res = 0;                               // 6. Переменная для хранения максимальной глубины
         while (!stack.isEmpty()) {                 // 7. Пока стек не пуст:
             TreeNode node = stack.pop();           // 8. Извлекаем узел из стека
             int depth = depths.pop();              // 9. Извлекаем соответствующую глубину
             res = Math.max(res, depth);            // 10. Обновляем максимум
             if (node.left != null) {               // 11. Если есть левый потомок:
                 stack.push(node.left);             // 12. Добавляем его в стек
                 depths.push(depth + 1);       // 13. Сохраняем его глубину (текущая + 1)
             }
             if (node.right != null) {              // 14. Если есть правый потомок:
                 stack.push(node.right);            // 15. Добавляем его в стек
                 depths.push(depth + 1);       // 16. Сохраняем его глубину (текущая + 1)
             }
         }
         return res;
     }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new Solution().maxDepth(root));
    }
}
