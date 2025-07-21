src/main/java/io/hexlet/App.java
В классе App реализуйте публичный статический метод getLongestLength(), принимающий на вход строку. Метод должен вернуть длину максимальной последовательности из неповторяющихся символов. Подстрока может состоять из одного символа. Например, в строке qweqrty, можно выделить следующие подстроки из неповторяющихся символов: qwe, weqrty. Самой длинной будет weqrty

App.getLongestLength("abcdeef"); // 5
App.getLongestLength("jabjcdel"); // 7
App.getLongestLength(""); // 0