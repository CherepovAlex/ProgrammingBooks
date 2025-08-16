package Easy._1047RemoveAllAdjacentDuplicatesInString;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//Вам дана строка s, состоящая из строчных букв английского алфавита.
// Удаление дубликатов состоит в выборе двух соседних и одинаковых букв и их удалении.
//Мы многократно выполняем удаление дубликатов в s до тех пор, пока это возможно.
//Верните окончательную строку после удаления всех повторяющихся символов.
// Можно доказать, что ответ уникален.
// Example 1:
//Input: s = "abbaca"
//Output: "ca"
//Explanation:
//For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
//Example 2:
//Input: s = "azxxzy"
//Output: "ay"
public class Solution {
    // time O(n) space O(n)
    public String removeDuplicates(String s) {
        // Создается стек для хранения символов
        Stack<Character> stack = new Stack<>();
        // Итерация по каждому символу входной строки.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Если стек пуст - просто добавляем текущий символ
            if (stack.isEmpty()) {
                stack.push(ch);
                // Если верхний элемент стека совпадает с текущим символом - удаляем его из стека
            } else if (stack.peek() == ch) {
                stack.pop();
                // Иначе добавляем текущий символ в стек
            } else {
                stack.push(ch);
            }
        }
        // Собираем результат из оставшихся в стеке символов.
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String removeDuplicates2(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

    public String removeDuplicates3(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int length = sb.length();
            if (length > 0 && sb.charAt(length - 1) == ch) {
                sb.deleteCharAt(length - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(new Solution().removeDuplicates(str));
    }
}
