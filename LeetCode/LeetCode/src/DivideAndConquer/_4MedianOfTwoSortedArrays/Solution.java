package DivideAndConquer._4MedianOfTwoSortedArrays;

// 4. Медиана двух отсортированных массивов
//Даны два отсортированных массива nums1 и nums2 размером m и n соответственно.
// Верните медиану двух отсортированных массивов.
//Общая временная сложность должна быть O(log (m+n)).
// Example 1:
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
//Example 2:
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// Constraints:
//nums1.length == m
//nums2.length == n
//0 <= m <= 1000
//0 <= n <= 1000
//1 <= m + n <= 2000
//-106 <= nums1[i], nums2[i] <= 106
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Гарантируем, что nums1 будет меньшим массивом для оптимизации
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;  // Длина первого (меньшего) массива
        int n = nums2.length;  // Длина второго (большего) массива
        int left = 0;          // Левая граница для бинарного поиска
        int right = m;         // Правая граница для бинарного поиска

        // Бинарный поиск позиции разделения в меньшем массиве
        while (left <= right) {
            // Находим точку разделения в первом массиве (сколько элементов взять из nums1)
            int partition1 = left + (right - left) / 2;  // Избегаем переполнения
            // Вычисляем точку разделения во втором массиве
            int partition2 = (m + n + 1) / 2 - partition1;

            // Обрабатываем крайние случаи для левых частей
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];

            // Обрабатываем крайние случаи для правых частей
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            // Проверяем, нашли ли мы правильное разделение
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Вычисляем медиану в зависимости от общей длины
                if ((m + n) % 2 == 1) {
                    // Нечетная общая длина: медиана - максимум из левых частей
                    return Math.max(maxLeft1, maxLeft2);
                } else {
                    // Четная общая длина: медиана - среднее между максимумом левых и минимумом правых
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            }
            // Если maxLeft1 слишком велик, двигаем разделение влево
            else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            }
            // Если maxLeft2 слишком велик, двигаем разделение вправо
            else {
                left = partition1 + 1;
            }
        }

        // Эта строка никогда не должна быть достигнута для корректных входных данных
        throw new IllegalArgumentException("Входные массивы не отсортированы");
    }

    //Объяснение подхода:
    //Алгоритм:
    //Условие корректного разделения: Для двух отсортированных массивов, разделенных в позициях partition1 и partition2, медиана находится, когда:
    //maxLeft1 <= minRight2 (максимальный элемент левой части nums1 ≤ минимального элемента правой части nums2)
    //maxLeft2 <= minRight1 (максимальный элемент левой части nums2 ≤ минимального элемента правой части nums1)
    //Формула для partition2: partition2 = (m + n + 1) / 2 - partition1
    //(m + n + 1) / 2 гарантирует, что левая часть всегда содержит столько же или на 1 элемент больше
    //Преимущества:
    //Время: O(log(min(m,n))) - бинарный поиск по меньшему массиву
    //Память: O(1) - используем только несколько переменных
    //Не требует слияния массивов - работаем только с индексами
    //Ключевые моменты:
    //Всегда работаем с меньшим массивом как с nums1
    //Используем Integer.MIN_VALUE и Integer.MAX_VALUE для обработки краевых случаев
    //Формула для медианы отличается для четного и нечетного количества элементов

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}
