package Tree._872MiddleOfLinkedList;
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

public class Solution {
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> array = new ArrayList<>();

        int length = 0;

        // time O(n), space O(n)
        while (head != null) {
            array.add(head);
            head = head.next;
            length++;
        }
//        return array.get(length / 2);

        // time O(n), space O(1)
        ListNode middle = head;
        ListNode end = head;
        while(end != null && end.next != null) {   // 3 1 2 7 7
            middle = middle.next;
            end = end.next.next;
        }

        return middle;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1,
                            new ListNode(2,
                                    new ListNode(4,
                                            new ListNode(5))));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}