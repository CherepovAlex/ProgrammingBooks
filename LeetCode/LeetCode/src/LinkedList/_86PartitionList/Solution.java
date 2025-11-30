package LinkedList._86PartitionList;
// 86. Список разделов
// Дан head связанный список и значение x, разделите его таким образом, чтобы все узлы меньше чем x находились
// перед узлами больше или равно x.
// Вы должны сохранить исходный относительный порядок узлов в каждом из двух разделов.
// Example 1:
//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
//Example 2:
//Input: head = [2,1], x = 2
//Output: [1,2]

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val;this.next = next;}
}

public class Solution {
    // time O(n), space O(1)
    public ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);   // Создаем фиктивную начальную ноду для списка "меньших" значений
        ListNode before = before_head;                // Указатель для перемещения по списку "меньших" значений

        ListNode after_head = new ListNode(0); // Создаем фиктивную начальную ноду для списка "больших или равных" значений
        ListNode after = after_head;               // Указатель для перемещения по списку "больших или равных" значений
        // Проходим по исходному списку
        while (head != null) {
            if (head.val < x) {         // Если значение меньше x, добавляем в список "меньших"
                before.next = head;
                before = before.next;
            } else {                    // Если значение больше или равно x, добавляем в список "больших или равных"
                after.next = head;
                after = after.next;
            }                           // Переходим к следующей ноде исходного списка
            head = head.next;
        }
        after.next = null;           // Завершаем список "больших или равных" значений (важно для избежания циклов)
        before.next = after_head.next;    // Соединяем список "меньших" со списком "больших или равных"

        return before_head.next;     // Возвращаем объединенный список (пропуская фиктивную начальную ноду)
    }

    // Ключевые особенности оптимального решения:
    //Один проход - алгоритм проходит по списку только один раз
    //Постоянная память - используются только фиксированное количество указателей
    //Сохранение порядка - относительный порядок узлов в каждой группе сохраняется
    //Избежание циклов - after.next = null критически важно для разрыва связей
    //Алгоритм элегантно решает задачу, создавая два временных списка и затем объединяя их.

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(4,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(5,
                                                new ListNode(2))))));

        Solution solution = new Solution();

        // Выводим исходный список
        System.out.print("Исходный список: ");
        printList(head);

        // Вызываем метод partition с x = 3
        ListNode result = solution.partition(head, 3);

        // Выводим результат
        System.out.print("После partition(3): ");
        printList(result);

        // Тестируем с другим примером
        System.out.println("\n--- Второй пример ---");
        ListNode head2 = new ListNode(2, new ListNode(1));
        System.out.print("Исходный список: ");
        printList(head2);

        ListNode result2 = solution.partition(head2, 2);
        System.out.print("После partition(2): ");
        printList(result2);

    }

    // Вспомогательный метод для вывода списка
    public static void printList(ListNode head) {
        ListNode current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }
}
