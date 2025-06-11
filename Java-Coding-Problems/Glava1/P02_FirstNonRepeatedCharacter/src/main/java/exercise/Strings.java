package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Strings {

    // http://www.alansofficespace.com/unicode/unicd99.htm
    private static final int EXTENDED_ASCII_CODES = 256; // can be increased to 65535

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }
    // В худшем случае (когда все символы повторяются или неповторяющийся символ — последний) метод работает за O(n²)
    public static char firstNonRepeatedCharacterV1(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (ch == str.charAt(j) && i != j) {
                    count++;
                    break;
                }
            }

            if (count == 0) {
                return ch;
            }
        }

        return Character.MIN_VALUE;
    }
    // Сложность O(n) вместо O(n²), так как используется массив для хранения состояний символов.
    public static char firstNonRepeatedCharacterV2(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }

        int[] flags = new int[EXTENDED_ASCII_CODES];

        for(int i = 0; i < flags.length; i++) {
            flags[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (flags[ch] == -1) {
                flags[ch] = i;
            } else {
                flags[ch] = -2;
            }
        }

        int position = Integer.MAX_VALUE;
        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }

        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
    }

    // Время: O(n) (два прохода: один по строке, второй по Map), Память: O(n) (хранение Map с символами).
    public static char firstNonRepeatedCharacterV3(String str) {
    // Этот метод эффективнее V1 и V2, если: трока содержит Unicode-символы (не только ASCII),
    // важен порядок символов (первое вхождение)
        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }
        // Хранит символы (Character) в порядке их добавления.
        Map<Character, Integer> chars = new LinkedHashMap<>();

        // or use for(char ch: str.toCharArray()) { ... }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // обновляет значение в Map для символа ch
            chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        // Проход по LinkedHashMap (в порядке добавления символов!).
        for (Map.Entry<Character, Integer> entry: chars.entrySet()) {
            // Если значение (entry.getValue()) равно 1 → значит, символ встречался ровно один раз.
            if (entry.getValue() == 1) {
                // Возвращаем первый такой символ
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }
    // Время: O(n) (один проход для группировки + один для поиска). Память: O(n) (хранение Map).
    public static char firstNonRepeatedCharacterV4(String str) {
        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Character.MIN_VALUE;
        }
        // преобразует строку в IntStream кодовых точек Unicode (каждый символ → int).
        Map<Integer, Long> chs = str.chars()
                // преобразует IntStream в Stream<Integer> (для работы с Collectors.groupingBy).
                .mapToObj(cp -> cp)
                //  группирует символы: ключом в Map будет сам символ (кодовая точка).
                .collect(Collectors.groupingBy(Function.identity(),
        // гарантирует сохранение порядка добавления символов, значение в Map - количество вхождений символа (Long).
                        LinkedHashMap::new, Collectors.counting()));
        // преобразует Map в поток пар (символ, количество), преобразует Integer (кодовую точку) в char.
        return (char) (int) chs.entrySet().stream()
                // оставляет только символы с частотой 1.
                .filter(e -> e.getValue() == 1L)
                //  находит первый такой символ (благодаря LinkedHashMap порядок сохранён).
                .findFirst()
                // извлекает ключ (кодовую точку символа).
                .map(Map.Entry::getKey)
                // если поток пуст, возвращает Character.MIN_VALUE.
                .orElse(Integer.valueOf(Character.MIN_VALUE));
    }
    // Время: O(n) (два прохода: создание карты + поиск в потоке). Память: O(n) (хранение LinkedHashMap).
    public static String firstNonRepeatedCharacterV5(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return String.valueOf(Character.MIN_VALUE);
        }
// Преобразует строку в поток кодовых точек Unicode (работает с символами за пределами BMP, например, эмодзи 🚀)
        Map<Integer, Long> chs = str.codePoints()
                // Конвертирует IntStream в Stream<Integer> для группировки.
                .mapToObj(cp -> cp)
                .collect(Collectors.groupingBy(Function.identity(),
                        // Создает LinkedHashMap, где: Ключ (Integer) — кодовая точка символа.
                                                     //Значение (Long) — количество вхождений.
                        //LinkedHashMap сохраняет порядок добавления символов.
                        LinkedHashMap::new, Collectors.counting()));

        int cp = chs.entrySet().stream()
                // Фильтрация символов с частотой 1.
                .filter(e -> e.getValue() == 1L)
                // берёт первый подходящий символ (благодаря LinkedHashMap порядок гарантирован).
                .findFirst()
                .map(Map.Entry::getKey)
                // Возвращает Character.MIN_VALUE, если неповторяющихся символов нет.
                .orElse(Integer.valueOf(Character.MIN_VALUE));
// Конвертирует кодовую точку Unicode в массив char[] (корректно обрабатывает surrogate pairs, например, для эмодзи)
        return String.valueOf(Character.toChars(cp));
        // Преобразует char[] в строку.
    }
}
