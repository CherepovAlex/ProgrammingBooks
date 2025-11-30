package Counting._169MajorityElement;

import java.util.HashMap;
import java.util.Map;

// Задача 169. Элемент c большим наличием
// Дан массив nums размером n, верните элемент c большим наличием
// Элемент, встречающийся чаще всего, — это элемент, который встречается более ⌊n / 2⌋ раз.
// Можно предположить, что элемент, встречающийся чаще всего, всегда присутствует в массиве.
// Example 1:
//Input: nums = [3,2,3]
//Output: 3
//Example 2:
//Input: nums = [2,2,1,1,1,2,2]
//Output: 2
public class Solution {
    // time O(n) - один проход по массиву, space O(n) - - только две переменные, решение с HashMap
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int majority = nums.length / 2;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majority) {
                result = entry.getKey();
            }
        }
        return result;
    }

    // Использует алгоритм Бойера-Мура как наиболее оптимальный
    // по времени time O(n) - один проход по массиву, по памяти space O(1) - - только две переменные
    public int majorityElement1(int[] nums) {
        // Инициализируем счетчик и кандидата
        int count = 0;
        Integer candidate = null;
        // Проходим по всем элементам массива
        for (int num : nums) {
            // Если счетчик равен 0, выбираем нового кандидата
            if (count == 0) {
                candidate = num;
            }
            // Увеличиваем счетчик, если текущий элемент равен кандидату, иначе уменьшаем
            count += (num == candidate) ? 1 : -1;
        }
        // Возвращаем кандидата (по условию задачи он всегда существует)
        return candidate;
    }
    // Принцип работы:
    // - "Отменяем" пары разных элементов
    // - Элемент-большинство останется в конце, т.к. его больше половины
    // Ключевые преимущества:
    //Не требует дополнительной памяти (в отличие от HashMap)
    //Один проход по данным
    //Простая реализация
    //Гарантированно работает при наличии элемента-большинства

    // Альтернативное решение с HashMap (более понятное, но требует O(n) памяти)
    // Time: O(n), Space: O(n)
    public int majorityElement3(int[] nums) {
        // Создаем HashMap для подсчета частот элементов
        Map<Integer, Integer> map = new HashMap<>();

        // Проходим по массиву и подсчитываем частоты
        for (int num : nums) {
            // Используем метод merge для компактного подсчета
            map.merge(num, 1, Integer::sum);
        }
        // Вычисляем пороговое значение (больше n/2)
        int majority = nums.length / 2;

        // Ищем элемент, частота которого превышает порог
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majority) {
                return entry.getKey(); // ранний возврат
            }
        }
        return -1; // никогда не выполнится по условию задачи
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        System.out.println(new Solution().majorityElement(nums));
        int[] nums1 = new int[]{1};
        System.out.println(new Solution().majorityElement(nums1));
    }
}
