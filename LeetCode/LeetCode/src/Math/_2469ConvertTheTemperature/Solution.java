package Math._2469ConvertTheTemperature;

import java.util.Arrays;

// Вам дано неотрицательное число с плавающей запятой, округлённое до двух знаков после запятой celsius,
// которое обозначает температуру в градусах Цельсия.
// Вам нужно преобразовать градусы Цельсия в кельвины и градусы Фаренгейта и вернуть результат в виде
// массива ans = [kelvin, fahrenheit].
//Верните массив ans. Ответы в пределах 10-5 от фактического ответа будут приняты.
//Обратите внимание, что: Kelvin = Celsius + 273.15 Fahrenheit = Celsius * 1.80 + 32.00
// Example 1:
//Input: celsius = 36.50
//Output: [309.65000,97.70000]
//Explanation: Temperature at 36.50 Celsius converted in Kelvin is 309.65 and converted in Fahrenheit is 97.70.
// Example 2:
//Input: celsius = 122.11
//Output: [395.26000,251.79800]
//Explanation: Temperature at 122.11 Celsius converted in Kelvin is 395.26 and converted in Fahrenheit is 251.798.
public class Solution {
    // Метод для конвертации температуры из Цельсия в Кельвины и Фаренгейты
    public double[] convertTemperature(double celsius) {
        // Создание массива результатов и непосредственное вычисление значений:
        // - kelvin = celsius + 273.15 (преобразование в Кельвины)
        // - fahrenheit = celsius * 1.80 + 32.00 (преобразование в Фаренгейты)
        double[] ans = {celsius + 273.15, celsius * 1.80 + 32.00};
        return ans; // Возврат массива с результатами преобразования
    }

    public static void main(String[] args) {
        double d = 36.50;
        double d1 = 122.11;
        System.out.println(Arrays.toString(new Solution().convertTemperature(d)));
        System.out.println(Arrays.toString(new Solution().convertTemperature(d1)));
    }
}
