package Array._435NonOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

// 435. Непересекающиеся интервалы
//Дан массив интервалов intervals где intervals[i] = [starti, endi], верните минимальное количество интервалов, которые
// нужно удалить, чтобы остальные интервалы не пересекались.
// Обратите внимание, что интервалы, которые пересекаются только в одной точке, не пересекаются.
// Например, [1, 2] и [2, 3] не пересекаются.
// Example 1:
//Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
//Example 2:
//Input: intervals = [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
//Example 3:
//Input: intervals = [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
public class Solution {
    // time O(n log n), space O(1)
    public int eraseOverlapIntervals(int[][] intervals) {
        // Сортируем интервалы по конечной точке в порядке возрастания
        Arrays.sort(intervals, Comparator.comparing(a -> a[1]));
      //Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // Инициализируем счетчик непересекающихся интервалов
        int count = 1;
        // Запоминаем конец первого интервала
        int end = intervals[0][1];

        // Проходим по всем оставшимся интервалам
        for (int i = 0; i < intervals.length; i++) {
            // Если начало текущего интервала >= конца предыдущего
            if (intervals[i][0] >= end) {
                // Увеличиваем счетчик непересекающихся интервалов
                count++;
                // Обновляем конец на текущий интервал
                end = intervals[i][1];
            }
        }
        // Общее количество интервалов минус максимальное количество непересекающихся
        return intervals.length - count;
    }



    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(new Solution().eraseOverlapIntervals(intervals));
    }
}
