package Easy._657RobotReturnToOrigin;

// Робот начинает движение в точке (0, 0), начале координат, на двумерной плоскости.
// По заданной последовательности его движений определите, окажется ли робот в точке (0, 0)
// после завершения своих движений.
//Вам дана строка moves, которая представляет собой последовательность движений робота,
// где moves[i] обозначает его ith движение.
// Допустимые движения: 'R' (вправо), 'L' (влево), 'U' (вверх) и 'D' (вниз).
//Вернитесь true если робот возвращается в исходную точку после выполнения всех своих действий,
// или falseв противном случае.
//Примечание: направление, в котором «смотрит» робот, не имеет значения.
// 'R' всегда заставляет робота двигаться вправо, 'L' всегда заставляет его двигаться влево и т. д.
// Кроме того, предположим, что величина перемещения робота при каждом движении одинакова.
// Example 1:
//Input: moves = "UD"
//Output: true
//Explanation: The robot moves up once, and then down once.
// All moves have the same magnitude, so it ended up at the origin where it started.
// Therefore, we return true.
//Example 2:
//Input: moves = "LL"
//Output: false
//Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin.
// We return false because it is not at the origin at the end of its moves.
public class Solution {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') y += 1;
            else if (move == 'D') y -= 1;
            else if (move == 'L') x -= 1;
            else if (move == 'R') x += 1;
        }
        return x == 0 && y == 0;
    }


    public static void main(String[] args) {
        String str = "UD";
        System.out.println(new Solution().judgeCircle(str));

    }

}
