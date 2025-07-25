В программировании часто встречаются задачи, связанные с обработкой строк. Одной из таких задач является проверка баланса скобок в строке. Вам предстоит создать метод, который будет проверять, сбалансированы ли скобки в переданной строке. Это означает, что каждая открывающая скобка имеет соответствующую закрывающую скобку в правильном порядке

src/main/java/io/hexlet/App.java
В классе App реализуйте публичный статический метод isBracketsBalanced(), который принимает на вход строку, состоящую только из открывающих и закрывающих скобок и проверяет баланс скобок. Если скобки в строке сбалансированы, метод должен вернуть true, Если же баланс нарушен, метод должен вернуть false

Примеры сбалансированных скобок: (), ((()())). Пустую строку тоже считаем сбалансированной

А эти скобки не сбалансированы: (, ((), )(

```java
App.isBracketsBalanced("()"); // true
App.isBracketsBalanced("()()"); // true
App.isBracketsBalanced("(()())"); // true

App.isBracketsBalanced("("); // false
App.isBracketsBalanced("(()"); // false
App.isBracketsBalanced(")("); // false
```

Алгоритм
Для проверки баланса недостаточно просто посчитать количество скобок, важен так же порядок, в котором они идут. Один из способов решения этой задачи - это использование связанного списка LinkedList. Решать задачу можно так:

Проходим по строке и проверяем каждый символ

Если перед нами открывающий элемент, то заносим его в конец связанного списка
Если закрывающий, то достаем из связанного списка последний добавленный элемент. Если список пустой, то есть в нем нет открывающих скобок, значит строка не сбалансирована.
Если мы дошли до конца строки и связанный список пустой, то все хорошо. Если в нем остались элементы, то проверка не прошла. Такое может быть, если в начале строки были открывающие элементы, но в конце для них не было закрывающих
Как видите, по ходу работы нам приходится постоянно добавлять новые элементы в конец списка и удалять их оттуда. А вот произвольный доступ к элементам нам тут не нужен. Поэтому для решения этой задачи гораздо лучше подходит именно реализация LinkedList

Подсказки
Метод pollLast() - получает последний элемент связанного списка и удаляет его