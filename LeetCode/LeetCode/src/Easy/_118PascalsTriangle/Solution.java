package Easy._118PascalsTriangle;

import java.util.ArrayList;
import java.util.List;
// Для заданного целого числа numRows верните первые numRows строк треугольника Паскаля.
//В треугольнике Паскаля каждое число является суммой двух чисел, расположенных непосредственно
// над ним, как показано на рисунке:
//Example 1:
//Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//Example 2:
//Input: numRows = 1
//Output: [[1]]
public class Solution {
    // time O(n²), space - O(n²)
    public List<List<Integer>> generate(int numRows) {
        // // Создаем список для хранения строк треугольника
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {return result;}  // / Если numRows = 0, возвращаем пустой список

        result.add(new ArrayList<>(List.of(1))); // Первая строка [1]

        for (int i = 1; i < numRows; i++) { // / Начинаем со второй строки (индекс 1)
            List<Integer> previousRow = result.get(i - 1);  // Берем предыдущую строку
            List<Integer> currentRow = new ArrayList<>();   // Создаем новую строку

            currentRow.add(1); // Первый элемент всегда 1

            for (int j = 1; j < i; j++) {   // Заполняем середину строки
                                            // Суммируем два элемента из предыдущей строки
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            currentRow.add(1); // Последний элемент всегда 1

            result.add(currentRow); // Добавляем строку в результат
        }
        return result;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(new Solution().generate(numRows));
    }
}
