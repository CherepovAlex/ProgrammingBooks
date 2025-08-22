package exercise.Consultation9_25_08_21;
// Эта программа читает CSV-файл (скорее всего, с финансовыми данными),
// извлекает числовые значения из четвертого столбца (индекс 3),
// суммирует их и подсчитывает количество успешно обработанных значений.
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example4 {

    public static void main(String[] args) throws IOException {
        // Создание объекта Path, который представляет путь к файлу
        // get - статический метод для создания пути
        Path src = Paths.get("C:\\credit_calculator.csv");
        double sum = 0.0; // Инициализация переменной для накопления суммы значений.
        int count = 0;    // Инициализация счетчика для подсчета обработанных записей.
        // автоматически закроет BufferedReader после выполнения блока
        // создает BufferedReader для чтения файла, указывает кодировку UTF-8 для правильного чтения символов
        try (BufferedReader bf = Files.newBufferedReader(src, StandardCharsets.UTF_8)) {
            String line; // читает следующую строку из файла,
           // условие продолжения цикла (пока есть что читать)
            while ((line = bf.readLine()) != null) {    // пока нет конца текста
                // Разделение строки на массив значений по запятой (CSV формат)
                // Параметр -1 сохраняет пустые значения в конце строки.
                String[] values = line.split(",", -1);
                // Пропуск строки, если в ней меньше 4 столбцов (нам нужен четвертый столбец).
                if (values.length < 4) continue;
                // Извлечение значения из 4-го столбца (индекс 3): удаляет двойные кавычки (часто встречается в CSV)
                String v = values[3].trim().replace("\"\"", "");
                // Пропуск пустых значений в четвертом столбце.
                if (v.isEmpty()) continue;
                try {
                    sum += Double.parseDouble(v); // преобразует строку в double
                    count++; // если успешно - добавляет к сумме и увеличивает счетчик
                } catch (NumberFormatException ignore) { //если возникает исключение (не числовое значение) -
                }                                        //  - игнорируется
            }
        }
        System.out.printf("Summa = %.2f, Count = %d ", sum, count);
    }
}
