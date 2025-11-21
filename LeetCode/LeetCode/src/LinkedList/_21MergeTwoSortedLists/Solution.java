package LinkedList._21MergeTwoSortedLists;

// Вам даны начала двух отсортированных связанных списков list1 и list2.
//Объедините два списка в один отсортированный список.
// Список должен быть составлен путём объединения узлов из первых двух списков.
//Вернуть начало объединённого связанного списка.
// Example 1:
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//Example 2:
//Input: list1 = [], list2 = []
//Output: []
//Example 3:
//Input: list1 = [], list2 = [0]
//Output: [0]
public class Solution {
    // time O(n + m), space O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Ранний возврат для edge cases
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Создаем временный фиктивный узел для начала нового списка
        ListNode tempNode = new ListNode(0);
        ListNode current = tempNode; // вводим текущий временный узел

        // Основной цикл: пока оба списка не пусты
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;  // Добавляем узел из list1
                list1 = list1.next;         // Перемещаем указатель list1
            } else {
                current.next = list2;  // Добавляем узел из list2
                list2 = list2.next;         // Перемещаем указатель list2
            }
            current = current.next;   // Перемещаем указатель результата
        }

        // Оставшиеся элементы - просто присоединяем хвост
        current.next = (list1 != null) ? list1 : list2;

        // Просто присоединяем оставшуюся часть списка
//        if (list1 != null) {
//            current.next = list1;
//        }
//        if (list2 != null) {
//            current.next = list2;
//        }

        return tempNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(4)));
        ListNode listNode2 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4)));
        System.out.println(new Solution().mergeTwoLists(listNode1, listNode2));
    }

}

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

