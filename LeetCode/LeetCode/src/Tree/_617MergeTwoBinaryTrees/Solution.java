package Tree._617MergeTwoBinaryTrees;

// Вам даны два бинарных дерева root1 и root2.
//Представьте, что, когда вы накладываете одно дерево на другое, некоторые узлы двух деревьев пересекаются,
// а другие — нет. Вам нужно объединить два дерева в новое бинарное дерево.
// Правило объединения заключается в том, что если два узла пересекаются,
// то в качестве нового значения объединённого узла суммируются значения этих узлов.
// В противном случае в качестве узла нового дерева будет использоваться ненулевой узел.
//Верните объединённое дерево.
//Примечание: процесс слияния должен начинаться с корневых узлов обоих деревьев.
// Example 1:
//Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
//Output: [3,4,5,5,4,null,7]
//Example 2:
//Input: root1 = [1], root2 = [1,2]
//Output: [2,2]
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
    // time O(n) space O(m), m - deeprth of recursion
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) { // Если оба узла null, вернем null
            return null;
        }

        // version 1
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        // version 2
          // Определяем значения для нового узла
//        int val = (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val);
//        // Создаем новый узел (не модифицируя исходные)
//        TreeNode newNode = new TreeNode(val);
//
//        // Рекурсивно объединяем левые и правые поддеревья
//        newNode.left = mergeTrees(
//            root1 == null ? null : root1.left,
//            root2 == null ? null : root2.left
//        );
//        newNode.right = mergeTrees(
//            root1 == null ? null : root1.right,
//            root2 == null ? null : root2.right
//        );

        return root1;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1,
                new TreeNode(3, new TreeNode(5), null),
                new TreeNode(2));
        TreeNode root2 = new TreeNode(2,
                new TreeNode(1, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(7)));
        System.out.println(new Solution().mergeTrees(root1, root2));
    }
}
