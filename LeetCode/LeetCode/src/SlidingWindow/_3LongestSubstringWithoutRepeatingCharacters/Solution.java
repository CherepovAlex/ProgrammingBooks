package SlidingWindow._3LongestSubstringWithoutRepeatingCharacters;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Создаем массив для хранения последних позиций символов (ASCII)
        int[] charIndex = new int[128];

        // Инициализируем массив -1 (символ еще не встречался)
        for (int i = 0; i < 128; i++) {
            charIndex[i] = -1;
        }

        int maxLength = 0;  // Переменная для хранения максимальной длины
        int left = 0;       // Левый указатель окна

        // Проходим по строке правым указателем
        for (int right = 0; right < s.length(); right++) {
            // Получаем текущий символ
            char currentChar = s.charAt(right);

            // Если символ уже встречался и его позиция внутри текущего окна
            if (charIndex[currentChar] >= left) {
                // Сдвигаем левый указатель за повторяющийся символ
                left = charIndex[currentChar] + 1;
            }

            // Обновляем позицию текущего символа
            charIndex[currentChar] = right;

            // Вычисляем текущую длину подстроки и обновляем максимум
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;  // Возвращаем максимальную длину
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
