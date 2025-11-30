package String._389FindTheDifference;
// 389. Найди отличия
// Вам даны две строки s и t.
//Строка t генерируется путем случайного перемешивания строки s с последующим добавлением
// еще одной буквы в случайном месте.
//Верните букву, которая была добавлена в t.
// Example 1:
//Input: s = "abcd", t = "abcde"
//Output: "e"
//Explanation: 'e' is the letter that was added.
//Example 2:
//Input: s = "", t = "y"
//Output: "y"
public class Solution {

    // Альтернативное решение через сумму кодов символов
    public char findTheDifference1(String s, String t) {
    int charCode = 0;
    // Суммируем коды всех символов t
    for (int i = 0; i < t.length(); i++) {
        charCode += t.charAt(i);
    }
    // Вычитаем коды всех символов s
    for (int i = 0; i < s.length(); i++) {
        charCode -= s.charAt(i);
    }
    return (char)charCode;
}
    // Метод для поиска добавленного символа
    // time O(n), space O(1)
    public char findTheDifference(String s, String t) {
        // Инициализируем переменную для хранения XOR-суммы
        int sum = 0;
        // Проходим по всем символам строки s
        for (int i = 0; i < s.length(); i++) {
            // Выполняем операцию XOR с кодом текущего символа
            sum ^= s.charAt(i);
        }
        // Проходим по всем символам строки t
        for (int i = 0; i < t.length(); i++) {
            // Выполняем операцию XOR с кодом текущего символа
            sum ^= t.charAt(i);
        }
        // Преобразуем числовое значение обратно в символ
        return (char)sum;
    }
    // Объяснение алгоритма:
    //Это решение использует свойство операции XOR:
    // - a ^ a = 0 (одинаковые элементы "обнуляются")
    // - a ^ 0 = a
    //Поскольку строка t содержит все символы s плюс один дополнительный, то при XOR всех символов обеих строк:
    // - Все парные символы из s и t дадут 0
    // - Останется только код добавленного символа
    //Сложность:
    //Время: O(n), где n - длина строки t
    //Память: O(1) - используется только одна переменная

    public static void main(String[] args) {
        String s1 = "abcd", t1 = "abcde";
        System.out.println(new Solution().findTheDifference(s1, t1));
    }
}
