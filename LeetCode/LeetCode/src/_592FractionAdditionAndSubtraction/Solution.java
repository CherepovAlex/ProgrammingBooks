package _592FractionAdditionAndSubtraction;
// Дано выражение expression для сложения и вычитания дробей.
// Верните результат вычисления в строковом формате.
//Конечным результатом должна быть неприводимая дробь.
// Если ваш конечный результат — целое число, преобразуйте его в дробь со знаменателем 1.
// Таким образом, в данном случае 2 следует преобразовать в 2/1.
// Example 1:
//Input: expression = "-1/2+1/2"
//Output: "0/1"
//Example 2:
//Input: expression = "-1/2+1/2+1/3"
//Output: "1/3"
//Example 3:
//Input: expression = "1/3-1/2"
//Output: "-1/6"
// Ограничения:
//Во входной строке есть только '0' to '9', '/', '+' и '-'. То же самое и в выходной строке.
//Каждая дробь (входная и выходная) имеет формат ±numerator/denominator.
// Если первая входная или выходная дробь положительная, то '+' можно не указывать.
//На входе только корректные неприводимые дроби, где числитель и знаменатель каждой дроби
// всегда находятся в диапазоне [1, 10]. Если знаменатель равен 1, это означает,
// что данная дробь на самом деле является целым числом в формате дроби, указанном выше.
//Количество заданных дробей будет находиться в диапазоне [1, 10].
//Числитель и знаменатель конечного результата гарантированно будут действительными
// и будут находиться в диапазоне 32-битного целого числа.
import java.util.ArrayList;
import java.util.List;
public class Solution {

    public String fractionAddition(String expression) {
        List<Character> signs = new ArrayList<>(); // для хранения знаков перед дробями - + +
        List<Integer> numerators = new ArrayList<>();   // для хранения числителей 1 1 1
        List<Integer> denominators = new ArrayList<>(); // для хранения знаменателей 2 2 3

        // parse all fractions; Начинаем парсить строку с позиции 0
        int i = 0;
        while (i < expression.length()) {

            // determine sing; По умолчанию знак '+'
            char sign = '+';
            // Если текущий символ '+' или '-', сохраняем его и двигаем указатель
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = expression.charAt(i);
                i++;
            }
            signs.add(sign); // Добавляем знак в список

            // parse numerator; Запоминаем начало числа
            int numStart = i;
            // Пока идут цифры, двигаем указатель
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                i++;
            }   // Преобразуем подстроку в число (числитель)
            int numerator = Integer.parseInt(expression.substring(numStart, i));
            i++;    // skip '/' - Пропускаем символ '/'

            // parse denominator - Аналогично числителю, считываем знаменатель
            int denomStart = i;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                i++;
            }
            int denominator = Integer.parseInt(expression.substring(denomStart, i));
            // Добавляем числитель и знаменатель в соответствующие списки
            numerators.add(numerator);
            denominators.add(denominator);
        }

        //calculate common denominator; Вычисление общего знаменателя
        int commomDenominator = 1;  // Начинаем с 1
        for (int d : denominators) {
            commomDenominator = lcm(commomDenominator, d); // Для каждого знаменателя вычисляем НОК (наименьшее общее кратное)
        }

        // summ all fractions - Вычисление общего числителя
        int totalNumerator = 0; // Начинаем с 0
        for (int j = 0; j < numerators.size(); j++) {   // Для каждой дроби:
            int numerator = numerators.get(j);  // Берем числитель
            if (signs.get(j) == '-') {  // Если знак '-', делаем числитель отрицательным
                numerator = -numerator;
            }   //  Приводим к общему знаменателю и суммируем
            totalNumerator += numerator * (commomDenominator / denominators.get(j));
        }

        // simplify the fraction  Упрощение дроби
        int gcd = Math.abs(gcd(totalNumerator, commomDenominator)); // Находим НОД (наибольший общий делитель)
        totalNumerator /= gcd;  // Делим числитель и знаменатель на НОД для упрощения
        commomDenominator /= gcd;

        return totalNumerator + "/" + commomDenominator; //  Формируем строку результата
    }
    // Метод вычисления НОД (алгоритм Евклида)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    // Вычисляет наименьшее общее кратное через НОД по формуле: НОК(a,b) = a*b/НОД(a,b)
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        String expression1 = "-1/2+1/2";
        String expression2 = "-1/2+1/2+1/3";
        String expression3 = "1/3-1/2";
        String expression4 = "1/3+4/1-3/5-2/3+2/7";

        System.out.println(new Solution().fractionAddition(expression1));
        System.out.println(new Solution().fractionAddition(expression2));
        System.out.println(new Solution().fractionAddition(expression3));
        System.out.println(new Solution().fractionAddition(expression4));
    }
}
