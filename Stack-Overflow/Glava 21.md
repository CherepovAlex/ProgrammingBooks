# Глава 21. Класс NumberFormat

[Раздел 21.1. Формат числа](#раздел-211-формат-числа)

## Раздел 21.1. Формат числа

В разных странах существуют различные форматы для представления чисел. Это необходимо учитывать при написании 
программ. Для формирования различных форматов представления чисел в языке Java существует механизм локализации 
`Locale`. Применение этого механизма упрощает фоматирование представляемых чисел.

```java
Locale locale = new Locale("en", "IN");
NumberFormat numberFormat = NumberFormat.getInstance(locale);
```

Используя приведённый выше формат, можно выполнять различные задачи

1. Форматировать численные значения

```java
numberFormat.format(10000000.99);
```

2. Задавать формат чисел при расчётах, связанных с местной валютой

```java
NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
currencyFormat.format(10340.999);
```

3. Задавть формат чисел при расчетах, связанных с вычислением процентов

```java
NumberFormat percentageFormat = NumberFormat.getPercentInstance(locale);
percentageFormat.format(10929.999);
```

4. Задавть количество значащих цифр в числах - в целой и в мнимой частях.

```java
numberFormat.setMinimumIntegerDigits(int digits)
numberFormat.setMaximumIntegerDigits(int digits)
numberFormat.setMinimumFractionDigits(int digits)
numberFormat.setMaximumFractionDigits(int digits)
```

[к оглавлению Глава 21](#глава-21-класс-numberformat)

