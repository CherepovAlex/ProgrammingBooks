package _83RemoveDuplicatesFromSortedList;

// Дан head отсортированный связный список.
// Удалите все дубликаты, чтобы каждый элемент встречался только один раз.
// Верните отсортированный, а также связанный список.
// Definition for singly-linked list.
//Example 1:
//Input: head = [1,1,2]
//Output: [1,2]
//Example 2:
//Input: head = [1,1,2,3,3]
//Output: [1,2,3]
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val;this.next = next;}
    @Override
    public String toString() {
        return val + (next != null ? "->" + next : "");
    }
}

class Solution {
    // time O(n), space O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return  head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(1,
                        new ListNode(2)));
        System.out.println(new Solution().deleteDuplicates(head));
    }
}