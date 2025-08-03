package _872MiddleOfLinkedList;

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