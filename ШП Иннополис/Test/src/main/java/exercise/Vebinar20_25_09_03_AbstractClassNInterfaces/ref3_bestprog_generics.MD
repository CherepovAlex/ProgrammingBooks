# Java. Обобщения (шаблоны). Параметризованные типы. Обобщенные классы

**1. Что такое «обобщение» (шаблон) в языке Java? Что такое параметризованный тип? Особенности применения обобщений**

_Обобщение_ – это механизм построения программного кода для некоторого типа с произвольным именем с целью его 
дальнейшего конвертирования (преобразования) в другой конкретный ссылочный тип. _Реализацию_ конвертирования из 
обобщенного типа в другой (конкретный) осуществляет _компилятор_.

Обобщения могут быть применены к _классам_, _интерфейсам_ или _методам_. Если класс, интерфейс или метод оперирует 
некоторым обобщенным типом `T`, то этот класс (интерфейс, метод) называется **обобщенным**. Тип, который получает 
обобщенный класс в качестве параметра, называется **параметризованным типом**. Имя параметризованного типа можно 
задавать _любым_ (T, Type, TT и т.д.).

**2. Преимущества применения обобщений**

Использование обобщений в языке Java дает следующие _преимущества_:

+ обеспечивается _компактность_ программного кода;
+ благодаря обобщениям все операции приведения типов выполняются _автоматически_ и _неявно_. Повторно используемый код 
обрабатывается более легко и безопасно;
+ обобщения обеспечивают типовую _безопасность типов_ в отличие от использования ссылок на тип _Object_. Как известно, 
в языке Java все классы или интерфейсы являются подклассами класса _Object_. Это значит, что с помощью ссылки на 
класс _Object_ можно оперировать разнотипными объектами. Однако, такой способ не обеспечивает типовой безопасности типов.

**3. Общая форма объявления обобщенного класса и объявление ссылки на обобщенный класс**

Чтобы метод некоторого класса оперировал обобщенным типом _Type_, нужно чтобы класс (интерфейс) был объявлен как 
обобщенный. В языке Java допускается объявление класса для одного или нескольких обобщенных типов. Общая форма класса, 
который использует обобщенные типы, следующая:

```java
class ClassName<Type1, Type2, ..., TypeN> {
    // ...

```

здесь

+ `ClassName` – имя класса;
+ `Type1, Type2, TypeN` – типы, с которыми оперирует класс _ClassName_.

Чаще всего обобщенный класс оперирует с одним типом. В этом случае общая форма класса имеет вид:

```java
class ClassName<Type> {
    // ...
}
```

Общая форма объявления ссылки на обобщенный класс следующая:

```java
ClassName<Type1, Type2, ..., TypeN> VarName = new ClassName<Type1, Type2, ..., Type>(argument_list);
```

где

+ `ClassName` – имя класса;
+ `VarName` – имя ссылки на экземпляр класса, который создается оператором new;
+ `argument_list` – список аргументов, которые получает конструктор класса.

Например, если в программе объявить _класс_, который получает параметром тип `T`

```java
class SomeClass<T> {
  // Объявление переменных с типом T
  T var1, var2, /* ...,*/ varN;

  // Объявление метода, использующего тип T
  public return_type SomeMethod(T param1, T param2, ..., T paramN) {
    // Реализация метода SomeMethod(), использущего тип T
    // ...
  }
}
```

После объявления, использование вышеприведенного класса для типа `Integer` будет следующим

```java
SomeClass<Integer> objInt = new SomeClass<Integer>();
objInt.SomeMethod(arg1, arg2, ..., argN);
```

В вышеприведенном объявлении тип `Integer` является _аргументом типа_.

Создание экземпляра класса для типа `Double` следующее

```java
SomeClass<Double> objDouble = new SomeClass<Double>();
```

Подобным образом обобщенный класс `SomeClass<T>` может использоваться для любых других типов.

**4. Какие типы запрещается использовать в обобщенных классах в качестве параметризованных типов?**

При использовании обобщенных классов параметр типа должен быть только _ссылочного_ типа. При использовании обобщенного 
класса запрещается использовать _базовые_ типы (int, char, double и т.д.) в качестве аргумента типа.

То есть, если задан класс

```java
class SomeClass<T> {
    // ...
}
```

то объявить экземпляр типа `int` или другого базового типа не удастся

```java
SomeClass<int> objInt = new SomeClass<int>(); // Ошибка
```

Вместо типа `int` нужно использовать класс-обертку `Integer`.

Аналогично для других базовых типов нужно использовать классы-обертки: `double` -> `Double`, `float` -> `Float`, 
`boolean` -> `Boolean` и т.д.

**5. Пример обобщенного класса, который реализует метод поиска элемента в двумерной матрице**

Объявляется обобщенный класс `GenericMatrix<Type>`, в котором реализован метод `SearchKey()`, который вычисляет 
количество вхождений заданного элемента `key` в матрице. 

Метод `SearchKey()` получает следующие параметры:

+ `M` – исходная матрица обобщенного типа `Type[][]`, в которой осуществляется поиск ключа `key`;
+ `m, n` – размерность матрицы, количество строк и столбцов соответственно;
+ `key` – ключ (элемент), количество вхождений которого в матрицу M нужно вычислить.

```java
// Обобщенный класс, оперирующий типом Type
class GenericMatrix<Type> {

  // Метод, который осуществляет подсчет количества элементов key в двумерной матрице M.
  public int SearchKey(Type[][] M, int m, int n, Type key) {
    int count = 0;
    for (int i=0; i<m; i++)
      for (int j=0; j<n; j++)
        if (key==M[i][j])
          count++;
    return count;
  }
}

public class TestGeneric<Type> {

  public static void main(String[] args) {
    // Демонстрация использования метода SearchKey в классе GenericMatrix<Type>

    // Объявление внутренних переменных
    int count;

    // Исходная матрица
    Integer[][] MI = {
      { 2, 5, -8 },
      { 3, 1, 5 },
      { 4, 8, 2 },
      { 5, 1, 8 }
    };

    // Создать экземпляр класса GenericMatrix<Type>
    GenericMatrix<Integer> obj = new GenericMatrix<Integer>();

    // Вызвать метод SearchKey() экземпляра
    count = obj.SearchKey(MI, 4, 3, 8);

    // Вывести результат
    System.out.println("count = " + count); // count = 2
  }
}
```

**6. Пример реализации метода, который осуществляет циклический сдвиг в массиве обобщенного типа Type**

В примере реализован класс `GenericClass<Type>`, который содержит следующие методы:

+ `CyclicShift()` – реализует циклический сдвиг в одномерном массиве, элементы которого имеют обобщенный тип `Type`;
+ `Print()` – реализует вывод массива обобщенного типа Type на экран;
+ `main()` – демонстрирует использование класса.

```java
// Класс, в котором есть метод циклического сдвига в массиве обобщенного типа Type
public class GenericClass<Type> {

  // Циклический сдвиг в массиве A на count позиций.
  // Параметры:
  // - A - исходный массив;
  // - count - количество позиций, на которые осуществляется сдвиг;
  // - direction - направление (true - влево, false - вправо).
    // time O(n * n), space O(1)
  public void CyclicShift(Type[] A, int count, boolean direction) {
    Type item;
    int iterations = (int)(count % A.length); // убрать лишние итерации

    if (direction)
    {
      // Сдвиг влево
      for (int i=0; i<iterations; i++)  // Внешний цикл: повторяем iterations раз
      {
        item = A[0];                    // Первый элемент сохраняем
        for (int j=0; j<A.length-1; j++)    
          A[j] = A[j+1];                // сдвигаем все элементы на одну позицию влево
        A[A.length-1] = item;           // Первый элемент помещаем в конец
      }
    }
    else
    {
      // Сдвиг вправо
      for (int i=0; i<iterations; i++)
      {
        item = A[A.length-1];           // Последний элемент сохраняем 
        for (int j=A.length-2; j>=0; j--)
          A[j+1] = A[j];
        A[0] = item;                    // Последний элемент помещаем в начало
      }
    }
  }

  // Метод, который выводит массив обобщенного типа Type с комментарием text.
  public void Print(Type[] A, String text) {
    System.out.println(text);
    for (int i=0; i<A.length; i++) {
      System.out.print(A[i] + " | ");
    }
    System.out.println();
  }

  public static void main(String[] args) {

    // Демонстрация использования метода CyclicShift() в классе TestGeneric<Type>
    // для типа String

    // Исходный массив
    String[] AS = { "1-abc", "2-cde", "3-fgh", "4-jklmn", "5-jprst" };

    // Объявить экземпляр класса TestGeneric<Type>
    GenericClass<String> obj = new GenericClass<String>();

    // Вывести массив AS
    obj.Print(AS, "Array AS. Before: ");

    // Реализовать циклический сдвиг для типа String
    obj.CyclicShift(AS, 3, true); // сдвинуть на 3 позиции влево

    // Вывести снова массив AS
    obj.Print(AS, "Array AS. After:");

    // -------------------------------------
    // Использование метода CyclicShift() для ссылочного типа Double
    Double[] AD = { 1.5, 1.3, 1.1, 0.8, 0.5, 0.2 };
    GenericClass<Double> objD = new GenericClass<Double>();

    objD.Print(AD, "Array AD. Before: ");
    objD.CyclicShift(AD, 2, false); // Сдвинуть на 2 позиции вправо
    objD.Print(AD, "Array AD. After:");

    // Использование метода CyclicShift() для ссылочного типа Interger
    Integer[] AI = { 5, 3, 2, -1, -8, 4, 3, 0, 12 };
    GenericClass<Integer> objI = new GenericClass<Integer>();
    objI.Print(AI, "Array AI. Before:");
    objI.CyclicShift(AI, 6, true); // сдвинуть на 6 позиций влево
    objI.Print(AI, "Array AI. After: ");
  }
}
```

Результат работы программы

```bash
Array AS. Before:
1-abc | 2-cde | 3-fgh | 4-jklmn | 5-jprst |
Array AS. After:
4-jklmn | 5-jprst | 1-abc | 2-cde | 3-fgh |
Array AD. Before:
1.5 | 1.3 | 1.1 | 0.8 | 0.5 | 0.2 |
Array AD. After:
0.5 | 0.2 | 1.5 | 1.3 | 1.1 | 0.8 |
Array AI. Before:
5 | 3 | 2 | -1 | -8 | 4 | 3 | 0 | 12 |
Array AI. After:
3 | 0 | 12 | 5 | 3 | 2 | -1 | -8 | 4 |
```

**7. Пример класса, который получает два параметризованных типа**

Класс может получать несколько типов в качестве параметров. Ниже дается пример класса, который получает два типа 
`T1, T2` в качестве параметров. В классе реализован метод `Print()`, который выводит значение массивов элементов типов
`T1 и T2`.

```java
// Класс, который получает в качестве параметров два типа T1, T2
public class GenericClass<T1, T2> {

  // Метод, который выводит одиночные элементы типов T1, T2
  public void Print(T1 item1, T2 item2, String comment) {
    System.out.println(comment);
    System.out.println("item1 = " + item1);
    System.out.println("item2 = " + item2);
    System.out.println("The type of item1 = " + item1.getClass());
    System.out.println("The type of item2 = " + item2.getClass());
  }

  // Метод, который выводит массивы элементов обобщенных типов T1, T2
  public void Print(T1[] A1, T2[] A2, String comment) {
    System.out.println(comment);

    System.out.print("A1 = { ");
    for (int i=0; i<A1.length; i++)
      System.out.print(A1[i] + " ");
    System.out.println(" }");

    System.out.print("A2 = { ");
    for (int i=0; i<A2.length; i++)
      System.out.print(A2[i] + " ");
    System.out.println(" }");

    System.out.println("The type of array A1 = " + A1.getClass());
    System.out.println("The type of array A2 = " + A2.getClass());
  }

  public static void main(String[] args) {

    // Демонстрация использования класса GenericClass<T1, T2>, который получает два параметра типов
    // 1. Использование метода Print() для одиночных элементов разных типов
    // 1.1. Объявить переменные разных типов
    Integer item1 = 23;
    Double item2 = 2.85;

    // 1.2. Объявить экземпляр obj1
    GenericClass<Integer, Double> obj1 = new GenericClass<Integer, Double>();

    // 1.3. Вызвать метод Print() для одиночных элементов
    obj1.Print(item1, item2, "The values of item1 and item2:");

    // 2. Использование метода Print() для массивов
    // 2.1. Объявить массивы
    Float[] AF = { 3.8f, 2.5f, -1.4f, 2.2f, 0.001f };
    Boolean[] AB = { true, true, false, true, false };

    // 2.2. Объявить экземпляр obj2
    GenericClass<Float, Boolean> obj2 = new GenericClass<Float, Boolean>();

    // 2.3. Вызвать метод Print() для массивов
    obj2.Print(AF, AB, "The values of arrays AF, AB");
  }
}
```

Результат выполнения программы

```bash
The values of item1 and item2:
item1 = 23
item2 = 2.85
The type of item1 = class java.lang.Integer
The type of item2 = class java.lang.Double
The values of arrays AF, AB
A1 = { 3.8 2.5 -1.4   2.2 0.001   }
A2 = { true true false   true false   }
The type of array A1 = class [Ljava.lang.Float;
The type of array A2 = class [Ljava.lang.Boolean;
```
