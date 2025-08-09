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

`java.util.Date is : Fri Jul 22 14:40:35 IST 2016
java.sql.Date is : 2016-07-22
dateFormated date is : 22/07/2016 - 02:40:35`

Класс `java.util.Date` содержит информацию о дате и времени, в то время как класс `java.sql.Date` содержит только информацию о дате.

[к оглавлению Глава 16](#глава-16-класс-date)

## Раздел 16.2. Вывод даты в основном формате



[к оглавлению Глава 16](#глава-16-класс-date)

[Раздел 16.1. Преобразование экземпляра класса java.util.Date в экземпляр класса java.sql.Date](#раздел-161-преобразование-экземпляра-класса-javautildate-в-экземпляр-класса-javasqldate)

[Раздел 16.2. Вывод даты в основном формате](#раздел-162-вывод-даты-в-основном-формате)
