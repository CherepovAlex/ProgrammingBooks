package Array._16_3SumClosest;

import java.util.Arrays;
// 16. Ближайшая целевая сумма 3х элементов.
// Дан целочисленный массив nums длиной n и целое число target.
// Найдите три целых числа в nums, сумма которых наиболее близка к target.
//Верните сумму трёх целых чисел.
//Можно предположить, что для каждого набора входных данных существует ровно одно решение.
// Example 1:
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//Example 2:
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1]; // может вызвать ArrayIndexOutOfBoundsException для массивов длиной меньше 3
        Arrays.sort(nums);      // сортировка необходима для алгоритма двух указателей

        for (int i = 0; i < nums.length - 2; i++) { // внешний цикл для первого числа тройки
            int a_pointer = i + 1;
            int b_pointer = nums.length - 1;

            while (a_pointer < b_pointer) {
                int current_sum = nums[i] + nums[a_pointer] + nums[b_pointer];

                if (current_sum > target) { // неполная логика. Нужно уменьшать правый указатель при сумме > target
                    b_pointer -= 1;         // и увеличивать левый при сумме < target
                } else {
                    a_pointer += 1;
                }

                if (Math.abs(current_sum - target) < Math.abs(result - target)) {
                    result = current_sum;
                }
            }
        }
        return result;
    }

    // Оптимизации:
    //Сортировка массива для возможности использования двух указателей
    //Пропуск дубликатов для уменьшения количества проверок
    //Немедленный возврат при точном совпадении с target

    // time O(n*n), внешний цикл O(n) и внутренний цикл с двумя указателями O(n)
    // space O(1), используем только константное количество дополнительной памяти
    public int threeSumClosest1(int[] nums, int target) {
        // Проверка на корректность входных данных: массив содержит как минимум 3 элемента
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Array must contain at least 3 elements");
        }
        // Сортируем массив для возможности использования алгоритма двух указателей
        Arrays.sort(nums);  // [-1, 2, 1, -4] -> [-4, -1, 1, 2]

        // Инициализируем начальное значение ближайшей суммы
        // Берем сумму первых трех элементов как начальное приближение
        int closestSum = nums[0] + nums[1] + nums[2];

        // Внешний цикл: перебираем все возможные первые элементы тройки
        for (int i = 0; i < nums.length - 2; i++) {

            // Оптимизация: пропускаем дубликаты для первого элемента
            // Если текущий элемент равен предыдущему, переходим к следующему
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Инициализируем два указателя:
            // left - следующий элемент после i
            // right - последний элемент массива
            int left = i + 1;
            int right = nums.length - 1;

            // Внутренний цикл: ищем пару для nums[i] используя два указателя
            while (left < right) {
                // Вычисляем текущую сумму трех элементов
                int currentSum = nums[i] + nums[left] + nums[right];

                // Если нашли точное совпадение с target - возвращаем сразу
                // Это оптимально, так как лучше суммы быть не может
                if (currentSum == target) {
                    return currentSum;
                }

                // Проверяем, является ли текущая сумма ближе к target
                // чем ранее найденная ближайшая сумма
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum; // Обновляем ближайшую сумму
                }

                // Логика движения указателей:
                if (currentSum < target) {
                    // Если сумма меньше target, нужно увеличить сумму
                    left++; // Двигаем левый указатель вправо (к большим числам)
                    // Пропускаем дубликаты слева для оптимизации
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    // Если сумма больше target, нужно уменьшить сумму
                    right--; // Двигаем правый указатель влево (к меньшим числам)

                    // Пропускаем дубликаты справа для оптимизации
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return closestSum; // Возвращаем найденную ближайшую сумму
    }
    //Итоговый Алгоритм:
    //Сортируем массив
    //Фиксируем первый элемент тройки
    //Для оставшихся элементов используем два указателя для поиска оптимальной пары
    //Сравниваем текущую сумму с target и двигаем указатели соответственно
    //Обновляем ближайшую сумму при нахождении более близкого варианта

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new Solution().threeSumClosest(nums, target));
    }
}
