package LinkedList._24SwapNodesInPairs;
// 24. Поменяйте местами узлы в парах
// Дан связный список. Поменяйте местами каждые два соседних узла и верните его начало.
// Вы должны решить задачу, не изменяя значения в узлах списка (то есть можно изменять только сами узлы).
// Example 1:
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
//Explanation:
//Example 2:
//Input: head = []
//Output: []
//Example 3:
//Input: head = [1]
//Output: [1]
//Example 4:
//Input: head = [1,2,3]
//Output: [2,1,3]
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    // time O(n), space O(1)
    public ListNode swapPairs(ListNode head) {
        // Проверка базовых случаев: пустой список или список из одного узла
        if (head == null || head.next == null) {
            return head; // Возвращаем исходный список без изменений
        }

        // Создаем фиктивный узел для упрощения логики обработки начала списка
        ListNode dummy = new ListNode(0);
        dummy.next = head; // Связываем фиктивный узел с началом исходного списка
        // Инициализируем указатель current, который будет указывать на узел перед парой для обмена
        ListNode current = dummy;
        // Пока существуют хотя бы два узла для обмена (текущий узел и следующий)
        while (current.next != null && current.next.next != null) {
            // Сохраняем ссылку на первый узел в паре
            // это два соседних узла, которые нужно поменять местами
            ListNode first = current.next;
            // Сохраняем ссылку на второй узел в паре
            ListNode second = current.next.next;

            // Меняем узлы местами:
            // Первый узел теперь указывает на то, что было после второго узла
            first.next = second.next;   // Второй узел теперь указывает на первый узел
            second.next = first;        // указывает на first.
            // Узел перед парой теперь указывает на новый первый узел (бывший второй)
            current.next = second;      // теперь указывает на second (так как second становится первым в паре)

            // После обмена пары current перемещается на два узла вперёд (на first, так как first теперь второй в паре).
            current = current.next.next;
        }
        // Возвращаем новый начало списка (то, что после фиктивного узла)
        return dummy.next;  // указывает на новый "head" списка.
    }
    // Алгоритм эффективно обрабатывает все краевые случаи и действительно является оптимальным решением.

    public static void main(String[] args) {
        Solution s = new Solution();

        // Пример 1: [1, 2, 3, 4] -> [2, 1, 4, 3]
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result1 = s.swapPairs(head);
        printList(result1); // // Ожидается: 2 -> 1 -> 4 -> 3
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
