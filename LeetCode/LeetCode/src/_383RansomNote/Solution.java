package _383RansomNote;

import java.util.HashMap;

public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        // использует O(n) space
        //        for(char r: ransomNote.toCharArray()){
        //        }

        // time O(nm) space O(m), n - длина ransomNote, m - длина magazine
        // Неэффективность из-за создания новых строк при каждом "удалении" символа
        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);

            // version 1
            int matchingIndex = magazine.indexOf(r);

            if (matchingIndex == -1) {
                return false;
            }

            magazine = magazine.substring(0, matchingIndex) + magazine.substring(matchingIndex + 1);

            // version 2
            int matchingIndex1 = -1;
            for (int j = 0; j < magazine.length(); j++) {
                char m = magazine.charAt(j);

                if (r == m) {
                    matchingIndex1 = j;
                }
            }

        }

        // time o(m + n) - count of magazine (один проход по каждой строке)
        // space O(1) - k = 26 (ак как размер алфавита ограничен (26 букв для английского))
        HashMap<Character, Integer> magazineLetters = new HashMap<>();  // k = 26
            // Считаем частоту символов в magazine
        for (int i = 0; i < magazine.length(); i++) {
            char m = magazine.charAt(i);

            int currentCount = magazineLetters.getOrDefault(m, 0);
            magazineLetters.put(m, currentCount + 1);
        }
            // Проверяем возможность построения ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);
            int currentCount = magazineLetters.getOrDefault(r, 0);

            if (currentCount == 0) {
                return false;
            }
            magazineLetters.put(r, currentCount - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canConstruct("aa", "araba"));
    }
}
