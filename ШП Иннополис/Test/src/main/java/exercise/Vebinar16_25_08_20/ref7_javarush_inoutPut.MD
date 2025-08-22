# Как работать с файлами и Input/Output в Java

_Это руководство разъясняет, как создавать, читать, записывать и удалять файлы в Java. 
Вы также узнаете, как работают классы `File`, `InputStream` и `OutputStream`._

## Введение

В Java файлы представлены классом `File`. 
Класс `File` предоставляет методы для создания, чтения, записи и удаления файлов.

`Input/output` (`I/O`, ввод/вывод) — это процесс передачи данных между программой и внешним источником, таким как файл, сетевой сокет или консоль. 
Java предоставляет множество классов для ввода/вывода, включая классы `InputStream` и `OutputStream`.

## Создание файлов

Для создания файла можно использовать метод `File.createNewFile()`. 
Он создаст новый файл, если файл с таким названием еще не существует. 
Если же такой файл уже есть, то метод `createNewFile()` выдаст исключение `IOException`.

Вот пример того, как создать новый файл с именем `myfile.txt` в текущем каталоге:

```java
File myFile = new File("myfile.txt");
myFile.createNewFile();
```

## Чтение файлов

Чтобы прочитать файл в Java, вы можете использовать класс `FileInputStream`. 
Он предоставляет методы для чтения байтов из файла.

Чтобы прочитать содержимое файла, следует использовать метод `read()`. 
Этот метод считывает один байт из файла и возвращает значение байта. 
Например, следующий код считывает содержимое файла `myfile.txt` и выводит его на консоль:

```java
File myFile = new File("myfile.txt");
FileInputStream inputStream = new FileInputStream(myFile);
byte[] buffer = new byte[1024];
int bytesRead;
while ((bytesRead = inputStream.read(buffer)) != -1) {
    System.out.print(new String(buffer, 0, bytesRead));
}
inputStream.close();
```

## Запись файлов

Для записи в файл можно использовать класс `FileOutputStream`. 
Он предоставляет методы для записи байтов в файл.

Чтобы записать содержимое строки в файл, следует применять метод `write()`. 
Этот метод записывает указанное количество байтов из определенного массива в файл. 
Вот пример того, как записывается строка `“Hello, world!”` в файл `myfile.txt`:

```java
File myFile = new File("myfile.txt");
FileOutputStream outputStream = new FileOutputStream(myFile);
byte[] buffer = "Hello, world!".getBytes();
outputStream.write(buffer);
outputStream.close();
```

## Удаление файлов

Чтобы удалить файл в Java, следует использовать метод `File.delete()`. 
Если же файл, который вы хотите удалить, не существует, то метод `delete()` вернет `false`. 
Перед вами пример кода, в котором удаляется файл `myfile.txt`:

```java
File myFile = new File("myfile.txt");
myFile.delete();
```

## Заключение

В этой публикации мы обсудили основы работы с файлами и `I/O Java`. 
Вы узнали, как создавать, читать, записывать и удалять файлы. 
Также вы получили информацию о классе `File` и классах `InputStream` и `OutputStream`.

# Служебные методы класса Objects — как с ними работать

Благодаря этой публикации вы улучшите свои знания о различных методах, представленных в классе `Objects`.

Класс `Objects` в Java имеет множество служебных методов, которые облегчают выполнение самых разных операций над объектами. 
В релизах JDK класс `Objects` претерпел несколько обновлений: были весьма значительные обновления в JDK 8 и 9, и небольшие обновления в JDK 16 и 19. 
Давайте рассмотрим, как можно использовать класс `Objects`.

## Сравнение объектов

`Objects` предоставляет несколько вариантов сравнения значений двух объектов. 
Ключевым преимуществом использования реализации `Objects` является безопасность от появления `null`.

### equals()

Ниже приведен пример сравнения двух записей.

```java
record RaceTime(String runnerName, Duration time) {}

RaceTime nullValue = null;
RaceTime billy = new RaceTime("Billy Korando", Duration.of(90, ChronoUnit.SECONDS));
RaceTime copyOfbilly = new RaceTime("Billy Korando", Duration.of(90, ChronoUnit.SECONDS));
RaceTime nicolai = new RaceTime("Nicolai Parlog", Duration.of(180, ChronoUnit.SECONDS));
nullValue.equals(billy);//NPE
Objects.equals(nullValue, billy);// false
Objects.equals(billy, nicolai);// false
Objects.equals(billy, copyOfbilly);// true
```

### deepEquals()

В классе `Objects` для сравнения двух массивов также можно использовать `deepEquals()`. 
В отличие от обычного `equals()`, здесь будут сравниваться значения, хранящиеся в массивах, что должно привести к более согласованным результатам. 
Принципиально этот метод проходит через `Arrays.deepEquals()`.

```java
record RaceTime(String runnerName, Duration time) {}

RaceTime billy = new RaceTime("Billy Korando", Duration.of(90, ChronoUnit.SECONDS));
RaceTime nicolai = new RaceTime("Nicolai Parlog", Duration.of(180, ChronoUnit.SECONDS));

RaceTime[] raceTimes1 = new RaceTime[] { billy, nicolai };
RaceTime[] raceTimes2 = new RaceTime[] { billy, nicolai };

Objects.equals(raceTimes1, raceTimes2);// false
Objects.deepEquals(raceTimes1, raceTimes2);// true
```

### compare()

`Objects` также имеет метод `compare()`, который может принимать два объекта и `Comparator<T>`. 
Метод `compare()` является одним из немногих `null`-небезопасных методов в `Objects`, так как у него нет приемлемого возврата в случае, если один из аргументов равен `null`.

```java
record RaceTime(String runnerName, Duration time) {}
class RaceTimeComparator implements Comparator<RaceTime> {
@Override
public int compare(RaceTime o1, RaceTime o2) {
	return o1.time.compareTo(o2.time);
}
}
RaceTime billy = new RaceTime("Billy Korando", Duration.of(90, ChronoUnit.SECONDS));
RaceTime nicolai = new RaceTime("Nicolai Parlog", Duration.of(180, ChronoUnit.SECONDS));

Objects.compare(billy, nicolai, new RaceTimeComparator());//-1
Objects.compare(null, nicolai, new RaceTimeComparator());//NPE
```

## String и HashCode

Класс `Objects` предоставляет методы для преобразования объекта в значения `String` и `HashCode`. 
Опять же, основным преимуществом этих методов является их безопасность от появления `null`.

### Преобразование в String

Одними из наиболее интересных методов является `toString(obj, nullDefault)`, который предоставляет значение по умолчанию (`default value`) в случае возникновения ошибки. 
Имеется в виду, что `toIdentityString(obj)` возвращает `toString()` и `hashCode()` переданных объектов, как будто ни один из этих методов не был перезаписан.

```java
record RaceTime(String runnerName, Duration time) {}

RaceTime nullValue = null;
RaceTime billy = new RaceTime("Billy Korando", Duration.of(90, ChronoUnit.SECONDS));
RaceTime nicolai = new RaceTime("Nicolai Parlog", Duration.of(180, ChronoUnit.SECONDS));

Objects.toString(billy);//RaceTime[runnerName=Billy Korando, time=PT1M30S]
Objects.toString(nullValue);//null
Objects.toString(nullValue, "Did not finish");//Did not finish
Objects.toIdentityString(billy);//ObjectsExamples$1RaceTime@251a69d7
```

### Преобразование в HashCode

`Objects` также предоставляет методы для преобразования объекта в его значение хэш-кода.

```java
record RaceTime(String runnerName, Duration time) {}

RaceTime nullValue = null;
RaceTime billy = new RaceTime("Billy Korando", Duration.of(90, ChronoUnit.SECONDS));
RaceTime nicolai = new RaceTime("Nicolai Parlog", Duration.of(180, ChronoUnit.SECONDS));

Objects.hashCode(nullValue);//0
Objects.hashCode(billy);//[HashValue]
Objects.hash(billy, nicolai);//[HashValue]
```

## Проверка на null

Класс `Objects` предоставляет несколько методов для проверки и обработки `null`.

### Выбрасывание исключения `NullPointException` на `null`

Метод `requireNonNull(obj)` выдаст ошибку `NullPointException`, если переданное значение равно `null`.

```java
record RaceTime(String runnerName, Duration time) {
	RaceTime{
		runnerName = Objects.requireNonNull(runnerName);
		time = Objects.requireNonNull(time);
	}
}
```

### Выбрасывание NullPointException на null с сообщением для пользователя

Метод `requireNonNull(obj, String)` выдаст ошибку `NullPointException` с сообщением для пользователя, если переданное значение равно `null`.

```java
record RaceTime(String runnerName, Duration time) {
	RaceTime{
		runnerName = Objects.requireNonNull(runnerName, "runner name required!");
		time = Objects.requireNonNull(time, "race time required!");
	}
}
```

### Возврат дефолтного значения для `null`

Метод `requireNonNullElse(obj, defaultValue)` вернет переданное `defaultValue` если `obj` является `null`.

```java
record RaceTime(String runnerName, Duration time) {
	RaceTime{
		runnerName = Objects.requireNonNullElse(runnerName, "John Smith");
		time = Objects.requireNonNullElse(time, Duration.ZERO);
	}
}
```

## Использование поставщиков (Suppliers)

Класс `Objects` также предоставляет методы `requireNonNull(obj, Supplier<String>)` и `T requireNonNullElseGet(T, Supplier<T>)`, которые могут использовать для предоставления сообщения или значения по умолчанию. 
Их следует использовать только в том случае, если создание сообщения или значения по умолчанию может оказать значительное влияние на производительность.    

```java
record RaceTime(String runnerName, Duration time) {
static Supplier<String> noNameMsgSupplier = () -> "runner name required!";
static Supplier<String> noTimeMsgSupplier = () -> "race time required!";
	RaceTime{
		runnerName = Objects.requireNonNull(runnerName, noNameMsgSupplier);
		time = Objects.requireNonNull(time, noTimeMsgSupplier);
	}
}
```

```java
record RaceTime(String runnerName, Duration time) {
static Supplier<String> noNameValueSupplier = () -> "John Smith";
static Supplier<Duration> noTimeValueSupplier = () -> Duration.ZERO;
	RaceTime{
		runnerName = Objects.requireNonNullElseGet(runnerName, noNameValueSupplier);
		time = Objects.requireNonNullElseGet(time, noTimeValueSupplier);
	}
}
```

### Предикативная проверка null

`Objects` обеспечивает проверку `null` для использования в предикатах, хотя ее можно использовать и в других сценариях.

```java
record RaceTime(String runnerName, Duration time) {}

RaceTime nullValue = null;
Objects.nonNull(nullValue);//false
Objects.isNull(nullValue);//true
```

### Проверка индекса
И наконец, класс `Objects` предоставляет несколько опций для проверки позиции индекса при обходе `File`, `String`, `Collection` или похожего объекта. 
Некоторые из этих методов недавно были добавлены в JDK 16.

```java
int checkIndex(int index, int length)

int checkFromToIndex(int fromIndex, int toIndex, int length)

int checkFromIndexSize(int fromIndex, int size, int length)

long checkIndex(long index, long length)

long checkFromToIndex(long fromIndex, long toIndex, long length)

long checkFromIndexSize(long fromIndex, long size, long length)
```
