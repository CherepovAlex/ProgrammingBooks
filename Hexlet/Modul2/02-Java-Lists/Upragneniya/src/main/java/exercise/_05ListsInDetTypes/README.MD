В этом упражнении мы лишний раз потренируемся обрабатывать списки, а заодно применим подход, рассмотренный в уроке.

src/main/java/io/hexlet/App.java
В классе App реализуйте публичный статический метод countBooks(), который посчитает общее количество книг автора. Метод принимает три параметра

Список книг
Имя автора, строка
Жанр, строка
Метод должен вернуть общее количество книг в библиотеке, написанных нашим автором в определенном жанре

var books = List.of(
    new Book("Death on the Nile", "Agatha Christie", "Detective"),
    new Book("Murder on the Orient Express", "Agatha Christie", "Detective"),
    new Book("The Raven", "Edgar Allan Poe", "Poem")
);

App.countBooks(books, "Agatha Christie", "Detective"); // 2
Реализуйте метод так, чтобы он мог принимать в качестве списка книг любую реализацию интерфейса List