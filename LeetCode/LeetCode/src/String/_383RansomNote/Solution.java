package String._383RansomNote;
// 383. Запись из букв.
// Даны две строки ransomNote и magazine, верните true, если ransomNote можно составить из букв magazine
// и false в противном случае.
//Каждая буква в magazine может использоваться только один раз в ransomNote.
//Пример 1:
//Ввод: note = «a», magazine = «b»
//Вывод: false
//Пример 2:
//Ввод: note = «aa», magazine = «ab»
//Вывод: false
//Пример 3:
//Ввод: note = «aa», magazine = «aab»
//Вывод: true

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // использует O(n) space
    //        for(char r: ransomNote.toCharArray()){
    //        }
    // time O(n*m), space O(m), n - длина ransomNote, m - длина magazine
    // Неэффективность из-за создания новых строк при каждом "удалении" символа
    public boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);
            // version 1
            // Ищем индекс первого вхождения r в magazine
            int matchingIndex = magazine.indexOf(r);
            if (matchingIndex == -1) {  // Если символ не найден (matchingIndex == -1), возвращаем false
                return false;
            }
            // "Удаляем" найденный символ из magazine, создавая новую строку без этого символа
            magazine = magazine.substring(0, matchingIndex) + magazine.substring(matchingIndex + 1);
            // version 2
            // Аналогична version 1, но поиск реализован вручную через цикл (менее эффективно, чем indexOf).
//            int matchingIndex1 = -1;
//            for (int j = 0; j < magazine.length(); j++) {
//                char m = magazine.charAt(j);
//
//                if (r == m) {
//                    matchingIndex1 = j;
//                }
//            }
        }
        return true;
    }

    // time o(m + n) - count of magazine (один проход по каждой строке)
    // space O(1) - k = 26 (так как размер алфавита ограничен (26 букв для английского))
    // version 3
    public boolean canConstruct2(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineLetters = new HashMap<>();  // k = 26
        // Считаем частоту символов в magazine
        for (int i = 0; i < magazine.length(); i++) {
            char m = magazine.charAt(i);
            int currentCount = magazineLetters.getOrDefault(m, 0);
            magazineLetters.put(m, currentCount + 1);
        }
        // Проверяем возможность построения ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);  // Для каждого символа в ransomNote:
            int currentCount = magazineLetters.getOrDefault(r, 0);
            // Если счетчик символа в HashMap равен 0 (или отсутствует) - возвращаем false
            if (currentCount == 0) {
                return false;
            }
            magazineLetters.put(r, currentCount - 1);   // Уменьшаем счетчик символа в HashMap
        }
        return true;    // Если все символы ransomNote успешно проверены - возвращаем true
    }

    // time O(n), space O(n)
    public boolean canConstruct3(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
            } else {
                map.put(magazine.charAt(i), 1);
            }
        }
        int count = 0;
        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i))) {
                char ch = ransomNote.charAt(i);
                if (map.containsKey(ch) && map.get(ch) > 0) {
                    count++;
                    map.put(ch, map.get(ch) - 1);
                } else return false;
            }
        }
        if (count == ransomNote.length()) {
            return true;
        }
        return false;
    }

    // time O(m + n), space O(1)
    public boolean canConstruct4(String ransomNote, String magazine) {
        // Создаем массив для подсчета доступных букв из magazine
        int[] availableLetters = new int[26];

        // Считаем частоту каждой буквы в magazine
        for (char c : magazine.toCharArray()) {
            // Увеличиваем счетчик для каждой доступной буквы
            availableLetters[c - 'a']++;
        }

        // Проверяем, можно ли составить ransomNote из доступных букв
        for (char c : ransomNote.toCharArray()) {
            // Получаем индекс текущей буквы
            int index = c - 'a';
            // Если буква закончилась или ее нет, возвращаем false
            if (availableLetters[index] <= 0) {
                return false;
            }
            // Используем одну букву
            availableLetters[index]--;
        }

        // Все буквы ransomNote успешно найдены в magazine
        return true;
    }

    // Преимущества:
    //Понятная логика: сначала считаем доступные буквы, затем "тратим" их
    //Ранний выход: если буквы недостаточно, сразу возвращаем false
    //Мало итераций: не нужно проходить по всему массиву в конце
    //Сложность:
    //Время: O(m + n), где m - длина magazine, n - длина ransomNote
    //Память: O(1) - всегда используем массив из 26 элементов


    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct2("aa", "araba"));
    }
}
