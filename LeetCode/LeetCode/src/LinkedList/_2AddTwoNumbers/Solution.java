package LinkedList._2AddTwoNumbers;

//2. Сложите два числа
//Вам даны два непустых связанных списка, представляющих два неотрицательных целых числа.
// Цифры в них расположены в обратном порядке, и каждый узел содержит одну цифру.
// Сложите эти два числа и верните сумму в виде связанного списка.
//Можно предположить, что в этих двух числах нет ведущих нулей, кроме самого числа 0.
// Ограничения:
//Количество узлов в каждом связанном списке находится в диапазоне [1, 100].
//0 <= Node.val <= 9
//Гарантируется, что список представляет собой число без ведущих нулей.
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Solution {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Создаём фиктивный начальный узел результата // Create a dummy initial node result
         ListNode dummyHead = new ListNode(0);
        // Текущий указатель для построения результата // Current pointer for building the result
         ListNode current = dummyHead;
        // Перенос из предыдущего разряда (0 или 1) // Carry from the previous digit (0 or 1)
         int carry = 0;

         // Пока есть узлы в любом из списков или есть перенос // While there are nodes in any of the lists or there is a carry
         while (l1 != null || l2 != null || carry != 0) {
            // Получаем значение из первого списка или 0, если список закончился // Get a value from the first list or 0 if the list is empty
             int val1 = (l1 != null) ? l1.val : 0;
            // Получаем значение из второго списка или 0, если список закончился // Get a value from the second list or 0 if the list is empty
             int val2 = (l2 != null) ? l2.val : 0;
            // Суммируем значения и перенос // Sum the values and the carry
             int sum = val1 + val2 + carry;
            // Вычисляем новую цифру для текущего разряда   // Calculate a new digit for the current digit
             int digit = sum % 10;
            // Вычисляем новый перенос для следующего разряда // Calculate a new carry for the next digit
             carry = sum / 10;

             // Создаём новый узел с вычисленной цифрой // Create a new node with the calculated digit
             current.next = new ListNode(digit);
            // Перемещаем указатель на новый узел       // Move the pointer to the new node
             current = current.next;

            // Переходим к следующим узлам в списках, если они существуют // Move to the next nodes in the lists, if they exist
             if (l1 != null) l1 = l1.next;
             if (l2 != null) l2 = l2.next;
         }

         // Возвращаем результат, пропуская фиктивный начальный узел    // Return the result, skipping the dummy initial node
         return dummyHead;
    }

    // Объяснение оптимизации:
    //Временная сложность: O(max(n, m)), где n и m - длины списков. Мы проходим каждый список только один раз.
    //Пространственная сложность: O(max(n, m)), так как создаем новый список для результата.
    //Ключевые моменты:
    //Используем фиктивный начальный узел (dummyHead) для упрощения кода
    //Обрабатываем списки разной длины, используя условные операторы
    //Учитываем перенос даже после обработки всех узлов списков
    //Работаем с цифрами поразрядно, как при обычном сложении в столбик

    public static void main(String[] args) {
         ListNode listNode1 = new ListNode(2,
                new ListNode(4,
                        new ListNode(3)));
        ListNode listNode2 = new ListNode(5,
                new ListNode(6,
                        new ListNode(4)));
        System.out.println(new Solution().addTwoNumbers(listNode1, listNode2));
    }
}
