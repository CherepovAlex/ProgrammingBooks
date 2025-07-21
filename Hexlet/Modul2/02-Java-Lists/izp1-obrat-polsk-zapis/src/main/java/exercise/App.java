package exercise;

import java.util.LinkedList;
import java.util.List;

public class App {

    // BEGIN
    private static int calculate(Integer a, Integer b, String operator) {

        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                throw new UnsupportedOperationException("Wrong operator");
        }
    }

    public static int calcInPolishNotation(String expression) {
        String[] values = expression.split(" ");
        var stack = new LinkedList<Integer>();
        var operators = List.of("+", "-", "*", "/");

        for (var value : values) {
            if (!operators.contains(value)) {
                stack.add(Integer.parseInt(value));
                continue;
            }
            var b = stack.pollLast();
            var a = stack.pollLast();
            var result = calculate(a, b, value);
            stack.add(result);
        }

        return stack.pollLast();
    }
    // END

    public static void main(String[] args) {

        System.out.println(App.calcInPolishNotation("1 2 + 4 * 3 +")); // 15
        System.out.println(App.calcInPolishNotation("7 2 3 * -")); // 1

    }
}
