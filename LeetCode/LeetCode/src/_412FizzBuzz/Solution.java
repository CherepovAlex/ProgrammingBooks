package _412FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;

            String currStr = "";

            if (divisibleBy3) {
                currStr += "Fizz";
            }
            if (divisibleBy5) {
                currStr += "Buzz";
            }

            if (currStr.isEmpty()) {
                currStr += String.valueOf(i);
            }

            answer.add(currStr);

//            if (divisibleBy3 && divisibleBy5) {
//                answer.add("FizzBuzz");
//            } else if (divisibleBy3) {
//                answer.add("Fizz");
//            } else if (divisibleBy5) {
//                answer.add("Buzz");
//            } else  {
//                answer.add(String.valueOf(i));
//            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fizzBuzz(3));
        System.out.println(solution.fizzBuzz(5));
        System.out.println(solution.fizzBuzz(15));
    }
}
