package ComputerScienceCenter.lection4;

import ComputerScienceCenter.lection4.interfaceApp.Weekday;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringJoiner;

public class StringTest {
    public static void main(String[] args) {
        String string = "Hello World!";

        String empty = "";

        String newEmptyString = new String();   // не смысла создавать объект, лучше строковый литерал

        String newNonEmptyString = new String("Hello World!"); //   аналогично

        String fromChars = new String(new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'});

        "Hello World!".startsWith("Hello");
        "Hello World!".endsWith("World!");
        "Hello World!".contains(" ");
        "Hello World!".equalsIgnoreCase("hELLO wOrLd!");
        "Hello World!".indexOf('e');
        "Hello World!".indexOf("oo");
        "Hello World!".lastIndexOf("o", 10);    // поиск с конца c индекса 10
        "Hello World!".replace('o', 'a');
        "Hello World!".replaceFirst("^Hello", "Goobye"); // не более 1 замены
        "Hello World!".replaceAll("\\w", "x");           // все вхождения (w - любая буква алфавита)
        "  Hello World!  ".trim();
        "Hello World!".substring(6);
        "Hello World!".substring(6, 11);
        "Hello World!".split(" ");

        // опасайтесь локализации по умолчанию
        String string1 = "INT";
        String lower1 = string1.toLowerCase();
        System.out.println(lower1);  // int
        System.out.println(lower1.equals("int"));    // true обычно
        System.out.println(lower1.equals("int"));    // false в турецкой java -Duser.langiage=tr
        // решение
        String string2 = "INT";
        String lower2 = string2.toLowerCase(Locale.ROOT);
        System.out.println(lower2.equals("int"));  // true

        // строки и байты - всё зависит от кодировки по умолчанию
        new String(new byte[]{72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33}); // перевод в строку ок
        "Hello World!".getBytes();  // перевод в массив байт - байтам не соответствуют символы
        // как правильно - перегрузка создания массива
        System.out.println(new String(new byte[]{72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33},
                StandardCharsets.UTF_8));
        System.out.println(Arrays.toString("Helo World!".getBytes(StandardCharsets.UTF_8)));

        // как не правильно - чтения из файла
        // файлы состоят из байтов, а если читать из Reader'ов, то будем получать строки
        // new FileReader("/etc/passwd"); - использует системную кодировку

        // как правильно
        // Files.newBufferedReader(Paths.get("/etc/passwd"));      // Java 7
        // new FileReader("/etc/passwd", StandardCharsets.UTF_8);  // Java 11
        // new FileReader("/etc/passwd"); использует UTF_8 by Default (Java 18+)

        // String.format()
        String make = "Make";
        String java = "Java";
        String great = "great";
        String again = "again!";
        String slogan = String.format("%s %s %s %s", make, java, great, again);
        System.out.println(slogan);
        // есть перегрузка - полезна для вывода дробных чисел через точку или запятую как разделитель
        String slogan1 = String.format(Locale.ENGLISH,"%s %s %s %s", make, java, great, again);
        // альтернативный вариант форматирования
        String slogan2 = MessageFormat.format("{0} {1} {2} {3}", make, java, great, again);
        // формирование строк - склейка через разделитель
        String slogan3 = String.join(" ", make, java, great, again);

        // StringBuilder лучше "string и +", т.к. имеет буфер для сложения строк
        StringBuilder allWeekdays = new StringBuilder();
        for (Weekday weekday : Weekday.values()) {
            allWeekdays.append(weekday).append("\n");
        }
        System.out.println(allWeekdays);

        // StringJoiner тоже лучше через цикл
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (Weekday weekday : Weekday.values()) {
            joiner.add(weekday.name());
        }
        System.out.println(joiner);
    }
}
