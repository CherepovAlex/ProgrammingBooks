# Глава 16. Класс Date

| **Параметр**       | **Пояснение**                                                                                                       |
|:-------------------|:--------------------------------------------------------------------------------------------------------------------|
| Без параметра      | При пояснении конструктор инициализирует новый объект Date c текущей датой и временем (с точностью до миллисекунды) |
| Значение типа long | Создаёт новый объект Date с временем, установленным в миллисекундах, истекших с получночи 1 января 1970 г.          |

## Раздел 16.1. Преобразование экземпляра класса java.util.Date в экземпляр класса java.sql.Date

Преобразование экземпляра класса `java.util.Date` в экземпляр класса `java.sql.Date` обычно необходимо, когда объект `Date` нужно разместить в базе данных.

Класс `java.sql.Date` является оберткой для значения даты в миллисекундах и используется `JDBC` (`Java DataBase Connectivity` - `соединение с базами данных в Java`) для определения типа даны для базы данных `SQL DATE`.

В приведённом ниже примере мы используем конструктор класса `java.util.Date()`, который создаёт объект `Date` и инициализирует его для представления времени с точностью до миллисекунды. Эта дата используется в методе `convert` (`java.util.Date utilDate`) для возврата объекта `java.sql.Date`

**Пример**

```java
public class UtilToSqlConversion {
    
    public static void main(String[] args) {
        java.util.Date utilDate = new java.util.Date();
        System.out.println("java.util.Date is : " + utilDate);
        java.sql.Date sqlDate = convert(utilDate);
        System.out.println("java.sql.Date is : " + sqlDate);
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
        System.out.println("dateFormated date is : " + df.format(utilDate));
    }
    
    private static java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
```

Вывод:

```bash
java.util.Date is : Fri Jul 22 14:40:35 IST 2016
java.sql.Date is : 2016-07-22
dateFormated date is : 22/07/2016 - 02:40:35
```

Класс `java.util.Date` содержит информацию о дате и времени, в то время как класс `java.sql.Date` содержит только информацию о дате.

[к оглавлению Глава 16](#глава-16-класс-date)

## Раздел 16.2. Вывод даты в основном формате

Используя следующий код со строкой формата `yyyy/MM/dd hh:mm.ss`, мы получим результат вида:

```java
    2016/04/19 11:45.36

// задать требуемый формат даты
String formatString = "yyyy/MM/dd hh:mm.ss";

// получить объект с текущей датой
Date date = Calendar.getInstance().getTime();

// создать экземпляр класса, форматирующего дату
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);

// форматирование даты
String fomattedDate = simpleDateFormat.format(date);

// вывести на экран
System.out.printkn(formattedDate);

// однострочная версия всего приведённого выше кода
System.out.println(new SimpleDateFormat("yyyy/MM/dd hh:mm.ss").format(Calendar.getInstance().getTime()));
```

## Раздел 16.3. Объекты LocalDate и LocalDateTime в версии Java 8

Объекты `Date` и `LocalDate` не могут быть точно преобразованы друг в друга, поскольку `Date` представляет конкретный день и время, а объект `LocalDate` не содержит информации о времени и часовом поясе. Тем не менее, преобразование между ними может быть полезным в том случае, если вам нужна информация только о дате, и не требуется информация о времени.

**Создание объекта LocalDate**

```java
// Создание объекта LocalDate, содержащего текущую дату по умолчанию
LocalDate lDate  = LocalDate.now();

// Создание даты на основании указанного значения даты
lDate = LocalDate.of(2017, 12, 15);

// Создание даты на основе значения, заданного в виде строки
lDate = LocalDate.parse("2017-12-15");

// Создать дату из зоны
LocalDate.now(ZoneId.systemDefault());
```

**Создание объекта LocalDateTime**

```java
// Создание объекта LocalDateTime, содержащего текущие дату и время по умолчанию
LocalDateTime lDateTime = LocalDateTime.now();

// Создание даты и времени на основе указанных значений
lDateTime = LocalDateTime.of(2017, 12, 15. 11, 30);

// Создание даты и времени на основе значений, заданных в виде строки
lDateTime = LocalDateTime.parse("2017-12-05T11:30:30");

// Создание даты и времени из зоны
LocalDateTime.now(ZoneId.systemDefault());
```

**Преобразование объекта LocalDate в объект Date и обратное преобразование**

```java
Date date = Date.from(Instant.now());
ZoneId defaultZoneId = ZoneId.systemDefault();

// Преобразование объекта Date в объект LocalDate
LocalDate localDate = date.toInstant().atZone(defaultZoneId).toLocalDate();

// Преобразование объекта LocalDate в объект Date
Date.from(localDate.atStartOfDate(defaultZoneId).toInstant());
```

**Преобразование объекта LocalDateTime в объект Date и наоборот**

```java
Date date = Date.from(Instant.now());
ZoneId defaultZoneId = ZoneId.systemDefault();

// Преобразование объекта Date в объект LocalDateTime
LocalDateTime localDateTime = date.toInstant().atZone(defaultZoneId).toLocalDateTime();

// Преобразование объекта LocalDateTime в объект Date
Date out = Date.from(localDateTime.atZone(defaultZoneId).toInstant());
```

[к оглавлению Глава 16](#глава-16-класс-date)

## Раздел 16.4. Создание конкретной даты.

Несмотря на то, что класс `Date` в языке Java имеет несколько конструкторов, можно заметить, что большинство их них уже устарело. Единственным приемлемым способом создания экземпляра `Date` напрямую является использование конструктора без параметров или передача значения типа `long` (задающего дату в виде количества миллисекунд от стандартного базового времени). Но ни то, ни другое не является удобным, если только вам не требуется текущая дата или у вас уже есть другой экземпляр класса `Date`.

Чтобы создать новую дату, необходимо создать экземпляр класса `Calendar`. Далее можно установить в экземпляре календаря требуемую дату.

```java
Calendar c = Calendar.getInstance();
```

В результате возвращается новый экземпляр `Calendar`, установленный на текущее время. Класс `Calendar` имеет множество методов для изменения даты и времени или установки их в произвольное значение. В данном случае мы установим определённую дату.

```java
c.set(1974, 6, 2, 8, 0, 0);
Date d = c.getTime();
```

Метод `getTime` возвращает необходимый нам экземпляр `Date`. Следует помнить, что семейство методов `set` класса `Calendar` устанавливают только одно или несколько полей, но не устанавливают их все. То есть, если вы установите год, то остальные поля останутся неизменными.

**Подводные камни**

Для большинства ситуаций этот фрагмент кода справляется со своей задачей, но при этом следует помнить, что здесь не определены две важные компоненты, касающиеся установки даты/времени.

+ параметры (1974, 6, 2, 8, 0, 0) интерпретируются в рамках часового пояса по умолчанию, который задаётся в другом месте.
+ значение, определяющее количество миллисекунд, не равно нулю, а устанавливается из системных часов на момент создания экземпляра `Calendar`.

[к оглавлению Глава 16](#глава-16-класс-date)

## Раздел 16.5. Преобразование даты в определённый формат строки

Метод `format()` из класса `SimpleDateFormat` позволяет преобразовать объект `Date` в объект `String`, формат которого определяется задаваемой строкой-шаблоном.

```java
Date today = new Date();

SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
// Здесь указывается шаблон
System.out.println(dateFormat.format(today));   // 25-Feb-16
```

Строки-шаблоны могут быть применены повторно с помощью функции applyPattern()

```java
dateFormat.applyPatten("dd-MM-yyy");
System.out.println(dateFormat.format(today));   // 25-02-2016

dateFormat.applyPattern("dd-MM-yyyy HH:mm:ss E");
System.out.println(dateFormat.format(today));   // 25-02-2016 06:14:33 Thu
```

_Примечание:_ здесь `mm` (маленькие буквы 'm') обозначают минуты, а `MM` (большие буквы `M`) - месяц. Будьте внимательные при форматировании года: прописная буква "Y" (`Y`) обозначает "неделю в году", а строчная "y" - год.


[к оглавлению Глава 16](#глава-16-класс-date)

## Раздел 16.6. LocalTime



[к оглавлению Глава 16](#глава-16-класс-date)

[Раздел 16.1. Преобразование экземпляра класса java.util.Date в экземпляр класса java.sql.Date](#раздел-161-преобразование-экземпляра-класса-javautildate-в-экземпляр-класса-javasqldate)

[Раздел 16.2. Вывод даты в основном формате](#раздел-162-вывод-даты-в-основном-формате)

[Раздел 16.3. Объекты LocalDate и LocalDateTime в версии Java 8](#раздел-163-объекты-localdate-и-localdatetime-в-версии-java-8)

[Раздел 16.4. Создание конкретной даты](#раздел-164-создание-конкретной-даты)

[Раздел 16.5. Преобразование даты в определённый формат строки](#раздел-165-преобразование-даты-в-определённый-формат-строки)

[Раздел 16.6. LocalTime](#раздел-166-localtime)
















