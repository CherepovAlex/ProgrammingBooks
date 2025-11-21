package Tree._938RangeSumOfBST;

import java.util.Stack;

// Сумма диапазонов BST (Binary Search Tree - двоичное дерево поиска)
//Для узла root бинарного дерева поиска и двух целых чисел low и high верните сумму значений всех узлов со значением
// в включительно диапазоне [low, high].
// Example 1:
//Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
//Output: 32
//Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
//Example 2:
//Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
//Output: 23
//Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
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
    // time O(N) (or O(log N), space O(H)
    public int rangeSumBST(TreeNode root, int low, int high) {
        // Базовый случай: если узел пустой, возвращаем 0
        if (root == null) return 0;

        // Получаем значение текущего узла
        int currentVal = root.val;
        int sum = 0;

        // Если значение в диапазоне [low, high], добавляем его к сумме
        if (currentVal >= low && currentVal <= high) {
            sum += currentVal;
        }

        // Если значение больше Low, проверяем левое поддерево
        // (в BST все значения в левом поддереве меньше текущего)
        if (currentVal > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        // Если значение меньше high, проверяем правое поддерево
        // (в BST все значения в правом поддереве больше текущего)
        if (currentVal < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum; // возвращаем общую сумму
    }

    public int rangeSumBSTIt(TreeNode root, int low, int high) {

        // Создаём стек для обхода дерева без рекурсии
        Stack<TreeNode> stack = new Stack<>();
        // Добавляем корень в стек
        stack.push(root);
        int sum = 0;

        // Пока стек не пуст, продолжаем обход
        while (!stack.isEmpty()) {
            // Извлекаем узел из стека
            TreeNode node = stack.pop();
            // Если узел не пустой, обрабатывае его
            if (node != null) {
                int val = node.val;
                // Если узел не пусто, обрабатываем его
                if (val >= low && val <= high) {
                    sum += val;
                }
                // Если значение больше Low, добавляем левое поддерево
                if (val > low) {
                    stack.push(node.left);
                }
                // Если значение меньше high, добавляем правео поддерево
                if (val < high) {
                    stack.push(node.right);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3), new TreeNode(7)),
                new TreeNode(15,
                        null, new TreeNode(18)));
        System.out.println(new Solution().rangeSumBST(root, 7, 15));
        System.out.println(new Solution().rangeSumBSTIt(root, 7, 15));
    }
}
