# Рефлексия кода, reflection

**Рефлексия** (от reflexio - обращение назад) - это механизм исследования данных о программе во время её выполнения. 
Рефлексия в Java осуществляется с помощью `Java Reflection API`, состоящий из классов пакетов `java.lang` и `java.lang.reflect`. 
В информатике рефлексия означает процесс, во время которого программа может отслеживать и модифицировать собственную структуру и поведение во время выполнения.

`Java Reflection API` позволяет получать информацию о конструкторах, методах и полях классов и выполнять следующие операции над полями и методами объекта/класса :
+ определение класса объекта;
+ получение информации о полях, методах, конструкторах и суперклассах;
+ получение информации о модификаторах полей и методов;
+ создание экземпляра класса, имя которого неизвестно до момента выполнения программы;
+ определение и изменение значений свойств объекта/класса;
+ вызов методов объекта/класса.

**Примечание**: _в тексте используется объект/класс. 
При работе с объектом (реализацией класса) можно обращаться к полям и методам класса напрямую, если они доступны (не private). 
При работе с классом можно обращаться к методам класса с использованием `Java Reflection API`. Но класс необходимо получить из объекта._

## Определение свойств класса

В работающем приложении для **получения класса** необходимо использовать метод `forName (String className)`. 
Следующий код демонстрирует возможность создания класса без использования и с использованием Reflection:

```java
// Без использования Reflection
Foo foo = new Foo();
 
// С использованием Reflection
Class foo = Class.forName("Foo");

// Загрузка JDBC-драйвера 
Class.forName("com.mysql.jdbc.Driver");
```

Метод класса `forName(className)` часто используется для загрузки JDBC-драйвера.

Методом `getName()` объекта `Class` можно получить **наименование** класса, включающего пакет (`package`):

```java
Class aclass = foo.getClass();         // получение объекта класс
System.out.println (aclass.getName()); // получение наименования класса
```

Для получения значения **модификатора** класса используется метод `getModifiers()`.

Класс `java.lang.reflect.Modifier` содержит статические методы, возвращающие логическое значения проверки модификатора класса: 

```java
Class cls = foo.getClass();     // получение объекта класс
int mods = cls.getModifiers();  // получения значения модификатора класса
if (Modifier.isPublic  (mods))	{ System.out.println("public");  }
if (Modifier.isAbstract(mods))	{ System.out.println("abstract");}
if (Modifier.isFinal   (mods))	{ System.out.println("final");   }
```

Для получения **суперкласса** рефлексированного объекта (класса) необходимо использовать метод getSuperclass() :

```java
Class cls = foo.getClass();  // получение объекта класс
Class superCls = cls.getSuperClass(); // // получение объекта суперкласс
```

Поскольку в Java отсутствует множественное наследование, то для получения **всех предков** следует рекурсивно вызвать метод `getSuperclass()` в цикле, пока не будет достигнут `Object`, являющийся родителем всех классов. 
`Object` не имеет родителей, поэтому вызов его метода `getSuperclass()` вернет `null`.

## Определение интерфейсов и конструкторов класса

Для получения в режиме run-time списка реализующих классом **интерфейсов**, необходимо получить `Class` и использовать его метод `getInterfaces()`. 
В следующем примере извлекается **список** интерфейсов класса `ArrayList`:

```java
Class<?> cls = ArrayList.class;       // Получение объекта Class для типа ArrayList
Class<?>[] ifs = cls.getInterfaces(); // Получение массива всех интерфейсов, реализуемых ArrayList

System.out.println("List of interfaces\n"); 
for(Class<?> ifc : ifs) { 
    System.out.println (ifc.getName()); // получение полных имен интерфейсов
}
```

Чтобы IDE (Eclipse) не предупреждала о необходимости определения типа класса

_Class is a raw type. References to generic type Class<T> should be parameterized_

в коде были использованы generic'и. В консоль выводятся следующие интерфейсы, реализуемые классом ArrayList :

```java
List of interfaces

java.util.List
java.util.RandomAccess
java.lang.Cloneable
java.io.Serializable
```

Метод класса `getConstructors()` позволяет получить массив открытых конструкторов типа `java.lang.reflect.Constructor`. 
После этого, можно извлекать информацию о типах параметров конструктора и генерируемых исключениях :

```java
Class<?> cls = obj.getClass();                      // получение объекта класс
Constructor[] constructors = cls.getConstructors(); // получение массива открытых конструкторов
for (Constructor constructor : constructors) { 
    Class<?>[] params = constructor.getParameterTypes(); // получение информации о типах параметров конструктора и генерируемых исключениях
    for (Class<?> param : params) { 
        System.out.println(param.getName());            // вывод наименований параметров и исключений
    } 
} 
```

## Определение полей класса

Метод `getFields()` объекта `Class` возвращает массив открытых полей типа `java.lang.reflect.Field`, которые могут быть определены не только в данном классе, но также и в его родителях (суперклассе), либо интерфейсах, реализованных классом или его родителями. 
Класс `Field` позволяет получить имя поля, тип и модификаторы:

```java
Class<?> cls = obj.getClass();      // получение объекта класс
Field[] fields = cls.getFields();   //  получение массива открытых полей 
for (Field field : fields) {        // итерация по каждому полю в массиве
    Class<?> fld = field.getType(); // возвращает Class объект, представляющий тип поля
    System.out.println("Class name : " + field.getName()); // возвращает имя поля
    System.out.println("Class type : " + fld.getName()); 
}
```

Если известно наименование поля, то можно получить о нем информацию с помощью метода `getField()` объекта `Class`.

```java
Class<?> cls = obj.getClass();          // получение объекта класс
Field fld = cls.getField("fieldName");  // получение поля по имения 
```

Методы `getField()` и `getFields()` возвращают только **открытые** члены данных класса. 
Чтобы получить все поля класса, включая закрытые и защищенные, необходимо использовать методы **getDeclaredField()** и **getDeclaredFields()**. 
Данные методы работают точно так же, как и их аналоги **getField()** и **getFields()**.

## Определение значений полей класса

Класс `Field` содержит специализированные методы для получения значений примитивных типов: `getInt()`, `getFloat()`, `getByte()` и др. 
Для установки значения поля, используется метод `set()`. 
Для примитивных типов имеются методы `setInt()`, `setFloat()`, `setByte()` и др.

```java
Class<?> cls = obj.getClass();           // получение объекта класс
Field field = cls.getField("fieldName"); // получение поля по имения 

String value = (String) field.get(obj);  // Метод get() возвращает значение поля для указанного объекта obj
field.set(obj, "New value");             // Метод set() устанавливает новое значение поля для объекта obj
```

## Определение методов класса

Метод `getMethods()` объекта `Class` возвращает **массив открытых методов** типа `java.lang.reflect.Method`. 
Эти методы могут быть определены не только в классе, но также и в его родителях (суперклассе), либо интерфейсах, реализованных классом или его родителями. 
Класс `Method` позволяет получить _имя метода_, _тип возвращаемого им значения_, _типы параметров метода_, _модификаторы_ и генерируемые _исключения_.

```java
Class<?> cls = obj.getClass();          // получение объекта класс
Method[] methods = cls.getMethods();    // получение массива открытых методов
for (Method method : methods) { 
    System.out.println("Method name : " + method.getName()); // получение имени метода
    System.out.println("Return type : " + method.getReturnType().getName()); // получение типа и имени возвращаемого им значения
 
    Class<?>[] params = method.getParameterTypes();   // получение типов параметров метода
    System.out.print("Parameters : ");
    for (Class<?> paramType : params) { 
        System.out.print(" " + paramType.getName()); //  наименования параметров метода
    } 
    System.out.println(); 
} 
```

Если известно имя метода и типы его параметров, то можно получить отдельный метод класса:

```java
Class<?> cls = obj.getClass();                               // получение объекта класс
Class[] params = new Class[] {Integer.class, String.class};  // создание массива с типами параметров метода
// Создается массив Class объектов, указывающих типы параметров метода:- первый параметр: Integer, - второй параметр: String
Method method = cls.getMethod("methodName", params);         // получение конкретного метода по имени и типам параметров: ищет public метод с именем "methodName",
                                                             // который принимает параметры: Integer и String (в указанном порядке), поиск включает унаследованные методы
```                                     

## Пример изменения значения закрытого поля класса

Чтобы изменить значение закрытого (_private_) поля класса необходимо получить это поле методом `getDeclaredField()` и вызвать метод `setAccessible(true)` объекта `Field`, чтобы открыть доступ к полю. 
После этого значение закрытого поля можно изменять, если оно не `final`. 
В следующем примере определен внутренний класс `PrivateFinalFields` с набором закрытых полей; одно из полей `final`. 
При создании объекта класса поля инициализируются. 
В методе `main` примера поочередно в закрытые поля вносятся изменения и свойства объекта выводятся в консоль.

```java
import java.lang.reflect.Field; 
 
class PrivateFinalFields { 
    private       int    i  = 1; 
    private final String s  = "String S"; 
    private       String s2 = "String S2"; 
 
    public String toString() { 
        return "i = " + i + ", " + s + ", " + s2; 
    } 
} 
 
public class ModifyngPrivateFields 
{
    public static void main(String[] args) throws Exception {
        PrivateFinalFields pf = new PrivateFinalFields(); 
        // Изменение private поля i (не-final)
        Field f = pf.getClass().getDeclaredField("i"); // получение объекта класс, затем все, в том числе приватные, поля
        f.setAccessible(true);                         // Разрешаем доступ к private полю
        f.setInt(pf, 47);                              // Устанавливаем новое значение 47 для поля i
        System.out.println("1. " + pf); 
        // Попытка изменения private final поля s
        f = pf.getClass().getDeclaredField("s");        // получение объекта класс, затем все, в том числе приватные, поля 
        f.setAccessible(true);                          // Разрешаем доступ к private полю 
        f.set(pf, "MODIFY S");                          // Устанавливаем новое значение для final поля s
        System.out.println("2. " + pf);                 // Вывод зависит от версии Java (может не измениться)
        // Изменение private поля s2 (не-final)
        f = pf.getClass().getDeclaredField("s2");       // получение объекта класс, затем все, в том числе приватные, поля 
        f.setAccessible(true);                          // Разрешаем доступ к private полю 
        f.set(pf, "MODIFY S2");                         // Устанавливаем новое значение для поля s2
        // Повторное изменение поля i
        f = pf.getClass().getDeclaredField("i");        // получение объекта класс, затем все, в том числе приватные, поля 
        f.setAccessible(true);                          // Разрешаем доступ к private полю 
        f.setInt(pf, 35);                               // устанавливаем значение 35 для поля i
        System.out.println("3. " + pf);                 // Вывод: i = 35, MODIFY S, MODIFY S2
    }
}
```

В результате выполнения примера в консоль будут выведены следующие сообщения:

```bash
1. i = 47, String S, String S2
2. i = 47, String S, String S2
3. i = 35, String S, MODIFY S2
```

Из приведённого примера видно, что поля `private` можно изменять. 
Для этого необходимо получить объект типа `java.lang.reflect.Field` с помощью метода `getDeclaredField()`, вызвать его метод `setAccessible(true)` и с помощью метода `set()` установить требуемое значение поля. 
Необходимо иметь в виду, что наличие модификатора `final` в закрытом текстовом поле не вызывает исключений при изменении значений, а само значение поля остаётся прежним, т.е. `final` поля остаются неизменные. 
Если не вызвать метод открытия доступа к полю `setAccessible(true)`, то будет вызвано исключение `java.lang.IllegalAccessException`.

## Пример вызова метода, invoke

`Java Reflection Api` позволяет вызвать метод класса. 
Рассмотрим пример, в котором определим класс `Reflect`, включающий поля и методы управления ими. 
В режиме run-time с помощью метода данного класса будем изменять значения полей и распечатывать их.

### Листинг класса Reflect

Класс `Reflect` включает два закрытых поля (_id, name_) и методы управления их значениями _set/get_. 
Дополнительно в класс включим метод _setData_, который будем вызывать для изменения значений полей, и метод _toString_ для печати их значений.

```java
class Reflect
{
    private String name;
    private int    id;

    Reflect() {
        name = "Test";
        id   = 999;
    }
    public int getId() {return id;}
    
    public void setId(int id) {this.id = id;}

    String getName() {return name;}
    
    public void setName(String name) {this.name = name;}

    public void setData(final int id, String name) {
        this.id   = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Reflect [ id : " + id + ", name : " + name + "]";
    }
}
```

Для тестирования объекта типа `Reflect` с помощью `Java Reflection Api` создадим класс `ReflectionTest`. 
В этот класс включим две процедуры `getClassFields` и `getClassMethods`, которые в режиме run-time распечатают всю информацию (описание полей и методов) о классе. 
Методы получают класс в качестве параметра. 
В процедурах сначала определяются массивы полей и методы; после этого их параметры распечатываются:

```java
// получает ВСЕ поля класса (включая private, protected): Имя поля, Тип данных поля 
private void getClassFields(Class<?> cls) {
    Field[] fields = cls.getDeclaredFields(); // Получение всех полей класса (включая private, protected, package-private)
    System.out.println("Class fields"); 
    for (Field field : fields) { 
        Class<?> fld = field.getType(); // Получение типа поля
        System.out.println("Class name : " + field.getName()); // Вывод имени поля
        System.out.println("Class type : " + fld.getName());   // Вывод типа поля
    }
}
// получение всех методов класса (включая private)
private void getClassMethods(Class<?> cls) {
    Method[] methods = cls.getDeclaredMethods(); 
    System.out.println("Class methods"); 
    for (Method method : methods) { 
        System.out.println("Method name : " + method.getName()); // Вывод имени метода
        System.out.println("Return type : " + method.getReturnType().getName()); //  Вывод наименования возвращаемого типа
        Class<?>[] params = method.getParameterTypes();     // Получение типов параметров метода
        System.out.print("Parameters : "); 
        for (Class<?> param : params)
            System.out.print(" " + param.getName());    // Вывод наименования параметров метода
        System.out.println(); 
    }
}
```

В конструкторе класса `ReflectionTest` сначала вызываются процедуры определения _полей_ и _методов_ объекта/класса `Reflect`. 
После этого вызываются _методы_ изменения значений и печати значений с использованием `Reflection API`. 
Для определения метода `setData` используется _массив_ типов параметров. 
Вызов метода `setData` выполняется с передачей ему массива новых значений.

```java
public class ReflectionTest 
{
    static Reflect reflect;
    public ReflectionTest() {
        getClassFields (reflect.getClass()); // получение объекта класс -> получение всех полей класса
        getClassMethods(reflect.getClass()); // получение объекта класс -> получение всех методов класса

        Class<?> cls = reflect.getClass(); // получение объекта класс
        try {
            // Вызов метода toString()
            System.out.println("\n1. invoke method toString()\n");

            Method method = cls.getMethod("toString");  // получение конкретного метода по имени: ищет public метод с именем "toString",
            System.out.println(method.invoke(reflect)); // Вызов toString()
            
            // Вызов метода setData() с параметрами
            Class<?>[] paramTypes;
            Object  [] args;
            paramTypes = new Class[] {int.class, String.class}; // создание массива с типами параметров метода
            method = cls.getMethod("setData", paramTypes);      // получение конкретного метода по имени и типам параметров: ищет public метод с именем "setData",

            args = new Object[]{(int)123,new String("New value")};
            method.invoke(reflect, args);                       // Вызов setData(123, "New value")
            
            // Повторный вызов toString() для проверки изменений
            System.out.println("\n2. invoke method toString()\n");
            method = cls.getMethod("toString");                 // получение конкретного метода по имени toString
            System.out.println(method.invoke(reflect));         // Вызов toString

        } catch (NoSuchMethodException e) {
        } catch (SecurityException e) {
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e) {
        } catch (InvocationTargetException e) {
        } 
    }
    // получение всех полей класса (включая private, protected): Имя поля, Тип данных поля 
    private void getClassFields(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields(); // Получение всех полей класса (включая private, protected, package-private)
        System.out.println("Class fields"); 
        for (Field field : fields) { 
            Class<?> fld = field.getType(); // Получение типа поля
            System.out.println("Class name : " + field.getName()); // Вывод имени поля
            System.out.println("Class type : " + fld.getName());   // Вывод типа поля
        }
    }
    // получение всех методов класса (включая private)
    private void getClassMethods(Class<?> cls) {
        Method[] methods = cls.getDeclaredMethods(); 
        System.out.println("Class methods"); 
        for (Method method : methods) { 
            System.out.println("Method name : " + method.getName()); // Вывод имени метода
            System.out.println("Return type : " + method.getReturnType().getName()); //  Вывод наименования возвращаемого типа
            Class<?>[] params = method.getParameterTypes();     // Получение типов параметров метода
            System.out.print("Parameters : "); 
            for (Class<?> param : params)
                System.out.print(" " + param.getName());    // Вывод наименования параметров метода
            System.out.println(); 
        }
    }

    public static void main(String[] args){
        reflect = new Reflect();
        new ReflectionTest();
        System.exit(0);
    }
}
```

В результате выполнения примера в консоль будут выведены представленные ниже сообщения. Методы setData и toString(), вызываемые с помощью Java Reflection API, вносят измнения в закрытые поля класса и распечатываются их значения.


```bash
Class fields

Class name : name
Class type : java.lang.String
Class name : id
Class type : int

Class methods

Method name : toString
Return type : java.lang.String
Parameters  : 

Method name : getId
Return type : int
Parameters  :

Method name : setId
Return type : void
Parameters :  int

Method name : getName
Return type : java.lang.String
Parameters  : 

Method name : setName
Return type : void
Parameters :  java.lang.String

Method name : setData
Return type : void
Parameters :  int java.lang.String

1. invoke method toString()

Reflect [ id : 999, name : Test]

2. invoke method toString()

Reflect [ id : 123, name : New value]
```