package Easy._160IntersectionOfTwoLinkedLists;
// Даны заголовки двух односвязных списков headA и headB.
// Вернуть узел, в котором пересекаются два списка. Если два связанных списка вообще не пересекаются, вернуть null.
//Например, следующие два связанных списка начинают пересекаться в узле c1:
//Тестовые примеры составлены таким образом, чтобы во всей связанной структуре не было циклов.
//Обратите внимание, что после возврата из функции связанные списки должны сохранить свою первоначальную структуру.
//Судья по Обычаю:
//Входные данные для судьи представлены следующим образом (ваша программа не получает эти входные данные):
//intersectVal — Значение узла, в котором происходит пересечение. Если пересекающихся узлов нет, то 0
//listA — Первый связанный список.
//listB — Второй связанный список.
//skipA — Количество узлов, которые нужно пропустить в listA (начиная с головного), чтобы добраться до пересекающегося узла.
//skipB — Количество узлов, которые нужно пропустить в listB (начиная с головного), чтобы добраться до пересекающегося узла.
//Затем судья создаст связанную структуру на основе этих входных данных и передаст вашей программе две головы: headA и headB . Если вы правильно вернёте пересекающийся узел, то ваше решение будет принято.

// Example 1:
//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
//Output: Intersected at '8'
//Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
//From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
//- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
//Example 2:
//Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
//Output: Intersected at '2'
//Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
//From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
//Example 3:
//Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//Output: No intersection
//Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
//Explanation: The two lists do not intersect, so return null.
//Constraints:
//The number of nodes of listA is in the m.
//The number of nodes of listB is in the n.
//1 <= m, n <= 3 * 104
//1 <= Node.val <= 105
//0 <= skipA <= m
//0 <= skipB <= n
//intersectVal is 0 if listA and listB do not intersect.
//intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    // time O(m + n), space O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Если один из списков пуст, пересечения нет
        if (headA == null || headB == null) return null;

        // Создаем два указателя
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Пока указатели не указывают на один и тот же узел
        // при разной длине списков, цикл пройдёт 2 раза и на 3 круге они встретятся.
        while (pointerA != pointerB) {
            // Перемещаем pointerA на следующий узел
            // Если достигли конца списка A, переходим к началу списка B
            pointerA = (pointerA == null) ? headB : pointerA.next;

            // Перемещаем pointerB на следующий узел
            // Если достигли конца списка B, переходим к началу списка A
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }
        // Возвращаем узел пересечения (или null, если пересечения нет)
        return pointerA;
    }

    public static void main(String[] args) {
        // Создаем пересекающиеся списки как в примере 1
        ListNode headA = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        headA.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode headB = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(1);

        headB.next = node5;
        node5.next = node6;
        node6.next = node2; // Пересечение происходит здесь

        Solution solution = new Solution();
        ListNode intersection = solution.getIntersectionNode(headA, headB);
        if (intersection != null) {
            System.out.println("Intersected at '" + intersection.val + "'");
        } else {
            System.out.println("No intersection");
        }
        // Output: Intersected at '8'
    }
}
