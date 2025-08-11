package Medium._242ValidAnagram;
//Даны две строки s и t. Верните true если t является анаграммой s,
// и false в противном случае.
// Продолжение: Что, если входные данные содержат символы Юникода?
// Как бы вы адаптировали своё решение для такого случая?
//Example 1:
//Input: s = "anagram", t = "nagaram"
//Output: true
//Example 2:
//Input: s = "rat", t = "car"
//Output: false
public class Solution {
    // time O(n). space O(1)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {return false;}

        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for(int count: counts) {
            if (count!=0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramUnicode(String s, String t) {
        if (s.length() != t.length()) {return false;}

        int[] counts = new int[0xFFFF]; // поддержка всех символов

        s.codePoints().forEach(cp -> {counts[cp]++;});
        t.codePoints().forEach(cp -> {counts[cp]--;});

        for(int count: counts) {
            if (count!=0) {
                return  false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(new Solution().isAnagram(s1,t1));
    }
}
