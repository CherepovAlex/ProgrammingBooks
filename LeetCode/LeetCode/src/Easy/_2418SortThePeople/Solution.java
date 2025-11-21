package Easy._2418SortThePeople;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 2418. Распределите людей
//Вам дан массив строк names и массив heights, состоящий из различных положительных целых чисел. Оба массива имеют длину n.
//Для каждого индекса i names[i] и heights[i] обозначают имя и рост i-го человека.
//Вернуть names отсортировать по убыванию по росту людей.
// Example 1:
//Input: names = ["Mary","John","Emma"], heights = [180,165,170]
//Output: ["Mary","Emma","John"]
//Explanation: Mary is the tallest, followed by Emma and John.
//Example 2:
//Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
//Output: ["Bob","Alice","Bob"]
//Explanation: The first Bob is the tallest, followed by Alice and the second Bob.
public class Solution {
    // time O(n log n), space O(n)
    public String[] sortPeople(String[] names, int[] heights) {
        // Создаём массив для хранения пар (рост, имя)
        int[][] people = new int[names.length][2];

        // Заполняем массив парами: индекс 0 - рост, индекс 1 - исходный индекс
        for (int i = 0; i < names.length; i++) {
            people[i][0] = heights[i];  // Сохраняем рост
            people[i][1] = i;           // Сохраняем исходный индекс для доступа к имени
        }

        // Сортируем пары по убыванию роста (сравниваем первый элемент каждой пары
        Arrays.sort(people, (a, b) -> b[0] - a[0]);

        // Создаём результирующий массив для отсортированных имен
        String[] result = new String[names.length];

        // Заполняем результат именами в порядке убывания роста
        for (int i = 0; i < names.length; i++) {
            result[i] = names[people[i][1]]; // Берём имя по сохранённому индексу
        }
        return result;
    }

    public String[] sortPeople2(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        String[] sortedNames = new String[names.length];
        int index = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            sortedNames[index++] = map.get(heights[i]);
        }
        return sortedNames;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortPeople(
                new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
        System.out.println(Arrays.toString(new Solution().sortPeople2(
                new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
    }
}
