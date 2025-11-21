package Tree._589NAryTreePreorderTraversal;

import java.util.*;

// Для root n-арного дерева верните пред-порядковый обход значений его узлов.
// Сериализация входных данных Nary-Tree представлена в виде обхода уровней в порядке возрастания.
// Каждая группа дочерних элементов отделяется нулевым значением (см. примеры)
// Example 1:
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [1,3,5,6,2,4]
//Example 2:
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
//Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>(); // Используем ArrayList для эффективного добавления

        // Если дерево пустое (корень равен null), сразу возвращаем пустой список — обход делать не из чего.
        if (root == null) return res;

        Stack<Node> stack = new Stack<>();  // Создаётся стек (stack) для обхода дерева.
        stack.push(root);            // Кладём корень дерева в стек, чтобы начать обход с него.

        while (!stack.isEmpty()) {  // Запускаем цикл, который будет работать, пока в стеке есть узлы для обработки.

            Node node = stack.pop();
            res.add(node.val);         // Добавляем в конец (правильный порядок)

            // Добавляем детей в обратном порядке, чтобы обрабатывать их слева направо
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1, Arrays.asList(
                new Node(3, Arrays.asList(
                        new Node(5),
                        new Node(6)
                )),
                new Node(2),
                new Node(4)
        ));
    }
}