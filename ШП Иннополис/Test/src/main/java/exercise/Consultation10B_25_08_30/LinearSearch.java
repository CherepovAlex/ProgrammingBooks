package exercise.Consultation10B_25_08_30;

public class LinearSearch {
    // линейный алгоритм поиска
    public static int line(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int target = 4;
        System.out.println("index : " + LinearSearch.line(arr, target));
    }
}
