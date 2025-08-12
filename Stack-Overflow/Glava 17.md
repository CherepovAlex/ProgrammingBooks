# Глава 17. Библиотека для работы с датой и временем (java.time.*)

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



[к оглавлению Глава 17](#глава-17-библиотека-для-работы-с-датой-и-временем-javatime)

[Раздел 17.1. Вычислить разницу между двумя датами, представленными объектами LocalDate](#раздел-171-вычислить-разницу-между-двумя-датами-представленными-объектами-localdate)

[Раздел 17.2. Дата и время](#раздел-172-дата-и-время)

[Раздел 17.3. Операции со значениями даты и времени](#раздел-173-операции-со-значениями-даты-и-времени)


















