package exercise._08LinkedList;

import java.util.LinkedList;

public class App {

    public static boolean isBracketsBalanced(String expression) {

        var brackets = new LinkedList<Character>();

        for (var symbol : expression.toCharArray()) {

            if (symbol == '(') {
                brackets.add(symbol);

            } else if (symbol == ')') {
                var lastBracket = brackets.pollLast();

                if (lastBracket == null) {
                    return false;
                }
            }
        }

        return brackets.size() == 0;
    }

    public static void main(String[] args) {

        System.out.println(App.isBracketsBalanced("()")); // true
        System.out.println(App.isBracketsBalanced("()()")); // true
        System.out.println(App.isBracketsBalanced("(()())")); // true

        System.out.println(App.isBracketsBalanced("(")); // false
        System.out.println(App.isBracketsBalanced("(()")); // false
        System.out.println(App.isBracketsBalanced(")(")); // false

        System.out.println(App.isBracketsBalanced("(), ((()()))"));
        System.out.println(App.isBracketsBalanced("(, ((), )("));

    }

}
