package Arrays;

public class Example2_AddElements {

    public static void main(String[] args) {
        // Declare an integer array of 6 elements
        int[] intArray = new int[6];
        int length = 0;

        // Add 3 elements to the Array
        for (int i = 0; i < 3; i++) {
            intArray[length] = i;
            length++;
        }

        intArray[length] = 10;
        length++;

        for (int i = 3; i >= 0; i--) {
            intArray[i + 1] = intArray[i];
        }
        intArray[0] = 20;

        for (int i = 4; i >= 2; i--) {
            // Shift each element one position to the right.
            intArray[i + 1] = intArray[i];
        }
        intArray[2] = 30;

        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Index " + i + " contains " + intArray[i]);
        }

    }

}