package Tree._114FlattenBinaryTreeToLinkedList;

import java.util.Stack;

// 114. Преобразование двоичного дерева в связанный список
//Учитывая root бинарного дерева, преобразуйте его в «связанный список»:
//В «связанном списке» должен использоваться тот же класс TreeNode, где дочерний указатель right указывает на
// следующий узел в списке, а дочерний указатель left всегда равен null.
//«Связанный список» должен быть упорядочен так же, как при предпорядковом обходе двоичного дерева.
// Example 1:
//Input: root = [1,2,5,3,4,null,6]
//Output: [1,null,2,null,3,null,4,null,5,null,6]
//Example 2:
//Input: root = []
//Output: []
//Example 3:
//Input: root = [0]
//Output: [0]
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
    // time O(n), space O(1)
    public void flatten(TreeNode root) {
        // Текущий узел для обхода дерева
        TreeNode current = root;

        // Пока текущий узел не станет null
        while (current != null) {
            // Если у текущего узла есть левое поддерево
            if (current.left != null) {
                // Находим самого правого узла в левом поддереве
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                // Перемещаем правое поддерево текущего узла в конец левого поддерева
                rightmost.right = current.right;

                // Перемещаем левое поддерево вправо
                current.right = current.left;

                // Обнуляем левый указатель
                current.left = null;
            }

            // Переходим к следующему узлу (который был левым поддеревом)
            current = current.right;
        }
    }

    public void flatten2(TreeNode root) {
        if (root == null) return;               // Проверка на пустое дерево
        Stack<TreeNode> stack = new Stack<>();  // Создание стека для обхода
        stack.push(root);                       // Помещение корня в стек

        while (!stack.isEmpty()) {              // Пока стек не пуст
            TreeNode current = stack.pop();     // Извлекаем текущий узел

            if (current.right != null) {        // Если есть правое поддерево
                stack.push(current.right);      // Добавляем его в стек
            }
            if (current.left != null) {         // Если есть левое поддерево
                stack.push(current.left);       // Добавляем кго в стек
            }
            if (!stack.isEmpty()) {             // Если в стеке ещё есть узлы
                current.right = stack.peek();   // Связываем текущий узел со следующим
            }
            current.left = null;                // Обнуляем левый указатель
        }
    }

    public static void main(String[] args) {
        // Создаём тестовое дерево: [1, 2, 5, 3, 4, null, 6]
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                                    new TreeNode(3),
                                    new TreeNode(4)),
                new TreeNode(5,
                                    null,
                                    new TreeNode(6)));
        // Преобразуем дерево в двусвязный список
        new Solution().flatten(root);

        // Выводим результат
        TreeNode node = root;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
        }
        // 1 2 3 4 5 6
    }
}
