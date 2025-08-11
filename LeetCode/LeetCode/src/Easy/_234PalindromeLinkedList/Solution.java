package Easy._234PalindromeLinkedList;

import java.util.ArrayList;
import java.util.List;
// Для head односвязного списка верните true, если это палиндром, или false иначе.
// Example 1:
//Input: head = [1,2,2,1]
//Output: true
//Example 2:
//Input: head = [1,2]
//Output: false
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        // time O(n), space O(1)
        if (head == null || head.next == null) {return true;}

        // find the middle of list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // revers 2 half of list
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // check 1 half and 2 half after reverse
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null) {return true;}
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (list.get(start) != list.get(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1))));
        System.out.println(new Solution().isPalindrome(head));
    }
}

