package String._6ZigzagConversion;

//6. Zigzag Conversion

// Строка "PAYPALISHIRING" записывается зигзагообразным образом в заданном количестве строк следующим образом:
// (для лучшей читаемости вы можете отобразить этот шаблон фиксированным шрифтом)
//P   A   H   N
//A P L S I I G
//Y   I   R
// А затем читайте построчно: "PAHNAPLSIIGYIR"
//Напишите код, который будет принимать строку и выполнять это преобразование с учётом количества строк:
class Solution {
    // [code1]
    public String convert(String s, int numRows) {
        // Проверяем тривиальные случаи:
        // если numRows равен 1 или строка короче numRows, возвращаем исходную строку
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Создаём StringBuilder для каждой строки зигзага
        // Размер массива = минимум между numRows и длиной строки (для экономии памяти)
        // [code2]
        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];

        // Инициализируем каждый элемент массива новым объектом StringBuilder
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        // Инициализируем переменную для отслеживания текущей строки
        // [code3]
        int currentRow = 0;  // Текущая строка, в которую добавляем символ
        boolean goingDown = false;  // Флаг направления движения по зигзагу: вниз или вверх по зигзагу
                                    // Начинаем с false, так как первый символ будет в строке 0
        // Проходим по всем символам исходной строки
        // [code4]
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);  // Добавляем текущий символ в StringBuilder текущей строки

            // Если достигли верхней (0) или нижней (numRows-1) границы,
            // то меняем направлениена противоположное
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Переходим к следующей строке: увеличиваем currentRow
            // при движении вниз, уменьшаем при движении вверх
            currentRow += goingDown ? 1 : -1;
        }

        // Создаём новый StringBuilder формирования  для результата
        // [code5]
        StringBuilder result = new StringBuilder();

        // Объединяем все строки в одну результирующую
        // Добавляем содержимое каждого из них в result
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();  // Преобразуем StringBuilder в String
    }
    // Особенности реализации на Java:
    //StringBuilder вместо String - используем StringBuilder для эффективной конкатенации строк, так как он изменяемый
    //toCharArray() - преобразуем строку в массив символов для удобного итеративного обхода
    //Math.min() - используем для определения размера массива, чтобы избежать создания лишних элементов
    //Сложность алгоритма:
    //Время: O(n), где n - длина строки s. Каждый символ обрабатывается один раз.
    //Память: O(n), так как все символы сохраняются в StringBuilder'ах.
    //Пример работы:
    //Для s = "PAYPALISHIRING", numRows = 3:
    //rows[0] = "PAHN"
    //rows[1] = "APLSIIG"
    //rows[2] = "YIR"
    //Результат: "PAHNAPLSIIGYIR"
    public String convert1(String s, int numRows) {
        // Check trivial cases:
        // If numRows is 1 or string length is less than or equal to numRows, return the original string
        if (numRows == 1 || s.length() <= numRows) return s;

        // Create a StringBuilder for each zigzag row
        // Array size = minimum between numRows and string length (for memory efficiency)
        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];

        // Initialize each array element with a new StringBuilder object
        for (int i = 0; i < rows.length; i++) rows[i] = new StringBuilder();

        // Initialize variable to track current row
        int currentRow = 0;  // Current row to add character to
        boolean goingDown = false;  // Flag for zigzag direction: down or up
                                    // Start with false as first character will be in row 0
        // Iterate through all characters in the input string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);  // Add current character to current row's StringBuilder

            // If we reach the top (0) or bottom (numRows-1) boundary,
            // reverse the direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move to next row: increment currentRow when going down,
            // decrement when going up
            currentRow += goingDown ? 1 : -1;
        }

        // Create a new StringBuilder for the result
        StringBuilder result = new StringBuilder();

        // Combine all rows into a single result
        // Append each row's content to result
        for (StringBuilder row : rows) result.append(row);

        // Convert StringBuilder to String
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        System.out.println(new Solution().convert(s, numRows));
    }
}