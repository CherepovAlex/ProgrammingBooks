package exercise;

import java.util.ArrayList;
import java.util.List;

class App {
    // BEGIN
    private static String getRangeOfSequence(List<Integer> sequence) {
        int first = sequence.get(0);
        int last = sequence.get(sequence.size() - 1);
        return first + "->" + last;
    }

    public static List<String> summaryRanges(List<Integer> numbers) {
        var size = numbers.size();
        var ranges = new ArrayList<String>();
        var sequence = new ArrayList<Integer>();

        for (int index = 0; index < size; index++) {
            int current = numbers.get(index);

            sequence.add(current);

            int nextIndex = index + 1;

            if (nextIndex == size || (current + 1 != numbers.get(nextIndex))) {
                if (sequence.size() > 1) {
                    var range = getRangeOfSequence(sequence);
                    ranges.add(range);
                }
                sequence.clear();
            }
        }
        return ranges;
    }
    // END

    public static void main(String[] args) {

        var ranges1 = App.summaryRanges(new ArrayList<Integer>());
        System.out.println(ranges1); // => []

        var ranges2 = App.summaryRanges(List.of(1));
        System.out.println(ranges2); // []

        var ranges3 = App.summaryRanges(List.of(1, 2, 3));
        System.out.println(ranges3); // [1->3]

        var ranges4 = App.summaryRanges(List.of(0, 1, 2, 4, 5, 7));
        System.out.println(ranges4); // [0->2, 4->5]

        var ranges5 = App.summaryRanges(List.of(110, 111, 112, 111, -5, -4, -2, -3, -4, -5));
        System.out.println(ranges5); // [110->112, -5->-4]

    }
}
