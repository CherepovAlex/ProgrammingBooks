package Medium._763PartitionLabels;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Вам дана строка s. Мы хотим разделить строку на как можно большее количество частей так, чтобы каждая буква
// встречалась не более чем в одной части. Например, строку "ababcc" можно разделить на ["abab", "cc"], но такие
// варианты, как ["aba", "bcc"] или ["ab", "ab", "cc"] недопустимы.
//Обратите внимание, что разбиение выполнено таким образом, что после объединения всех частей по порядку получается строка s.
//Верните список целых чисел, обозначающих размер этих частей.
// Example 1:
//Input: s = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
//Example 2:
//Input: s = "eccbbbbdec"
//Output: [10]
public class Solution {

    public List<Integer> partitionLabels(String s) {
        char[] arr = s.toCharArray();           // Преобразуем строку в массив символов
        int[] cache = new int[128];             // Создаем кэш для хранения последних позиций символов
        for (int i = 0; i < arr.length; i++) {
            char cur = arr[i];
            cache[cur] = i;                     // Записываем последнюю позицию каждого символа
        }
        int L = 0;          // L - начало сегмента
        int R = 0;          // R - конец сегмента
        int index = 0;      // index - текущий индекс

        List<Integer> res = new LinkedList<>();    // Результирующий список

        while (index < arr.length) {
            char cur = arr[index];
            R = Math.max(R, cache[cur]); // Расширяем правую границу до последнего вхождения текущего символа
            if (R == index) {            // Если достигли конца текущего сегмента
                int size = R - L + 1;    // Вычисляем размер сегмента
                res.add(size);
                R++;                     // Сдвигаем правую границу
                L = R;                   // Начинаем новый сегмент
            }
            index++;
        }
        return res;
    }

    // time O(n), space O(1)
    public List<Integer> partitionLabels1(String s) {
        // Массив для хранения последних позиций каждого символа (128 - размер ASCII)
        int[] lastOccurence = new int[128];
        char[] chars = s.toCharArray();

        // Заполняем массив последних вхождений (ПЕРВЫЙ ПРОХОД)
        for (int i = 0; i < chars.length; i++) {
            lastOccurence[chars[i]] = i;
        }

        List<Integer> result = new ArrayList<>();
        int segmentStart = 0; // Начало текущего сегмента
        int segmentEnd = 0;   // Конец текущего сегмента

        // ВТОРОЙ ПРОХОД: определяем границы сегментов
        for (int i = 0; i < chars.length; i++) {
            // Расширяем конец сегмента до последнего вхождения текущего символа
            segmentEnd = Math.max(segmentEnd, lastOccurence[chars[i]]);

            // если достигли конца текущего сегмента
            if (i == segmentEnd) {
                // Добавляем размер сегмента в результат
                result.add(segmentEnd - segmentStart + 1);
                // Начинаем новый сегмент со следующего символа
                segmentStart = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        System.out.println(new Solution().partitionLabels(str));
    }

}
