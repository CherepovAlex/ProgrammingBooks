package Sorting._148SortList;

// 148. Сортировка списка
// Дан head связанный список. Верните список после его сортировки в порядке возрастания.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    // time O(n log n), space O(log n)
    public ListNode sortList(ListNode head) {
        // Базовый случай: если список пуст или содержит один элемент
        if (head == null || head.next == null) {
            return head;
        }

        // Находим середину списка с помощью медленного и быстрого указателей
        ListNode mid = getMid(head);
        // Рекурсивно сортируем левую половину
        ListNode left = sortList(head);
        // Рекурсивно сортируем правую половину
        ListNode right = sortList(mid);
        // Сливаем отсортированные половины
        return merge(left, right);
    }

    // Метод для нахождения середины списка и разрыва связи
    ListNode getMid(ListNode head) {
        ListNode prev = null; // Указатель на предыдущий узел перед серединой
        ListNode slow = head; // Медленный указатель (достигнет середины)
        ListNode fast = head; // Быстрый указатель (движется в 2 раза быстрее)

        // Пока быстрый указатель не достигнет конца списка
        while (fast != null && fast.next != null) {
            prev = slow; // Сохраняем предыдущий узел
            slow = slow.next; // Медленный двигаем на 1 шаг
            fast = fast.next.next; // Быстрый двигаем на 2 шага
        }

        // Разрываем связь между двумя половинами
        if (prev != null) {prev.next = null;}

        // Возвращаем начало второй половины
        return slow;
    }

    // Метод для слияния двух отсортированных списков
    ListNode merge(ListNode list1, ListNode list2) {
        // Создаем фиктивный узел для упрощения логики
        ListNode dummy = new ListNode();
        ListNode current = dummy; // Указатель для построения нового списка

        // Пока оба списка не пусты
        while (list1 != null && list2 != null) {
            // Выбираем узел с меньшим значением
            if (list1.val <= list2.val) {
                current.next = list1; // Добавляем узел из первого списка
                list1 = list1.next; // Переходим к следующему узлу в первом списке
            } else {
                current.next = list2; // Добавляем узел из второго списка
                list2 = list2.next; // Переходим к следующему узлу во втором списке
            }
            current = current.next; // Переходим к последнему добавленному узлу
        }

        // Добавляем оставшиеся узлы из непустого списка
        current.next = (list1 != null) ? list1 : list2;

        // Возвращаем начало отсортированного списка (пропуская фиктивный узел)
        return dummy.next;
    }

    public static void main(String[] args) {
        // Создаем тестовый список: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        // Сортируем список
        ListNode sorted = new Solution().sortList(head);
        // Выводим результат (для красивого вывода нужен дополнительный метод toString)
        printList(sorted); // Ожидаемый результат: 1 -> 2 -> 3 -> 4
    }

    // Вспомогательный метод для вывода списка
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
