# Глава 17. Библиотека для работы с датой и временем (java.time.*)

[Раздел 17.1. Вычислить разницу между двумя датами, представленными объектами LocalDate](#раздел-171-вычислить-разницу-между-двумя-датами-представленными-объектами-localdate)

[Раздел 17.2. Дата и время](#раздел-172-дата-и-время)

[Раздел 17.3. Операции со значениями даты и времени](#раздел-173-операции-со-значениями-даты-и-времени)

[Раздел 17.4. Класс Instant](#раздел-174-класс-instant)

[Раздел 17.5. Использование различных классов для работы с Date Time API ](#раздел-175-использование-различных-классов-для-работы-с-date-time-api-)

[Раздел 17.6. Форматирование даты и времени](#раздел-176-форматирование-даты-и-времени)

[Раздел 17.7. Простые действия с датами](#раздел-177-простые-действия-с-датами)

## Раздел 17.1. Вычислить разницу между двумя датами, представленными объектами LocalDate

Для этого следует воспользоваться возможностями класса `LocalDate` и перечисления `ChronoUnit`:

```java
LocalDate d1 = LocalDate.of(2017, 5, 1);
LocalDate d2 = LocalDate.of(2017, 5, 18);
```

теперь, поскольку метод `between` объекта-перечисления `ChronoUnit` принимает в качестве параметра 2 интерфейса `Temporal`, через которые можно без проблем передавать экземпляры класса `LocalDate`, разницу между датами можно определить так:

```java
long days = ChronoUnit.DAYS.between(d1, d2);
System.out.println(days);
```

[к оглавлению Глава 17](#глава-17-библиотека-для-работы-с-датой-и-временем-javatime)

## Раздел 17.2. Дата и время

Дата и время без информации о часовом поясе

```java
LocalDateTime dateTime = LocalDateTime.of(2016, Month.JULY, 27, 8, 0);
LocalDateTime now = LocalDateTime.now();
LocalDateTime parsed = LocalDateTime.parse("2016-07-27T07:00:00");
```

Дата и время с информацией о часовом поясе

```java
ZoneId zoneId = ZoneId.of("UTC+2");
ZoneDateTime dateTime = ZoneDateTime.of(2016, Month.JULY, 27, 7, 0, 0, 235, zoneId);
ZoneDateTime composition = ZoneDateTime.of(localDate, localTime, zoneId);
ZoneDateTime now = ZoneDateTime.now();  // часовой пояс по умолчанию
ZoneDateTime parsed = ZoneDateTime.parse("2016-07-27T07:00:00+01:00[Europe/Stockholm]");
```

Дата и время с информацией о смене часового пояса (т.е. без учета изменения времени суток)

```java
ZoneOffset zoneOffset = ZoneOffset.ofHours(2);
OffserDateTime dateTime = OffsetDateTime.of(2016, 7, 27, 7, 0, 0, 235, zoneOffset);
OffsetDateTime composition = OffsetDateTime.of(localDate, localTime, zoneOffset);
OffsetDateTime now = OffsetDateTime.now();  // Смещение берётся из стандартного ZoneId
OffsetDateTime parsed = OffsetDateTime.parse("2016-07-27T07:00:00+02:00");
```

[к оглавлению Глава 17](#глава-17-библиотека-для-работы-с-датой-и-временем-javatime)

## Раздел 17.3. Операции со значениями даты и времени

```java
LocalDate tomorrow = LocalDate.now().plusDays(1);
LocalDateTime anHourFromNow = LocalDateTime.now().plusHours(1);
Long daysBetween = java.time.temporal.Chronounit.DAYS.between(LocalDate.now(), LocalDate.now().plusDays(3));    // 3
Duration duration = Duration.between(Instant.now(), ZonedDateTime.parse("2016-07-27T07:00:00+01:00[Europe/Stockholm]"));
```

[к оглавлению Глава 17](#глава-17-библиотека-для-работы-с-датой-и-временем-javatime)

## Раздел 17.4. Класс Instant

Представляет собой определённый момент во времени. Можно рассматривать как класс-обёртку для временной метки в формате ОС Unix.

```java
Instant now = Instant.now();
Instant epoch1 = Instant.ofEpochMilli(0);
Instant epoch2 = Instant.parse("1970-01-01T00:00:00Z");
java.time.temporal.ChronoUnit.MICROS.betweet(epoch1, epoch2);   // 0
```

[к оглавлению Глава 17](#глава-17-библиотека-для-работы-с-датой-и-временем-javatime)

## Раздел 17.5. Использование различных классов для работы с Date Time API 
 
Следующие примеры содержат пояснения, необходимые для понимания их работы.

```java
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class SomeMethodsExamples {

/**
 * Содержит методы класса {@link LocalDateTime}
  */
public static void checkLocalDateTime() {
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println("Local Date time using static now() method ::: >>> " + localDateTime);

    LocalDateTime ldt1 = LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("AET")));
    System.out.println("LOCAL TIME USING now(ZoneId zoneId) method ::: >>> " + ldt1);

    LocalDateTime ldt2 = LocalDateTime.now(Clock.system(ZoneId.of(ZoneId.SHORT_IDS.get("PST"))));
    System.out.println("LOCAL TIME USING now(Clock.system(ZoneId.of())) ::: >>> " + ldt2);

    System.out.println("now() is overridden to take ZoneId as parameter using this we can get the same date under different timezones.");
    System.out.println(ZoneId.SHORT_IDS);

}

/**
 * Содержит методы класса {@link LocalDate}
  */
public static void checkLocalDate() {
    LocalDate localDate = LocalDate.now();
    System.out.println("Получает дату без времени с помощью метода now(). >> " + localDate);
    LocalDate localDate2 = LocalDate.now(ZoneId.of(ZoneId.SHORT_IDS.get("ECT")));
    System.out.println("now() переопределена для принятия ZoneID в качестве параметра, используя это, мы можем получить одну и ту же дату в разных часовых поясах. >> " + localDate2);
    }

/**
 * Содержит методы абстрактного класса {@link Clock}. Класс Clock может быть
 * использован для получения времени с учетом временных зон {@link TimeZone}.
  */
public static void checkClock() {
    Clock clock = Clock.systemUTC();
    // Отражает время в соответствии с ISO 8601
    System.out.println("Время, полученное при использовании класса Clock : " + clock.instant());
}

/**
 * Содержит методы класса {@link Instant}* 
 */
public static void checkInstant() {
    Instant instant = Instant.now();
    
    System.out.println("Класс Instant, использующий метод now() :: " + instant);
    
    Instant ins1 = Instant.now(Clock.systemUTC());
    
    System.out.println("Класс Instant, использующий метод now(Clock clock) :: " + ins1);
}

/**
 * Этот класс проверяет работу методов класса {@link Duration}
 */
public static void checkDuration() {
    // toString() преобразует длительность в формат PTnHnMnS в соответствии
    // со стандартом ISO 8601. Если поле равно нулю, то оно игнорируется.
    
    // P - обозначение длительности (исторически называемое "периодом"), расположено
    // в начале строки представления длительности
    // Y - обозначение года, которое помещается после числового значение количества лет
    // M - обозначение месяца, которое помещается после числового значения количества месяцев
    // W - обозначение недели, которое помещается после числового значения количества недель
    // D - обозначение дней, которое помещается после числового значения количества дней
    // T - обозначение времени, расположено в начале строки представления времени
    // H - обозначение часа, которое помещается после числового значения количества часов
    // M - обозначение минут, которое помещается после числового значения количества минут
    // S - обозначение секунд, которое помещается после числового значения количества секунд
    
    System.out.println(Duration.ofDays(2));
}

/**
 * Выводит время без дат. Этот метод не сохраняет время и не выводит дату совместно
 * с временем. Вместо этого он представляет время в виде, подобно тому, как отображают
 * время электронные часы на стене
 */
public static void checkLocalTime() {
    LocalTime localTime = LocalTime.now();
    System.out.println("LocalTime :: " + localTime);
}

/**
 * Выводит дату и время с указанием часового пояса в стандарте ISO-8601
 */
public static void checkZoneDateTime() {
    ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("CST")));
    System.out.println(zonedDateTime);
}
}
```

[к оглавлению Глава 17](#глава-17-библиотека-для-работы-с-датой-и-временем-javatime)

## Раздел 17.6. Форматирование даты и времени

До появления Java 8 в пакете `java.text` существовали классы `Dateformat` и `SimpleDateFormat`, и этот код, унаследованный последними версиями языка, будет использоваться ещё некоторое время.

Однако одновременно с этим Java 8 предлагаете и современный подход к работе с форматированием и разбором строк, содержащих дату.

При форматировании и разборе вы сначала передаёте объект `String` в объект `DateTimeFormatter`, а тот, в свою очередь, используется свои методы для форматирования или разбора переданной ему строки.

```java
import java.time.*;
import java.time.format.*;

class DateTimeFormat {
    public static void main(String[] args) {
        // разбор строки
        String pattern = "d-MM-yyyy HH:mm";
        // d — день месяца (без ведущего нуля), MM — месяц (с ведущим нулём), yyyy — год (4 цифры)
        // HH — часы в 24-часовом формате, mm — минуты.
        DateTimeFormatter dtF1 = DateTimeFormatter.ofPattern(pattern);
        
        LocalDateTime ldp1 = LocalDateTime.parse("2014-03-25T01:30"); // Формат по умолчанию
        LocalDateTime ldp2 = LocalDateTime.parse("15-05-2016 13:55", dtF1); // Нестандартный формат
        
        System.out.println(ldp1 + "\n" + ldp2); // Выводится в формате по умолчанию
        
        // Форматирование строки с датой
        DateTimeFormatter dtF2 = DateTimeFormatter.ofPattern("EEE d, MMM, yyyy HH:mm");
        // EEE — сокращенное название дня недели (например, "Пн"), d — день месяца
        // MMM — сокращенное название месяца (например, "Мар"), yyyy — год, HH:mm — время
        DateTimeFormatter dtF3 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        
        LocalDateTime ldtf1 = LocalDateTime.now();
        
        System.out.println(ldtf1.format(dtF2) + "\n" + ldtf1.format(dtF3));
    }
}
```

Важное замечание: вместо использования пользовательских шаблонов лучше использовать предопределённые форматы. Ваш код будет выглядеть более понятным, а поддержание стандарта `ISO8061` будет вам очень полезно в долгосрочной перспективе.

[к оглавлению Глава 17](#глава-17-библиотека-для-работы-с-датой-и-временем-javatime)

## Раздел 17.7. Простые действия с датами

Получить текущую дату.

`LocalDate.now()`

Получить дату вчерашнего дня.

`LocalDate y = LocalDate.now().minusDays(1);`

Получить дату завтрашнего дня

`LocalDate t = LocalDate.now().plusDays(1);`

Получить дату конкретного дня.

`LocalDate t = LocalDate.of(1974, 6, 2, 8, 30, 0, 0);`

Помимо методов с префиксами `plus` и `minus`, существует набор методов с префиксом `with`, которые могут быть использованы для установки определённого поля объекта `LocalDate`.

`LocalDate.now().withMonth(6);`

Приведённый пример возвращает новый объект `LocalDate` с месяцем, установленным на июнь (этим он отличается от метода `setMonth` класса `java.util.Date`, где месяцы индексируются от 0, и, следовательно, июню соответствует число 5).

Поскольку манипуляции с объектом `LocalDate` возвращают неизменяемые экземпляры класса `LocalDate`, эти методы могут быть объединены в цепочку.

`LocalDate ld = LocalDate.now().plusDays(1).plusYears(1);`

Таким образом, мы узнаем, какая дата будет у завтрашнего дня, через год.

[к оглавлению Глава 17](#глава-17-библиотека-для-работы-с-датой-и-временем-javatime)