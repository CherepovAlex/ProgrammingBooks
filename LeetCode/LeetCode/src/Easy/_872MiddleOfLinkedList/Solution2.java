package Easy._872MiddleOfLinkedList;
// Рассмотрим все листья двоичного дерева в порядке слева направо.
// Значения этих листьев образуют последовательность значений листьев.
// Например, в приведённом выше дереве последовательность конечных значений выглядит так: (6, 7, 4, 9, 8).
// Два бинарных дерева считаются похожими по листьям, если последовательность значений их листьев одинакова.
// Верните true тогда и только тогда, когда два заданных дерева с головными узлами root1 и root2 являются листовыми аналогами.
// Example 1:
// Input: root1 = [3,5,1,6,2,9,8,null,null,7,4],
//        root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
// Output: true
// Example 2:
// Input: root1 = [1,2,3],
//        root2 = [1,3,2]
// Output: false

import java.util.ArrayList;

public class Solution2 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaves1 = new ArrayList<>();
        ArrayList<Integer> leaves2 = new ArrayList<>();

        // Собираем листья первого дерева
        collectLeaves(root1, leaves1);
        // Собираем листья второго дерева
        collectLeaves(root2, leaves2);

        // Сравниваем последовательности листьев
        return leaves1.equals(leaves2);
    }

    private void collectLeaves(TreeNode root, ArrayList<Integer> leaves) {
        if (root == null) return;

        // Если узел является листом, добавляем его значение в список
        if (root.left == null && root.right == null)
            leaves.add(root.val);

        // Рекурсивно обходим левое и правое поддеревья
        collectLeaves(root.left, leaves);
        collectLeaves(root.right, leaves);
    }

    public static void main(String[] args) {

        Solution2 solution2 = new Solution2();

        // Example1
        TreeNode root1 = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4)
                        )
                ),
                new TreeNode(1,
                        new TreeNode(9),
                        new TreeNode(8)
                )
        );

        TreeNode root2 = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(7)
                ),
                new TreeNode(1,
                        new TreeNode(4),
                        new TreeNode(2,
                                new TreeNode(9),
                                new TreeNode(8)
                        )
                )
        );

        System.out.println(solution2.leafSimilar(root1, root2)); // true

        // Пример 2
        TreeNode root3 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
        );

        TreeNode root4 = new TreeNode(1,
                new TreeNode(3),
                new TreeNode(2)
        );

        System.out.println(solution2.leafSimilar(root3, root4)); // false
    }
}

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