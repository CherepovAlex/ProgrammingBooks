package TwoPointers._141LinkedListCycle;
// 141. Цикл в связанном списке
// Дано head, начало связного списка. Определите, есть ли в связном списке цикл.
// В связанном списке есть цикл, если в списке есть узел, до которого можно снова добраться,
// если непрерывно следовать за указателем next.
// Внутри списка pos используется для обозначения индекса узла, с которым связан указатель next.
// Обратите внимание, что pos не передаётся в качестве параметра.
// Верните true если в связанном списке есть цикл. В противном случае верните false.
// Example 1:
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
//Example 2:
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
//Example 3:
//Input: head = [1], pos = -1
//Output: false
//Explanation: There is no cycle in the linked list.
public class Solution {
    // time O(n), space O(1)
    public boolean hasCycle(ListNode head) {
        // Инициализация двух указателей (slow и fast) на начало списка.
        ListNode slow = head;   // будет двигаться на 1 узел за шаг.
        ListNode fast = head;   // будет двигаться на 2 узла за шаг.
        while (fast != null && fast.next != null) { // Цикл продолжается, пока fast не достигнет конца списка
            // дополнительная проверка fast.next != null нужна, так как fast делает два шага.
            slow = slow.next;         // slow перемещается на 1 узел вперед.
            fast = fast.next.next;    // fast перемещается на 2 узла вперед.
            if (slow == fast) {     // Если slow и fast указывают на один и тот же узел, значит обнаружен цикл.
                return true;        // Это происходит потому, что в цикле быстрый указатель "догоняет" медленный.
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2; // Это создаёт цикл, соединяя хвост обратно к node2

        System.out.println(new Solution().hasCycle(head));

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
