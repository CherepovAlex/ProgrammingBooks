package Easy._941ValidMountainArray;

//Дан массив целых чисел arr. Верните true, если и только если это допустимый массив гор.
//Напомним, что arr является горным массивом тогда и только тогда, когда: arr.length >= 3
//Существует некоторый i с 0 < i < arr.length - 1 такой, что:
//arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//Example 1:
//Input: arr = [2,1]
//Output: false
//Example 2:
//Input: arr = [3,5,5]
//Output: false
//Example 3:
//Input: arr = [0,3,2,1]
//Output: true
public class Solution {
    // time (n), space O(1)
    public boolean validMountainArray(int[] arr) {
        // Проверка минимальной длины или пустой
        if (arr == null || arr.length < 3) return false;
        int i = 0;
        int len = arr.length;
        // go up to mountain
        // Ищем вершину горы, двигаясь слева направо, пока элементы возрастают.
        while (i < len - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        // if i - 0 or n-1 -> not mountain
        // Если вершина на краю массива - это не гора
        if (i == 0 || i == len - 1) {
            return false;
        }

        //go down
        // После вершины должны идти строго убывающие элементы.
        while (i < len - 1 && arr[i] > arr[i + 1]) {
            i++;
        }
        // проверяем, что дошли до конца массива при спуске (не было "плато" или подъема).
        return i == len - 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0};
        System.out.println(new Solution().validMountainArray(arr));
    }
}
