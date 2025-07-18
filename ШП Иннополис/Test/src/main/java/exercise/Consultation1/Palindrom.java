package exercise.Consultation1;


public class Palindrom {
    public static void main(String[] args) {
        String input = "довод1";
        String reversed = new StringBuilder(input)
                .reverse().toString();
        System.out.println(reversed);
        boolean isPalindrome = input.equalsIgnoreCase(reversed);
        if (isPalindrome) {
            System.out.printf("'%s' - полиндром.%n", input);
        } else {
            System.out.printf("'%s' - не полиндром.%n", input);
        }
    }
}
