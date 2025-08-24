package Easy._876MiddleOfTheLinkedList;

// Для head односвязного списка верните средний узел связного списка.
// Если есть два средних узла, верните второй средний узел.
// Example 1:
//Input: head = [1,2,3,4,5]
//Output: [3,4,5]
//Explanation: The middle node of the list is node 3.
//Example 2:
//Input: head = [1,2,3,4,5,6]
//Output: [4,5,6]
//Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
class ListNode {
    int val;             // Хранит значение узла
    ListNode next;       // Ссылка на следующий узел

    ListNode() {         // Конструктор по умолчанию
    }

    ListNode(int val) {  // Конструктор с значением
        this.val = val;
    }

    ListNode(int val, ListNode next) { // Конструктор со значением и ссылкой
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    // time O(n), space O(1)
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) { // Если список пуст или содержит 1 элемент
            return head;                         // Возвращаем сам элемент (или null)
        }
        ListNode slow = head;   // Медленный указатель - начинает с головы
        ListNode fast = head;   // Быстрый указатель - начинает с головы
        // Пока быстрый указатель не достиг конца списка
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Медленный двигается на 1 шаг
            fast = fast.next.next;  // Быстрый двигается на 2 шага
        }
        return slow;    // Когда быстрый достиг конца, медленный будет в середине
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        System.out.println(new Solution().middleNode(head));
    }
}

