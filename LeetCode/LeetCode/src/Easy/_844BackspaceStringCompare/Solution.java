package Easy._844BackspaceStringCompare;

// Даны две строки s и t. Верните true , если они равны, когда обе строки вводятся в пустые
// текстовые редакторы. '#' означает символ возврата каретки.
//Обратите внимание, что после удаления символа возврата каретки пустой текст останется пустым.
// Example 1:
//Input: s = "ab#c", t = "ad#c"
//Output: true
//Explanation: Both s and t become "ac".
//Example 2:
//Input: s = "ab##", t = "c#d#"
//Output: true
//Explanation: Both s and t become "".
//Example 3:
//Input: s = "a#c", t = "b"
//Output: false
//Explanation: s becomes "c" while t becomes "b".
public class Solution {
    // time O(n + m), space O(1)
    public boolean backspaceCompare(String s, String t) {
        // Инициализация указателей: начинаются с конца строк для обработки в обратном порядке
        int pointerS = s.length() - 1;
        int pointerT = t.length() - 1;
        // Счётчики пропусков: cчитают количество символов # для определения, сколько символов нужно пропустить
        int skpisS = 0;
        int skpisT = 0;
        // пока есть символы для обработки в любой из строк.
        while (pointerS >= 0 || pointerT >= 0) {
            // Обрабатываем строку s
            while (pointerS >= 0) {
                // Встречаем # → увеличиваем счётчик пропусков
                if (s.charAt(pointerS) == '#') {
                    // увеличиваем пропуски, двигаем указатель
                    skpisS++;
                    pointerS--;
                    // если есть пропуски → пропускаем символ
                } else if (skpisS > 0) {
                    // уменьшаем пропуски, двигаем указатель
                    skpisS--;
                    pointerS--;
                    // Нет пропусков → останавливаемся на символе для сравнения
                } else {
                    break;
                }
            }
            // Обрабатываем строку t аналогично
            while (pointerT >= 0) {
                if (t.charAt(pointerT) == '#') {
                    skpisT++;
                    pointerT--;
                } else if (skpisT > 0) {
                    skpisT--;
                    pointerT--;
                } else {
                    break;
                }
            }
            // Сравниваем текущие символы
            if (pointerS >= 0 && pointerT >= 0) {
                if (s.charAt(pointerS) != t.charAt(pointerT)) {
                    return false;
                }
            } else {
                // Если одна строка закончилась, а другая - нет
                if (pointerS >= 0 || pointerT >= 0) {
                    return false;
                }
            }

            pointerS--;
            pointerT--;
        }

        return true;
    }

    // time O(n + m), space O(n + m)
    public boolean backspaceCompare2(String s, String t) {
        return buildString(s).equals(buildString(t));
    }

    private String buildString(String str) {
        StringBuilder result = new StringBuilder();
        int backSpaceCount = 0;
        // обрабатываем строку в обратном порядке
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == '#') {
                backSpaceCount++;
            } else if (backSpaceCount > 0) {
                backSpaceCount--;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(new Solution().backspaceCompare(s, t));
    }
}
