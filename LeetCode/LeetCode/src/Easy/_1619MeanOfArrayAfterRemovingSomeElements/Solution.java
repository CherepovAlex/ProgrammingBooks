package Easy._1619MeanOfArrayAfterRemovingSomeElements;

import java.util.Arrays;

// Дан целочисленный массив arr.
// Верните среднее арифметическое оставшихся целых чисел после удаления
// наименьшего 5% и наибольшего 5% элементов.
//Ответы в пределах 10-5 от фактического ответа будут считаться принятыми.
// Example 1:
//Input: arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
//Output: 2.00000
//Explanation: After erasing the minimum and the maximum values of this array, all elements are equal to 2, so the mean is 2.
//Example 2:
//Input: arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
//Output: 4.00000
//Example 3:
//Input: arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]
//Output: 4.77778
public class Solution {
    // time O(n log n) - из-за сортировки, space O(1)
    public double trimMean(int[] arr) {
        int len = arr.length;   // Получаем длину массива
        Arrays.sort(arr);       // Сортируем массив по возрастанию

        double limit = 0.05 * len;  // Вычисляем 5% от длины массива
        int start = (int) limit;    // Начальный индекс (отбрасываем первые 5%)
        int end = len - (int) limit; // Конечный индекс (отбрасываем последние 5%)

        double sum = 0, newLength = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];      // Суммируем оставшиеся элементы
            newLength++;        // Считаем количество оставшихся элементов
        }
        return sum / newLength; // Возвращаем среднее арифметическое
    }

    // time O(n log n) - из-за сортировки, space O(1)
    public double trimMean2(int[] arr) {
        int len = arr.length;   // Получаем длину массива
        Arrays.sort(arr);       // Сортируем массив по возрастанию

        // Вычисляем количество элементов для удаления с каждой стороны
        int elementsToRemove = (int) Math.round(len * 0.05);

        // Убеждаемся, что мы удаляем хотя бы по одному элементу с каждой стороны
        // (для очень маленьких массивов)
        elementsToRemove = Math.max(elementsToRemove, 1);

        int start = elementsToRemove;    // Начальный индекс (отбрасываем первые 5%)
        int end = len - elementsToRemove; // Конечный индекс (отбрасываем последние 5%)

        if (start >= end) { // Проверка на случай, если массив слишком маленький
            double sum = 0;
            for (int num : arr) {
                sum += num;      // Суммируем оставшиеся элементы
            }
            return sum / len; // Возвращаем среднее арифметическое
        }

        double sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum / (end - start);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        System.out.println(new Solution().trimMean(arr));
    }
}
