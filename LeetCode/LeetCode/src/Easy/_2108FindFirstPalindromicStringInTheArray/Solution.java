package Easy._2108FindFirstPalindromicStringInTheArray;

// Найдите первую палиндромную строку в массиве
//Дан массив строк words. Верните первую палиндромную строку в массиве. Если такой строки нет, верните пустую строку "".
//Строка является палиндромом, если она читается одинаково как слева направо, так и справа налево.
// Example 1:
//Input: words = ["abc","car","ada","racecar","cool"]
//Output: "ada"
//Explanation: The first string that is palindromic is "ada".
//Note that "racecar" is also palindromic, but it is not the first.
//Example 2:
//Input: words = ["notapalindrome","racecar"]
//Output: "racecar"
//Explanation: The first and only string that is palindromic is "racecar".
//Example 3:
//Input: words = ["def","ghi"]
//Output: ""
//Explanation: There are no palindromic strings, so the empty string is returned.
public class Solution {
    // time O(n * m) n - количество слов, m - длина самого длинного слова, O(1) - space
    public String firstPalindrome(String[] words) {
        // Проходим по каждому слову в массиве
        for (String word : words) {
            // Проверяем, является ли текущее слово палиндромом
            if (isPalindrome(word)) {
                // Если да, возвращаем это слово
                return word;
            }
        }
        // Если палиндром не найден, возвращаем пустую строку
        return "";
    }

    private boolean isPalindrome(String s) {
        // Инициализируем два указателя: начала и конец строки
        int left = 0;
        int right = s.length() - 1;
        // Пока указатели не встреились
        while (left < right) {
            // Сравниваем символы на позициях left и right
            if (s.charAt(left) != s.charAt(right)) {
                // Если символы не совпадают, то строка не полиндром
                return false;
            }
            // Сдвигаем указатели к центру
            left++;
            right--;
        }
        // Все символы совпали, строка - палиндром
        return true;
    }

    public static void main(String[] args) {

        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        System.out.println(new Solution().firstPalindrome(words));
    }
}
