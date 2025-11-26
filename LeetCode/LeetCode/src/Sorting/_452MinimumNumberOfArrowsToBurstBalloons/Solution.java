package Sorting._452MinimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

// 452. Минимальное количество стрел для взрыва воздушных шаров
// На плоской стене, представляющей собой плоскость XY, прикреплены несколько сферических воздушных шаров.
// Шары представлены в виде двумерного целочисленного массива points, где points[i] = [xstart, xend] обозначает шар,
// горизонтальный диаметр которого находится в диапазоне от xstart до xend. Точные координаты шаров по оси Y вам неизвестны.
//Стрелы можно пускать прямо вертикально (в положительном направлении оси Y) из разных точек на оси X.
// Воздушный шар с xstart и xend лопается от стрелы, выпущенной в x, если xstart <= x <= xend.
// Количество стрел, которые можно выпустить, не ограничено. Выпущенная стрела продолжает бесконечно подниматься вверх,
// лопая все воздушные шары на своем пути.
//Учитывая массив points, верните минимальное количество стрелок, которые необходимо выпустить, чтобы лопнули все воздушные шары.
// Example 1:
//Input: points = [[10,16],[2,8],[1,6],[7,12]]
//Output: 2
//Explanation: The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
//- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
//Example 2:
//Input: points = [[1,2],[3,4],[5,6],[7,8]]
//Output: 4
//Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
//Example 3:
//Input: points = [[1,2],[2,3],[3,4],[4,5]]
//Output: 2
//Explanation: The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
//- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
public class Solution {
    public int findMinArrowShots(int[][] points) {
        // Если шаров нет, стрел не нужно
        if (points.length == 0) return 0;

        // Сортируем шары по восрастанию xend (правого края)
        Arrays.sort(points, Comparator.comparing(a -> a[1]));

        // Инициализируем позицию первой стрелы в правом конце первого шара
        int arrowPos = points[0][1];

        // Начинаем с одной стрелы
        int arrowCount = 1;

        // Проходим по всем шарам, начиная со второго
        for (int i = 1; i < points.length; i++) {
            // Если текущий шар начинается после позиции стрелы, он не будет лопнут
            if (points[i][0] > arrowPos) {
                // Нужна новая стрела
                arrowCount++;
                // Обновляем позицию стрелы на правый конец текущего шара
                arrowPos = points[i][1];
            }
            // Иначе текущий шар лопнет от текущей стрелы (arrowPos внутри [xstart, xend] или в xend)
            // Ничего не делаем
        }
        return arrowCount;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7,12}};
        System.out.println(new Solution().findMinArrowShots(points)); // 2
    }
}
