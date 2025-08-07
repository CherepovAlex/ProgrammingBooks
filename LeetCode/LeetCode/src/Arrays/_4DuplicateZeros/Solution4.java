package Arrays._4DuplicateZeros;

import java.util.Arrays;

public class Solution4 {

    public void duplicateZeros(int[] arr) {

        // version 2 O(n)
        int zeroCount = 0;
        int length = arr.length;

        // Counting number of 0
        for (int num : arr) {
            if (num == 0) zeroCount++;
        }

        // if no 0, then exit
        if (zeroCount == 0) return;

        // go from end and copy elements
        int i = length - 1;
        int j = length + zeroCount - 1;

        while (i >= 0 && j >= 0) {
            if (arr[i] == 0) {
                if (j < length) {
                    arr[j] = 0;
                }
                j--;
                if (j < length) {
                    arr[j] = 0;
                }
            } else {
                if (j < length) {
                    arr[j] = arr[i];
                }
            }
            i--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        new Solution4().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1, 2, 3};
        new Solution4().duplicateZeros(arr1);
        System.out.println(Arrays.toString(arr1));
    }

}
