package _374GuessNumberHigherOrLower;
// Мы играем в «Угадайку». Правила игры таковы:
//Я выбираю число от 1 до n. Вам нужно угадать, какое число я выбрал.
//Каждый раз, когда вы будете ошибаться, я буду сообщать вам, больше или меньше число, которое я выбрал,
// чем ваше предположение.
//Вы вызываете заранее определённый API int guess(int num), который возвращает три возможных результата:
//-1: Ваша догадка выше числа, которое я выбрал (т. е. num > pick).
//1: Ваша догадка меньше числа, которое выбрал я (то есть num < pick).
//0: ваша догадка совпадает с выбранным мной числом (то есть num == pick).
//Верните выбранное мной число.
// Example 1:
//Input: n = 10, pick = 6
//Output: 6
//Example 2:
//Input: n = 1, pick = 1
//Output: 1
//Example 3:
//Input: n = 2, pick = 1
//Output: 1
/**
 * Forward declaration of guess API.
// * @param  num  your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
class GuessGame {
    int guess(int num) {
        return 0;
    }
}

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            }
            else if (res == 1) {
                low = mid + 1;
            }
            else  {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution().guessNumber(n));
    }
}