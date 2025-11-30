package HashTable._219ContainsDuplicateII;

import java.util.HashMap;
import java.util.Map;

// 219. Содержит дубликат II
// Дан целочисленный массив nums и целое число k.
// Верните true если есть два различных индекса i и j в массиве таких,
// что nums[i] == nums[j] и abs(i - j) <= k.
// Example 1:
//Input: nums = [1,2,3,1], k = 3
//Output: true
//Example 2:
//Input: nums = [1,0,1,1], k = 1
//Output: true
//Example 3:
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
public class Solution {
    // time O(n), space O(n) - временная сложность O(n), пространственная O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Создаем хэш-таблицу для хранения чисел и их последних индексов
        Map<Integer, Integer> map = new HashMap<>();
        // Проходим по всем элементам массива
        for (int i = 0; i < nums.length; i++) {
            // Проверяем, есть ли текущее число в хэш-таблице И
            // расстояние между текущим индексом и последним сохраненным индексом <= k
            if (map.containsKey(nums[i]) && abs(i - map.get(nums[i])) <= k) {
                // Если условие выполняется, возвращаем true
                return true;
            }
            // Обновляем хэш-таблицу: сохраняем текущее число с его индексом
            // (перезаписываем предыдущее значение, если оно было)
            map.put(nums[i], i);
        }
        // Если не нашли подходящих дубликатов, возвращаем false
        return false;
    }
    // Вспомогательный метод для вычисления модуля числа
    private int abs(int x) {
        return x < 0 ? -x : x;
    }
    // Ключевые особенности оптимального решения:
    //Временная сложность O(n) - один проход по массиву
    //Пространственная сложность O(n) - хэш-таблица хранит до n элементов
    //Алгоритм скользящего окна - храним только последний встреченный индекс для каждого числа
    //Ранний выход - возвращаем true сразу при нахождении подходящей пары

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().containsNearbyDuplicate(nums, 3));
        int[] nums1 = {1, 2, 3, 1, 2, 3};
        System.out.println(new Solution().containsNearbyDuplicate(nums1, 2));
    }

}
