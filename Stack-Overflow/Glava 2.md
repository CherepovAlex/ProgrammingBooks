

# Глава 2. Преобразование типов.

## Раздел 2.1. Приведение числовых примитивов.

Приведение числовых примитивов может осуществляться двумя способами. Неявное или автоматическое приведение происходит, когда исходный тип имеет меньший диапазон, чем целевой тип.<br>
```java
// Неявное приведение
byte byteVar = 42;
short shortVar = byteVar;
int intVar = shortVar;
long longVar = intVar;
float floatVar = longVar;
double doubleVar = floatVar;
```
Явное приведение необходимо делать в тех случаях, когда исходный тип имеет больший диапазон, чем целевой.
```java
// Явное приведение
double doubleVar = 42.0d;
float floatVar = (float) doubleVar;
long longVar = (long) floatVar;
int intVar = (int) longVar;
short shortVar = (short) intVar;
byte byteVar = (byte) shortVar;
```

При приведении примитивов с плавающей запятой (`float`, `double`) к примитивам целых чисел исходное число округляется в меньшую сторону.

## Раздел 2.2. Основные числовые преобразования.

```java
static void testNumericPromotion() {
    char char1 = 1, char2 = 2;
    short short1 = 1, short 2 = 2;
    int int1 = 1, int 2 = 2;
    float float1 = 1.0f, float2 = 2.0f;
    
    // char1 = char1 + char2;       // Ошибка: Невозможно преобразовать из int в char;
    // short1 = short1 + short2;    // Ошибка: Невозможно преобразовать из int в short;
    int1 = char1 + char2;           // char преобразуется в int.
    int1 = short1 + short2;         // short переводится в int.
    int1 = char1 + short2;          // и char, и short преобразуются в int.
    float1 = short1 + float2;       // short преобразуется в float
    int1 = int1 + int2;             // int не изменяется.
}
```

## Раздел 2.3. Приведение нечисловых примитивов.

[к оглавлению Глава 2](#глава-2-преобразование-типов)

[к оглавлению Раздел 2.1](#раздел-21-приведение-числовых-примитивов)

[к оглавлению Раздел 2.2](#раздел-22-основные-числовые-преобразования)

[к оглавлению Раздел 2.3](#раздел-23-приведение-нечисловых-примитивов)