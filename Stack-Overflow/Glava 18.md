# Глава 18. LocalTime

| **Метод**                      | **Возвращаемое значение**                                                                                                                       |
|:-------------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------|
| LocalTime.of(13, 12, 11)       | 13:12:11                                                                                                                                        |
| LocalTime.MIDNIGHT             | 00:00                                                                                                                                           |
| LocalTime.NOON                 | 12:00                                                                                                                                           |
| LocalTime.now()                | Текущее время по данным системных часов                                                                                                         |
| LocalTime.MAX                  | Максимальное возможное время 23:59:59.9999999999                                                                                                |
| LocalTime.MIN                  | Максимальное возможное время 00:00                                                                                                              |
| LocalTime.ofSecondOfDay(84399) | 23:59:59 , получает время по номеру секунды в сутках LocalTime.ofNanoOfDay(2000000000) 00:00:02 , получает время по номеру наносекунды в сутках |

## Раздел 18.1. Количество времени между двумя значениями LocalTime

Существует два эквивалентных способа вычисления количества единиц времени между двумя значениями `LocalTime`: 1) через методы `until(Temporal, TemporalUnit)` и 2) через метод `TemporalUnit.between(Temporal, Temporal)`.

```java
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class AmountOfTime {
    
    public static void main(String[] args) {
        
        LocalTime start = LocalTime.of(1, 0, 0);    // час, минута, секунда
        LocalTime end = LocalTime.of(2, 10, 20);    // час, минута, секунда
        
        long halfDays1 = start.until(end, ChronoUnit.HALF_DAYS);    // 0
        long halfDays2 = ChronoUnit.HALF_DAYS.between(start, end);  // 0
        
        long hours1 = start.until(end, ChronoUnit.HOURS);   // 1
        long hours2 = ChronoUnit.HOURS.between(start, end); // 1
        
        long minutes1 = start.until(end, ChronoUnit.MINUTES);   // 70
        long minutes2 = ChronoUnit.MINUTES.between(start, end); // 70
        
        long seconds1 = start.until(end, ChronoUnit.SECONDS);   // 4220
        long seconds2 = ChronoUnit.SECONDS.between(start, end); // 4220
        
        long millisecs1 = start.until(end, ChronoUnit.MILLIS);  // 4220000
        long millisecs2 = ChronoUnit.MILLIS.between(start, end);  // 4220000
        
        long microsecs1 = start.until(end, ChronoUnit.MICROS);      // 4220000000
        long microsecs2 = ChronoUnit.MICROS.between(start, end);    // 4220000000
        
        long nanosecs1 = start.until(and, ChronoUnit.NANOS);        // 420000000000
        long nanosecs2 = ChronoUnit.NANOS.between(start, end);      // 420000000000
        
        // При попытке использования других значений Chronounit, кроме выше приведённых,
        // будет выброшено исключение UnsupportedTemporalTypeException. Ниже приведены
        // примеры использования двух вышеописанных методов.
        long days1 = start.until(end, ChronoUnit.DAYS);
        long days2 = ChronoUnit.DAYS.between(start, end);
    }
}
```

[к оглавлению Глава 18](#глава-18-localtime)

## Раздел 18.2. Введение



[к оглавлению Глава 18](#глава-18-localtime)

[Раздел 18.1. Количество времени между двумя значениями LocalTime](#раздел-181-количество-времени-между-двумя-значениями-localtime)

[Раздел 18.2. Введение](#раздел-182-введение)