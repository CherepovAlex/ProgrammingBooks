package Tree._590NaryTreePostorderTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
// Для root n-арного дерева верните последовательный обход значений его узлов.
// Сериализация входных данных Nary-Tree представлена в виде обхода уровней в порядке возрастания.
// Каждая группа дочерних элементов отделяется нулевым значением (см. примеры)
// Example 1:
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [5,6,3,2,4,1]
//Example 2:
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
//Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
// Definition for a Node.
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
    //принимает корень N-арного дерева (root), возвращает список значений в порядке постордер (дети → узел).
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();  // Создаётся стек (stack) для обхода дерева.
        LinkedList<Integer> res = new LinkedList<>(); // Список res для результата
        // Здесь тоже LinkedList, потому что мы хотим вставлять элементы в начало списка (addFirst),
        // что эффективно именно у LinkedList.

        // Если дерево пустое (корень равен null), сразу возвращаем пустой список — обход делать не из чего.
        if (root == null) return res;

        stack.add(root);            // Кладём корень дерева в стек, чтобы начать обход с него.
        while (!stack.isEmpty()) {  // Запускаем цикл, который будет работать, пока в стеке есть узлы для обработки.
            Node node = stack.pollLast();   // берём последний добавленный элемент из стека (pollLast),
            res.addFirst(node.val);         // Вставляем значение текущего узла в начало списка res.
            for (Node child : node.children) {  // Перебираем всех детей текущего узла и кладём их в стек.
                stack.add(child);               // Они будут обработаны позже, после того как стек "дойдёт" до них.
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

        System.out.println(new Solution().postorder(root));
    }
}

// 2. Исходное состояние
//stack = [1]
//res = []

//3. Шаг 1 — достаём 1
//Достаём из стека 1 → stack = []
//
//Добавляем 1 в начало res → res = [1]
//
//Добавляем детей 3, 2, 4 в стек → stack = [3, 2, 4]

//4. Шаг 2 — достаём 4
//Достаём из стека 4 → stack = [3, 2]
//
//Добавляем 4 в начало res → res = [4, 1]
//
//У 4 нет детей → стек не меняется.

//5. Шаг 3 — достаём 2
//Достаём 2 → stack = [3]
//
//Добавляем 2 в начало res → res = [2, 4, 1]
//
//У 2 нет детей.

//6. Шаг 4 — достаём 3
//Достаём 3 → stack = []
//
//Добавляем 3 в начало res → res = [3, 2, 4, 1]
//
//Добавляем детей 5, 6 в стек → stack = [5, 6]

//7. Шаг 5 — достаём 6
//Достаём 6 → stack = [5]
//
//Добавляем 6 в начало res → res = [6, 3, 2, 4, 1]
//
//У 6 нет детей.

//8. Шаг 6 — достаём 5
//Достаём 5 → stack = []
//
//Добавляем 5 в начало res → res = [5, 6, 3, 2, 4, 1]
//
//У 5 нет детей.