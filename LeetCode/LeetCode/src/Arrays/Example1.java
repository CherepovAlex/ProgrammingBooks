package Arrays;

public class Example1 {

    public static void main(String[] args) {

        int[] squareNumbers = new int[10];

        // Go through each of the Array indexes, from 0 to 9.
        for (int i = 0; i < 10; i++) {
            // We need to be careful with the 0-indexing. The next square number
            // is given by (i + 1) * (i + 1).
            // Calculate it and insert it into the Array at index i.
            int square = (i + 1) * (i + 1);
            squareNumbers[i] = square;
        }

        // Go through each of the Array indexes, from 0 to 9.
        for (int i = 0; i < 10; i++) {
            // Access and print what's at the i'th index.
            System.out.println(squareNumbers[i]);
        }

        // Will print:
        // 1
        // 4
        // 9
        // 16
        // 25
        // 36
        // 49
        // 64
        // 81
        // 100

        // For each VALUE in the Array.
        for (int square : squareNumbers) {
            // Print the current value of square.
            System.out.println(square);
        }
        // Prints exactly the same as the previous example.

        // Create a new array with a capacity of 6.
        int[] array = new int[6];

        // Current length is 0, because it has 0 elements.
        int length = 0;

        // Add 3 items into it.
        for (int i = 0; i < 3; i++) {
            array[i] = i * i;
            // Each time we add an element, the length goes up by one.
            length++;
        }

        System.out.println("The Array has a capacity of " + array.length);  // 6
        System.out.println("The Array has a length of " + length);          // 3

    }
}
