package Easy._2053KthDistinctStringInAnArray;

import java.util.*;

//Уникальная строка — это строка, которая встречается в массиве только один раз.
//Дан массив строк arr и целое число k. Верните ту k-th отличную строку, которая есть в arr.
// Если меньше k отличных строк, верните пустую строку"".
//Обратите внимание, что строки рассматриваются в порядке их следования в массиве.
// Example 1:
//Input: arr = ["d","b","c","b","c","a"], k = 2
//Output: "a"
//Explanation:
//The only distinct strings in arr are "d" and "a".
//"d" appears 1st, so it is the 1st distinct string.
//"a" appears 2nd, so it is the 2nd distinct string.
//Since k == 2, "a" is returned.
//Example 2:
//Input: arr = ["aaa","aa","a"], k = 1
//Output: "aaa"
//Explanation:
//All strings in arr are distinct, so the 1st string "aaa" is returned.
//Example 3:
//Input: arr = ["a","b","a"], k = 3
//Output: ""
//Explanation:
//The only distinct string is "b". Since there are fewer than 3 distinct strings, we return an empty string "".
public class Solution {
    // Неоптимальное использование памяти, Двойной проход по данным
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        if (list.size() < k) {
            return "";
        }
        return list.get(k - 1);
    }
    // Один проход для подсчета частот
    // Второй - непосредственно по исходному массиву для поиска k-й уникальной строки
    // time O(n), space O(n)
    public String kthDistinct1(String[] arr, int k) {
        Map<String, Integer> frequencyMap = new LinkedHashMap<>();

        // первый проход: подсчет частот с сохранением порядка
        for (String s : arr) {  // для безопасного получения и увеличения счетчика.
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }

        // второй проход: поиск k-й уникальной строки
        int count = 0;
        for (String s : arr) {
            if (frequencyMap.get(s) == 1) {
                count++;
                if (count == k) return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] arr = {"d", "b", "c", "b", "c", "a"};
        int k = 2;
        System.out.println(new Solution().kthDistinct(arr, k));
    }
}
