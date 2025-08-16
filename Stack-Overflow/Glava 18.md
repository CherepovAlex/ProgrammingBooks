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

Существует два эквивалентных способа вычисления количества единиц времени между двумя значениями `LocalTime`: 
1) через методы `until(Temporal, TemporalUnit)` и 
2) через метод `TemporalUnit.between(Temporal, Temporal)`.

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

`LocalTime` - это неизменямый класс (т.е. класс, объекты которого не могут быть изменены после создания), безопасный для потоков, который используется для предоставления времени в формате "часы-минуты-секунды". Время представляется с точностью до наносекунды. Например, в экземпляре класса `LocalTime` может храниться значение "13:45.30.123456789".

Этот класс не хранит и не представляет дату или часовой пояс. Вместо этого он представляет время в виде, подобном тому, как отображают время электронные часы на стене. Он не может представить момент времени на линии времени без дополнительной информации, такой как смещение или часовой пояс. Он основан на работе со значениями, а не ссылками, поэтому для сравнений следует использовать метод `equals`.

**Поля**

`MAX` - Максимально возможное время в `LocalTime`, `23:59:59.999999999`. `MIDNIGHT`, `MIN`, `MOON`.

**Важные статические методы**

`now(), now(Clock clock), now(ZoneId zone), parse(CharSequence text)`

**Важные методы объекты**

`isAfter(LocalTime other), isBefore(LocalTie other), minus(TemporalAmount amountToSubstract), minus(long amountToSubtract, TemporalUnit unit), plus(TemporalAmount amountToAdd), plus(long amountToAdd, TemporalUnit unit)`.

```java
ZoneId zone = ZoneId.of("Asia/Kolkata");
LocalTime now = LocalTime.now();
LocalTime now1 = LocalTime.now(zone);
LocalTime then = LocalTime.parse("04:16:40");
```

Разница между двумя значениям времени может быть рассчитана одни из следующих способов

```java
long timeDiff = Duration.between(now, now1).toMinutes();
long timeDiff1 = java.time.temporal.ChronoUnit.MINUTES.between(now2, now1);
```

Вы также можете добавлять/вычитать часы, минуты или секунды из любого объекта `LocalTime`.

`minusHours(long hoursToSutrct), minusMinutes(long hoursToMinutes), minusNanos(longnanosToSubtract), minusSeconds(long secondsToSubtract), 
plusHours(long hoursToSubtract), plusMinutes(long hoursToMinutes), plusNanos(long nanosToSubtract), plusSeconds(long secondsToSubtract)`

```java
now.plusHours(1L);
now1.minusMinutes(20L);
```

[к оглавлению Глава 18](#глава-18-localtime)

## Раздел 18.3. Изменение времени


[к оглавлению Глава 18](#глава-18-localtime)

[Раздел 18.1. Количество времени между двумя значениями LocalTime](#раздел-181-количество-времени-между-двумя-значениями-localtime)

[Раздел 18.2. Введение](#раздел-182-введение)

[Раздел 18.3. Изменение времени](#раздел-183-изменение-времени)