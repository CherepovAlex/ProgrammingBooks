# Глава 20. Класс BigInteger

Класс `BigInteger` используется для выполнения математических операций с большими целыми числами, величины которых слишком велики для примитивных типов данных. Например, факториал числа 100 состоим из 158 цифр - что гораздо больше, чем может предоставить тип `long`. Класс `BigInteger` предлагает аналоги всех операторов, что и Java для примитивных целых чисел, а также методы, аналогичные методам из класса `java.lang.Math`, и ещё некоторые другие операции.

## Раздел 20.1. Инициализация

Класс `java.math.BigInteger` предоставляет аналоги операций для всех примитивных целочисленных операторов Java и для всех соответствующих методов из `java.lang.Math`. Поскольку пакет `java.math` не предоставляется автоматически, вам, возможно, придётся импортировать `java.math.BigInteger`, преде чем вы сможете использовать просто имя класса.

Для преобразования значений `long` или `int` в `BigInteger` используйте следующие способы:

```java
long longValue = Long.MAX_VALUE;
BigInteger valueFromLong = BigInteger.valueOf(longValue);
```

или, для целых чисел:

```java
int intValue = Integer.MIN_VALUE;   // отрицательное значение
BigInteger valueFromInt = BigInteger.valueOf(intValue);
```

Это метод который _"расширит"_ целое число `intValue` до типа `long`, используя для расширения знаковый бит, так что отрицательные значения останутся отрицательными.

Для преобразования числовой строки `String` в `BigInteger` используйте следующий способ:

```java
String decimalString = "-1";
BigInteger valueFromDecimalString = new BigInteger(decimalString);
```

Следующий конструктор используется для преобразования строкового представления `BigInteger` в указанном радиксе в строку `BigInteger`.

```java
String binaryString = "10";
int binaryRadix = 2;
BigInteger valueFromBinaryString = new BigInteger(binaryString, binaryRadix);
```

Java также поддерживает прямое преобразование байтов в экземпляр `BigInteger`. В настоящее время можно использовать только знаковое и беззнаковое кодирование `big endian` (хранит старший байт числа по меньшему адресу памяти), что интуитивно понятно при чтении слева направо. Например, число `0x12345678` будет храниться как 12 34 56 78):

```java
byte[] bytes = new byte[] {(byte) 0x80 };
BigInteger valueFromBytes = new BigInteger(bytes);
```

В результате будет сгенерирован экземпляр `BigInteger` со значением 128, поскольку байт интерпретируются как беззнаковое число, а знак явно установлен в 1, что означает положительное число.

```java
byte[] unsignedBytes = new byte[] {(byte) 0x80 };
int sign = 1;   // положительный
BigInteger valueFromUnsignedBytes = new BigInteger(sign, unsignedBytes);
```

В результате будет сгенерирован экземпляр `BigInteger` со значением 128, поскольку байт интерпретируются как беззнаковое число, что означает положительное число.

Для общих значений существуют предопределённые константы:
+ `BigInteger.ZERO` - значение "0".
+ `BigInteger.ONE` - значение "1".
+ `BigInteger.TEN` - значение "10".

Существует также `BigInteger.TWO` (значение "2"), но вы не можете использовать его в своём коде, поскольку он является приватным (модификатор доступа установлен `private`).

[к оглавлению Глава 20](#глава-20-класс-biginteger)

## Раздел 20.2. Примеры математических операций с числами BigInteger

Объект `BigInteger` - неизменяемый объект, поэтому результаты любой математической операции необходимо присваивать
новому экземпляру `BigInteger`.

**Сложение: 10 + 10 = 20**

```java
BigInteger value1 = new BigInteger("10");
BigInteger value2 = new BigInteger("10");

BigInteger sum = value1.add(value2);
System.out.println(sum);
```

Выводит: 20

**Вычитание: 10 - 9 = 1**

```java
BigInteger value1 = new BigInteger("10");
BigInteger value2 = new BigInteger("10");

BigInteger sub = value1.subtract(value2);
System.out.println(sub);
```

Выводит: 1

**Деление: 10/5 = 2**

```java
BigInteger value1 = new BigInteger("10");
BigInteger value2 = new BigInteger("10");

BigInteger div = value1.divide(value2);
System.out.println(div);
```

Выводит: 2

**Целочисленное деление: 17/4 = 4**

```java
BigInteger value1 = new BigInteger("17");
BigInteger value2 = new BigInteger("4");

BigInteger div = value1.divide(value2);
System.out.println(div);
```

Выводит: 4

**Умножение: 10 * 5 = 50**

```java
BigInteger value1 = new BigInteger("10");
BigInteger value2 = new BigInteger("5");

BigInteger mul = value1.multiply(value2);
System.out.println(mul);
```

Выводит: 50

**Возведение в степень: 10 ^ 3 = 1000**

```java
BigInteger value1 = new BigInteger("10");
BigInteger power = value1.pow(3);
System.out.println(power);
```

Выводит: 1000

**Деление по модулю (остаток от деление): 10 % 6 = 4**

```java
BigInteger value1 = new BigInteger("10");
BigInteger value2 = new BigInteger("6");

BigInteger power = value1.remainder(value2);
System.out.println(power);
```

Выводит: 4

**НОД(GCD): Наибольший общий делитель (GCD) для 12 и 18 равен 6**

```java
BigInteger value1 = new BigInteger("12");
BigInteger value2 = new BigInteger("18");

System.out.println(value1.gcd(value2));
```

Выводит: 6

**Определение максимального из двух чисел:**

```java
BigInteger value1 = new BigInteger("10");
BigInteger value2 = new BigInteger("11");

System.out.println(value1.max(value2));
```

Выход: 11

**Определение минимального из двух чисел:**

```java
import java.math.BigInteger;

BigInteger value1 = new BigInteger("10");
BigInteger value2 = new BigInteger("11");

System.out.println(value1.min(value2));
```

Выводит: 10

[к оглавлению Глава 20](#глава-20-класс-biginteger)

## Раздел 20.3. Сравнение чисел BigInteger



[к оглавлению Глава 20](#глава-20-класс-biginteger)


[Раздел 20.1. Инициализация](#раздел-201-инициализация)

[Раздел 20.2. Примеры математических операций с числами BigInteger](#раздел-202-примеры-математических-операций-с-числами-biginteger)






















