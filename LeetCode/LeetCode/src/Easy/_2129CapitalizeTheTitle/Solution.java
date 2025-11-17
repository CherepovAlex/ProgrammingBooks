package Easy._2129CapitalizeTheTitle;

// Заглавие с заглавной буквы
//Вам дана строка title, состоящая из одного или нескольких слов, разделённых пробелом, где каждое слово состоит из
//английских букв. Преобразуйте строку в заглавную, изменив регистр каждого слова таким образом, чтобы:
//Если длина слова составляет 1 или 2 букв, переведите все буквы в нижний регистр.
//В противном случае измените первую букву на заглавную, а остальные — на строчные.
//Верните то написанное с заглавной буквы title.
// Example 1:
//Input: title = "capiTalIze tHe titLe"
//Output: "Capitalize The Title"
//Explanation:
//Since all the words have a length of at least 3, the first letter of each word is uppercase, and the remaining letters are lowercase.
//Example 2:
//Input: title = "First leTTeR of EACH Word"
//Output: "First Letter of Each Word"
//Explanation:
//The word "of" has length 2, so it is all lowercase.
//The remaining words have a length of at least 3, so the first letter of each remaining word is uppercase, and the remaining letters are lowercase.
//Example 3:
//Input: title = "i lOve leetcode"
//Output: "i Love Leetcode"
//Explanation:
//The word "i" has length 1, so it is lowercase.
//The remaining words have a length of at least 3, so the first letter of each remaining word is uppercase, and the remaining letters are lowercase.
public class Solution {
    // time O(n), space O(n)
    public String capitalizeTitle(String title) {
        // Создаём StringBuilder для эффективной работы со строками
        StringBuilder result = new StringBuilder();
        // Разбиваем строку на слова по пробелам
        String[] words = title.split(" ");

        //Проходим по каждому слову в массиве
        for (int i = 0; i < words.length; i++) {
            // Получаем текущее слово
            String word = words[i];

            // Проверяем длина слова
            if (word.length() <= 2) {
                // Если длина 1 или 2 символа, переводим всё в нижний регистр
                result.append(word.toLowerCase());
            } else {
                // Для слов длиной 3 и более символов
                // Первую букву делаем заглавной, остальные - строчными
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1).toLowerCase());
            }
            // Добавляем пробел после слова, если это не последнее слово
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        // Возвращаем результат как строку
        return result.toString();
    }
    // time O(n), space O(n)
    public String capitalizeTitle2(String title) {
        // Создаём массив символов для работы (более эффективен по памяти)
        char[] chars = title.toCharArray();
        // Индекс начала текущего слова
        int start = 0;
        // Длина текущего слова
        int length = 0;
        // Проходим по всем символам строки
        for (int i = 0; i <= chars.length; i++) {
            // Если достигли конца строки или пробела
            if (i == chars.length || chars[i] == ' ') {
                // Обрабатываем слово согласно правилам
                if (length <= 2) {
                    // Для коротких слов - все буквы в нижний регистр
                    for (int j = start; j < i; j++) {
                        chars[j] = Character.toLowerCase(chars[j]);
                    }
                } else {
                    // Для длинных слов - первая буква заглавная, остальные строчные
                    chars[start] = Character.toUpperCase(chars[start]);
                    for (int j = start + 1; j < i; j++ ) {
                        chars[j] = Character.toLowerCase(chars[j]);
                    }
                }
                // Сбрасываем параметры для следующего слова
                start = i + 1;
                length = 0;
            } else {
                // Увеличиваем счетчик длины текущего слова
                length++;
            }
        }
        // Возвращаем результат как строку
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.capitalizeTitle("capiTalIze tHe titLe"));
    }
}
