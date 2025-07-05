package exercise;

import java.util.Date;

public class TestFormats {

    public static void main(String[] args) {

        String s = String.format("%, d", 1000000000);   // 1,000,000,000

        String.format("Мне нужно исправить %2.f ошибка", 476578.09876); // 476578.10

        String.format("Мне нужно исправить %,2.f ошибка", 476578.09876); // 476,578.10

        String.format("%d", 42);  // "__42.0"

        String.format("%d", 42);  // 42

        String.format("%.3f", 42.000000);  // 42.000

        String.format("%x", 42);  // 16x: 2a

        String.format("%c", 42);  // char: *

        int one = 20456654;
        double two = 100567890.248907;
        String s1 = String.format("Уровень %,d из %,.2f", one, two); // ... 20,456,654 из 100,567,890.25

        String.format("%tc", new Date());  // Вос Ноя 28 14:52:1 MST 2004

        String.format("%tк", new Date());  // 03:01:47 PM

        Date today = new Date();
        String.format("%tA, %tB %td", today, today, today); // Восересенье, Ноябрь 28

        Date today1 = new Date();
        String.format("%tA, %<tB %<td", today); // Восересенье, Ноябрь 28

    }

}
