package String._8StringToIntegerAtoi;

class Solution {
    public int myAtoi(String s) {
        // Инициализация указателя для прохода по строке
        int i = 0;
        // Получение длины строки
        int n = s.length();

        // Пропуск начальных пробелов
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Проверка, достигнут ли конец строки после пробелов
        if (i == n) {
            return 0;
        }

        // Определение знака числа
        int sign = 1; // По умолчанию знак положительный
        if (s.charAt(i) == '-') { // Если текущий символ '-'
            sign = -1; // Устанавливаем отрицательный знак
            i++; // Переходим к следующему символу
        } else if (s.charAt(i) == '+') { // Если текущий символ '+'
            i++; // Переходим к следующему символу (знак остается положительным)
        }

        // Инициализация переменной для накопления результата
        int result = 0;
        // Установка границ для 32-битного целого со знаком
        int intMin = Integer.MIN_VALUE;
        int intMax = Integer.MAX_VALUE;

        // Преобразование цифр в число
        while (i < n && Character.isDigit(s.charAt(i))) { // Пока есть цифры
            int digit = s.charAt(i) - '0'; // Преобразуем символ в цифру

            // Проверка на переполнение перед добавлением цифры
            // Для положительных чисел
            if (sign == 1) {
                // Проверяем, не превысит ли result * 10 + digit максимальное значение
                if (result > (intMax - digit) / 10) {
                    return intMax; // Возвращаем максимальное значение
                }
            }
            // Для отрицательных чисел
            else {
                // Проверяем, не станет ли result * 10 + digit меньше минимального значения
                // Учитываем, что мы работаем с положительным result, а потом применим знак
                if (-result < (intMin + digit) / 10) {
                    return intMin; // Возвращаем минимальное значение
                }
            }

            // Добавление цифры к результату
            result = result * 10 + digit;
            i++; // Переход к следующему символу
        }

        // Умножение результата на знак и возврат
        return sign * result;
    }
    // Ключевые особенности реализации на Java:
    //Метод charAt(i) - получение символа по индексу
    //Метод Character.isDigit() - проверка, является ли символ цифрой
    //Константы Integer.MAX_VALUE и Integer.MIN_VALUE - границы 32-битного целого
    //Преобразование char в int: s.charAt(i) - '0' - вычитание кода символа '0'
    //Особенность проверки переполнения: нужно учитывать знак при проверке
    //Сложность алгоритма:
    //Временная сложность: O(n), где n - длина строки
    //Пространственная сложность: O(1), используется константная память
    //Все три реализации корректно обрабатывают:
    //Начальные пробелы
    //Знаки + и -
    //Ведущие нули
    //Недопустимые символы (прекращают чтение)
    //Переполнение (возвращают граничные значения)
}

class Solution1 {
    public int myAtoi(String s) {
        // Initialize pointer for traversing the string
        int i = 0;
        // Get the length of the string
        int n = s.length();

        // Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check if end of string is reached after whitespaces
        if (i == n) {
            return 0;
        }

        // Determine the sign of the number
        int sign = 1; // Default sign is positive
        if (s.charAt(i) == '-') { // If current character is '-'
            sign = -1; // Set negative sign
            i++; // Move to next character
        } else if (s.charAt(i) == '+') { // If current character is '+'
            i++; // Move to next character (sign remains positive)
        }

        // Initialize variable to accumulate the result
        int result = 0;
        // Set boundaries for 32-bit signed integer
        int intMin = Integer.MIN_VALUE;
        int intMax = Integer.MAX_VALUE;

        // Convert digits to number
        while (i < n && Character.isDigit(s.charAt(i))) { // While there are digits
            int digit = s.charAt(i) - '0'; // Convert character to digit

            // Check for overflow before adding digit
            // For positive numbers
            if (sign == 1) {
                // Check if result * 10 + digit would exceed maximum value
                if (result > (intMax - digit) / 10) {
                    return intMax; // Return maximum value
                }
            }
            // For negative numbers
            else {
                // Check if result * 10 + digit would become less than minimum value
                // Note: we work with positive result and apply sign later
                if (-result < (intMin + digit) / 10) {
                    return intMin; // Return minimum value
                }
            }

            // Add digit to result
            result = result * 10 + digit;
            i++; // Move to next character
        }

        // Multiply result by sign and return
        return sign * result;
    }

    // Key features of Java implementation:
    // Method charAt(i) - get character by index
    // Method Character.isDigit() - check if character is a digit
    // Constants Integer.MAX_VALUE and Integer.MIN_VALUE - 32-bit integer boundaries
    // Char to int conversion: s.charAt(i) - '0' - subtract ASCII code of '0'
    // Overflow check nuance: must consider sign during check
    // Algorithm complexity:
    // Time complexity: O(n), where n is string length
    // Space complexity: O(1), constant memory used
    // All three implementations correctly handle:
    // Leading whitespaces
    // + and - signs
    // Leading zeros
    // Invalid characters (stop reading)
    // Overflow (return boundary values)
}