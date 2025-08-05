package _14LongestCommonPrefix;
// Напишите функцию для поиска самого длинного общего префикса в массиве строк.
//Если общего префикса нет, верните пустую строку ""
// Пример 1:
//Ввод: strs = ["flower", "flow", "flight"]
//Вывод: "fl"
//Пример 2:
//Входные данные: strs = [«собака», «гоночный автомобиль», «автомобиль»]
//Выходные данные: ""
//Пояснение: Во входных строках нет общего префикса.
public class Solution {
    // time O(s), s - summa all of simbols in strs; space O(1)
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // binary search
    // time O(s*log n), n - length os most short str, space - O(1)
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Ищется максимальная длина mid, для которой подстрока первых mid символов является префиксом всех строк.
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int low = 1;
        int high = minLen;
        while (low <= high) {
            int mid = (low + high) / 2;
//            System.out.println(mid);
            // Если для текущего mid префикс общий, ищется более длинный префикс (сдвигается low).
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                // Если не общий - ищется более короткий (сдвигается high).
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    // проверяет, является ли подстрока первых len символов первой строки префиксом всех остальных строк.
    private boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
//        System.out.println(true);
        return true;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(new Solution().longestCommonPrefix1(strs));
    }
}
