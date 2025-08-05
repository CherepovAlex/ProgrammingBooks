package _20ValidParentheses;
// Дана строка s, содержащая только символы '(', ')', '{', '}', '[' и ']'. Определите, является ли входная строка корректной.
//Введённая строка действительна, если:
//Открытые скобки должны быть закрыты скобками того же типа.
//Открытые скобки должны быть закрыты в правильном порядке.
//Каждой закрывающей скобке соответствует открывающая скобка того же типа.

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // time O(n), space O(n)
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {return false;}

        char[] arr = s.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
                stack.push(arr[i]);
            } else if (stack.isEmpty()) {
                return false;
            } else if (arr[i] == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (arr[i] == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (arr[i] == '}' && stack.peek() == '{') {
                stack.pop();
            } else return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(new Solution().isValid(s));
    }
}
