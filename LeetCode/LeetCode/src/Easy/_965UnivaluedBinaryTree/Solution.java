package Easy._965UnivaluedBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// Однозначное двоичное дерево
//Двоичное дерево является однозначным, если все узлы дерева имеют одинаковое значение.
//Для root бинарного дерева верните true, если заданное дерево является однозначным, или false - в противном случае.
// Example 1:
//Input: root = [1,1,1,1,1,null,1]
//Output: true
//Example 2:
//Input: root = [2,2,2,5,2]
//Output: false
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
    // time O(n), n - количество узлов в дереве, O(h), h - высота дерева (глубина рекурсивного стека вызовов)
    public boolean isUnivalTree(TreeNode root) {
        // Если дерево пустое, считаем его однозначным (по согласшению)
        if (root == null) {return true;}
        // Запускаем рекурсивную проверку, начиная с корня
        return isUnivalTree(root, root.val);
    }

    public boolean isUnivalTree(TreeNode node, int value) {
        // Если текущий узел null, достигли конца ветки - возвращаем true
        if (node == null) {return true;}
        // Если значение текущего узла не равно эталонному значению, дерево не однозначно
        if (node.val != value) {return false;}
        // Рекурсивно проверяем левое и правое поддеревья
        // Дерево однозначно только если оба поддерева однозначны
        return isUnivalTree(node.left, value) && isUnivalTree(node.right, value);
    }

    // альтернативный итеративный подход
    public boolean isUnivalTreeIt(TreeNode root) {
        // Если дерево пустое, возвращаем true
        if (root == null) return true;
        // Создаём очередь для обхода дерева в ширину
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int value = root.val;   // запоминаем значение корня
        // Пока в очереди есть узлы
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();   // Извлекаем узел из очереди
            // Если значение узла не совпадает с корневым, дерево не однозначно
            if (node.val != value) return false;

            // Добавление левого потомка в очередь, если он существует
            if (node.left != null) queue.offer(node.left);
            // Добавление правого потомка в очередь, если он существует
            if (node.right != null) queue.offer(node.right);
        }

        // Все узлы проверены и имеют одинаковое значение
        return true;
    }

    public static void main(String[] args) {
        // Создаем тестовое дерево: [1,1,1,1,1,null,1]
        TreeNode root = new TreeNode(1, new TreeNode(1, new TreeNode(1), new TreeNode(1)),
                new TreeNode(1, null, new TreeNode(1)));
        // Проверяем и выводим результат
        System.out.println(new Solution().isUnivalTree(root));
    }
}
