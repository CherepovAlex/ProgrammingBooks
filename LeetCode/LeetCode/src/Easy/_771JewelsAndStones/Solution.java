package Easy._771JewelsAndStones;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Вам даны строки jewels с указанием типов драгоценных камней и stones с указанием имеющихся у вас камней.
// Каждый символ в stones обозначает имеющийся у вас камень. Вы хотите узнать, сколько имеющихся у вас камней
// являются драгоценными.
//Буквы различаются по регистру, поэтому "a" считается камнем другого типа, чем "A".
// Example 1:
//Input: jewels = "aA", stones = "aAAbbbb"
//Output: 3
//Example 2:
//Input: jewels = "z", stones = "ZZ"
//Output: 0
public class Solution {
    // time O(n*m), space O(n+m)
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        char[] arrJewels = jewels.toCharArray();
        char[] arrStones = stones.toCharArray();
        for (char arrJewel : arrJewels) {
            for (char arrStone : arrStones) {
                if (arrJewel == arrStone) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numJewelsInStones1(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arrJewels = jewels.toCharArray();
        for (char arrJewel : arrJewels) {
            map.put(arrJewel, map.getOrDefault(arrJewel, 0) + 1);
        }
        int count = 0;
        char[] arrStones = stones.toCharArray();
        for (char arrStone : arrStones) {
            if (map.containsKey(arrStone)) {
                count++;
            }
        }
        return count;
    }

    public int numJewelsInStones2(String jewels, String stones) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (char arrJewel : jewels.toCharArray()) {
            set.add(arrJewel);
        }
        for (char arrStone : stones.toCharArray()) {
            if (set.contains(arrStone)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(new Solution().numJewelsInStones(jewels, stones));
        System.out.println(new Solution().numJewelsInStones1(jewels, stones));
    }
}
