package _206ReverseLinkedList;
// Дан head односвязный список. Необходимо перевернуть список и вернуть перевернутый список.
// Example 1:
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
//Example 2:
//Input: head = [1,2]
//Output: [2,1]
//Example 3:
//Input: head =

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    // time O(n), space O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {return head;}

        ListNode prev = null;   // предыдущий узел, изначально null
        ListNode current = head;    // текущий узел, начинается с head

        while (current != null) {   // пока не дошли до конца списка
            ListNode next = current.next;   // сохраняем текущий узел
            current.next = prev;    // разворачиваем ссылку текущего узла на предыдущий
            prev = current;         // перемещаем предыдущий узел на текущий
            current = next;         // перемещает текущий узел на следующий
        }
        return prev;    // после цикла prev будет новой головой списка
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    }
}