package LinkedList._206ReverseLinkedList;
// 206. Обратный связанный список
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
        // Проверяем базовые случаи: пустой список или список из одного элемента
        if (head == null || head.next == null) {
            return head; // Возвращаем исходный список без изменений
        }

        ListNode prev = null;   // Инициируем указатель на предыдущий узел, изначально null (конец нового списка).
        ListNode current = head;// И указатель на текущий узел, начинаем с головы исходного списка

        // Проходим по всем узлам исходного списка
        while (current != null) {   // пока не дошли до конца списка
            ListNode next = current.next;   // Сохраняем ссылку на следующий узел, чтобы не потерять ее при изменении ссылок
            current.next = prev;    // Разворачиваем направление ссылки: текущий узел теперь указывает на предыдущий
            prev = current;         // Перемещаем указатель prev на текущий узел (текущий становится предыдущим для следующей итерации)
            current = next;         // Перемещаем указатель current на следующий узел (сохраненный ранее)
        }
        return prev;    // После завершения цикла prev указывает на новую голову развернутого списка
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    }
}