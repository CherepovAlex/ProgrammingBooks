# Глава 14. Класс StringTokenizer

[Раздел 14.1. Разделение по пробелам с помощью StringTokenizer](#раздел-141-разделение-по-пробелам-с-помощью-stringtokenizer)

[Раздел 14.2. Разделение запятой ',' с помощью StringTokenizer](#раздел-142-разделение-запятой--с-помощью-stringtokenizer)

Класс `java.util.StringTokenizer` позволяет разбивать строку на составляющие (лексемы). Это простой способ разбиения строки.

Набор разделителей (символов, разделяющих составляющие части строки) может быть задан как во время создания экземпляра класса, так и для каждой лексемы в теле цикла обработки строки.

## Раздел 14.1. Разделение по пробелам с помощью StringTokenizer

```java
import java.util.StringTokenizer;
public class Simple{
    public static void main(String args[]) {
        StringTokenizer st = new StringTokenizer("apple ball cat dog", " ");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
```

Вывод:
`apple
ball
cat
dog`

[к оглавлению Глава 14](#глава-14-класс-stringtokenizer)

## Раздел 14.2. Разделение запятой ',' с помощью StringTokenizer

```java
public static void main(String args[]) {
    StringTokenizer st = new StringTokenizer("apple,ball cat,dog", ",");
    while (st.hasMoreTokens()) {
        System.out.println(st.nextToken());
    }
}
```

Вывод:

`apple
ball cat
dog`

[к оглавлению Глава 14](#глава-14-класс-stringtokenizer)