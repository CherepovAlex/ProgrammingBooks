package Arrays._10ReplaceElements;
// Замените элементы наибольшим элементом в правой части
//Дан массив arr. Замените каждый элемент этого массива на наибольший элемент среди элементов,
// расположенных справа от него, а последний элемент замените на -1. После этого верните массив.
// Пример 1:
//Входные данные: arr = [17,18,5,4,6,1]
//Выходные данные: [18,6,6,6,1,-1]
// Пример 2:
//Входные данные: arr = [400]
//Выходные данные: [-1]

import java.util.Arrays;

public class Solution10 {
    // time O(n*n), space - O(1)
    public int[] replaceElements(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            arr[i] = max;
        }
        arr[len - 1] = -1;
        return arr;
    }
    // time O(n), space - O(1)
    public int[] replaceElements2(int[] arr) {
        int maxRight = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = maxRight;
            if (current > maxRight) {
                maxRight = current;
            }
        }
        return arr;
    }


    public static void main(String[] args) {

        int[] array = {17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(new Solution10().replaceElements(array)));
        int[] array2 = {17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(new Solution10().replaceElements2(array2)));

    }
}
