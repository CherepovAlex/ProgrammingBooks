# Потеря объектов в hash-коллекциях Java

В Java объекты могут "теряться" в hash-коллекциях (`HashSet, HashMap, LinkedHashMap, LinkedHashSet, ConcurrentHashMap` и
др.) в следующих случаях:

## 1. Изменение хэш-кода объекта после добавления в коллекцию

**Описание**: Если изменяется поле объекта, участвующее в вычислении `hashCode()`, то при поиске объект будет искаться 
в другой корзине (`bucket`).

```java
public class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    
    @Override
    public boolean equals(Object o) {
        // реализация equals
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }
    
    // Сеттер, изменяющий поле, участвующее в hashCode()
    public void setAge(int age) {
        this.age = age;
    }
}

// Пример использования:
Set<Person> people = new HashSet<>();
Person person = new Person("John", 25);
people.add(person);

// Изменяем поле, влияющее на hashCode
person.setAge(30); // Хэш-код изменился!

System.out.println(people.contains(person)); // false - объект "потерян"
people.remove(person); // Не удалится
```

## 2. Неправильная реализация equals() и hashCode()

**Описание**: Нарушение контракта между `equals()` и `hashCode()` - если два объекта равны по `equals()`, они должны 
иметь одинаковый `hashCode()`.

```java
public class BadPerson {
    private String name;
    
    public BadPerson(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadPerson that = (BadPerson) o;
        return Objects.equals(name, that.name);
    }
    
    // hashCode() не переопределен - используется Object.hashCode()
    // Нарушение контракта: equals говорит, что объекты равны, 
    // но hashCode разный
}

// Проблема:
BadPerson p1 = new BadPerson("John");
BadPerson p2 = new BadPerson("John");

System.out.println(p1.equals(p2)); // true
System.out.println(p1.hashCode() == p2.hashCode()); // false (скорее всего)

Set<BadPerson> set = new HashSet<>();
set.add(p1);
set.add(p2); // Добавится как отдельный объект, хотя по equals они равны
```

## 3. Изменение ключа в HashMap

**Описание**: Особо опасный случай с изменяемыми ключами в HashMap.

```java
Map<Person, String> map = new HashMap<>();
Person key = new Person("Alice", 25);
map.put(key, "Developer");

// Изменяем ключ
key.setAge(30); // hashCode изменился!

// Теперь оригинальный объект недоступен
System.out.println(map.get(key)); // null

// Но он все еще в мапе - создаем утечку памяти
map.forEach((k, v) -> System.out.println(k + ": " + v)); // Может не показать объект
```

## 4. Проблемы с устаревшими ссылками в WeakHashMap

**Описание**: В `WeakHashMap` записи автоматически удаляются при сборке мусора, если на ключ нет сильных ссылок.

```java
WeakHashMap<Object, String> weakMap = new WeakHashMap<>();
Object key = new Object();
weakMap.put(key, "value");

System.out.println(weakMap.size()); // 1

// Удаляем сильную ссылку
key = null;
System.gc(); // Принудительно вызываем сборщик мусора

// После GC запись может исчезнуть
Thread.sleep(100);
System.out.println(weakMap.size()); // 0
```

## 5. Проблемы с ConcurrentModification в многопоточности

**Описание**: При одновременной модификации коллекции из разных потоков без синхронизации.

```java
Map<Integer, String> map = new HashMap<>();

// Поток 1
new Thread(() -> {
    for (int i = 0; i < 1000; i++) {
        map.put(i, "value" + i);
    }
}).start();

// Поток 2
new Thread(() -> {
    for (int i = 0; i < 1000; i++) {
        map.remove(i); // Может привести к потере данных или исключению
    }
}).start();
```

## 6. Коллизии хэш-кодов с неправильным equals()

**Описание**: Объекты с одинаковым `hashCode()`, но разными по `equals()` помещаются в одну корзину, но поиск может 
работать некорректно.

```java
public class CollidingObject {
    private int id;
    
    public CollidingObject(int id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        return 1; // Всегда один и тот же hashCode
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollidingObject that = (CollidingObject) o;
        return id == that.id;
    }
}

// Использование:
Set<CollidingObject> set = new HashSet<>();
CollidingObject o1 = new CollidingObject(1);
CollidingObject o2 = new CollidingObject(2);

set.add(o1);
set.add(o2); // Оба добавятся, но производительность деградирует

// Поиск будет работать, но медленно из-за линейного поиска в корзине
```

## Решения и лучшие практики:

1. **Сделайте ключи неизменяемыми (immutable)** (не использовать сеттеры)

2. **Всегда переопределяйте equals() и hashCode() вместе** (используйте те же поля)

3. **Используйте final поля в hashCode() вычислениях** (финализирует поля ключа)

4. **Для многопоточности используйте ConcurrentHashMap**

5. **Следуйте контракту equals()/hashCode()**
(контракт: консистентность (множественные вызовы hashcode на неизменяемом объекте), равенство объектов (если равны по 
equals, то равно по hashcode), обратное НЕ обязательно).

```java
// Правильная immutable реализация
public final class GoodPerson {
    private final String name;
    private final int age;
    
    public GoodPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodPerson that = (GoodPerson) o;
        return age == that.age && Objects.equals(name, that.name);
    }
}
```
