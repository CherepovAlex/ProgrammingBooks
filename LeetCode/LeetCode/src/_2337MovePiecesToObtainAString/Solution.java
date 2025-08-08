package _2337MovePiecesToObtainAString;
// Вам даны две строки start и target, обе длиной n. Каждая строка состоит только из символов
// 'L', 'R', и '_', где:
//Символы 'L' и 'R' обозначают фигуры, где фигура 'L' может переместиться влево,
// только если слева от неё есть пустое место, а фигура 'R' может переместиться вправо,
// только если справа от неё есть пустое место.
//Символ '_' обозначает пустое место, которое может быть занято любым из 'L' или 'R' элементов.
//Верните true если возможно получить строку target путем перемещения частей строки start
// любое количество раз. В противном случае верните false.
// Example 1:
//Input: start = "_L__R__R_", target = "L______RR"
//Output: true
//Explanation: We can obtain the string target from start by doing the following moves:
//- Move the first piece one step to the left, start becomes equal to "L___R__R_".
//- Move the last piece one step to the right, start becomes equal to "L___R___R".
//- Move the second piece three steps to the right, start becomes equal to "L______RR".
//Since it is possible to get the string target from start, we return true.
//Example 2:
//Input: start = "R_L_", target = "__LR"
//Output: false
//Explanation: The 'R' piece in the string start can move one step to the right to obtain "_RL_".
//After that, no pieces can move anymore, so it is impossible to obtain the string target
// from start.
//Example 3:
//Input: start = "_R", target = "R_"
//Output: false
//Explanation: The piece in the string start can move only to the right,
// so it is impossible to obtain the string target from start.
public class Solution {
    // time O(n) space O(1)
    public boolean canChange(String start, String target) {
        if(start.length() != target.length()) return false;

        int n = start.length();
        int i = 0, j = 0;

        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_')  i++; // пропускаем пустые места в start
            while (j < n && target.charAt(j) == '_') j++; // пропускаем пустые места в target

            // если один из указателей вышел за пределы строки, а другой нет
            if (i == n && j == n) return true;
            if (i == n || j == n) return false;

            // если символы не совпадают, преобразование невозможно
            if (start.charAt(i) != target.charAt(j)) return false;

            // проверяем позиции для 'L' и 'R'
            if (start.charAt(i) == 'L' && i < j) return false;   // 'L' может двигаться только влево (i >= j)
            if (start.charAt(i) == 'R' && i > j) return false;   // 'R' может двигаться только вправо (i <= j)

            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "_L__R__R_", target = "L______RR";
        System.out.println(new Solution().canChange(s1, target));   // true
    }
}
