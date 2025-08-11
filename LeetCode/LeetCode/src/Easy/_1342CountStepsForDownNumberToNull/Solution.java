package Easy._1342CountStepsForDownNumberToNull;
// Для заданного целого числа num верните количество шагов, необходимых для уменьшения его до нуля.
//Если текущее число чётное, то за один шаг его нужно разделить на 2, в противном случае из него нужно вычесть 1.
//Example 1:
//Input: num = 14
//Output: 6
//Explanation:
//Step 1) 14 is even; divide by 2 and obtain 7.
//Step 2) 7 is odd; subtract 1 and obtain 6.
//Step 3) 6 is even; divide by 2 and obtain 3.
//Step 4) 3 is odd; subtract 1 and obtain 2.
//Step 5) 2 is even; divide by 2 and obtain 1.
//Step 6) 1 is odd; subtract 1 and obtain 0.
//Example 2:
//Input: num = 8
//Output: 4
//Explanation:
//Step 1) 8 is even; divide by 2 and obtain 4.
//Step 2) 4 is even; divide by 2 and obtain 2.
//Step 3) 2 is even; divide by 2 and obtain 1.
//Step 4) 1 is odd; subtract 1 and obtain 0.
//Example 3:
//Input: num = 123
//Output: 12
public class Solution {

    public int numberOfSteps(int num) {
        int steps = 0;
        // 1 version
        while(num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            steps++;
        }

        // 2 version
        while(num > 0) {
            // проверка чётности через побитовую операцию (младший бит 0)
            if ((num & 1) == 0) {   // num: xxxxxxx0 or xxxxxxx1 bitmask: 00000001
                // если чётное, сдвигаем биты вправо (эквивалентно делению на 2)
                num >>= 1; // num = num >> 1;
            } else {
                num--;
            }
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSteps(48));
    }
}
