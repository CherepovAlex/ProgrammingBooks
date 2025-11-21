package HashTable._771JewelsAndStones;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 771. Вам даны строки jewels с указанием типов драгоценных камней и stones с указанием имеющихся у вас камней.
// Каждый символ в stones обозначает имеющийся у вас камень. Вы хотите узнать, сколько имеющихся у вас камней
// являются драгоценными.
//Буквы различаются по регистру, поэтому "a" считается камнем другого типа, чем "A".
// Example 1:
// Input: jewels = "aA", stones = "aAAbbbb"
// Output: 3
// Example 2:
// Input: jewels = "z", stones = "ZZ"
// Output: 0
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

    // time O(n+m), space O(n) - оптимальное решение по времени и памяти
    public int numJewelsInStones2(String jewels, String stones) {
        // Инициализируем счетчик драгоценных камней
        int count = 0;
        // Создаем множество для хранения драгоценных камней
        Set<Character> set = new HashSet<>();
        // Преобразуем строку jewels в массив символов и добавляем каждый символ в множество
        for (char arrJewel : jewels.toCharArray()) {
            set.add(arrJewel);
        }
        // Преобразуем строку stones в массив символов и проверяем каждый камень
        for (char arrStone : stones.toCharArray()) {
            // Если камень является драгоценным, увеличиваем счетчик
            if (set.contains(arrStone)) {
                count++;
            }
        }
        // Возвращаем общее количество драгоценных камней
        return count;
    }

    public int numJewelsInStonesOptimized(String jewels, String stones) {
        // Создаем массив boolean для отметки драгоценных камней (ASCII символы)
        boolean[] isJewel = new boolean[128];

        // Отмечаем все драгоценные камни в массиве
        for (int i = 0; i < jewels.length(); i++) {
            isJewel[jewels.charAt(i)] = true;
        }

        int count = 0;
        // Подсчитываем драгоценные камни
        for (int i = 0; i < stones.length(); i++) {
            if (isJewel[stones.charAt(i)]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(new Solution().numJewelsInStones(jewels, stones)); // 3
        System.out.println(new Solution().numJewelsInStones1(jewels, stones));
    }
}
