package exercise;

import java.util.ArrayList;

class App {
    // BEGIN
    public static int getLongestLength(String str) {
        var sequence = new ArrayList<Character>();
        var maxLength = 0;

        for (var currentChar : str.toCharArray()) {
            var index = sequence.indexOf(currentChar);
            sequence.add(currentChar);

            if (index != -1) {
                sequence.subList(0, index + 1).clear();
            }
            System.out.println(sequence.toString());
            int sequenceLength = sequence.size();
            if (sequenceLength > maxLength) {
                maxLength = sequenceLength;
            }
        }

        return maxLength;
    }
    // END

    public static void main(String[] args) {
        System.out.println(App.getLongestLength("abcdeef")); // 5
        System.out.println(App.getLongestLength("jabjcdel")); // 7
        System.out.println(App.getLongestLength("")); // 0
    }
}
