# Глава 19. Класс BigDecimal

[Раздел 19.1. Сравнение больших чисел](#раздел-191-сравнение-больших-чисел)

[Раздел 19.2. Использование значений BigDecimal вместо значений типа float](#раздел-192-использование-значений-bigdecimal-вместо-значений-типа-float)

[Раздел 19.3. Метод BigDecimal.valueOf()](#раздел-193-метод-bigdecimalvalueof)

[Раздел 19.4. Математические операции с большими числами (BigDecimal)](#раздел-194-математические-операции-с-большими-числами-bigdecimal)

[Раздел 19.5. Инициализация числа BigDecimals значениями ноль, один и девять](#раздел-195-инициализация-числа-bigdecimals-значениями-ноль-один-и-девять)

[Раздел 19.6. Объекты BigDecimal являются неизменяемыми](#раздел-196-объекты-bigdecimal-являются-неизменяемыми)

Класс `BigDecimal` (большие числа) представляет разработчику арифметические операции (сложение, вычитание, умножение, деление), а также операции с изменением точности - количество знаков после запятой (scale), округления, сравнения, хеширования и преобразования форматов. Класс `BigDecimal` представляет неизменяемые знаковые десятичные вещественные числа произвольной точности. Этот класс используется дял вычислений с крайне высокими требованиями к точности. 

## Раздел 19.1. Сравнение больших чисел

Для сравнения двух больших чисел (`BigDecimal`) следует использовать метод `compareTo`:

```java
BigDecimal a = new BigDecimal(5);
a.compareTo(new BigDecimal(0));     // а больше, возвращается 1
a.compareTo(new BigDecimal(5));     // а равно, возвращается 0
a.compareTo(new BigDecimal(10));     // а меньше, возвращается -1
```

При сравнении больших чисел не рекомендуется использовать метод `equals`, так как он считает два `BigDecimal` равными только в том случае, если они равны по значению, а также имеют одинаковую точность или масштаб (**scale**):

```java
BigDecimal a = new BigDecimal(5);
a.equals(new Decimal(5));       // значения и масштаб равны, возвращается true
a.equals(new BigDecimal(5.00)); // значения равны, а масштаб нет, возвращается false 
```

[к оглавлению Глава 19](#глава-19-класс-bigdecimal)

## Раздел 19.2. Использование значений BigDecimal вместо значений типа float

Из-за особенностей представления значений с плавающей точкой в памяти компьютера результаты операций с использованием типа `float` могут быть неточными - некоторые значения сохраняются в памяти с некоторой погрешностью. Хорошей иллюстрацией этой проблемы являются денежные вычисления. Если необходима высокая точность, следует использовать другие типы. Например, в Java 7 уже предусмотрен класс `BigDecimal`.

```java
import java.math.BigDecimal;

public class FloatTest {
    public static void main(String[] args) {
        float accountBalance = 10000.00f;
        System.out.println("Операции с использованием типа float:");
        System.out.println("10000 операций со значением 1,99");
        for (int i = 0; i < 1000; i++) {
            accountBalance -= 1.99f;
        }
        System.out.println(String.format("Остаток на счете после операций с плавающей запятой: %f", accountBalance));
        
        BigDecimal accountBalanceTwo = new BigDecimal("10000.00");
        System.out.println("Операции с использованием BigDecimal:");
        System.out.println("1000 операций со значением 1.99");
        BigDecimal operation = new BigDecimal("1.99");
        for (int i = 0; i < 1000; i++) {
            accountBalanceTwo = accountBalanceTwo.subtract(operation);
        }
        System.out.println(String.format("Остаток на счете после операций BigDecimal: %f", accountBalanceTwo));
    }
}
```

После завершения работы программа выдаст следующий результат:

```bash
Операции с использование float:
1000 операций с 1,99
Остаток на счете после операций с плавающей запятой: 8009,765625
Операции с использованием BigDecimal:
1000 операций со значением 1.99
Остаток на счете после операций BigDecimal: 8010,000000
```

Для начального баланса 10000,00 после 1000 операций со значением 1,99 баланс должен быть 8010,00. Использование типа `float` даёт результат, примерно равный 8009,77, что приемлемо для денежных вычислений. Использование класса `BigDecimal` даёт правильный результат.

[к оглавлению Глава 19](#глава-19-класс-bigdecimal)

## Раздел 19.3. Метод BigDecimal.valueOf()

Класс `BigDecimal` содержит внутренний кеш часто используемых чисел, например, чисел от 0 до 10. Поэтому лучше использовать метод `BigDecimal.valueOf()`, а не конструктор с аналогичным параметром, т.е. в приведённом ниже примере способ инициализации числа `a` предпочтительнее способа инициализации числа `b`.

```java
import java.math.BigDecimal;

BigDecimal a = BigDecimal.valueOf(10L); // Возвращает ссылку на объект, помещённый в кеш
BigDecimal b = new BigDecimal(10L); // Не возвращает ссылку на объект, помещённый в кеш

BigDecimal a = BigDecimal.valueOf(20L); // Не возвращает ссылку на объект, помещённый в кеш
BigDecimal b = new BigDecimal(20L); // Не возвращает ссылку на объект, помещённый в кеш

BigDecimal a = BigDecimal.valueOf(15.15); // Предпочтительный способ преобразования
// типа double (или типа float) в BigDecimal, поскольку возвращаемое значение равно
// значению, полученному при создании BigDecimal на основе результата использования
// метода Double.toString(double)

BigDecimal b = new BigDecimal(15.15); // Выдаст непредсказуемый результат
```

[к оглавлению Глава 19](#глава-19-класс-bigdecimal)

## Раздел 19.4. Математические операции с большими числами (BigDecimal)

В данном примере показано, как выполнять основные математические операции с использованием больших чисел (`BigDecimal`)

**1. Сложение**

```java
BigDecimal a = new BigDecimal("5");
BigDecimal b = new BigDecimal("7");

// Эквивалентно result = a + b
BigDecimal result = a.add(b);
System.out.println(result);
```

    `Результат: 12`

**2. Вычитание**

```java
BigDecimal a = new BigDecimal("5");
BigDecimal b = new BigDecimal("7");

// Эквивалентно result = a - b
BigDecimal result = a.subtract(b);
System.out.println(result);
```

    `Результат: -2`

**3. Умножение**

При умножении двух больших чисел (`BigDecimal`) результат будет иметь количество знаков после запятой, равное суммарному количеству знаков после запятой двух операндов.

```java
BigDecimal a = new BigDecimal("5.11");
BigDecimal b = new BigDecimal("7.211");

// Эквивалентно result = a * b
BigDecimal result = a.multiply(b);
System.out.println(result);
```

    `Результат: 36.89931`

Для изменения у результата количества знаков после запятой используется перегруженный метод `multiply`, который позволяет передавать объект `MathContext`, устанавливающий правила работы операторов, в частности точность и режим округления результата. Более подробная информация о доступных режимах округления приведена в документации `Oracle`.

```java
BigDecimal a = new BigDecimal("5.11");
BigDecimal b = new BigDecimal("7.211");

MathContext returnRules = new MathContext(4, RoundingMode.HALF_DOWN);

// Эквивалентно result = a * b
BigDecimal result = a.multiply(b, returnRules);
System.out.println(result);
```

    `Результат: 36.90`

**4. Деление**

Деление несколько сложнее других арифметических операций. Рассмотрим следующий пример:

```java
BigDecimal a = new BigDecimal("5");
BigDecimal b = new BigDecimal("7");

BigDecimal result = a.divide(b);
System.out.println(result);
```

Мы ожидаем, что программа выведет на экран что-то похожее на: `0.7142857142857143`, но мы получим: 

    `Результат: java.lang.ArithmeticException: Непрерывное десятичное расширение;
     нет точного десятичного результата`.

Приведённый способ прекрасно работает, если результат - конечное десятичное число, например, такой, который получится, если разделить 5 на 2, но для тех чисел, которые при делении не дают конечный результат, мы получим исключение `ArithmeticException`. В реальных условиях невозможно предсказать значения, которые будут встречаться при делении, поэтому для деления больших чисел (`BigDecimal`) необходимо указать масштаб (**scale**) (количество знаков после запятой) и режим округления (**Rounding Mode**). Более подробную информацию о режимах Scale и Rounding Mode можно найти в документации Oracle по адресу (https://docs.oracle.com/javase/7/docs/api/java/math/BigDecimal.html). Например:

```java
BigDecimal a = new BigDecimal("5");
BigDecimal b = new BigDecimal("7");

// Эквивалентно result = a / b (до 10 знаков после запятой и режим округления HALF_UP)
BigDecimal result = a.divide(b, 10, RoundingMode.HALF_UP);
System.out.println(result);
```

    `Результат: 0.7142857143`

**5. Остаток или деление по модулю**

```java
BigDecimal a = new BigDecimal("5");
BigDecimal b = new BigDecimal("7");

// Эквивалентно result = a % b
BigDecimal result = a.remainder(b);
System.out.println(result);
```

    `Результат: 5`

**6. Возведение в степень**

```java
BigDecimal a = new BigDecimal("5");

// Эквивалентно result = a^10
BigDecimal result = a.pow(10);
System.out.println(result);
```

    `Результат: 9765625`

**7. Определение максимального из двух чисел**

```java
BigDecimal a = new BigDecimal("5");
BigDecimal b = new BigDecimal("7");

// Эквивалентно result = MAX(a,b)
BigDecimal result = a.max(b);
System.out.println(result);
```

    `Результат: 7`

**8. Определение минимального из двух чисел**

```java
BigDecimal a = new BigDecimal("5");
BigDecimal b = new BigDecimal("7");

// Эквивалентно result = MIN(a,b)
BigDecimal result = a.min(b);
System.out.println(result);
```

    `Результат: 5`

**9. Переместить десятичную точку влево**

```java
BigDecimal a = new BigDecimal("5234.49843776");

// Перемещение десятичной точки на 2 знака влево от текущей позиции
BigDecimal result = a.movePointLeft(2);
System.out.println(result);
```

    `Результат: 52.3449843776`

**10. Переместить десятичную точку вправо**

```java
BigDecimal a = new BigDecimal("5234.49843776");

// Перемещение десятичной точки на 3 знака вправо от текущей позиции
BigDecimal result = a.movePointLeft(3);
System.out.println(result);
```

    `Результат: 5234498.43776`

Вариантов и комбинаций параметров для приведённых выше примеров выполнений операций гораздо больше (например, существует 6 вариаций метода деления `divide`). Приведённый набор является далеко неполным перечнем разновидностей операций с большими числами и охватывает только несколько основных базовых вариаций. 

[к оглавлению Глава 19](#глава-19-класс-bigdecimal)

## Раздел 19.5. Инициализация числа BigDecimals значениями ноль, один и девять

Объект `BigDecimal` предоставит статические свойства для чисел ноль, один, и десять. Рекомендуется использовать их, а не сами числа:
+ `BigDecimal.ZERO`
+ `BigDecimal.ONE`
+ `BigDecimal.TEN`

Использование статических свойств позволяют избежать ненужной инициализации объекта, а также получить в коде литерал вместо "магического числа".

```java
// Плохой пример инициализации больших чисел:
BigDecimal bad0 = new BigDecamil(0);
BigDecimal bad1 = new BigDecimal(1);
BigDecimal bad10 = new BigDecimal(10);

// Хороший пример инициализации больших чисел
BigDecimal good0 = BigDecimal.ZERO;
BigDecimal good1 = BigDecimal.ONE;
BigDecimal good10 = BigDecimal.TEN;
```

[к оглавлению Глава 19](#глава-19-класс-bigdecimal)

## Раздел 19.6. Объекты BigDecimal являются неизменяемыми

Если вы хотите произвести вычисления с помощью чисел `BigDecimal`, то возвращаемое значение необходимо присваивать экземпляру `BigDecimal`, поскольку объекты `BigDecimal` неизменяемы:

```java
BigDecimal a = new BigDecimal("42.23");
BigDecimal b = new BigDEcimal("10.001");

a.add(b);   // а по прежнему будет равно 42.23
BigDecimal c = a.add(b));   // c будет равно 52.231
```

[к оглавлению Глава 19](#глава-19-класс-bigdecimal)
