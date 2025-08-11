package Easy._412FizzBuzz;
// Для заданного целого числа n верните массив строк answer (с индексацией от 1) где:
//answer[i] == "FizzBuzz" если i делится на 3 и 5.
//answer[i] == "Fizz" если i делится на 3.
//answer[i] == "Buzz" если i делится на 5.
//answer[i] == i (в виде строки), если ни одно из вышеперечисленных условий не выполняется.
//Example 1:
//Input: n = 3
//Output: ["1","2","Fizz"]
//Example 2:
//Input: n = 5
//Output: ["1","2","Fizz","4","Buzz"]
//Example 3:
//Input: n = 15
//Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // time - O(n), space - O(n)
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            // Проверка делимости текущего числа i на 3 и 5:
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;

            String currStr = "";

            if (divisibleBy3) { // Если число делится на 3, добавляем "Fizz" к строке результата
                currStr += "Fizz";
            }
            if (divisibleBy5) { // Если число делится на 5, добавляем "Buzz" к строке результата.
                currStr += "Buzz";
            }

            if (currStr.isEmpty()) {
                currStr += String.valueOf(i);
            }
            // если строка осталась пустой (число не делится ни на 3, ни на 5),
            // преобразуем само число i в строку и добавляем к результату
            answer.add(currStr);
        }
        return answer;  // Добавляем полученную строку в результирующий список answer
    }

    // time - O(n), space - O(n)
    public List<String> fizzBuzz2(int n) {
        List<String> answer = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) answer.add("FizzBuzz");
            else if (i % 3 == 0) answer.add("Fizz");
            else if (i % 5 == 0) answer.add("Buzz");
            else answer.add(String.valueOf(i));
        }
        return answer;
    }
    // time - O(n), space - O(n)
    public List<String> fizzBuzz3(int n) {
        List<String> answer = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) sb.append("Fizz");
            if (i % 5 == 0) sb.append("Buzz");
            if (sb.isEmpty()) sb.append(i);
            answer.add(sb.toString());
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fizzBuzz(3));
        System.out.println(new Solution().fizzBuzz(5));
        System.out.println(new Solution().fizzBuzz(15));
    }
}
