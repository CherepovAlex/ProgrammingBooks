package BinarySearch._852PeakIndexInAMountainArray;
// 852. Индекс пиков в горной цепи
//Вам дан целочисленный горный массив arr длиной n, в котором значения увеличиваются до пикового элемента, а затем уменьшаются.
//Верните индекс элемента с максимальным значением.
//Ваша задача — решить её за O(log(n)) времени.
public class Solution {
    // time O(log n), space O(1)
    public int peakIndexInMountainArray(int[] arr) {
        // Инициализация левой границы поиска - начало массива
        int left = 0;
        // Инициализация правой границы поиска -конец массив
        int right = arr.length - 1;

        // Продолжаем поиск
        while (left < right) {
            // Вычисление среднего индекса между left и right
            int mid = left + (right - left) / 2;

            // Проверка: находится ли пик в правой части от mid
            if (arr[mid] < arr[mid + 1]) {
                // Пик справа, сдвигаем левую границу к mid+1
                left = mid + 1;
            } else {
                // Пик слева или в mid, свдигаем правую границу к mid
                right = mid;
            }
        }
        // Когда left == right, мы нашли индекс пиковго элемента
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0};
        System.out.println(new Solution().peakIndexInMountainArray(arr)); // 1
    }
}
