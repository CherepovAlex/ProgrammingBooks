src/main/java/io/hexlet/App.java
В классе App реализуйте публичный статический метод replaceByZero(), 
который принимает в качестве парамера список List целых чисел. Метод должен вернуть новый список, 
в котором все отрицательные числа заменены на нули. Метод не должен менять исходный список

var items = List.of(1, -2, 3, -5);

var result = App.replaceByZero(items);
System.out.println(result); // => [1, 0, 3, 0]

// Исходный список не изменился
System.out.println(items); // => [1, -2, 3, -5]