# Использование отражения Java

Автор : Глен Маккласки

**Рефлексия** — это функция языка программирования Java. 
Она позволяет исполняющейся Java-программе анализировать или «рефлексировать» саму себя и управлять внутренними свойствами программы. 
Например, класс Java может получить имена всех своих членов и вывести их на экран.

Возможность изучать класс Java и управлять им изнутри может показаться не такой уж важной, но в других языках программирования такой функции просто нет. 
Например, в программах на Pascal, C или C++ невозможно получить информацию о функциях, определённых в этой программе.

Одно из наглядных применений рефлексии — `JavaBeans`, где программными компонентами можно управлять визуально с помощью инструмента-конструктора. 
Этот инструмент использует рефлексию для получения свойств Java-компонентов (классов) при их динамической загрузке.

## Простой пример

Чтобы понять, как работает рефлексия, рассмотрим простой пример:

```java
import java.lang.reflect.*;
 
   public class DumpMethods {
      public static void main(String args[])
      {
         try {
            Class c = Class.forName(args[0]);   // загружает указанный класс
            Method m[] = c.getDeclaredMethods();    // для получения списка методов
            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());
         }
         catch (Throwable e) {
            System.err.println(e);
         }
      }
   }
```

Для вызова

`java DumpMethods java.util.Stack `

результатом является:

```bash
public java.lang.Object java.util.Stack.push(
    java.lang.Object)
   public synchronized 
     java.lang.Object java.util.Stack.pop()
   public synchronized
      java.lang.Object java.util.Stack.peek()
   public boolean java.util.Stack.empty()
   public synchronized 
     int java.util.Stack.search(java.lang.Object)
```

То есть перечислены **имена методов** класса `java.util.Stack` вместе с их полными типами параметров и возвращаемых значений.

Эта программа загружает указанный класс с помощью `class.forName`, а затем вызывает `getDeclaredMethods` для получения списка методов, определённых в классе. 
`java.lang.reflect.Method` — это класс, представляющий один метод класса.

## Настройка на использование отражения

Классы рефлексии, такие как `Method`, находятся в пакете `java.lang.reflect`. 
Чтобы использовать эти классы, необходимо выполнить три шага. 
**Первый шаг** — получить `java.lang.Class`-объект для класса, которым вы хотите управлять. 
`java.lang.Class` используется для представления классов и интерфейсов в работающей программе на Java.

Один из способов получить объект `Class` — сказать:

`Class c = Class.forName("java.lang.String");`

чтобы получить объект `Class` для `String`. Другой способ — использовать:

`Class c = int.class;`

или

`Class c = Integer.TYPE;`

для получения информации о классе фундаментальных типов. 
При использовании второго подхода осуществляется доступ к предопределённому `TYPE` полю оболочки (например, `Integer`) для фундаментального типа.

**Второй шаг* — вызов такого метода, как `getDeclaredMethods`, для получения списка всех методов, объявленных в классе.

Когда эта информация будет у вас на руках, **третьим шагом** будет использование API отражения для работы с информацией. Например, последовательность:

```java
Class c = Class.forName("java.lang.String");    
Method m[] = c.getDeclaredMethods();    
System.out.println(m[0].toString());
```

отобразится текстовое представление первого метода, объявленного в `String`.

В приведённых ниже примерах три шага объединены в самодостаточные иллюстрации того, как решать конкретные задачи с помощью рефлексии.

## Моделирование `instanceof` оператора

После получения информации о классе часто возникает необходимость задать базовые вопросы об объекте класса. 
Например, метод `Class.isInstance` можно использовать для имитации оператора `instanceof`:

```java


class A {}

   public class instance1 {
      public static void main(String args[])
      {
         try {
            Class cls = Class.forName("A");
            boolean b1 = cls.isInstance(new Integer(37));
            System.out.println(b1);`    // false
            boolean b2 = cls.isInstance(new A());
            System.out.println(b2);     // true
         }
         catch (Throwable e) {
            System.err.println(e);
         }
      }
   }
   ```

В этом примере создаётся объект `Class` для `A`, а затем проверяются объекты-экземпляры класса на предмет того, являются ли они экземплярами `A`. 
`Integer(37)` не является экземпляром, а `new A()` является.

## Знакомство с методами класса

Одно из самых ценных и базовых применений рефлексии — определение того, какие методы определены в классе. Для этого можно использовать следующий код:

```java
import java.lang.reflect.*;

   public class method1 {
      private int f1(Object p, int x) throws NullPointerException {
         if (p == null)
            throw new NullPointerException();
         return x;
      }
        
      public static void main(String args[]) {
         try {
           Class cls = Class.forName("method1");
        
            Method methlist[] = cls.getDeclaredMethods();
            for (int i = 0; i < methlist.length; i++) {  
               Method m = methlist[i];
               System.out.println("name = " + m.getName());
               System.out.println("decl class = " + m.getDeclaringClass());
               Class pvec[] = m.getParameterTypes();
               for (int j = 0; j < pvec.length; j++)
                  System.out.println(" param #" + j + " " + pvec[j]);
               Class evec[] = m.getExceptionTypes();
               for (int j = 0; j < evec.length; j++)
                  System.out.println("exc #" + j + " " + evec[j]);
               System.out.println("return type = " + m.getReturnType());
               System.out.println("-----");
            }
         }
         catch (Throwable e) {
            System.err.println(e);
         }
      }
   }
```

Сначала программа получает описание класса для `method1`, а затем вызывает `getDeclaredMethods`, чтобы получить список объектов `Method`, по одному для каждого метода, определённого в классе. 
Сюда входят открытые, защищённые, пакетные и закрытые методы. 
Если в программе вместо `getMethods` используется `getDeclaredMethods`, можно также получить информацию о наследуемых методах.

После получения списка объектов `Method` остаётся только отобразить информацию о типах параметров, типах исключений и типе возвращаемого значения для каждого метода. 
Каждый из этих типов, будь то фундаментальные типы или типы классов, в свою очередь, представлен дескриптором класса.

Результат работы программы:

```bash
name = f1
   decl class = class method1
   param #0 class java.lang.Object
   param #1 int
   exc #0 class java.lang.NullPointerException
   return type = int
   -----
   name = main
   decl class = class method1
   param #0 class [Ljava.lang.String;
   return type = void
   -----
```

## Получение информации о конструкторах

Аналогичный подход используется для получения информации о конструкторах класса. Например:

```java
import java.lang.reflect.*;
        
   public class constructor1 {
      public constructor1() {}
        
      protected constructor1(int i, double d) {}
        
      public static void main(String args[])
      {
         try {
           Class cls = Class.forName("constructor1");
           Constructor ctorlist[] = cls.getDeclaredConstructors();
           for (int i = 0; i < ctorlist.length; i++) {
               Constructor ct = ctorlist[i];
               System.out.println("name = " + ct.getName());
               System.out.println("decl class = " + ct.getDeclaringClass());
               Class pvec[] = ct.getParameterTypes();
               for (int j = 0; j < pvec.length; j++)
                  System.out.println("param #" + j + " " + pvec[j]);
               Class evec[] = ct.getExceptionTypes();
               for (int j = 0; j < evec.length; j++)
                  System.out.println("exc #" + j + " " + evec[j]);
               System.out.println("-----");
            }
          }
          catch (Throwable e) {
             System.err.println(e);
          }
      }
   }
```

В этом примере не извлекается информация о типе возвращаемого значения, поскольку у конструкторов нет настоящего типа возвращаемого значения.

При запуске этой программы выводится следующее:

```java
name = constructor1
   decl class = class constructor1
   -----
   name = constructor1
   decl class = class constructor1
   param #0 int
   param #1 double
   -----
```

## Информация о полях класса

Также можно узнать, какие поля данных определены в классе. Для этого можно использовать следующий код:

```java
import java.lang.reflect.*;
        
   public class field1 {
      private double d;
      public static final int i = 37;
      String s = "testing";
        
      public static void main(String args[]) {
         try {
            Class cls = Class.forName("field1");
        
            Field fieldlist[] = cls.getDeclaredFields();
            for (int i = 0; i < fieldlist.length; i++) {
               Field fld = fieldlist[i];
               System.out.println("name = " + fld.getName());
               System.out.println("decl class = " + fld.getDeclaringClass());
               System.out.println("type = " + fld.getType());
               int mod = fld.getModifiers();
               System.out.println("modifiers = " + Modifier.toString(mod));
               System.out.println("-----");
            }
          }
          catch (Throwable e) {
             System.err.println(e);
          }
       }
   }
```

Этот пример похож на предыдущие. Новым является использование `Modifier`. 
Это класс отражения, который представляет модификаторы, используемые для элементов полей, например "private int". 
Сами модификаторы представлены целым числом, а `Modifier.toString` используется для возврата строкового представления в «официальном» порядке объявления (например, "static" перед "final"). 
Результат работы программы:

```java
name = d
   decl class = class field1
   type = double
   modifiers = private
   -----
   name = i
   decl class = class field1
   type = int
   modifiers = public static final
   -----
   name = s
   decl class = class field1
   type = class java.lang.String
   modifiers =
   -----
```

Как и в случае с методами, можно получить информацию только о полях, объявленных в классе (`getDeclaredFields`), или также получить информацию о полях, определённых в суперклассах (`getFields`).

## Вызов методов по имени

Все приведённые примеры связаны с получением информации о классе. 
Но рефлексию можно использовать и другими способами, например для вызова метода с заданным именем.

Чтобы понять, как это работает, рассмотрим следующий пример:

```java
import java.lang.reflect.*;
        
   public class method2 {
      public int add(int a, int b) {
         return a + b;
      }
        
      public static void main(String args[])
      {
         try {
           Class cls = Class.forName("method2");
           Class partypes[] = new Class[2];
            partypes[0] = Integer.TYPE;
            partypes[1] = Integer.TYPE;
            Method meth = cls.getMethod("add", partypes); // поиск в классе метода с двумя целочисленными параметрами и соответствующим именем
            
            method2 methobj = new method2();
            
            Object arglist[] = new Object[2];
            arglist[0] = new Integer(37);
            arglist[1] = new Integer(47);
            
            Object retobj = meth.invoke(methobj, arglist); // он вызывается для экземпляра объекта соответствующего типа.
            Integer retval = (Integer)retobj;
            System.out.println(retval.intValue());
         }
         catch (Throwable e) {
            System.err.println(e);
         }
      }
   }
```

Предположим, что программа хочет вызвать метод `add`, но не знает, какой именно, до момента выполнения. 
То есть имя метода указывается во время выполнения (например, это может делать среда разработки `JavaBeans`). 
В приведённой выше программе показан способ сделать это.

`getMethod` Используется для поиска в классе метода с двумя целочисленными параметрами и соответствующим именем. 
После того как этот метод найден и помещён в `Method`-объект, он вызывается для экземпляра объекта соответствующего типа. 
Для вызова метода необходимо составить список параметров, в котором основные целочисленные значения 37 и 47 заключены в Integer-объекты. 
Возвращаемое значение (84) также заключено в Integer-объект.

## Создание новых объектов

Для конструкторов не существует эквивалента вызова метода, потому что вызов конструктора эквивалентен созданию нового объекта (если быть точным, создание нового объекта включает в себя как выделение памяти, так и конструирование объекта). 
Таким образом, ближайшим эквивалентом предыдущего примера будет следующее выражение:

```java
import java.lang.reflect.*;
        
   public class constructor2 {
      public constructor2() {}
        
      public constructor2(int a, int b) {
         System.out.println("a = " + a + " b = " + b);
      }
        
      public static void main(String args[]) {
         try {
           Class cls = Class.forName("constructor2");
           Class partypes[] = new Class[2];
            partypes[0] = Integer.TYPE;
            partypes[1] = Integer.TYPE;
            Constructor ct = cls.getConstructor(partypes);
            
            Object arglist[] = new Object[2];
            arglist[0] = new Integer(37);
            arglist[1] = new Integer(47);
            
            Object retobj = ct.newInstance(arglist);
         }
         catch (Throwable e) {
            System.err.println(e);
         }
      }
   }
```

Он находит конструктор, который обрабатывает указанные типы параметров, и вызывает его для создания нового экземпляра объекта. 
Преимущество такого подхода в том, что он полностью динамический: поиск и вызов конструктора происходят во время выполнения, а не во время компиляции.

## Изменение значений полей

Ещё одно применение рефлексии — изменение значений полей данных в объектах. 
Ценность этого подхода заключается в динамической природе рефлексии, которая позволяет найти поле по имени в исполняемой программе и затем изменить его значение. 
Это иллюстрируется следующим примером:

```java
import java.lang.reflect.*;
        
   public class field2 {
      public double d;
        
      public static void main(String args[]) {
         try {
            Class cls = Class.forName("field2");
            Field fld = cls.getField("d");
            field2 f2obj = new field2();
            System.out.println("d = " + f2obj.d);
            
            fld.setDouble(f2obj, 12.34);
            System.out.println("d = " + f2obj.d);
         }
         catch (Throwable e) {
            System.err.println(e);
         }
      }
   }
```

В этом примере значение поля `d` равно `12,34`.

## Использование Массивов

Ещё одно применение рефлексии — создание массивов и управление ими. 
Массивы в языке Java — это специализированный тип класса, и ссылку на массив можно присвоить ссылке `Object`.

Чтобы понять, как работают массивы, рассмотрим следующий пример:

```java
import java.lang.reflect.*;
        
   public class array1 {
      public static void main(String args[])
      {
         try {
            Class cls = Class.forName("java.lang.String");
            Object arr = Array.newInstance(cls, 10);
            Array.set(arr, 5, "this is a test");
            String s = (String)Array.get(arr, 5);
            System.out.println(s);
         }
         catch (Throwable e) {
            System.err.println(e);
         }
      }
   }
```

В этом примере создаётся массив строк длиной `10`, а затем в массив по индексу `5` записывается строковое значение. Значение извлекается и отображается.

Более сложная манипуляция с массивами показана в следующем коде:

```java
import java.lang.reflect.*;
        
   public class array2 {
      public static void main(String args[])
      {
         int dims[] = new int[]{5, 10, 15};
         Object arr = Array.newInstance(Integer.TYPE, dims);
        
         Object arrobj = Array.get(arr, 3);
         Class cls = arrobj.getClass().getComponentType();
         System.out.println(cls);
         arrobj = Array.get(arrobj, 5);
         Array.setInt(arrobj, 10, 37);
        
         int arrcast[][][] = (int[][][])arr;
         System.out.println(arrcast[3][5][10]);
      }
   }
```

В этом примере создаётся массив целых чисел размером `5 x 10 x 15`, а затем в ячейку [3][5][10] массива записывается значение 37. 
Обратите внимание, что многомерный массив на самом деле является массивом массивов, поэтому, например, после первого вызова `Array.get` результатом в `arrobj` будет массив размером `10 x 15`. 
Это значение снова отбрасывается, чтобы получить массив длиной `15`, и `10-й` элемент этого массива устанавливается с помощью `Array.setInt.`

Обратите внимание, что создаваемый массив является динамическим и его тип не нужно указывать во время компиляции.

# Краткие сведения

Рефлексия в Java полезна тем, что поддерживает динамический поиск информации о классах и структурах данных по имени и позволяет манипулировать ими в рамках исполняющейся программы на Java. 
Эта функция чрезвычайно мощная и не имеет аналогов в других распространённых языках, таких как C, C++, Fortran или Pascal.

Глен МакКласки занимается языками программирования с 1988 года. Он консультирует по вопросам производительности Java и C++, тестирования и технической документации.











