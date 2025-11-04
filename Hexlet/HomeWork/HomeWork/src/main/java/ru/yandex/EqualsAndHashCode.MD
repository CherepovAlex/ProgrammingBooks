# Методы equals и hashCode в классе Object

## 1. Что они делают по умолчанию?

`equals(Object obj)` - сравнивает **ссылки** на объекты, а не их содержимое.

```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

`hashCode()` - возвращает числовое представление объекта, обычно основанное на адресе памяти.

```java
public native int hashCode();
```

## 2. Контракт между equals и hashCode
 
Это **обязательные правила**, которые должны соблюдаться при переопределении этих методов:

Правила для `hashCode`:

1. **Консистентность**: Если объект не меняется, `multiple` вызовы `hashCode()` должны возвращать одно и то же значение

2. **Равенство объектов**: Если `a.equals(b) == true`, то `a.hashCode() == b.hashCode()`

3. **Обратное НЕ обязательно**: Если `a.hashCode() == b.hashCode()`, это НЕ означает, что `a.equals(b) == true`

## 3. Почему контракт важен?
 
Нарушение контракта приводит к неправильной работе коллекций, особенно **hash-based коллекций**:

```java
import java.util.*;

class BadPerson {
    String name;

    public BadPerson(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadPerson person = (BadPerson) o;
        return Objects.equals(name, person.name);
    }
    // hashCode НЕ переопределен - НАРУШЕНИЕ КОНТРАКТА!
}

public class Example {
    public static void main(String[] args) {
        BadPerson p1 = new BadPerson("John");
        BadPerson p2 = new BadPerson("John");

        System.out.println(p1.equals(p2)); // true

        Set<BadPerson> set = new HashSet<>();
        set.add(p1);
        set.add(p2);

        System.out.println(set.size()); // 2! Ожидалось 1
        System.out.println(set.contains(p1)); // true
        System.out.println(set.contains(p2)); // false! Проблема!
    }
}
```

## 4. Правильная реализация

```java
import java.util.Objects;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

// Использование
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("John", 25);
        Person p2 = new Person("John", 25);

        System.out.println(p1.equals(p2)); // true
        System.out.println(p1.hashCode() == p2.hashCode()); // true

        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);

        System.out.println(set.size()); // 1 - корректно!
    }
}
```

## 5. Значение и важность

Для каких коллекций критически важны:
- HashMap
- HashSet 
- HashTable
- ConcurrentHashMap

**Что происходит при поиске в HashMap:**

1. Сначала вычисляется `hashCode()` - определяет **корзину (bucket)**

2. Затем в корзине ищется объект с помощью `equals()`

```java
Map<Person, String> map = new HashMap<>();
Person key = new Person("John", 25);
map.put(key, "Developer");

// Поиск:
// 1. key.hashCode() - находит правильную корзину
// 2. key.equals() - находит точное совпадение в корзине
```

## 6. Лучшие практики

1. **Всегда переопределяйте оба метода вместе**
2. **Используйте одни и те же поля** в `equals()` и `hashCode()`
3. **Используйте** `Objects.equals()` и `Objects.hash()` для избежания `NPE`
4. **Следите за иммутабельностью** - если объект меняется, не используйте его как ключ в `HashMap`

## 7. Генерация в IDE

Современные IDE генерируют корректные реализации:

```java
// IntelliJ IDEA / Eclipse генерация
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return age == person.age && Objects.equals(name, person.name);
}

@Override
public int hashCode() {
    return Objects.hash(name, age);
}
```

**Вывод**

Контракт `equals`-`hashCode` - это **фундаментальный принцип** Java, обеспечивающий корректную работу hash-коллекций. 
Нарушение контракта ведет к трудноотлавливаемым багам и непредсказуемому поведению программ.
