package Easy._1636SortArrayByIncreasingFrequency;

import java.util.*;

// Дан массив целых чисел nums. Отсортируйте его в по возрастанию в зависимости от частоты встречаемости значений.
// Если несколько значений встречаются одинаково часто, отсортируйте их в по убыванию.
//Верните отсортированный массив.
// Example 1:
//Input: nums = [1,1,2,2,2,3]
//Output: [3,1,1,2,2,2]
//Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
//Example 2:
//Input: nums = [2,3,1,3,2]
//Output: [1,3,3,2,2]
//Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
//Example 3:
//Input: nums = [-1,1,-6,4,5,-6,1,4,1]
//Output: [5,-1,4,4,-6,-6,1,1,1]
public class Solution {
    // time O(n + m log m), space O(n)
    public int[] frequencySort(int[] nums) {
        // собираем мап: ключ - элемент массива, значение - количество
        Map<Integer, Integer> map = new HashMap<>();

        // Подсчет частот
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        // Сортировка ключей
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            if (map.get(a) == map.get(b)){
                return b - a;   // по убыванию при равных частотах
            }
            else {
                return map.get(a) - map.get(b); // по возрастанию частот
            }
        });

        // Построение результата
        int[] result = new int[nums.length];

        int index = 0;
        // берём каждый элемент из листа
        for (int num : list) {
            // выводи его сколько у него значений
            for (int i = 0; i < map.get(num); i++) {
                result[index++] = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(new Solution().frequencySort(num)));
    }
}
