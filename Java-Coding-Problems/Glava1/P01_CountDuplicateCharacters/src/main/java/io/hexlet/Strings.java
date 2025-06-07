package io.hexlet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Map<Character, Integer> countDuplicateCharactersV1(String str) {

        if (str == null || str.isBlank()) { // Проверка на null/пустую строку.
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        Map<Character, Integer> result = new HashMap<>();

        // or use for (char ch: str.toCharArray()) {}
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);    // Получение символа.

            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);    //Увеличение счетчика для символа.
        }

        return result;
    }

    public static Map<String, Integer> countDuplicateCharactersVCP1(String str) {

        if (str == null || str.isEmpty()) {  // Проверка на null/пустую строку.
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            /*
            String ch = String.valueOf(Character.toChars(str.codePointAt(i)));
            if (i < str.length() - 1 && str.codePointCount(i, i + 2) == 1) {
                i++;
            }
            */
            // or, like this (this code produce the same result as the commented code above
            int cp = str.codePointAt(i); // Получение code point (может быть 32-битным).
            String ch = String.valueOf(Character.toChars(cp)); // Конвертация code point в строку (поддержка surrogate pairs).
            if (Character.charCount(cp) == 2) { // 2 means a surrogate pair, Пропуск второго char в surrogate pair.
                i++;
            }
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);    //Увеличение счетчика для символа.
        }
        return result;
    }

    public static Map<Character, Long> countDuplicateCharactersV2(String str) {

        if (str == null || str.isBlank()) {  // Проверка на null/пустую строку.
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        Map<Character, Long> result = str.chars()       // Получение IntStream из символов.
                .mapToObj(c -> (char) c)        // Конвертация в Character.
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())); // Группировка и подсчет.

        return result;
    }

    public static Map<String, Long> countDuplicateCharactersVCP2(String str) {

        if (str == null || str.isEmpty()) {   // Проверка на null/пустую строку.
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        Map<String, Long> result = str.codePoints()     // Получение IntStream из code points.
                .mapToObj(c -> String.valueOf(Character.toChars(c))) // Конвертация в строку (поддержка surrogate pairs).
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())); // Группировка и подсчет.

        return result;
    }
}
