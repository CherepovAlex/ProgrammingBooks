package Arrays;

import java.util.Arrays;

public class Example5_EvenElements {
    // space O(length) - non effective
    public int[] squareEven(int[] array, int length) {
        // Check for edge cases.
        if (array == null) {
            return null;
        }
        // Create a resultant Array which would hold the result.
        int[] result = new int[length];
        // Iterate through the original Array.
        for (int i = 0; i < length; i++) {
            // Get the element from slot i of the input Array.
            int element = array[i];
            // If the index is an even number, then we need to square element.
            if (i % 2 == 0) {
                element *= element;
            }
            // Write element into the result Array.
            result[i] = element;
        }

        // Return the result Array.
        return result;
    }

    public int[] squareEven2(int[] array, int length) {
        // Check for edge cases.
        if (array == null) {
            return array;
        }
        // Iterate through even elements of the original array.
        // Notice how we don't need to do *anything* for the odd indexes? :-)
        for (int i = 0; i < length; i += 2) {
            // Index is an even number, so we need to square the element
            // and replace the original value in the Array.
            array[i] *= array[i];
        }
        // We just return the original array. Some problems on leetcode require you
        // to return it, and other's don`t.
        return array;
    }

    public static void main(String[] args) {
        int[] array = {9, -2, -9, 11, 56, -12, -3};
        System.out.println(Arrays.toString(new Example5_EvenElements().squareEven(array, 7)));
        System.out.println(Arrays.toString(new Example5_EvenElements().squareEven2(array, 7)));
    }
}
