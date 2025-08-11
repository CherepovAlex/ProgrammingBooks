package Easy._1051HeightChecker;
import java.util.Arrays;
//Школа пытается сделать ежегодную фотографию всех учеников.
// Учеников просят выстроиться в одну шеренгу в порядке возрастания по росту.
// Пусть этот порядок будет представлен целочисленным массивом expected,
// где expected[i] — ожидаемый рост ith-го ученика в шеренге.
//Вам дан целочисленный массив heights, представляющий собой текущий порядок,
// в котором стоят ученики. Каждый heights[i] — это рост ith ученика в очереди (нумерация с нуля).
//Верните the количество индексов where heights[i] != expected[i].
//Example 1:
//Input: heights = [1,1,4,2,1,3]
//Output: 3
//Explanation:
//heights:  [1,1,4,2,1,3]
//expected: [1,1,1,2,3,4]
//Indices 2, 4, and 5 do not match.
//Example 2:
//Input: heights = [5,1,2,3,4]
//Output: 5
//Explanation:
//heights:  [5,1,2,3,4]
//expected: [1,2,3,4,5]
//All indices do not match.
//Example 3:
//Input: heights = [1,2,3,4,5]
//Output: 0
//Explanation:
//heights:  [1,2,3,4,5]
//expected: [1,2,3,4,5]
//All indices match.
public class Solution {
    public int heightChecker(int[] heights) {
        // копируем текущий массив в новый expected
        int[] expected = Arrays.copyOf(heights, heights.length);

        // сортируем expected
        Arrays.sort(expected);

        // Считаем несовпадения
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num1 = new int[] {1,1,4,2,1,3};
        System.out.println(new Solution().heightChecker(num1));
    }
}
