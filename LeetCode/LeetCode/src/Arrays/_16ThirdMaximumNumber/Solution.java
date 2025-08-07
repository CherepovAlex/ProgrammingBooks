package Arrays._16ThirdMaximumNumber;

import java.util.TreeSet;

// Дан целочисленный массив nums. Верните третье по величине число в этом массиве.
// Если третьего по величине числа нет, верните максимальное число.
// Example 1:
//Input: nums = [3,2,1]
//Output: 1
//Explanation:
//The first distinct maximum is 3.
//The second distinct maximum is 2.
//The third distinct maximum is 1.
//Example 2:
//Input: nums = [1,2]
//Output: 2
//Explanation:
//The first distinct maximum is 2.
//The second distinct maximum is 1.
//The third distinct maximum does not exist, so the maximum (2) is returned instead.
//Example 3:
//Input: nums = [2,2,3,1]
//Output: 1
//Explanation:
//The first distinct maximum is 3.
//The second distinct maximum is 2 (both 2's are counted together since they have the same value).
//The third distinct maximum is 1.
public class Solution {
    // time O(n), space O(1)
    public int thirdMax(int[] nums) {
        // фиксируем где будем хранить числа
        Integer firstMax = null;
        Integer preMax = null;
        Integer prePreMax = null;
        // идём по массиву: ищем максимальное, предмаскимальное, предпредмаксимальное
        for (Integer num : nums) {
            // пропускаем дубликаты
            if (num.equals(firstMax) || num.equals(preMax) || num.equals(prePreMax)) {
                continue;
            }
            // Обновляем значение
            if (firstMax == null || num > firstMax) {
                prePreMax = preMax;
                preMax = firstMax;
                firstMax = num;
            } else if (preMax == null || num > preMax) {
                prePreMax = preMax;
                preMax = num;
            } else if (prePreMax == null || num > prePreMax) {
                prePreMax = num;
            }
        }
        // проверяем заполнено ли треть максимальное
        return prePreMax != null ? prePreMax : firstMax;
    }

    // time O(n log 3) ≈ O(n), space O(1)
    public int thirdMax2(int[] nums) {
        // Используем TreeSet для автоматической сортировки и удаления дубликатов
        TreeSet<Integer> set = new TreeSet<>();
        // добавляем элементы в множество
        for (int num : nums) {
            set.add(num);
            // Держим только 3 максимальных элемента
            if (set.size() > 3) {
                set.remove(set.first()); // удаляем наименьший
            }
        }
        // Если есть 3 уникальных числа, возвращаем минимальное из них (третье по величине)
        // Иначе возвращаем максимальное
        return set.size() >= 3 ? set.first() : set.last();
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 1}; // 1
        int[] nums2 = new int[]{1, 2};   // 2
        int[] nums3 = new int[]{2, 2, 3, 1}; // 1
        System.out.println(new Solution().thirdMax(nums1));
        System.out.println(new Solution().thirdMax(nums2));
        System.out.println(new Solution().thirdMax(nums3));
    }
}
