# Глава 1. Начало работы с языком Java.

[Раздел 1.1. Создание первой Java-программы.](#раздел-11-создание-первой-java-программы)

## Раздел 1.1. Создание первой Java-программы.

Создайте в любом текстовом редакторе или в любой IDE (интегрированной среде разработки), поддерживающей язык Java, новый файл с именем `HelloWorld.java`. Затем вставьте в него блок кода и сохраните:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); } 
} 
```
Вы можете запустить эту программу онлайн на сайте ideone.com, перейдя по ссылке (https://ideone.com/rbWs4M). (`ideone.com` - это онлайн-сервис, который позволяет пользователям писать, компилировать и исполнять код на ращличныз языках программирования.)

***Примечание:*** чтобы компилятор Java распознал этот класс как класс с общим доступом (т.е. как `public class`) и не выдал ошибку компиляции, имя файла должно совпадать с именем класса (в данном примере - `HelloWorld`) и иметь расширение `.java`. Перед ним также должен стоять модификатор доступа public.

Согласно принятым соглашениям об именах переменных в языке Java рекомендуется начинать имя класса с прописной буквы и использовать так называемых формат Camel Case ("верблюжий стиль") (в котором каждое слово должно начинаться с прописной буквы). Не рекомендуется использовать символы подчеркивания (_) и знаки доллара ($).

Для компиляции откройте окно терминала и перейдите в каталог, содержащий файл `HelloWorld.java`:

```bash
cd /path/to/containing/folder/
```

***Примечание***: `cd` - это команда терминала для смен каталога.

Запустите программу на компиляцию с помощью компилятора Java, набрав следующую команду:

```bash
$ javac HelloWorld.java
```

При выполнении команды довольно часто может возникнуть ошибка компиляции вида

```bash
'javac' not recognized as an internal or external command, operable program or batch file
```
(`"javac"` не распознаётся как внутренняя или внешняя команда, работающая программа или командный файл), даже в том случае, если вы установили на свою машину комплект JDK и запускаете программу из среды IDE, например, из eclipse или ей подобной. Это происходит вследствие того, что путь к компилятору `'javac'` не добавляется автоматически в переменную окружения по умолчанию.

В случае, если ошибка случилась на машине с ОС Windows, для решения проблемы попробуйте сначала определить полный путь к `javac.exe`. Как правило, компилятор Java находится в C:\Program Files\Java\jdk(номер версии)\bin. Затем попробуйте запустить программу с помощью следующей команды.

```bash
$ C:\Program Files\Java\jdk(номер версии)\bin\javac HelloWorld.java
```
Два продемонстрированных способа запуска программы на компиляцию при помощи компилятора javac полностью аналогичны. Только в последнем случае ваша ОС знала, где находится javac. Так что давайте теперь укажем операционной системе полный путь к компилятору, чтобы не набирать его при каждом запуске. Для этого нам необходимо добавить путь в переменную окружения PATH.

Для редактирования переменной окружения РАТН в операционных системах Windows ХР/Vista/7/8/10:
+ Панель управления => Система => Дополнительные настройки системы (Control Panel => System => Advanced system settings)
+ Перейдите на вкладку “Дополнительно” => Переменные среды
+ В разделе “Системные переменные” прокрутите вниз и выберите “РАТН” => Изменить.

**Отменить это будет невозможно**, поэтому будьте осторожны. Сначала скопируйте существующее содержимое переменной `РАТН` в блокнот. Затем, чтобы получить точный путь к компилятору javac, вручную перейдите в папку, где находится программа javac, и нажмите на адресную строку, а затем скопируйте адрес. Это должно выглядеть примерно так: C:\Program Files\Java\jdk1.8.0_xx\bin

В поле “Variable value” (“Значение переменной”) вставьте скопированный путь **ПЕРЕД** всеми существующими каталогами, после чего поставьте точку с запятой (;). **НЕ УДАЛЯЙТЕ** существующие записи.

```bash
Имя переменной: РАТН
Значение переменной: C:\Program Files\Java\jdk1.8.0_xx\bin; [Existing Entries...]
```
Теперь эта ошибка больше возникнуть не должна.

Для систем на базе Linux попробуйте перейти по ссылке (https://docs.oracle.com/javase/tutorial/essential/environment/paths.html).

**Примечание**: команда `javac` вызывает компилятор Java.

Компилятор генерирует файл `HelloWorld.class`, содержащий байт-код, который может быть выполнен виртуальной машиной Java (JVM). Компилятор языка программирования Java javac читает исходные файлы, написанные на языке программирования Java, и компилирует их в файлы классов в байт-коде. В качестве опции компилятор может обрабатывать аннотации, содержащиеся в исходных текстах и файлах классов, используя подключаемый интерфейс обработки аннотаций (Pluggable Annotation Processing API). Компилятор является инструментом командной строки, но может быть вызван и с помощью Java Compiler API.

Для запуска программы введите команду java, а затем имя класса, содержащего метод main (в нашем примере это класс HelloWorld). Обратите внимание на то, что при вызове опущено расширение файла **.class**:

```bash
$ java HelloWorld
```
**Примечание**: команда java запускает java-приложение. 

В результате работы программы в консоль будет выведено:

```bash
Hello, World!
```
Поздравляем! Вы успешно написали и создали свою первую программу на языке Java!

**Примечание**: для того, чтобы операционной системой распознавались команды Java (java, javac и т.д.), необходимо убедиться в том, что:

+ Установлен JDK.
+ Правильно настроены переменные окружения.

Для этого необходимо использовать компилятор (`javac`) и загрузчик (`java`), предоставляеые вашей JVM. Чтобы узнать, какие версии у вас установлены, введите в командной строке команду `java -version` и `javac -version`. В терминале будет выведен номер версии вашей программы (например, 1.8.0_73).

**Более пристальный взгляд на программу Hello World.**

Программа "Hello World" содержит один файл, в котором определен класс `HelloWorld`, метод `main` и оператор внутри метода `main`.

```java
public class HelloWorld {
```

Определение класса с именем `HelloWorld` начинается с ключевого слова ***class***. Каждое Java-приложение содержит хотя бы одно определение класса.

```java
public static void main(String[] args)
```

Этот метод является точкой входа (отличительный признак - имя `main` и объявление `public static void main(String[]))`, из которой виртуальная машина `JMV` запускает вашу программу. Каждая Java-программа должна содержать такой метод. Здесь:

+ модификатор доступа **`public`**: означает, что метод может быть вызван откуда угодно, в том числе и извне программы.
+ модификатор доступа **`static`**: означает, что он существует и может быть запущен сам по себе (на уровне класса без создания объекта).
+ модификатор доступа **`void`**: означает, что метод не возвращает никакого значения.

_Примечание_: в отличие от метода *`main`* в _С_ и _C++_, где всегда ожидается код возврата - число типа _*int*_ (аналог в _Java_ - _System.exit()_).

Метод `main` принимает следующие аргументы:

+ Массив строк (обычно имеющий имя `args`), передаваемых в качестве аргументов в метод `main` (например, состоящий из аргументов командной строки).
Почти все это требуется в Java для метода точки входа в обязательном порядке.
Необязательные части:
+ Имя `args` - это имя переменной, поэтому её можно называть как угордно, хотя обычно её именуют `args`.
+ Тип параметра - будь то массив строк (`String[] args`) или изменяющийся список аргументов Varargs (`String... args`) - не имеет значения, поскольку массивы можно передавать и в переменную типа Varargs.

**Примечание**: в одном приложении может быть несколько классов, содержащих метод точки входа (`main`). Точка входа в приложение определяется именем класса, переданного в качестве аргумента команде `java`.

Метод main содержит следующий оператор:
```java
    System.out.println("Hello, World!");
```
Давайте разберём этот оператор по элементам:
|**Элемент**|**Назначение**|
|:-----------------------|:--------------------------------------------------------------------------------------------|
|`System`|обозначает, что последующее выражение будет обращаться к классу `System` из пакета `java.lang`.|
|**.**|это оператор точка. Оператор точка предоставляет доступ к членам класса, т.е. к его полям (переменным и методам). В данном случае оператор точка позволяет сослаться на статическое поле `out` внутри класса `System`.|
|`out`|это имя переменной, которая хранит ссылку на объект (сущность) типа `PrintStream`. Этот объект настроен таким образом, чтобы все информация, которая записывается в него, попадала на консоль.|
|**.**|это ещё один оператор точка. Он обеспечивает доступ к методу `prinln` внутри переменной `out`.|
|`println`|это имя метода в классе `PrintStream`. В частности, этот метод выводит в консоль содержимое параметров и встравляет после них новую строку.|
|`(`|это скобка указывает на то, что происходит обращение именно к методу (а не к полю), и обозначает стартовую позицию, после которой распоалагаются параметры, передаваемые в `ptintln`.|
|`"Hello, World!"`|это строковый литерал, который передаётся в качестве параметра в метод `println`. Двойные кавычки по краям указывают на то, что текст является строкой.|
|`)`|эта скобка закрывает список параметров, передаваемых в метод `println`.|
|`;`|эта точка с запяток отмечает конец оператора.|

***Примечание***: каждый оператор в языке _Java_ должен заканчиваться с точкой с запятой (_;_).

После этого тело метода и тело класса ограничиваются закрывающими фигурными скобками

```java
    }   // конец области видимости функции main
}       // конец области видимости класса HelloWorld
```

Приведём ещё один пример, демонстрирующий парадигму ОП (объектного программирования). Давайте смоделируем футбольную команду с одним (да, одним!) игроком. Из может быть больше, но об этом мы поговорим, когда перейдём к массивам.

Сначала определим на класс Team:
```java
public class Team {
    Memeber member;
    public Yeam(Member member) {    // кто входит в эту команду?
        this.member = member;       // в этой команде находится один "игрок"        
    }
}
```

Теперь опишем наш класс `Member`:
```java
класс Member {
    private String name;
    private String typel;
    private int level;  // обратите внимание на тип данных
    private int rank;   // здесь также следует обратить внимание на тип данных

    public Member(String name, String type, int level, int rank) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.rank = rank;
    }
}
```
Почему мы используем слово `private`? Да потому что, например, если кто-то захочет узнать ваше имя, он должен спросить его напрямую, а не лезть к вам в карман, чтобы вытащить у вас карточку социального страхования. Модификатор доступа `private` делает нечто подобное: он не позволяет внешник сущностям получить доступ к вашим переменным. Обращаться к переменным с модификатором доступа `private` можно только с помощью функций-геттеров (см. ниже).

Собрав все это вмест, добавив геттеры и метод `main`, как уже говорилось, мы получим:

```java
class Member {
    private String name;
    private String type;
    private int level;
    private int rank;

    public Member(String name, String type, int level, int rank) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.rank = rank;
    }

    /* давайте определим здесь наши функции геттеры */
    public String getName() { //как вас зовут?
        return this.name;   // моё имя
    }

    public String getType() {   // какой у вас тип?
        return this.type;   // мой тип - ...
    }

    public int getLevel() { // какой у вас уровень?
        return this.level;   // мой уровень
    }
    
    public int getRank() {  // какой у вас ранг?
        return this.rank;   // мой ранг
    }
}
```
Вывод:
```bash
Aurieel
Light
10
1
```

Вы можете запустить этй программу онлайн на сайте `ideone.com`.

И снова метод `main` внутри класса `Test` является точкой входа в нашу программу. Без метода `main` мы не можем указать виртуальной машине Java (JVM), с какого места начинать выполнение программы.

[к оглавлению Глава 1](#глава-1-начало-работы-с-языком-java)