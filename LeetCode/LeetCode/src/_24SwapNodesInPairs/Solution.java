package _24SwapNodesInPairs;
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
        // base cases: empty list or list from one node
        if (head == null || head.next == null) {
            return head; // возвращаем head без изменений.
        }

        // fake node for simple logic - Вводится для упрощения логики обмена, особенно для первых двух узлов.
        ListNode dummy = new ListNode(0);
        dummy.next = head; // всегда указывает на новый "head" списка после возможных обменов.
        ListNode current = dummy; // current указывает на узел перед парой, которую нужно поменять.

        while (current.next != null && current.next.next != null) {
            // это два соседних узла, которые нужно поменять местами
            ListNode first = current.next;
            ListNode second = current.next.next;

            // change first and second
            first.next = second.next;   // указывает на узел после second.
            second.next = first;        // указывает на first.
            current.next = second;      // теперь указывает на second (так как second становится первым в паре)

            // move current on 2 nodes ago
            // После обмена пары current перемещается на два узла вперёд (на first, так как first теперь второй в паре).
            current = current.next.next;
        }

        return dummy.next;  // указывает на новый "head" списка.
    }

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
