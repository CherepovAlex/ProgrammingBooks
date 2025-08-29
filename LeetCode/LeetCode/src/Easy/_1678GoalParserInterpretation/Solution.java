package Easy._1678GoalParserInterpretation;

// У вас есть Goal Parser, который может интерпретировать строку command. command состоит из алфавита
// "G", "()" и/или "(al)" в определённом порядке. Goal Parser интерпретирует "G" как строку "G", "()"
// как строку "o", а "(al)" как строку "al". Затем интерпретированные строки объединяются в исходном порядке.
//Для строки command верните интерпретацию Goal Parser'scommand.
// Example 1:
//Input: command = "G()(al)"
//Output: "Goal"
//Explanation: The Goal Parser interprets the command as follows:
//G -> G
//() -> o
//(al) -> al
//The final concatenated result is "Goal".
//Example 2:
//Input: command = "G()()()()(al)"
//Output: "Gooooal"
//Example 3:
//Input: command = "(al)G(al)()()G"
//Output: "alGalooG"
public class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
                i++;
            } else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                sb.append("o");
                i += 2;
            } else {
                sb.append("al");
                i += 4;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String st = "G()(al)";
        System.out.println(new Solution().interpret(st));
    }

}
