package LinkedList._234PalindromeLinkedList;

import java.util.ArrayList;
import java.util.List;
// 234. Связный список-палиндром
// Для head односвязного списка верните true, если это палиндром, или false иначе.
// Сможете ли вы сделать это за O(n) времени и O(1) места?
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
         // Проверяем базовые случаи: пустой список или список из одного элемента всегда палиндром
        if (head == null || head.next == null) {return true;}

        // Находим середину списка с помощью двух указателей (черепаха и заяц)
        ListNode slow = head, fast = head;
        // Пока не достигнут конец списка
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Медленный указатель движется на 1 шаг
            fast = fast.next.next;  // Быстрый указатель движется на 2 шага
        }

        // Разворачиваем вторую половину списка
        ListNode prev = null;   // Предыдущий узел (изначально null)
        ListNode curr = slow;   // Текущий узел (начало второй половины)
        // Пока не достигнут конец списка
        while (curr != null) {
            ListNode nextTemp = curr.next;  // Сохраняем ссылку на следующий узел
            curr.next = prev;               // Разворачиваем указатель текущего узла
            prev = curr;                    // Перемещаем prev на текущий узел
            curr = nextTemp;                // Перемещаем curr на следующий узел
        }

         // Сравниваем первую половину и развернутую вторую половину
        ListNode firstHalf = head;      // Указатель на начало первой половины
        ListNode secondHalf = prev;     // Указатель на начало развернутой второй половины
        while (secondHalf != null) {    // Пока не достигнут конец второй половины списка
            if (firstHalf.val != secondHalf.val) { // Сравниваем значения по элементам
                return false;           // Если значения не совпадают - не палиндром
            }
            firstHalf = firstHalf.next;     // Двигаем указатель первой половины
            secondHalf = secondHalf.next;   // Двигаем указатель второй половины
        }
        return true;    // Все элементы совпали - палиндром
    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null) {return true;}            // Базовый случай: пустой список
        List<Integer> list = new ArrayList<>();     // Создаем список для хранения значений узлов
        ListNode current = head;
        while (current != null) {                   // Копируем все значения связного списка в ArrayList
            list.add(current.val);
            current = current.next;
        }
        // Проверяем, является ли массив палиндромом
        int start = 0;              // Указатель на начало массива
        int end = list.size() - 1;  // Указатель на конец массива
        while (start < end) {       // Просматриваем весь список
            if (list.get(start) != list.get(end)) {
                return false;       // Элементы не совпадают - не палиндром
            }
            start++;    // Двигаем начало вперед
            end--;      // Двигаем конец назад
        }
        return true;    // Все элементы совпали - палиндром
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1))));
        System.out.println(new Solution().isPalindrome(head));
    }
}

