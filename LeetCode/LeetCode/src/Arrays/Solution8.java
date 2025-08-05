package Arrays;

import java.util.HashSet;
import java.util.Set;

public class Solution8 {
    // time O(n*n)
    public boolean checkIfExist(int[] arr) {
        if (arr == null || arr.length == 0) return false;

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // time O(n) space O(n)
    public boolean checkIfExist2(int[] arr) {
        if (arr == null || arr.length == 0) return false;

        Set<Integer> seen = new HashSet<>();

        for(int num : arr) {
            if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {10,2,5,3};
        int[] arr2 = {3,1,7,11};
        System.out.println(new Solution8().checkIfExist(arr1));
        System.out.println(new Solution8().checkIfExist(arr2));
    }

}
