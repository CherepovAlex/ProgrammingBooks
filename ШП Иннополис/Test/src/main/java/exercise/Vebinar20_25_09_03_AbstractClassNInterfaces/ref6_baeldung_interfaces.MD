# Интерфейсы Java

## 1. Общий обзор

В этом уроке мы поговорим об _интерфейсах_ в Java. Мы также рассмотрим, как Java использует их для реализации 
полиморфизма и множественного наследования.

## 2. Что такое интерфейсы в Java?

В Java _интерфейс_ — это абстрактный тип, содержащий набор методов и константных переменных. Это одно из основных 
понятий в Java, которое **используется для достижения абстракции**, **полиморфизма** и **множественного наследования**.

Давайте рассмотрим простой пример интерфейса на Java:

```java
public interface Electronic {

    // Constant variable
    String LED = "LED";

    // Abstract method
    int getElectricityUse();

    // Static method
    static boolean isEnergyEfficient(String electtronicType) {
        if (electtronicType.equals(LED)) {
            return true;
        }
        return false;
    }

    //Default method
    default void printDescription() {
        System.out.println("Electronic Description");
    }
}
```

Мы можем реализовать интерфейс в классе Java с помощью ключевого слова `implements`.

Далее давайте создадим класс `Computer`, который реализует только что созданный нами интерфейс `Electronic`:

```java
public class Computer implements Electronic {

    @Override
    public int getElectricityUse() {
        return 1000;
    }
}
```

### 2.1. Правила создания интерфейсов

В интерфейсе мы можем использовать:
+ **константы переменные**
+ **абстрактные методы**
+ **статические методы**
+ **методы по умолчанию**

Мы также должны помнить, что:

+ мы не можем создавать экземпляры интерфейсов напрямую
+ интерфейс может быть пустым, без методов и переменных
+ мы не можем использовать ключевое слово `final` в определении интерфейса, так как это приведёт к ошибке компилятора
+ все объявления интерфейса должны иметь модификатор доступа `public` или по умолчанию; модификатор `abstract` будет 
добавлен компилятором автоматически
+ метод интерфейса не может быть _protected_ или _final_
+ До Java 9 методы интерфейса не могли быть _private_; однако в Java 9 появилась возможность определять private 
методы в интерфейсах
+ Переменные интерфейса по определению являются public, static и final ; мы не можем изменить их видимость

## 3. Чего мы можем добиться с их помощью?

### 3.1. Поведенческая функциональность

Мы используем интерфейсы для добавления определённых поведенческих функций, которые могут использоваться несвязанными 
классами. Например, `Comparable`, `Comparator` и `Cloneable` — это интерфейсы Java, которые могут быть реализованы 
несвязанными классами. Ниже приведён пример интерфейса `Comparator`, который используется для сравнения двух 
экземпляров класса `Employee`:

```java
public class Employee {

    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class EmployeeSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employeeA, Employee employeeB) {
        if (employeeA.getSalary() < employeeB.getSalary()) {
            return -1;
        } else if (employeeA.getSalary() > employeeB.getSalary()) { 
            return 1;
        } else {
            return 0;
        }
    }
}
```

Для получения дополнительной информации ознакомьтесь с нашим руководством по `Comparator` и `Comparable` в Java.

### 3.2. Множественное наследование

Классы Java поддерживают _одиночное наследование_. Однако с помощью интерфейсов мы можем реализовать _множественное 
наследование_.

Например, в приведённом ниже примере мы видим, что `Car`  реализует интерфейсы `Fly` и `Transform`. Таким образом, он 
наследует методы `fly` и `transform`:

```java
public interface Transform {
    void transform();
}

public interface Fly {
    void fly();
}

public class Car implements Fly, Transform {

    @Override
    public void fly() {
        System.out.println("I can Fly!!");
    }

    @Override
    public void transform() {
        System.out.println("I can Transform!!");
    }
}
```

### 3.3. Полиморфизм

Давайте начнём с вопроса: что такое **полиморфизм**? Это способность объекта принимать различные формы во время выполнения 
программы. Если говорить более конкретно, то это _выполнение_ переопределённого метода, связанного с конкретным типом 
объекта, во время выполнения программы.

**В Java мы можем добиться полиморфизма с помощью интерфейсов**. Например, интерфейс `Shape` может принимать различные формы 
— это может быть `круг` или `квадрат`

Давайте начнём с определения интерфейса `Shape`:

```java
public interface Shape {
    String name();
}
```

Теперь давайте создадим класс `Circle`:

```java
public class Circle implements Shape {

    @Override
    public String name() {
        return "Circle";
    }
}
```

А также класс Square :

```java
public class Square implements Shape {

    @Override
    public String name() {
        return "Square";
    }
}
```

Наконец-то пришло время увидеть полиморфизм в действии с помощью нашего интерфейса Shape и его реализаций. Давайте 
создадим несколько объектов `Shape`, добавим их в `List`, и, наконец, выведем их названия в цикле:

```java
List<Shape> shapes = new ArrayList<>();
Shape circleShape = new Circle();
Shape squareShape = new Square();

shapes.add(circleShape);
shapes.add(squareShape);

for (Shape shape : shapes) {
    System.out.println(shape.name());
}
```

## 4. Методы по умолчанию в интерфейсах

Традиционные интерфейсы в Java 7 и более ранних версиях _не обеспечивают_ обратную совместимость.

Это означает, что **если у вас есть устаревший код, написанный на Java 7 или более ранней версии, и вы решили добавить 
абстрактный метод в существующий интерфейс, то все классы, реализующие этот интерфейс, должны переопределить новый 
абстрактный метод**. В противном случае код не будет работать.

**В Java 8 эта проблема была решена с помощью метода default**, который является _необязательным_ и может быть 
реализован на уровне интерфейса.

## 5. Правила наследования интерфейса

Чтобы реализовать _множественное наследование_ через интерфейсы, нужно помнить несколько правил. Давайте рассмотрим их 
подробнее.

### 5.1. Расширение интерфейса другим интерфейсом

Когда интерфейс _расширяет_ другой интерфейс, он наследует _все_ абстрактные методы этого интерфейса. Давайте начнём с 
создания двух интерфейсов: _HasColor_ и _Shape_:

```java
public interface HasColor {
    String getColor();
}

public interface Box extends HasColor {
    int getHeight();
}
```

В приведённом выше примере `Box` наследуется от `HasColor` с помощью ключевого слова `extends`. Таким образом, интерфейс 
`Box` наследует `getColor`. В результате в интерфейсе `Box` теперь есть два метода: getColor и getHeight.

### 5.2. Абстрактный класс, реализующий интерфейс

Когда абстрактный класс реализует интерфейс, он _наследует_ все его абстрактные методы и методы по умолчанию. Давайте 
рассмотрим интерфейс `Transform` и абстрактный класс `Vehicle`, который его реализует:

```java
public interface Transform {
    
    void transform();
    default void printSpecs(){
        System.out.println("Transform Specification");
    }
}

public abstract class Vehicle implements Transform {}
```

В этом примере класс `Vehicle` наследует два метода: абстрактный метод `transform` и метод `printSpecs` по умолчанию.

## 6. Функциональные интерфейсы

С первых дней существования Java в ней было много функциональных интерфейсов, таких как `Comparable` (начиная с 
Java 1.2) и `Runnable` (начиная с Java 1.0).

В Java 8 появились _новые_ функциональные интерфейсы, такие как `Predicate`, `Consumer` и `Function`.

## 7. Заключение

В этом уроке мы рассмотрели интерфейсы Java и поговорили о том, как использовать их для реализации полиморфизма и 
множественного наследования.
