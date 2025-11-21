package BinarySearch._744FindSmallestLetterGreaterThanTarget;
// 744. Найдите наименьшую букву, которая больше заданной
//Вам предоставляется массив символов, letters который отсортирован в неубывающем порядке, и символ target.
// В есть как минимум два разных letters символа.
//Верните наименьший символ в lettersкоторый лексикографически больше target. Если такого символа нет, верните первый символ в letters.
// Example 1:
//Input: letters = ["c","f","j"], target = "a"
//Output: "c"
//Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
//Example 2:
//Input: letters = ["c","f","j"], target = "c"
//Output: "f"
//Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
//Example 3:
//Input: letters = ["x","x","y","y"], target = "z"
//Output: "x"
//Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
public class Solution {
        // time O(log n), space O(1)
    public char nextGreatestLetter(char[] letters, char target) {
        // Левая граница поиска - начало массива
        int left = 0;
        // Правая граница поиска - конец массива
        int right = letters.length - 1;

        // Пока левая граница не превысит правую
        while (left <= right) {
            // Находим средний индекс
            int mid = left + (right - left) / 2;

            // Если средний элемент меньше или равен target, ищем в правой половине
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                // Если средний элемент больше target, ищем в левой половине
                right = mid - 1;
            }
        }

        // Если left выходит за границы массива, возвращаем первый элемент
        // В противном случае врозвращаем элемент на позиции left
        return left < letters.length ? letters[left] : letters[0];
    }
}
