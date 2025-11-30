package Sorting._217ContainsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 217. Содержит дубликаты
// Для заданного целочисленного массива nums верните true, если какое-либо значение встречается
// в массиве как минимум дважды, и верните false, если все элементы различны.
// Example 1:
//Input: nums = [1,2,3,1]
//Output: true
//Explanation:
//The element 1 occurs at the indices 0 and 3.
//Example 2:
//Input: nums = [1,2,3,4]
//Output: false
//Explanation:
//All elements are distinct.
//Example 3:
//Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true
public class Solution {
    // Основной метод проверки на наличие дубликатов
    // time O(n), space O(n) - самая ранняя остановка при нахождении дубликата
    public boolean containsDuplicate(int[] nums) {
        // Проверка на null и массивы длиной 0 или 1 элемент
        if (nums == null || nums.length <= 1) {
            return false; // В таких массивах дубликатов быть не может
        }
        // Создаем HashSet для хранения уникальных элементов
        Set<Integer> set = new HashSet<>();
        // Проходим по всем элементам массива
        for (int num : nums) {
            // Пытаемся добавить элемент в set. Метод add возвращает false если элемент уже существует
            if (!set.add(num)) {    // return boolean
                return true;    // Найден дубликат - сразу возвращаем true
            }
        }
        return false; // Если дошли до конца - дубликатов нет
    }
     // Альтернативный метод с явной проверкой contains
     // time O(n), space O(n) - но делает две операции с HashSet вместо одной
    public boolean containsDuplicate1(int[] nums) {
        // Создаем HashSet для хранения увиденных элементов
        HashSet<Integer> set = new HashSet<>();
        // Проходим по массиву по индексам
        for (int i = 0; i < nums.length; i++) {
            // Проверяем, содержится ли текущий элемент уже в set
            if (set.contains(nums[i])) return true; // Если да - возвращаем true
            set.add(nums[i]);   // Добавляем элемент в set
        }
        return false; // Дубликатов не найдено
    }
    // Метод с сортировкой - использует меньше памяти но больше времени
    // time O(n log n), O(1) память (если сортировка на месте)
    // хуже по времени но лучше по памяти для больших массивов
    public boolean containsDuplicate2(int[] nums) {
        // Сортируем массив - одинаковые элементы окажутся рядом
        Arrays.sort(nums);
        // Проходим по отсортированному массиву, сравнивая соседние элементы
        for (int i = 0; i < nums.length - 1; i++) {
            // Если текущий элемент равен следующему - найден дубликат
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;   // Дубликатов нет
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(new Solution().containsDuplicate(nums));
        int[] nums1 = new int[]{1, 2, 3, 4};
        System.out.println(new Solution().containsDuplicate(nums1));
    }
}
