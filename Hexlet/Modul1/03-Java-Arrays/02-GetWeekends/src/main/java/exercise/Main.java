// Допишите публичный статический метод getWeekends(), который возвращает массив из двух элементов – названий
// выходных дней на английском. Метод принимает на вход параметр – формат возврата в виде строки.
// Всего есть два возможных значения:
//"long" (по умолчанию) – массив содержит строки "saturday" и "sunday"
//"short" – массив содержит строки "sat" и "sun"
package exercise;

import java.util.Arrays;

public class Main {
    public static String[] getWeekends(String format) {
        // BEGIN
        String[] longFormats = {"saturday", "sunday"};
        String[] shortFormats = {"sat", "sun"};
        switch (format) {
            case "long":
                return longFormats;
            case "short":
                return shortFormats;
            default:
                return longFormats;
        }
        // END
    }
    public static void main(String[] args) {
        // Вывод не показан, так как это равносильно ответу
        System.out.println(Arrays.toString(Main.getWeekends("short")));
        System.out.println(Arrays.toString(Main.getWeekends("long")));
        // Если передано любое другое значение параметра,
        // то это равносильно вызову с параметром "long"
        System.out.println(Arrays.toString(Main.getWeekends("a")));
    }
}