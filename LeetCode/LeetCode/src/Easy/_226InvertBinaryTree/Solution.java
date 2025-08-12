package Easy._226InvertBinaryTree;

// Для root бинарного дерева инвертируйте дерево и верните его корень.
// Example 1:
//Input: root = [4,2,7,1,3,6,9]
//Output: [4,7,2,9,6,3,1]
//Example 2:
//Input: root = [2,1,3]
//Output: [2,3,1]
//Example 3:
//Input: root = []
//Output: []
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
    // O(n)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // swap
        root.right = left;
        root.left = right;

        return root;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(new Solution().invertTree(root1));
    }
}

