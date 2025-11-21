package Array._2496MaximumValueOfAStringInAnArray;
// 2496. Максимальное значение строки в массиве
//значение буквенно-цифровой строки можно определить как:
//Числовое представление строки в системе счисления 10, если она состоит только из цифр.
//В противном случае — длина строки.
//Дан массив strs буквенно-цифровых строк. Верните то максимальное значение любой строки в strs.
// Example 1:
//Input: strs = ["alic3","bob","3","4","00000"]
//Output: 5
//Explanation:
//- "alic3" consists of both letters and digits, so its value is its length, i.e. 5.
//- "bob" consists only of letters, so its value is also its length, i.e. 3.
//- "3" consists only of digits, so its value is its numeric equivalent, i.e. 3.
//- "4" also consists only of digits, so its value is 4.
//- "00000" consists only of digits, so its value is 0.
//Hence, the maximum value is 5, of "alic3".
//Example 2:
//Input: strs = ["1","01","001","0001"]
//Output: 1
//Explanation:
//Each string in the array has value 1. Hence, we return 1.
public class Solution {
    // time O(n * m), space O(1)
    public int maximumValue(String[] strs) {
        // Инициализируем переменную для хранения максимального значения
        int maxVal = 0;

        // Проходим по всем строкам в массиве
        for (String str : strs) {
            // Предполагаем, что строка состоит только из цифр
            boolean isNumeric = true;

            //Проверяем каждый символ строки
            for (char c : str.toCharArray()) {
                // Если найден нецифровой символ
                if (!Character.isDigit(c)) {
                    // Помечаем, что строка не числовая
                    isNumeric = false;
                    // Прерываем проверку, так как уже нашли букву
                    break;
                }
            }

            // Если строка состоит только из цифр
            if (isNumeric) {
                // Преобразуем в число (ведущие нули игнорируются)
                int num = Integer.parseInt(str);
                // Сравниваем с текущим максимумом
                maxVal = Math.max(maxVal, num);
            } else {
                // Если есть буквы, берём длину строки
                maxVal = Math.max(maxVal, str.length());
            }
        }
        // Возвращаем найденное максимальное значение
        return maxVal;
    }

    public static void main(String[] args) {
        String[] test = {"alic3", "bob", "3", "4", "00000"};
        System.out.println(new Solution().maximumValue(test)); // 5
    }
}
