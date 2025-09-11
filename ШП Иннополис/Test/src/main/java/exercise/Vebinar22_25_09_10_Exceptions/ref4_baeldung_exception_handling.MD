# Обработка исключений в Java

## 1. Общий обзор

В этом обучающем материале мы рассмотрим основы обработки исключений в Java, а также некоторые подводные камни.

## 2. Первые принципы

### 2.1. Что это такое?

Чтобы лучше понять, что такое исключения и обработка исключений, давайте проведём сравнение с реальной жизнью.

Представьте, что мы заказываем товар онлайн, но во время доставки происходит сбой. Хорошая компания может решить эту 
проблему и перенаправить нашу посылку так, чтобы она всё равно была доставлена вовремя.

Точно так же в Java при выполнении наших инструкций в коде могут возникать ошибки. Грамотная обработка исключений 
позволяет справляться с ошибками и корректно перенаправлять программу, чтобы пользователь по-прежнему получал 
положительный опыт.

### 2.2. Зачем это использовать? 

Обычно мы пишем код в идеализированной среде: в файловой системе всегда есть наши файлы, сеть работает без сбоев, а у 
JVM всегда достаточно памяти. Иногда мы называем это «благоприятным стечением обстоятельств».

Однако в реальных условиях файловые системы могут повреждаться, сети — выходить из строя, а JVM — испытывать нехватку 
памяти. Благополучие нашего кода зависит от того, как он справляется с «нештатными ситуациями».

Мы должны обрабатывать эти условия, поскольку они негативно влияют на работу приложения и приводят к исключениям:

```java
public static List<Player> getPlayers() throws IOException {
    Path path = Paths.get("players.dat");
    List<String> players = Files.readAllLines(path);

    return players.stream()
      .map(Player::new)
      .collect(Collectors.toList());
}
```

Этот код не обрабатывает IOException, а вместо этого передаёт его вверх по стеку вызовов. В идеальной среде код 
нормально.

Но что может произойти в рабочей среде, если файл `players.dat` отсутствует?

```bash
Exception in thread "main" java.nio.file.NoSuchFileException: players.dat <-- players.dat file doesn't exist
    at sun.nio.fs.WindowsException.translateToIOException(Unknown Source)
    at sun.nio.fs.WindowsException.rethrowAsIOException(Unknown Source)
    // ... more stack trace
    at java.nio.file.Files.readAllLines(Unknown Source)
    at java.nio.file.Files.readAllLines(Unknown Source)
    at Exceptions.getPlayers(Exceptions.java:12) <-- Exception arises in getPlayers() method, on line 12
    at Exceptions.main(Exceptions.java:19) <-- getPlayers() is called by main(), on line 19
```

**Без обработки этого исключения работоспособная в остальном программа может полностью перестать работать!** Нам нужно 
убедиться, что в нашем коде предусмотрен план действий на случай, если что-то пойдёт не так.

Также обратите внимание на ещё одно преимущество исключений — _трассировку стека_. Благодаря трассировке стека мы часто 
можем определить проблемный код без необходимости подключать отладчик.

## 3. Иерархия исключений

В конечном счёте исключения — это просто объекты Java, все они наследуются от `Throwable`:

```bash
         ---> Throwable <--- 
              |    (checked)     |
              |                  |
              |                  |
      ---> Exception           Error
      |    (checked)        (unchecked)
      |
RuntimeException
  (unchecked)
```

Существует три основные категории исключительных обстоятельств:
+ Проверенные исключения
+ Необработанные исключения / исключения во время выполнения
+ Ошибки

_Необработанные_ и _непроверяемые исключения_ — это одно и то же. Часто мы можем использовать эти термины как 
взаимозаменяемые.

### 3.1. Контролируемые исключения

Проверяемые исключения — это исключения, которые, согласно компилятору Java, мы должны обработать. Мы должны либо явно 
вызвать исключение в стеке вызовов, либо обработать его самостоятельно. Подробнее об этом чуть позже.

Документация Oracle рекомендует использовать проверяемые исключения, когда есть основания полагать, что вызывающая 
сторона нашего метода сможет восстановиться после ошибки.

Вот несколько примеров проверяемых исключений: `IOException` и `ServletException`.

### 3.2. Необработанные исключения

Непроверяемые исключения — это исключения, которые компилятор Java не требует обрабатывать.

Проще говоря, если мы создадим исключение, которое расширяет `RuntimeException`, оно будет непроверяемым; в противном 
случае оно будет проверяемым.

И хотя это звучит удобно, документация Oracle говорит нам, что для обеих концепций есть веские причины, например, 
различие между ситуативной ошибкой (отмечено) и ошибкой использования (не отмечено).

Вот несколько примеров непроверяемых исключений: `NullPointerException`, `IllegalArgumentException`, и 
`SecurityException`.

### 3.3. Ошибки

_Ошибки_ — это серьёзные и, как правило, неустранимые проблемы, такие как несовместимость библиотек, бесконечная 
рекурсия или утечки памяти.

И хотя они не расширяют `RuntimeException`, они также не проверяются.

В большинстве случаев нам было бы странно обрабатывать, создавать экземпляры или расширять `Errors`. Обычно мы хотим, 
чтобы они распространялись вверх по стеку.

Вот несколько примеров ошибок: `StackOverflowError` и `OutOfMemoryError`.

## 4. Обработка исключений

В Java API есть множество мест, где что-то может пойти не так, и некоторые из этих мест отмечены исключениями либо в 
сигнатуре, либо в Javadoc:

```java
/**
 * @exception FileNotFoundException ...
 */
public Scanner(String fileName) throws FileNotFoundException {
   // ...
}
```

Как мы уже говорили, при вызове этих «рискованных» методов мы должны обрабатывать проверяемые исключения и _можем_ 
обрабатывать непроверяемые. В Java есть несколько способов сделать это:

### 4.1. вызвать

Самый простой способ «обработать» исключение — вызвать его повторно:

```java
public int getPlayerScore(String playerFile) throws FileNotFoundException {
 
    Scanner contents = new Scanner(new File(playerFile));
    return Integer.parseInt(contents.nextLine());
}
```

Поскольку `FileNotFoundException` является проверяемым исключением, это самый простой способ удовлетворить требования 
компилятора, но **это означает, что теперь любой, кто вызывает наш метод, тоже должен его обработать!**

_parseInt_ может вызвать _NumberFormatException_, но поскольку это непроверяемое исключение, нам не нужно его 
обрабатывать.

### 4.2. try-catch

Если мы хотим попытаться обработать исключение самостоятельно, мы можем использовать блок `try-catch`. Мы можем 
обработать его, повторно вызвав исключение:

```java
public int getPlayerScore(String playerFile) {
    try {
        Scanner contents = new Scanner(new File(playerFile));
        return Integer.parseInt(contents.nextLine());
    } catch (FileNotFoundException noFile) {
        throw new IllegalArgumentException("File not found");
    }
}
```

Или выполнив действия по восстановлению:

```java
public int getPlayerScore(String playerFile) {
    try {
        Scanner contents = new Scanner(new File(playerFile));
        return Integer.parseInt(contents.nextLine());
    } catch ( FileNotFoundException noFile ) {
        logger.warn("File not found, resetting score.");
        return 0;
    }
}
```

### 4.3. finally

Иногда нам нужно выполнить код независимо от того, возникнет ли исключение. В таких случаях используется ключевое 
слово `finally`.

В наших примерах до сих пор скрывалась неприятная ошибка: по умолчанию Java не возвращает дескрипторы файлов 
операционной системе.

Конечно, независимо от того, можем ли мы прочитать файл или нет, мы хотим убедиться, что провели соответствующую 
очистку!

Давайте сначала попробуем сделать это «ленивым» способом:

```java
public int getPlayerScore(String playerFile) throws FileNotFoundException {
    Scanner contents = null;
    try {
        contents = new Scanner(new File(playerFile));
        return Integer.parseInt(contents.nextLine());
    } finally {
        if (contents != null) {
            contents.close();
        }
    }
}
```

Здесь блок `finally` указывает, какой код мы хотим, чтобы Java выполняла независимо от того, что происходит при попытке
прочитать файл.

Даже если в стеке вызовов возникнет `FileNotFoundException`, Java перед этим вызовет содержимое `finally`.

Мы также можем обработать исключение и убедиться, что наши ресурсы закрыты:

```java
public int getPlayerScore(String playerFile) {
    Scanner contents;
    try {
        contents = new Scanner(new File(playerFile));
        return Integer.parseInt(contents.nextLine());
    } catch (FileNotFoundException noFile) {
        logger.warn("File not found, resetting score.");
        return 0;
    } finally {
        try {
            if (contents != null) {
                contents.close();
            }
        } catch (IOException io) {
            logger.error("Couldn't close the reader!", io);
        }
    }
}
```

Поскольку `close` — это тоже «рискованный» метод, нам нужно перехватить и его исключение!

Это может показаться довольно сложным, но нам нужно, чтобы каждая часть правильно решала каждую потенциальную проблему, 
которая может возникнуть.

### 4.4. try-with-resources

К счастью, начиная с Java 7, мы можем упростить приведённый выше синтаксис при работе с объектами, расширяющими 
`AutoCloseable`:

```java
public int getPlayerScore(String playerFile) {
    try (Scanner contents = new Scanner(new File(playerFile))) {
      return Integer.parseInt(contents.nextLine());
    } catch (FileNotFoundException e ) {
      logger.warn("File not found, resetting score.");
      return 0;
    }
}
```

4.5. Несколько блоков catch
Иногда код может генерировать несколько исключений, и у нас может быть несколько блоков `catch`, обрабатывающих каждое 
исключение по отдельности:

```java
public int getPlayerScore(String playerFile) {
    try (Scanner contents = new Scanner(new File(playerFile))) {
        return Integer.parseInt(contents.nextLine());
    } catch (IOException e) {
        logger.warn("Player file wouldn't load!", e);
        return 0;
    } catch (NumberFormatException e) {
        logger.warn("Player file was corrupted!", e);
        return 0;
    }
}
```

Несколько блоков `catch` дают нам возможность обрабатывать каждое исключение по-своему, если возникнет такая 
необходимость.

Также обратите внимание, что мы не перехватили `FileNotFoundException`, потому что оно расширяет `IOException`. 
Поскольку мы перехватываем `IOException`, Java будет считать, что все его подклассы также обработаны.

Однако предположим, что нам нужно обрабатывать `FileNotFoundException` иначе, чем более общее `IOException`:

```java
public int getPlayerScore(String playerFile) {
    try (Scanner contents = new Scanner(new File(playerFile)) ) {
        return Integer.parseInt(contents.nextLine());
    } catch (FileNotFoundException e) {
        logger.warn("Player file not found!", e);
        return 0;
    } catch (IOException e) {
        logger.warn("Player file wouldn't load!", e);
        return 0;
    } catch (NumberFormatException e) {
        logger.warn("Player file was corrupted!", e);
        return 0;
    }
}
```

Java позволяет обрабатывать исключения подклассов отдельно **не забудьте разместить их выше в списке перехватов**.

### 4.6. Блоки объединения catch

Однако, когда мы знаем, что будем обрабатывать ошибки одинаково, в Java 7 появилась возможность перехватывать несколько 
исключений в одном блоке:

```java
public int getPlayerScore(String playerFile) {
    try (Scanner contents = new Scanner(new File(playerFile))) {
        return Integer.parseInt(contents.nextLine());
    } catch (IOException | NumberFormatException e) {
        logger.warn("Failed to load score!", e);
        return 0;
    }
}
```

## 5. Обработка исключений

Если мы не хотим обрабатывать исключение самостоятельно или хотим генерировать собственные исключения, чтобы их 
обрабатывали другие, нам нужно изучить ключевое слово `throw`.

Допустим, у нас есть следующее проверенное исключение, которое мы создали сами:

```java
public class TimeoutException extends Exception {
    public TimeoutException(String message) {
        super(message);
    }
}
```

и у нас есть метод, реализация которого потенциально может занять много времени:

```java
public List<Player> loadAllPlayers(String playersFile) {
    // ... potentially long operation
}
```

### 5.1. Генерация проверяемого исключения

Как и в случае с возвратом из метода, мы можем `throw` в любой момент.

Конечно, мы должны бросать мяч, когда хотим показать, что что-то пошло не так:

```java
public List<Player> loadAllPlayers(String playersFile) throws TimeoutException {
    while ( !tooLong ) {
        // ... potentially long operation
    }
    throw new TimeoutException("This operation took too long");
}
```

Поскольку `TimeoutException` проверяется, мы также должны использовать ключевое слово `throws` в сигнатуре, чтобы 
вызывающие наш метод знали, как с ним работать.

### 5.2. Выброс непроверяемого исключения

Если мы хотим сделать что-то вроде проверки входных данных, мы можем использовать непроверяемое исключение:

```java
public List<Player> loadAllPlayers(String playersFile) throws TimeoutException {
    if(!isFilenameValid(playersFile)) {
        throw new IllegalArgumentException("Filename isn't valid!");
    }
   
    // ...
}
```

Поскольку `IllegalArgumentException` не является проверяемым исключением, нам не нужно помечать метод, хотя мы можем 
это сделать.

Некоторые всё равно отмечают этот метод как форму документирования.

### 5.3. Упаковка и повторная отправка

Мы также можем повторно вызвать перехваченное исключение:

```java
public List<Player> loadAllPlayers(String playersFile) throws IOException {
    try { 
        // ...
    } catch (IOException io) { 		
        throw io;
    }
}
```

Или сделайте рулет и снова заверните:

```java
public List<Player> loadAllPlayers(String playersFile) throws PlayerLoadException {
    try { 
        // ...
    } catch (IOException io) { 		
        throw new PlayerLoadException(io);
    }
}
```

Это может быть удобно для объединения множества различных исключений в одно.

### 5.4. Повторное создание Throwable или Exception

А теперь о конкретном случае.

Если единственными возможными исключениями, которые может вызвать данный блок кода, являются `unchecked` исключения, 
то мы можем перехватить и повторно вызвать `Throwable` или `Exception`, не добавляя их в сигнатуру нашего метода:

```java
public List<Player> loadAllPlayers(String playersFile) {
    try {
        throw new NullPointerException();
    } catch (Throwable t) {
        throw t;
    }
}
```

Несмотря на свою простоту, приведённый выше код не может вызвать проверяемое исключение, поэтому, даже если мы повторно 
вызываем проверяемое исключение, нам не нужно помечать сигнатуру предложением `throws`.

**Это удобно при работе с прокси-классами и методами**. 

### 5.5. Наследование

Когда мы помечаем методы ключевым словом `throws`, это влияет на то, как подклассы могут переопределять наш метод.

В ситуации, когда наш метод генерирует проверяемое исключение:

```java
public class Exceptions {
    public List<Player> loadAllPlayers(String playersFile) 
      throws TimeoutException {
        // ...
    }
}
```

Подкласс может иметь «менее рискованную» сигнатуру:

```java
public class FewerExceptions extends Exceptions {	
    @Override
    public List<Player> loadAllPlayers(String playersFile) {
        // overridden
    }
}
```

Но не «более рискованная» подпись:

```java
public class MoreExceptions extends Exceptions {		
    @Override
    public List<Player> loadAllPlayers(String playersFile) throws MyCheckedException {
        // overridden
    }
}
```

Это происходит потому, что контракты определяются во время компиляции на основе ссылочного типа. Если я создам 
экземпляр `MoreExceptions` и сохраню его в `Exceptions`:

```java
Exceptions exceptions = new MoreExceptions();
exceptions.loadAllPlayers("file");
```

Тогда JVM предложит мне перехватить `TimeoutException`, что неправильно, поскольку я указал, что 
`MoreExceptions#loadAllPlayers` генерирует другое исключение.

Проще говоря, подклассы могут генерировать меньше проверяемых исключений, чем их суперкласс, но не больше.

## 6. Антишаблоны

### 6.1. Обработка исключений

Есть ещё один способ, с помощью которого мы могли бы удовлетворить компилятор:

```java
public int getPlayerScore(String playerFile) {
    try {
        // ...
    } catch (Exception e) {} // <== catch and swallow
    return 0;
}
```

**проглатывание исключения Вызывается вышеописанное**. В большинстве случаев нам не стоит этого делать, потому что это 
не решает проблему и не позволяет другому коду решить проблему.

Бывают случаи, когда возникает проверяемое исключение, которое, как мы уверены, никогда не произойдёт. В **таких случаях 
мы всё равно должны хотя бы добавить комментарий о том, что мы намеренно проглотили исключение**:

```java
public int getPlayerScore(String playerFile) {
    try {
        // ...
    } catch (IOException e) {
        // this will never happen
    }
}
```

Другой способ «проглотить» исключение — просто вывести его в поток ошибок:

```java
public int getPlayerScore(String playerFile) {
    try {
        // ...
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}
```

Мы немного улучшили ситуацию, по крайней мере записав ошибку куда-то для последующей диагностики.

Однако нам было бы лучше использовать логгер:

```java
public int getPlayerScore(String playerFile) {
    try {
        // ...
    } catch (IOException e) {
        logger.error("Couldn't load the score", e);
        return 0;
    }
}
```

Хотя такой способ обработки исключений очень удобен, нам нужно убедиться, что мы не теряем важную информацию, которую 
пользователи нашего кода могли бы использовать для устранения проблемы.

Наконец, мы можем случайно проглотить исключение, не указав его в качестве причины при создании нового исключения:

```java
public int getPlayerScore(String playerFile) {
    try {
        // ...
    } catch (IOException e) {
        throw new PlayerScoreException();
    }
}
```

Здесь мы хвалим себя за то, что предупредили звонящего об ошибке, но не указываем `IOException` как причину. Из-за этого 
мы потеряли важную информацию, которую звонящие или операторы могли бы использовать для диагностики проблемы.

Нам было бы лучше сделать так:

```java
public int getPlayerScore(String playerFile) {
    try {
        // ...
    } catch (IOException e) {
        throw new PlayerScoreException(e);
    }
}
```

### 6.2. Использование return в блоке finally

Другой способ обработки исключений — возврат из блока `finally`. Это плохо, потому что при резком возврате JVM 
проигнорирует исключение, даже если оно было вызвано нашим кодом:

```java


public int getPlayerScore(String playerFile) {
    int score = 0;
    try {
        throw new IOException();
    } finally {
        return score; // <== the IOException is dropped
    }
}
```

Согласно спецификации языка Java:

+ Если выполнение блока try внезапно завершается по какой-либо другой причине `R`, то выполняется блок `finally`, а 
затем происходит выбор.
+ Если блок `finally` завершается нормально, то оператор `try` завершается _досрочно_ по причине R.
+ Если блок `finally` завершается аварийно по причине `S`, то оператор `try` завершается аварийно по причине `S` (а 
причина `R` игнорируется).

### 6.3. Использование throw в блоке finally

Как и в случае с использованием `return` в блоке `finally`, исключение, возникшее в блоке `finally`, будет иметь 
приоритет над исключением, возникшим в блоке `catch`.

Это «сотрёт» исходное исключение из блока try, и мы потеряем всю эту ценную информацию:

```java
public int getPlayerScore(String playerFile) {
    try {
        // ...
    } catch ( IOException io ) {
        throw new IllegalStateException(io); // <== eaten by the finally
    } finally {
        throw new OtherException();
    }
}
```

### 6.4. Использование throw в качестве goto

Некоторые люди также поддались искушению использовать `throw` в качестве оператора `goto`:

```java
public void doSomething() {
    try {
        // bunch of code
        throw new MyException();
        // second bunch of code
    } catch (MyException e) {
        // third bunch of code
    }		
}
```

Это странно, потому что код пытается использовать исключения для управления потоком, а не для обработки ошибок.

## 7. Распространённые исключения и ошибки

Вот несколько распространённых исключений и ошибок, с которыми мы все время от времени сталкиваемся:

### 7.1. Проверяемые исключения

`IOException` — это исключение обычно означает, что произошла ошибка в сети, файловой системе или базе данных.

### 7.2. Исключения во время выполнения

+ `ArrayIndexOutOfBoundsException` — это исключение означает, что мы попытались получить доступ к несуществующему 
индексу массива, например, попытались получить индекс 5 из массива длиной 3.
+ `ClassCastException` — это исключение означает, что мы попытались выполнить недопустимое приведение типов, например 
преобразовать `String` в `List`. Обычно этого можно избежать, выполнив защитные проверки `instanceof` перед приведением 
типов.
+ `IllegalArgumentException` — это общее исключение, которое указывает на то, что один из предоставленных параметров 
метода или конструктора является недопустимым.
+ `IllegalStateException` — это общее исключение, которое указывает на то, что внутреннее состояние, например состояние 
объекта, является недопустимым.
+ `NullPointerException` — это исключение означает, что мы попытались обратиться к `null` объекту. Обычно этого можно 
избежать, выполнив защитные `null` проверки или используя `Optional`.
+ `NumberFormatException` — это исключение означает, что мы попытались преобразовать `String` в число, но в строке были 
недопустимые символы, например при попытке преобразовать «5f3» в число.

### 7.3. Ошибки

+ `StackOverflowError` — это исключение означает, что трассировка стека слишком длинная. Такое иногда случается в 
крупных приложениях, но обычно это означает, что в нашем коде происходит бесконечная рекурсия.
+ `NoClassDefFoundError` — это исключение означает, что класс не удалось загрузить либо из-за отсутствия в пути к 
классам, либо из-за сбоя при статической инициализации.
+ `OutOfMemoryError` — это исключение означает, что у JVM больше нет свободной памяти для выделения новых объектов. 
Иногда это происходит из-за утечки памяти.
 
## 8. Заключение

В этой статье мы рассмотрели основы обработки исключений, а также несколько примеров хорошей и плохой практики.
