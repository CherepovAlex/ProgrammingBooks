package Medium._328OddEvenLinkedList;

// Для односвязного списка head сгруппируйте все узлы с нечётными индексами,
// а затем узлы с чётными индексами и верните переупорядоченный список.
//Первый узел считается нечётным, а второй узел — чётным, и так далее.
//Обратите внимание, что относительный порядок внутри чётных и нечётных групп должен оставаться таким же, как во входных данных.
//Вы должны решить задачу с дополнительной пространственной сложностью O(1) и временной сложностью O(n) .
// Example 1:
//Input: head = [1,2,3,4,5]
//Output: [1,3,5,2,4]
//Example 2:
//Input: head = [2,1,3,5,6,4,7]
//Output: [2,3,6,7,1,5,4]
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
    public ListNode oddEvenList(ListNode head) {
        // Если список пуст или содержит только один элемент, возвращаем его как есть (нечего перегруппировывать)
        if (head == null) {
            return head;
        }
        ListNode odd = head;        // нечетный узел (первый) - голова:  odd -> 1
        ListNode even = head.next;  // четный узел (второй) - следующий: even -> 2
        ListNode evenHead = even;   // сохраняем голову четного списка:  evenHead -> 2

        while (even != null && even.next != null) {
            // Обновляем указатель для нечетного списка
            odd.next = even.next;   //  связываем текущий нечетный узел со следующим нечетным
            odd = odd.next;         //  перемещаем указатель нечетного на следующий нечетный

            // Обновляем указатель для четного списка
            even.next = odd.next;   //  связываем текущий четный узел со следующим четным
            even = even.next;       //   перемещаем указатель четного на следующий четный
        }

        // Соединяем два списка
        odd.next = evenHead;        // Присоединяем четный список после последнего нечетного узла
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        System.out.println(new Solution().oddEvenList(head));
    }
}