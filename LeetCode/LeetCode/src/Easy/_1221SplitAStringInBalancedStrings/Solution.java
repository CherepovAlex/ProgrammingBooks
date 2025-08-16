package Easy._1221SplitAStringInBalancedStrings;

// Сбалансированные строки — это строки, в которых одинаковое количество 'L' и 'R' символов.
//Дана сбалансированная строка s. Разделите её на несколько подстрок таким образом, чтобы:
//Каждая подстрока сбалансирована.
//Верните то максимальное количество сбалансированных строк, которое вы можете получить.
// Example 1:
//Input: s = "RLRRLLRLRL"
//Output: 4
//Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
//Example 2:
//Input: s = "RLRRRLLRLL"
//Output: 2
//Explanation: s can be split into "RL", "RRRLLRLL", each substring contains same number of 'L' and 'R'.
//Note that s cannot be split into "RL", "RR", "RL", "LR", "LL", because the 2nd and 5th substrings are not balanced.
//Example 3:
//Input: s = "LLLLRRRR"
//Output: 1
//Explanation: s can be split into "LLLLRRRR".
public class Solution {
    // time O(n) space O(n)
    public int balancedStringSplit(String s) {
        int count = 0;
        int left = 0;
        int right = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'L') {
                left++;
            } else if (ch[i] == 'R') {
                right++;
            }
            if (left == right) {
                count++;
            }
        }
        return count;
    }
    // time O(n) space O(1)
    public int balancedStringSplit2(String s) {
        int count = 0;
        int balance = 0;  // Разница между количеством 'L' и 'R'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            balance += (c == 'L') ? 1 : -1;  // Увеличиваем баланс для 'L', уменьшаем для 'R'

            if (balance == 0) {  // Когда баланс нулевой - нашли сбалансированную подстроку
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "RLRRLLRLRL";
        System.out.println(new Solution().balancedStringSplit(str));
    }
}
