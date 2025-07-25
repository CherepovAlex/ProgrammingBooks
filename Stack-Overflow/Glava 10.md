# Глава 10. Примитивные типы данных

Существует 8 примитивных типов данных `byte`, `short`, `int`, `long`, `char`, `boolean`, `float` и `double`, в которых хранится большинство исходных числовых данных в программах на языке Java.

## Раздел 10.1. Примитив char

В переменной типа `char` может храниться один 16-битный символ Unicode. Символьный литерал заключается в одинарные кавычки

```java
char myChar = 'u';
char myChar2 = '5';
char myChar3 = 65;  // myChar3 == 'A'
```

Его минимальное значение `\u0000` (0 в десятичном представлении также называется _нулевым символом_), а максимальное `\uffff` (65 535).

По умолчанию значение `char` равно `\u0000`.

```java
char defaultChar;       // defaultChar == \u0000
```

Чтобы определить символ, имеющий значение ', необходимо использовать управляющую последовательность (символ, которому предшествует обратная косая черта):

```java
char singleQuote = '\'';
```

Существуют и другие управляющие последовательности:

```java
char tab = '\t';
char backspace = '\b';
char newline = '\n';
char carriageReturn = '\r';
char formfeed = '\f';
char singleQuote = '\'';
char doubleQuote = '\"';    // экранирование здесь излишне; ' " ' последовательность
                           // выражает то же самое; однако всё равно допустимо
char backlash = '\\\';
char unicode = '\uXXXX' // XXX представляет собой значение символа в Uncode,
                       // которое вам надо отобразить
```

Вы можете объявить `char` любым символом Unicode.

```java
char heart = '\u2764';
System.out.println(Character.toString(heart));  // Печатается строка, содержащая "♥"
```

Например, чтобы перебрать все буквы алфавита, можно поступить следующим образом:

```java
for (int i = 0; i <= 26; i++) {
    char letter = (char) ('a' + i);
    System.out.println(letter);
}
```
[к оглавлению Глава 10](#глава-10-примитивные-типы-данных)

## Раздел 10.2. Шпаргалка по примитивным типам

Таблица, в которой отображены размер и диапазон значений всех примитивных типов:
|**Тип данных**|**Числовое представление**|**Диапазон значений**|**По умолчанию значение**|
|:---------|:------------------|:--------------------------------------|:-----------------|
|`boolean`|однозначно определено|false и true|ложь|
|`byte`|8-бит знаковый|-2^7 - 2^7 - 1|0|
|`short`|16-бит знаковый|-2^15 - 2^15 - 1, от -32,768 до +32,767|0|
|`int`|32-бит знаковый|-2^31-2^31 - 1, от -2 147 483 648 до + 2 147 483 647|0|
|`long`|64-бит знаковый|-2^63 - 2^63 - 1, от -9 223 372 036 854 775 808 до 9 223 372 036 854 775 807|0L|
|`float`|32-бит с плавающей точкой|от 1,401298464е-45 до 3,402823466е+38 (положительный или отрицательный)|0.0F|
|`double`|64-бит с плавающей точкой|от 4,94065645841246544е-324d до -1,79769313486231570е+308d (положительный или отрицательный)|0.0D|
|`char`|16-бит беззнаковый|от 0 до 2^16 - 1, от 0 до 65 535|0|

_Примечания_:

1. Спецификация языка Java предписывает, чтобы целочисленные типы данных со знаком (от `byte` до `long`) использовали двоичное представление в дополнительном коде, а типы с плавающей точкой - стандартное двоичное представление с плавающей точкой, соответствует стандарту IEE 754.
2. Java 8 и более поздние версии предоставляют стандартные методы для выполнения беззнаковых арифметических операций над типами данных `int` и `long`. Несмотря на то, что эти методы позволяют программе _рассматривать_ значения соответствующих типов как беззнаковые, сами типы остаются знаковыми типами данных.
3. Наименьшее их приведённых выше чисел с плавающей точкой являются _субнормальными_, т.е. имеют меньшую точность, чем нормальное значение. Наименьшими _нормальными_ числами являются 1,175494351е-38 и 2,2250738585072014е-308.
4. Значение типа `char` условно представляет собой беззнаковое целое число, представляющее собой символ UTF-16 _кодовую точку_ Unicode/UTF-16.
5. Несмотря на то, что значение типа `boolean` содержит всего один бит информации, его размер в памяти варьируется в зависимости от реализации виртуальной машины Java (см. документацию по адресу http://docs.oracle.com/javase/specs/jvms/se8/jvms-2.html#jvms-2.3.4).

[к оглавлению Глава 10](#глава-10-примитивные-типы-данных)

## Раздел 10.3. Примитивный тип данных float

`float` - это 32 разрядное число с плавающей точкой одинарной точности по стандарту IEEE 754. По умолчанию десятичные числа интерпретируются как тип данных `double`. Чтобы определить тип данных `float`, просто добавьте символ `f` к десятичному литералу.

```java
double DoubleExample = 0.5;         // без 'f' после цифр, соответственно это тип double
float FLoatExample = 0.5f;           // c 'f' после цифр - это тип float

float myFloat = 92.7f;              // это тип данных float...
float positiveFloat = 89.3f;        // положительное значение типа float
float negativeFloat = -89.3f;       // отрицательное значение типа float
float integerFloat = 43.0f;         // можно задать целое число (оно все равно будет типа float, а не int)
float underZeroFloat = 0.0549f;     // можно задать дробное значение, меньшее 1
```

Тип `float` поддерживает пять общих арифметических операций: сложение, вычитание, умножение, деление и деление по модулю (определяет остаток от деления).

_Примечание_: приведённые ниже результаты могут незначительно отличаться в результате возникновения погрешностей, _связанных_ с выполнением операций с плавающей точкой. Для наглядности и удобочитаемости некоторые результаты были округлены (например, приведённый в примере с операцией сложения на самом деле равен 34.600002).

```java
// сложение
float result = 32.2f + -2.6f;   // результат 34.6

// вычитание
float result = 45.1f - 10.3f;   // результат 34.8

// умножение
float result = 26.3f * 1.7f;   // результат 44.71

// деление
float result = 37.1f / 4.8f;   // результат 7.729166

// деление по модулю
float result = 37.1f % 4.8f;   // результат 3.4999971
```

Многие числа с плавающей запятой не имеют точного представления. Это связано с особенностями хранения этих чисел в памяти компьютера (т.е. с особенностями представления этих чисел в двоичной форме).

```java
float notExact = 3.1415926f;
System.out.println(notExact);   // 3.1415925
```

Тип данных `float` вполне подходит для большинства приложений, однако примитивы `float` и `double` не следует использовать для хранения точных значений десятичных чисел (например, денежных сумм), а также чисел, к которым предъявляется требование повышенной точности. Вместо них следует использовать класс `BigDecimal`.

По умолчанию значение `float` равно `0,0f`.

```java
float defaultFloat;     // defaultFloat =- 0.0f
```

Точность значения с плавающей точкой составляет примерно 1 к 10 миллионам.

_Примечание_: `Float.POSITIVE_INFINITY`, `Float.NEGATIVE_INFINITY`, `Float.NaN` - это всё значение типа `float`. `Nan` обозначает результаты операций, которые невозможно определить, например, деление двух бесконечных величин. Кроме того, значения `0f` и `-0f` различны, но, тем не менее, операция `==` с ними даёт результат `true`:

```java
float f1 = 0f;
float f2 = -0f;
System.out.println(f1 == f2);   // true
System.out.println(1f / f1);    // бесконечность
System.out.println(1f / f2);    // отрицательная бесконечность
System.out.println(Float.POSITIVE_INFINITY / Float.POSITIVE_INFINITY);    // NaN
```

[к оглавлению Глава 10](#глава-10-примитивные-типы-данных)

## Раздел 10.4. Примитивный тип данных int

Примитивный тип данных, такой как `int`, хранит значения непосредственно в переменной, которая его использует, в то время как переменная, объявленная с использованием ключевого слова `Integer`, хранит ссылку на значение.

Согласно java API: "Класс `Integer` оборачивает значение примитивного типа `int` в объект. Объект тип `Integer` содержит одно поле, тип которого `int`".

По умолчанию `int` является 32-разрядным знаковым целым числом. Оно может хранить минимальное значение -2^31, а максимальное - 2^31 - 1.

```java
int example = -42;
int myInt = 284;
int anotherInt = 73;

int addedInts = myInt + anotherInt; // 284 + 73 = 357
int subtractedInts = myInt + anotherInt; // 284 - 73 = 211
```

Если необходимо хранить число, выходящее за пределы этого диапазона, то вместо него следует использовать тип `long`. Выход за пределы диапазона значений `int` приводит к целочисленному переполнению, в результате чего значение, выходящее за пределы диапазона, добавляется к противоположному участку диапазона (положительное значение становится отрицательным и наоборот). Значение `(value - MIN_VALUE) % RANGE) + MIN_VALUE`, или `((value + 2147483648) % 4294967296) - 2147483648`.

```java
int demo = 2147483647;  // максимальное положительное целое число
System.out.println(demo);   // выведет число 2147483647
demo = demo + 1;    // приводит к целочисленному переполнению
System.out.println(demo);   // выведет число -2147483648
```

Максимальное и минимальное значения `int` можно получить следующим образом:

```java
int high = Integer.MAX_VALUE;   // high == 2147483647
int low = Integer.MIN_VALUE;    // low == -2147483648
```

По умолчанию значение `int` равно 0.

```java
int defaultInt;     // default == 0
```

[к оглавлению Глава 10](#глава-10-примитивные-типы-данных)

## Раздел 10.5. Преобразование примитивов

В языке Java мы можем преобразовывать целые значение в значения с плавающей точкой. Кроме того, поскольку в кодировке `Unicode` каждый символ соответствует числу, типы `char` могут быть преобразованы в целочисленные типы данных и в данные с плавающей запятой. Тип данных `boolean` - единственный примитивный тип данных, который не может быть преобразован в любой другой примитивный тип данных. Также невозможно выполнить и обратное преобразование в тип данных `boolean`.

Существует два типа преобразования: расширение типов и сужение типов.

Расширение типов (больше известное как неявное приведение типов) - это когда значение одного типа данных, занимающее меньшее пространство в памяти, преобразуется в значение другого типа данных, занимающее большее пространство в памяти. В этом случае не возникает проблем потери данных.

Соответственно, _сужение типов_ (больше известное как явное приведение типов) - это когда значение одного типа данных, занимающее большее пространство в памяти, преобразуется в значение другого типа данных, занимающее меньшее пространство в памяти, чем первое. В этом случае может произойти потеря данных.

Java выполняет неявное приведение автоматически. Но если вам потребуется преобразование на сужение типов (и вы полностью уверены, что потери данных при этом не произойдёт), то можно заставить Java выполнить преобразование с помощью языковой конструкции, известной как приведение.

**Расширение типов (неявное приведение)**

```java
int a = 1;
double d = a;   // корректное преобразование в double, явного приведения не требуется
```

**Сужение типов (явное приведение)**

```java
double d = 18.96;
int b = d;       // некорректное преобразование в int, будет выдана ошибка компиляции
int b = (int) d; // корректное преобразование в int, но результат получается
                 // усеченным (округляется вниз)
                 // Это приведение типов
                 // Теперь b = 18
```

[к оглавлению Глава 10](#глава-10-примитивные-типы-данных)

## Раздел 10.6. Сравнение использования памяти примитивами и классами-обертками

| **Примитив** | **Класс-обертка** | **Размер памяти примитив/класс-обертка** |
|:-------------|:------------------|:-----------------------------------------|
| boolean      | Boolean           | 1 байт/16 байт                           |
| byte         | Byte              | 1 байт/16 байт                           |
| Short        | Short             | 2 байта/16 байт                          |
| char         | Char              | 2 байта/16 байт                          |
| int          | Integer           | 4 байта/16 байт                          |
| long         | Long              | 8 байт/16 байт                           |
| float        | Float             | 4 байта/16 байт                          |
| double       | Double            | 8 байт/16 байт                           |

**Классы-обертки** всегда требуют 8 байт для управления типом и памятью, а поскольку размер объектов всегда кратен 8, то для _всех классов-оберток требуется 16 байт_. Кроме того, каждое использование класса-обертки влечёт за собой хранение ссылки, которая занимает место в памяти ещё дополнительно 4 или 8 байт, в зависимости от JVM и опций JVM.

При выполнении операций с большими объёмами данных использование памяти может существенно влиять на производительность. При использовании массивов потребление памяти возрастает ещё больше: массив `float[5]` занимает в памяти всего 32 байта, в то время как массив `Float[5]`, содержащий 5 отдельных ненулевых значений, потребует уже 112 байт (на 64-битной системе без применения сжатых указателей этот показатель возрастает до 152 байт).

**Кеширование классов-оберток**

Потребление памяти классами-обертками может быть в некоторой степени уменьшено за счет применения механизма кеширования. Некоторые классы-обертки реализуют кеш своих экземпляров. Например, класс `Integer` по умолчанию помещает в кеш экземпляры для представления чисел в диапазоне от `-128` до `+127`. Однако это не уменьшает дополнительных затрат памяти, связанных с дополнительной переадресацией.

При создании экземпляра класса-обертки либо с помощью автоупаковщика либо путём вызова статического метода `valueOf(primitve)` система попытается использовать значение, размещённое в кеше. Конечно, если вы создаёте экземпляры классов-оберток "вручную", то лучше использовать `valueOf`, а не `new`. (Операция `new` всегда создаёт новый экземпляр.) Однако если большинство ваших значений не входит в кешируемый диапазон, то лучше использовать `new` и сэкономить при этом на поиске в хеше.

[к оглавлению Глава 10](#глава-10-примитивные-типы-данных)

## Раздел 10.7. Примитивный тип данных double

Тип данных `double` - это 64-разрядное число с плавающей запятой двойной точности по стандарту IEEE 754.

```java
double example = -7162.37;
double myDouble = 974.21;
double anotherDouble = 658.7;

double addedDoubles = myDouble + anotherDouble;     // 315,51
double substractedDoubles = myDouble - anotherDouble;   // 1632,91

double scientificNotationDouble = 1.2e - 3;         // 0.0012
```

Так же, как и в случае с `float`, значения типа `double` не имеют точного представления. Как уже было сказано, это связано с особенностями хранения этих чисел в памяти компьютера (т.е. с особенностями представления этих чисел в двоичной форме).

```java
double notExact = 1,32 - 0,42;  // результат должен быть 0,9
System.out.println(notExact);   // 0.9000000000000001
```

Тип данных `double` вполне подходит для большинства приложений, однако примитивы `float` и `double` не следует использовать для хранения точных значений десятичных чисел (например, денежных сумм), а также чисел, к которым предъявляется требование повышенной точности. Вместо них следует использовать класс `BigDecimal`.

По умолчанию значение `double` равно `0,0d`

```java
public double defaultDouble;    // defaultDouble == 0.0
```

_Примечание:_ `Double.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Double.NaN` - это все значения типа `double.NaN` обозначает результат операций, которые невозможно определить, например, деление двух бесконечных величин. Кроме того, значения `0f` и `-0f` различны, но тем не менее операция `==` с ними даёт результат `true`:

```java
double d1 = d0;
double d2 = -0d;
System.out.println(d1 == d2); // true
System.out.println(1d / d1); // бесконечность
System.out.println(1d / d2); // отрицательная бесконечность
System.out.println(Double.POSITIVE_INFINITY / Double.POSITIVE_INFINITY); // NaN
```

[к оглавлению Глава 10](#глава-10-примитивные-типы-данных)

## Раздел 10.8. Примитивный тип данных long

По умолчанию `long` является 64-разрядным знаковым целым числом (в Java 8 оно может быть как знаковым, так и беззнаковым). В качества числа со знаком оно может хранить минимальное значение -2^63 и максимальное 2^63-1, а в качестве беззнакового числа - минимальное значение 0 и максимальное 2^64 - 1.

```java
long example = -42;
long myLong = 284;
long anotherLong = 73;
```
```java

// К концу числа необходимо добавить букву "L", так как по умолчанию,
// числа инициализируются как тип int. Добавление буквы "L" инициализирует
// переменную значением типа long
// Поскольку 549755813888 (2 ^ 39) больше максимального значения int (2^31 - 1),
// необходимо добавить "L"
long bigNumber = 549755813888L;

long addedLongs = myLong + anotherLong;  // 284 + 73 = 357
long subtractedLongs = myLong - anotherLong;   // 284 - 73 = 211
```

Максимальное и минимальное значения `long` можно определить следующим образом:

```java
long high = Long.MAX_VALUE;     // high == 9223372036584775807L
long low = Long.MIN_VALUE;      // low == -9223372036854775808L
```

По умолчанию значение `long` равно `0L`

```java
long defaultLong;   // defaultLong == 0L
```

_Примечание_: буква "L", добавляемая в конце литерала long, нечувствительна к регистру, однако лучше использовать заглавную, так как её легче отличить от цифры 1:

```java
2L == 2l; // true
```

_Предупреждение_: Java помещает в кеш экземпляры объектов Integer из диапазона от -128 до 128. Почему так происходит, поясняется здесь: http://blogs.oracle.com/darcy/entry/boxing_and_caches_integer_valueof.

Получим следующие результаты:

```java
Long val1 = 127L;
Long val2 = 127L;

System.out.println(val1 == val2);   // true

Long val3 = 128L;
Long val4 = 128L;
System.out.println(val3 == val4);   // false
```

Чтобы корректно сравнить 2 значения Object Long, используйте следующий код (начиная с Java 1.7):

```java
Long val3 = 128L;
Long val4 = 128L;

System.out.println(Objects.equal(val3, val4);   // true
```

Сравнение примитива long с классом оберткой Long не приведёт к ложноотрицательному результату false, как это происходит при сравнении двух объектов с помощью операции ==.

[к оглавлению Глава 10](#глава-10-примитивные-типы-данных)

## Раздел 10.9. Примитивный тип данных boolean

Переменная с типом данных `boolean` может хранить одно из двух значений - `true` или `false`

```java
boolean foo = true;
System.out.println("foo = " + foo);                 // foo = true

boolean bar = false;
System.out.println("bar = " + bar);                 // bar = false

boolean notFoo = !foo;
System.out.println("notFoo = " + notFoo);           // notFoo = false

boolean fooAndBar = foo && bar;
System.out.println("fooAndBar = " + fooAndBar);     // fooAndBar = false

boolean fooOrBar = foo || bar;
System.put.println("fooOrBar = " + fooOrBar);       // fooOrBar = true

boolean fooXorBar = foo ^ bar;
System.out.println("fooXorBar = " + fooXorBar);     // fooXorBar = true
```

По умолчанию значение переменной типа `boolean` равно `false`.

```java
boolean defaultBoolean;             // defaultBoolean == false
```

[к оглавлению Глава 10](#глава-10-примитивные-типы-данных)

## Раздел 10.10. Примитивный тип данных byte

Тип данных `byte` - это 8-разрядное знаковое целое число. Оно имеет диапазон от минимального значение -2^7 (-128) и до максимального значение 2^7 - 1 (127)

```java
byte example = -36;
byte myByte = 96;
byte anotherByte = 7;

byte addedBytes = (byte) (myByte + anotherByte);    // 103
byte substructedBytes = (byte) (myByte - anotherByte);    // 89
```

Максимальное и минимальное значение `byte` можно определить следующим образом:

```java
byte high = Byte.MAX_VALUE;     // high == 127
byte low = Byte.MIN_VALUE;     // high == -128
```

По умолчанию значение переменной типа `byte` равно 0.

```java
byte defaultByte;       // defaultByte == 0
```

## Раздел 10.11. Представление отрицательных значений

В языке программирования Java, как и в большинстве других языков программирования отрицательные целые числа хранятся в дополнительном коде. В этом представлении двоичный код числа с разрядностью `n` бит кодируется следующим образом: младшие значения `n - 1` бит хранят положительное целое число `x` в виде целого числа. В старшем значащм разраяде хранит бит `v` со значением `s`. Значение, представляемое этими битами, равно `x - s * 2^n - 1`.

Т.е. если старший бит равен 1, то из `x` вычитается значение, которое всего на 1 больше числа, которое можно представить с помощью остальных битов `(2^(n-2) + 2^(n-3) + ... + 2^1 + 2^0 = 2^(n-1) - 1`, что позволяет получить уникальное двоичное представление для каждого значение от `-2^n-1 (s = 1; x = 0)` до `2^(n-1) - 1 (s = 0; x = 2^(n-1) - 1)`.

Такое представление чисел удобно ещё и тем, что в качестве бонуса оно позволяет вам складывать двоичные представления числе, как если бы они были положительными двоичными числами:

`v1 = x1 - s1 * 2^n - 1 v2 = x2 - s2 * 2^n - 1`.

| **s1** | **s2** | **x1 + x2**    |**переполнение**| Результат сложения                                                                                                                        |
|:-------|:-------|:---------------|:------------------|:------------------------------------------------------------------------------------------------------------------------------------------|
| 0      | 0      | Нет            | | x1 + x2 = v1 + v2                                                                                                                         |
| 0      | 0      | Да             | | слишком большой, чтобы быть представленным с помощью данного типа данных (переполнение)                                                   |
| 0      | 1      | Нет            | | x1 + x2 - 2^n - 1 = x1 + x2 - s2 * 2^n = v1 + v2                                                                                          |
| 0      | 1      | Да             | | (x1 + x2) mod 2^n - 1 = x1 + x2 - 2^n - 1 = v1 + v2                                                                                       |
| 1      | 0      | *              | | см. выше (поменять местыми слагаемые)                                                                                                     |
| 1      | 1      | Нет            | | слишком мал, чтобы быть представленным данным типом данных (x1 + x2 - 2^n < -2^n - 1; число невозможно представить без потери значимости) |
| 1      | 1      | Да             | | (x1 + x2) mod 2^n - 1 - 2^n - 1 = (x1 + x2) - 2^n - 1 = (x1 - s1 * 2^n - 1) + (x2 - s2 * 2^n - 1) = v1 + v2                               |

Если мы проинверсируем представление числа в дополнительном коде, то получим отрицательное значение этого числа.

Обратите внимание, что при добавлении побитового дополнения к числу все биты станут равными 1.

Теперь, если добавить 1 так, чтобы результирующее значение переполнялось, вы получите нейтральный элемент 0 (все биты станут равными 0).

Таким образом, отрицательное значение числа `i` может быть вычислено следующим образом (здесь мы игнорируем автоматическое преобразование числа к типу `int`)

`(~i) + 1`

Пример: получить отрицательное значение 0 (тип данных `byte`):

Результат инверсии 0 равен 11111111. Прибавление 1 даст значение 100000000 (9 бит). Поскольку тип даныхх `byte` может хранить только 8 бит, крайний левый бит отбрасывается, и в результате мы получим значение 00000000.

| **Первоначальное значение** | **Производимое действие**    | **Результат**         |
|:----------------------------|:-----------------------------|:----------------------|
| 0 (00000000)                | побитная инверсия            | -0 (11111111)         |
| 11111111                    | Добавить 1 к двоичному числу | 100000000             |
| 1000000000                 | Усечение до 8 бит            | 00000000 (-0 равно 0) |

[к оглавлению Глава 10](#глава-10-примитивные-типы-данных)

## Раздел 10.12. Примитивный тип данных short


[к оглавлению Глава 10](#глава-10-примитивные-типы-данных)

[Раздел 10.1. Примитив char](#раздел-101-примитив-char)

[Раздел 10.2. Шпаргалка по примитивным типам](#раздел-102-шпаргалка-по-примитивным-типам)

[Раздел 10.3. Примитивный тип данных float](#раздел-103-примитивный-тип-данных-float)

[Раздел 10.4. Примитивный тип данных int](#раздел-104-примитивный-тип-данных-int)

[Раздел 10.5. Преобразование примитивов](#раздел-105-преобразование-примитивов)

[Раздел 10.6. Сравнение использования памяти примитивами и классами-обертками](#раздел-106-сравнение-использования-памяти-примитивами-и-классами-обертками)

[Раздел 10.7. Примитивный тип данных double](#раздел-107-примитивный-тип-данных-double)

[Раздел 10.8. Примитивный тип данных long](#раздел-108-примитивный-тип-данных-long)

[Раздел 10.9. Примитивный тип данных boolean](#раздел-109-примитивный-тип-данных-boolean)

[Раздел 10.10. Примитивный тип данных byte](#раздел-1010-примитивный-тип-данных-byte)

[Раздел 10.11. Представление отрицательных значений](#раздел-1011-представление-отрицательных-значений)

[Раздел 10.12. Примитивный тип данных short](#раздел-1012-примитивный-тип-данных-short)