package LinkedList._83RemoveDuplicatesFromSortedList;
// 83. Удалите дубликаты из отсортированного списка
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
        // Создаем указатель current, который начинается с головы списка
        ListNode current = head;
         // Пока текущий узел и следующий узел существуют (не равны null)
        while (current != null && current.next != null) {
            // Сравниваем значение текущего узла со значением следующего узла
            if (current.val == current.next.val) {
                // Если значения совпадают, пропускаем следующий узел
                // Связываем текущий узел с узлом, следующим за дубликатом
                current.next = current.next.next;
            }
            else {
                // Если значения разные, перемещаем указатель на следующий узел
                current = current.next;
            }
        }
        // Возвращаем исходную голову списка (возможно измененного)
        return  head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(1,
                        new ListNode(2)));
        System.out.println(new Solution().deleteDuplicates(head));
    }
}