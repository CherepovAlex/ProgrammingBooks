src/main/java/io/hexlet/App.java
Представьте, что мы работаем с каталогом ретро автомобилей. В классе App реализуйте публичный статический метод getCars(), который будет искать в каталоге автомобили, выпущенные до определенного года

Каждый автомобиль в каталоге представлен классом Car, у которого есть марка, модель и год выпуска (дата LocalDate)

Метод принимает два параметра:

Каталог автомобилей, список List<Car>
Год выпуска, целое число
Метод должен вернуть список строк - названий автомобилей, выпущенных до указанного года. Каждое название - это марка + модель, например "Jaguar XK120". Список должен быть отсортирован по названиям автомобилей в прямом порядке без учета регистра
```java
var cars = List.of(
    new Car("Jaguar", "XK120", LocalDate.of(1950, 8, 21)),
    new Car("Mercedes-Benz", "W114", LocalDate.of(1968, 7, 10)),
    new Car("Fiat", "600", LocalDate.of(1956, 1, 1))
);

var result = App.getCars(cars, 1960);
System.out.println(result); // => [Fiat 600, Jaguar XK120]
```

Подсказки
В классе Car реализован метод toString(), который возвращает текстовое представление автомобиля. Этот метод можно использовать для формирования названия