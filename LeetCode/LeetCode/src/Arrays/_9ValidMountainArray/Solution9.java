package Arrays._9ValidMountainArray;
// Дан массив целых чисел arr. Верните true, если и только если это допустимый массив гор.
// Напомним, что arr является горным массивом тогда и только тогда, когда: arr.length >= 3
//Существует некоторый i с 0 < i < arr.length - 1 такой, что:
//arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

public class Solution9 {
    // time O(n), space - O(1)
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (arr.length < 3) {return false;}

        int i = 0;

        // go up to mountain
        while (i < n - 1 && arr[i] < arr[i+1]) {
            i++;
        }

        // if i - 0 or n-1 -> not mountain
        if (i == 0 || i == n - 1) {return false;}

        //go down
        while (i < n - 1 && arr[i] > arr[i+1]) {
            i++;
        }

        return i == n - 1;
    }


    public static void main(String[] args) {
        int[] arr1 = {2, 1};
        int[] arr2 = {3, 5, 5};
        int[] arr3 = {0, 3, 2, 1};
        System.out.println(new Solution9().validMountainArray(arr1));
        System.out.println(new Solution9().validMountainArray(arr2));
        System.out.println(new Solution9().validMountainArray(arr3));
    }
}
