# Глава 12. Класс StringBuffer

[Раздел 12.1. Класс StringBuffer](#раздел-121-класс-stringbuffer)

## Раздел 12.1. Класс StringBuffer

**Ключевые моменты:**
+ используется для создания изменяемой (модифицируемой) строки.
+ **Изменяемый:** может быть изменен.
+ является потокобезопасным, т.е. несколько потоков не могут получить к нему доступ одновременно.

**Методы**:
+ public synchronized StringBuffer append(String s)
+ public synchronized StringBuffer insert(int offset, String s)
+ public synchronized StringBuffer replace(int startIndex, int endIndex, String s)
+ public synchronized StringBuffer delete(int startIndex, int endIndex)
+ public synchronized StringBuffer reverse()
+ public int capacity()
+ public void ensureCapacity(int minimumCapacity)
+ public char charAt(int index)
+ public int length()
+ public String substring(int beginIndex)
+ public String substring(int beginIndex, int endIndex)

**Пример, показывающий разницу между реализациями String и StringBuffer**

```java
class Test {
    public static void main(String args[]) {
        String str = "study";
        str.concat("tonight");
        System.out.println(str);    // Выведет: study
        
        StringBuffer strB = new StringBuffer("study");
        strB.append("tonight");
        System.out.println(strB);   // Выведет: studytonight
    }
}
```

[к оглавлению Глава 12](#глава-12-класс-stringbuffer)