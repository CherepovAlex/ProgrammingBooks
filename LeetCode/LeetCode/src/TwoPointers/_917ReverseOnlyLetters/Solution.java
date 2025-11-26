package TwoPointers._917ReverseOnlyLetters;
// 917. Переверните только буквы
//Дана строка s. Поверните её в обратном направлении в соответствии со следующими правилами:
//Все символы, которые не являются английскими буквами, остаются на своих местах.
//Все английские буквы (строчные и прописные) должны быть перевёрнуты.
//Верните s после перестановки
// Example 1:
//Input: s = "ab-cd"
//Output: "dc-ba"
//Example 2:
//Input: s = "a-bC-dEf-ghIj"
//Output: "j-Ih-gfE-dCba"
//Example 3:
//Input: s = "Test1ng-Leet=code-Q!"
//Output: "Qedo1ct-eeLg=ntse-T!"
public class Solution {
    // time O(n), space O(n)
    public String reverseOnlyLetters(String s) {
        // Преобразуем строку в массив символов для модификации
        char[] chars = s.toCharArray();
        // Инициализируем два указателя: left с начала, right с конца
        int left = 0;
        int right = chars.length - 1;
        // Пока указатели не встретились
        while (left < right) {
            // Если символ слева не буква - пропускаем его
            if (!Character.isLetter(chars[left])) {
                left++;
            }
            // Если символ справа не буква - пропускаем его
            else if (!Character.isLetter(chars[right])) {
                right--;
            }
            //  Если оба символа - буквы, меняем их местами
            else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                // Сдвигаем оба указателя
                left++;
                right--;
            }
        }
        // Преобразуем массив символов обратно в строку
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "ab-cd";
        System.out.println(new Solution().reverseOnlyLetters(s)); // "dc-ba"
    }
}
