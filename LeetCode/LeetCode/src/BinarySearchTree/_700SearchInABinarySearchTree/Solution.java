package BinarySearchTree._700SearchInABinarySearchTree;
// 700. Поиск в двоичном дереве поиска
//Вам даны root бинарного дерева поиска (BST) и целое число val.
//Найдите в двоичном дереве поиска узел, значение которого равно val, и верните поддерево с корнем в этом узле.
// Если такого узла нет, верните null.
// Example 1:
//Input: root = [4,2,7,1,3], val = 2
//Output: [2,1,3]
//Example 2:
//Input: root = [4,2,7,1,3], val = 5
//Output: []
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
    // time O(h), space O(1)
    // рекурсивное
    public TreeNode searchBST(TreeNode root, int val) {
        // Проверяем, является ли текущий узел null (базовый случай рекурсии)
        if (root == null) return null; // Узел не найден, возвращаем null
        // Если значение текущего узла равно искомому значению
        if (root.val == val)
            return root; // Найден искомый узел, возвращаем его
        // Если искомое значение меньше значения текущего узла
        if (val < root.val)
            return searchBST(root.left, val); // ищем в левом поддерева (в БДП все меньшие значения слева)
        else
            return searchBST(root.right, val); // ищем в правом поддереве (в БПД все большие значения справа)
    }
    // итеративное
    public TreeNode searchBST1(TreeNode root, int val) {
            // Начинаем с корневого узла
            TreeNode current = root;
            // Пока текущий узел не станет null
            while (current != null) {
                // Если нашли узел с искомым значением
                if (current.val == val) {
                    return current; // Возвращаем найденный узел
                }
                // Если искомое значение меньше значения текущего узла
                else if (val < current.val) {
                    current = current.left; // Переходим в левое поддерево
                }
                // Если искомое значение больше значения текущего узла
                else {
                    current = current.right; // Переходим в правое поддерево
            }
            }
        // Если дошли до конца и не нашли узел
        return null; // возвращаем null
    }

    public static void main(String[] args) {
        int val = 2;
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, null, null));
        System.out.println(new Solution().searchBST(root, val));
    }
}
