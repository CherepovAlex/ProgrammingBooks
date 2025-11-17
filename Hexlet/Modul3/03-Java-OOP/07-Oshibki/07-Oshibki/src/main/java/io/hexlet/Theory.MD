# Ошибки и исключения

Ошибка может произойти в любой момент работы программы, как по вину пользователя, так и по вине программиста или 
окружения.

Глобально ошибки можно разделить на два типа: ошибки компиляции и ошибки работы программы.

Большую часть ошибок можно избежать или обработать.

## Определение и иерархия

Исключительная ситуация - ситуция, в которой программа не может продолжать правильно функционировать.

![img.png](img.png)

## Способы обработки исключений
 - Конструкция try-catch-finally
 - Ключевое слово throws

**try-catch-finally**

```java
try {
    // Исполняемый код, который может сгенерировать исключение
} catch (Exception exception) {
    // обработка исключения
} finally {
    // Общий код, который выполнится в любом случае
}

// Пример обработки разных типов исключений
try {...}
catch (ArithmeticException | IndexOutOfBoundsException exception) {...}
catch (Exception exception) {...}
finally {...}
```

**try with resources**

В случаях, когда требуется раотать объектами типа реализующими интерфейс `Closeable`, удобно использовать конструкцию 
`try with resources`.

```java
try (FileWriter fileWriter = new FileWriter("filename.txt")) {
    fileWriter.append("some string");
} catch (IOException e) {
    e.printStackTrace();
}
```

**Ключевое слово throws**

В случаях, когда не получается обработать `checked` исключение там же, где оно было сгенерировано, можно пробросить его 
на уровень выше с помощью ключевого слова `throws`.

```java
public static void method() throws IOException {
    throw new IOException();
}
```

## Генерация исключений

Часто в процессе разработки приходится генерировать (выбрасывать) исключения вручную. Например, при валидации входных 
данных пользователя.

Для генерации исключения используется ключевое слово `throw`.

```java
public void validateAge(int age) {
    if (age < 6) {
        throw new RuntimeException("Пользователь должен быть старше 6 лет");
    }
    if (age > 18) {
        throw new RuntimeException("Пользователь должен быть младше 18 лет");
    }
}
```

## Реализация собственный исключений

Исключения- классы, наследующие класс `Throwable`.

Для реализации собственного исключения необходимо создать класс, унаследованный от классов 
**RuntimeException (unchecked)** или **Exception (checked)**.

```java
public class ValidationException extends RuntimeException {
    public String fieldName;
    
    public ValidationException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }
}
```




























