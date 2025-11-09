package ru.yandex;

import java.util.*;
import java.util.regex.*;

// Этот код реализует систему обработки данных с датчиков температуры и влажности, вычисляя средние значения с учетом
// погрешностей измерений через интервальную арифметику.

public class Main1 {
    public static void main(String[] args) {
        // Пример использования
        // Создает список тестовых входных строк с данными датчиков
        List<String> inputLines = Arrays.asList(
            "[\"Type\"=\"T\",\"ID\":\"1\",\"Value\":25,\"Accuracy\":2]",
            "[\"Type\"=\"T\",\"ID\":\"2\",\"Value\":23,\"Accuracy\":1]",
            "[\"Type\"=\"H\",\"ID\":\"3\",\"Value\":60,\"Accuracy\":5]"
        );

        List<String> results = processInputLines(inputLines);
        // Вызывает метод обработки входных данных и сохраняет результаты
        for (String result : results) {
            System.out.println(result);
        }
    }
    // статический метод для обработки списка строк
    public static List<String> processInputLines(List<String> inputLines) {
        ProcessingSensorData processor = new ProcessingSensorData();
        // Начинает цикл перебора всех входных строк
        for (String line : inputLines) {
            processor.parseInputLine(line); // Вызывает метод парсинга для каждой строки
        }

        return processor.processResults();  // Возвращает результаты обработки данных
    }
}

class Interval {
    // Объявляет приватные поля для левой и правой границ интервала
    private int left;
    private int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }
    // Объявляет статический метод создания интервала из значения и точности
    public static Interval fromValueAndAccuracy(int value, int accuracy) {
        // Создает и возвращает новый интервал [value-accuracy, value+accuracy]
        return new Interval(value - accuracy, value + accuracy);
    }

    public int getLeft() { return left; }   // Возвращает значение левой границы интервала
    public int getRight() { return right; } // Возвращает значение правой границы интервала
    // Объявляет метод сложения двух интервалов
    public static Interval add(Interval a, Interval b) {
        return new Interval(a.left + b.left, a.right + b.right);
    }
    // Объявляет метод вычитания интервалов
    public static Interval subtract(Interval a, Interval b) {
        return new Interval(a.left - b.right, a.right - b.left); // (минимально-максимальная разница)
    }
    // Объявляет метод умножения интервалов
    public static Interval multiply(Interval a, Interval b) {
        int[] products = {  // Создает массив всех возможных произведений границ
            a.left * b.left,
            a.left * b.right,
            a.right * b.left,
            a.right * b.right
        };
        int min = Arrays.stream(products).min().getAsInt(); // Находит минимальное значение в массиве произведений
        int max = Arrays.stream(products).max().getAsInt(); // Находит максимальное значение в массиве произведений
        return new Interval(min, max);      // Возвращает новый интервал [min, max]
    }
    // Объявляет метод деления интервалов
    public static Interval divide(Interval a, Interval b) {
        // Проверка деления на ноль
        if (b.left <= 0 && b.right >= 0) {
            throw new ArithmeticException("Division by interval containing zero");
        }
        // Создает массив всех возможных частных границ
        int[] divisions = {
            a.left / b.left,
            a.left / b.right,
            a.right / b.left,
            a.right / b.right
        };
        int min = Arrays.stream(divisions).min().getAsInt(); // Находит минимальное значение в массиве частных
        int max = Arrays.stream(divisions).max().getAsInt(); // Находит максимальное значение в массиве частных
        return new Interval(min, max);  // Возвращает новый интервал [min, max]
    }
    // Объявляет метод деления интервала на скаляр
    public Interval divideByScalar(int scalar) {
        if (scalar == 0) {
            throw new ArithmeticException("Division by zero");
        }       // Возвращает новый интервал с границами, поделенными на скаляр
        return new Interval(this.left / scalar, this.right / scalar);
    }

    @Override   // Переопределяет метод преобразования в строку
    public String toString() {
        return "[" + left + "," + right + "]";
    }
}

class SensorData {  // Объявляет приватные поля: тип датчика, ID, значение и точность
    private String type;
    private int id;
    private int value;
    private int accuracy;

    public SensorData(String type, int id, int value, int accuracy) {
        this.type = type;
        this.id = id;
        this.value = value;
        this.accuracy = accuracy;
    }
    // геттеры
    public String getType() { return type; }
    public int getId() { return id; }
    public int getValue() { return value; }
    public int getAccuracy() { return accuracy; }
    // Объявляет метод получения интервала значения
    public Interval getInterval() {
        return Interval.fromValueAndAccuracy(value, accuracy); // Возвращает интервал [value-accuracy, value+accuracy]
    }
}
// Объявляет класс для обработки данных датчиков
class ProcessingSensorData {    // Создает два списка для хранения данных температурных и влажностных датчиков
    private List<SensorData> temperatureSensors = new ArrayList<>();
    private List<SensorData> humiditySensors = new ArrayList<>();
    // Объявляет метод парсинга входной строки
    public void parseInputLine(String line) {
        // Создает регулярное выражение для разбора строки датчика
        Pattern pattern = Pattern.compile("\\[\"Type\"=\"([TH])\",\"ID\":\"(\\d+)\",\"Value\":(-?\\d+),\"Accuracy\":(\\d+)\\]");
        Matcher matcher = pattern.matcher(line); // Создает объект Matcher для сопоставления строки с регулярным выражением
        // Проверяет, соответствует ли строка шаблону
        if (matcher.find()) {
            String type = matcher.group(1); // Извлекает тип датчика (T или H) из первой группы регулярного выражения
            int id = Integer.parseInt(matcher.group(2));    // Извлекает и преобразует в int ID датчика из второй группы
            int value = Integer.parseInt(matcher.group(3)); // Извлекает и преобразует в int значение датчика из третьей группы
            int accuracy = Integer.parseInt(matcher.group(4)); // Извлекает и преобразует в int точность датчика из четвертой группы
                                // Создает новый объект SensorData с извлеченными значениями
            SensorData sensorData = new SensorData(type, id, value, accuracy);

            if ("T".equals(type)) { // Проверяет, является ли датчик температурным
                temperatureSensors.add(sensorData); // Добавляет датчик в список температурных датчиков
            } else if ("H".equals(type)) {  // Проверяет, является ли датчик влажностным
                humiditySensors.add(sensorData); // Добавляет датчик в список влажностных датчиков
            }
        }
    }
    // Объявляет метод обработки результатов
    public List<String> processResults() {
        List<String> results = new ArrayList<>();   // Создает список для хранения результатов

        if (temperatureSensors.isEmpty()) { // Проверяет, есть ли температурные датчики
            results.add("Temp: none");
        } else {
            Interval tempSum = new Interval(0, 0);  // Создает начальный интервал-сумму [0,0]
            for (SensorData sensor : temperatureSensors) {    // Начинает цикл по всем температурным датчикам
                tempSum = Interval.add(tempSum, sensor.getInterval()); // Добавляет интервал текущего датчика к общей сумме
            }           // Вычисляет средний интервал делением суммы на количество датчиков
            Interval tempAverage = tempSum.divideByScalar(temperatureSensors.size());
                        // Форматирует и добавляет строку результата для температуры
            results.add(String.format("Temp: [%d, %d] from %d samples",
                tempAverage.getLeft(), tempAverage.getRight(), temperatureSensors.size()));
        }

        if (humiditySensors.isEmpty()) {    // Проверяет, есть ли влажностные датчики
            results.add("Humidity: none");
        } else {                            // Создает начальный интервал-сумму [0,0]
            Interval humiditySum = new Interval(0, 0);
            for (SensorData sensor : humiditySensors) { // Начинает цикл по всем влажностным датчикам
                humiditySum = Interval.add(humiditySum, sensor.getInterval()); // Добавляет интервал текущего датчика к общей сумме
            }               // Вычисляет средний интервал делением суммы на количество датчиков
            Interval humidityAverage = humiditySum.divideByScalar(humiditySensors.size());
            // Форматирует и добавляет строку результата для влажности
            results.add(String.format("Humidity: [%d, %d] from %d samples",
                humidityAverage.getLeft(), humidityAverage.getRight(), humiditySensors.size()));
        }

        return results;
    }
}