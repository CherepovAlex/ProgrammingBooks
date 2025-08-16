package Easy._101SymmetricTree;

// Для root бинарного дерева проверьте, является ли оно зеркальным отражением самого себя
// (то есть симметричным относительно своего центра).
// Example 1:
//Input: root = [1,2,2,3,4,4,3]
//Output: true
//Example 2:
//Input: root = [1,2,2,null,3,null,3]
//Output: false
class TreeNode {
    int val;    // значение узла
    TreeNode left; //  левый потомок
    TreeNode right; // правый потомок

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

class Solution {
    // time O(n), space O(h), h - высота дерева
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root); // передаём вспомогательному методу корень дважды.
    }
    // рекурсивно проверяет, являются ли два дерева зеркальными:
    private boolean isMirror(TreeNode root1, TreeNode root2) {
        // Если оба узла null - они зеркальны (базовый случай)
        if (root1 == null && root2 == null) return true;
        // Если только один из узлов null - не зеркальны
        if (root1 == null || root2 == null) return false;
        // проверяем, что значения узлов равны, и:
        // левый потомок первого узла зеркален правому потомку второго узла
        // Правый потомок первого узла зеркален левому потомку второго узла
        return (root1.val == root2.val) && (isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)),
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(3)));

        System.out.println(new Solution().isSymmetric(root));
    }
}