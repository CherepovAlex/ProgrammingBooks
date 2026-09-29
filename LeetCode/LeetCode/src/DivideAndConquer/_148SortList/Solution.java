package DivideAndConquer._148SortList;

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
    // Основной метод сортировки списка (сортировка слиянием)
    // Сложность по времени: O(n log n), по памяти: O(log n) (стек вызовов)
    public ListNode sortList(ListNode head) {
        // Базовый случай: если список пуст или содержит один элемент - он уже отсортирован
        if (head == null || head.next == null) {
            return head; // Возвращаем исходный список
        }

        // Находим середину списка с помощью медленного и быстрого указателей и разрываем связь между половинами
        ListNode mid = getMid(head);
        // Рекурсивно сортируем левую половину  (от head до середины)
        ListNode left = sortList(head);
        // Рекурсивно сортируем правую половину (от середины до конца)
        ListNode right = sortList(mid);
        // Сливаем две отсортированные половины в один отсортированный список
        return merge(left, right);
    }

    // Метод для нахождения середины списка и разрыва связи - разделения его на две части
    ListNode getMid(ListNode head) {
        ListNode prev = null; // Указатель на предыдущий узел перед серединой
        ListNode slow = head; // Медленный указатель (достигнет середины)
        ListNode fast = head; // Быстрый указатель (движется в 2 раза быстрее)

        // Пока быстрый указатель не достигнет конца списка
        while (fast != null && fast.next != null) {
            prev = slow; // Сохраняем текущее положение медленного указателя
            slow = slow.next; // Медленный указатель движется на 1 шаг
            fast = fast.next.next; // Быстрый указатель движется на 2 шага
        }

        // Разрываем связь между двумя половинами
        if (prev != null) {
            prev.next = null; // Обрезаем связь, делая первую половину независимым списком
        }

        // Возвращаем начало второй половины (медленный указатель теперь на середине)
        return slow;
    }

    // Метод для слияния двух отсортированных списков в один отсортированный
    ListNode merge(ListNode list1, ListNode list2) {
        // Создаем фиктивный узел для упрощения логики
        ListNode dummy = new ListNode();
        ListNode current = dummy; // Указатель для построения нового списка

        // Пока оба списка не пусты
        while (list1 != null && list2 != null) {
            // Выбираем узел с меньшим значением
            if (list1.val <= list2.val) { // сравниваем значения первых узлов обоих списков
                current.next = list1; // Добавляем узел из первого списка
                list1 = list1.next; // Переходим к следующему узлу в первом списке
            } else {
                current.next = list2; // Добавляем узел из второго списка
                list2 = list2.next; // Перемещаем указатель во втором списке вперед
            }
            current = current.next; // Перемещаем указатель в новом списке вперед
        }

        // Добавляем оставшиеся узлы из непустого списка
        // / Если первый список не пуст - Если второй список не пуст
        current.next = (list1 != null) ? list1 : list2;

        // Возвращаем начало отсортированного списка (пропуская фиктивный узел)
        return dummy.next;
    }
    // Ключевые моменты оптимальности:
    //Время O(n log n) - классическая сложность сортировки слиянием
    //Память O(log n) - используется только стек вызовов для рекурсии
    //Алгоритм - сортировка слиянием идеально подходит для связанных списков,
    // так как не требует дополнительной памяти для массива и позволяет эффективно делить и сливать списки

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
