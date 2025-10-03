# Глава 22. Побитовые операции

## Раздел 22.1. Проверка, установка, сброс и переключение отдельных битов. Использование значения типа long в качестве битовой маски

Предположим, что мы хотим модифицировать бит `n` целочисленного примитива `i` (байт, short, char, int или long).

```java
(i & 1 << n) != 0   // проверяет, установлен ли бит 'n'
i |= 1 << n;        // устанавливает бит 'n' в 1
i &= ~(1 << n);     // устанавливает бит 'n' в 0
i ^= 1 << n;        // переключает значение бита 'n' на противоположное
```

Использование значений типа `long/int/short/byte` в качестве битовой маски:

```java
public class BitMaskExample {
    private static final long FIRST_BIT = 1L << 0;
    private static final long SECOND_BIT = 1L << 1;
    private static final long THIRD_BIT = 1L << 2;
    private static final long FOURTH_BIT = 1L << 3;
    private static final long FIFTH_BIT = 1L << 4;
    private static final long BIT_55 = 1L << 54;

    public static void main(String[] args) {
        checkBitMask(FIRST_BIT | THIRD_BIT | FIFTH_BIT | BIT_55);
    }
    
    private static void checkBitMask(long bitmask) {
        System.out.println("ПЕРВЫЙ_БИТ: " + ((bitmask & FIRST_BIT) != 0));
        System.out.println("ВТОРОЙ_БИТ: " + ((bitmask & SECOND_BIT) != 0));
        System.out.println("ТРЕТИЙ_БИТ: " + ((bitmask & THIRD_BIT) != 0));
        System.out.println("ЧЕТВЕРТЫЙ_БИТ: " + ((bitmask & FOURTH_BIT) != 0));
        System.out.println("ПЯТЫЙ_БИТ: " + ((bitmask & FIFTH_BIT) != 0));
        System.out.println("БИТ_55: " + ((bitmask & BIT_55) != 0));
    }
}
```

Программа выведет на экран

 ПЕРВЫЙ_БИТ: **true**
 ВТОРОЙ_БИТ: **false**
 ТРЕТИЙ_БИТ: **true**
 ЧЕТВЕРТЫЙ_БИТ: **false**
 ПЯТЫЙ_БИТ: **true**
 БИТ_55: **true**

Это полностью соответствует той маске, которую мы передали в качестве параметра методу checkBitMask: 
`FIRST_BIT | THIRD_BIT | FIFTH_BIT | BIT_55 // ПЕРВЫЙ_БИТ | ТРЕТИЙ_БИТ | ПЯТЫЙ_БИТ | БИТ_55`

[к оглавлению Глава 22](#глава-22-побитовые-операции)

## Раздел 22.2. Класс java.util.BitSet

Начиная с версии 1.7 в Java существует класс `java.util.BitSet`, предоставляющий простой и удобный интерфейс для 
проведения побитовых операций: 

```java
final BitSet bitSet = new BitSet(8);    // по умолчанию все биты сброшены, создается новый BitSet

IntStream.range(0, 8).filter(i -> i % 2 == 0).forEach(bitSet::set);    // {0, 2, 4 ,6} поток включает лампочку с номером i

bitSet.set(3);  // {0, 2, 3, 4, 6} лампочку номер 3 — включить"

bitSet.set(3, false);   // {0, 2, 4, 6} лампочку номер 3 — установить в состояние false (выключить)

final  boolean b = bitSet.get(3);   // b = false проверить, горит ли лампочка номер 3

bitSet.flip(6); //  {0, 2, 4} переключить лампочку номер 6

bitSet.set(100);    // {0, 2, 4, 100} - расширяется автоматически
```

`BitSet` реализует свойства `Clonable` и `Serializable`, а под капотом все значение битов хранятся в поле, которое 
представляет собой массив `long[] words`, размер которого автоматически увеличивается.

Также поддерживается набор логических побитовых операций, таких как `and`, `or`, `xor` и `andNot` (_и-не_):

```java
bitSet.and(new BitSet(8));
bitSet.or(new BitSet(8));
bitSet.xor(new BitSet(8));
bitSet.andNot(bew BitSet(8));
```

[к оглавлению Глава 22](#глава-22-побитовые-операции)

## Раздел 22.3. Как проверить, является ли значение степенью числа 2



[к оглавлению Глава 22](#глава-22-побитовые-операции)

[Раздел 22.1. Проверка, установка, сброс и переключение отдельных битов. Использование значения типа long в качестве битовой маски](#раздел-221-проверка-установка-сброс-и-переключение-отдельных-битов-использование-значения-типа-long-в-качестве-битовой-маски)

[Раздел 22.2. Класс java.util.BitSet](#раздел-222-класс-javautilbitset)































