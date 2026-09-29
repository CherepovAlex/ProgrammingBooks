package Counting._2529MaximumCountOfPositiveIntegerAndNegativeInteger;
// 2529. Максимальное количество положительных и отрицательных целых чисел
//Дан массив nums, отсортированный в неубывающем порядке. Верните максимальное значение между количеством положительных
// и количеством отрицательных целых чисел
//Другими словами, если количество положительных целых чисел в nums равно pos, а количество отрицательных целых чисел
// равно neg, то верните максимальное значение из pos и neg.
// Обратите внимание, что 0 не является ни положительным, ни отрицательным.
// Example 1:
//Input: nums = [-2,-1,-1,1,2,3]
//Output: 3
//Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
//Example 2:
//Input: nums = [-3,-2,-1,0,0,1,2]
//Output: 3
//Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.
//Example 3:
//Input: nums = [5,20,66,1314]
//Output: 4
//Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.
public class Solution {
    // Основной метод для подсчета максимального количества положительных или отрицательных чисел
    // time O(log n), space O(1)
    public int maximumCount(int[] nums) {
        // Находим индекс первого неотрицательного числа (первого числа >= 0)
        int firstNonNegative = findFirstNonNegative(nums);

        // Находим индекс первого положительного числа (первого числа > 0)
        int firstPositive = findFirstPositive(nums);

        // Количество отрицательных чисел равно индексу первого неотрицательного числа,
        // так как все элементы до этого индекса - отрицательные (массив отсортирован)
        int negCount = firstNonNegative;

        // Количество положительных чисел равно разнице между длиной массива
        // и индексом первого положительного числа
        int posCount = nums.length - firstPositive;

        // Возвращаем максимальное из двух количеств
        return Math.max(negCount, posCount);
    }

    // Метод для бинарного поиска первого числа >= 0
    private int findFirstNonNegative(int[] nums) {
        // Устанавливаем левую границу поиска на начало массива
        int left = 0;
        // Устанавливаем правую границу поиска на конец массива (не включая)
        int right = nums.length;
        // Продолжаем поиск, пока левая граница меньше правой
        while (left < right) {
            // Находим средний индекс для предотвращения переполнения
            int mid = left + (right - left) / 2;
            // Если средний элемент >= 0, ищем в левой половине
            if (nums[mid] >=0 ){
                right = mid;
            // Если средний элемент < 0, ищем в правой половине
            } else {
                left = mid + 1;
            }
        }
        // Возвращаем индекс первого элемента >= 0
        return left;
    }

    // Бинарный поиск для нахождения первого числа > 0
    private int findFirstPositive(int[] nums) {
        // Устанавливаем левую границу поиска на начало массива
        int left = 0;
        // Устанавливаем правую границу поиска на конец массива (не включая)
        int right = nums.length;
        // Продолжаем поиск, пока левая граница меньше правой
        while (left < right) {
            // Находим средний индекс для предотвращения переполнения
            int mid = left + (right - left) / 2;
            // Если средний элемент > 0, ищем в левой половине
            if (nums[mid] > 0) {
                right = mid;
            // Если средний элемент <= 0, ищем в правой половине
            } else {
                left = mid + 1;
            }
        }
        // Возвращаем индекс первого элемента > 0
        return left;
    }
    // Ключевые моменты оптимальности:
    //Время O(log n): Используется два бинарных поиска вместо линейного обхода
    //Память O(1): Используются только константные дополнительные переменные
    //Разделение поиска: Поиск первого >=0 и первого >0 разделен, чтобы корректно обрабатывать нули
    //Предотвращение переполнения: mid = left + (right - left) / 2 вместо (left + right) / 2

    public static void main(String[] args) {
        int[] nums = {-2, -1, -1, 1, 2, 3};
        System.out.println(new Solution().maximumCount(nums));  // 3
    }
}
