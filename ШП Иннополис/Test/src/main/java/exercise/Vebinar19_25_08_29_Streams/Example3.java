package exercise.Vebinar19_25_08_29_Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Example3 {

    public static void main(String[] args) {

        // Промежуточные операции, не завершают поток:
        // map - "Function: V apply(T t))" - преобразовать данные, чтобы что-то с каждым из них произошло
        // filter - "Predicate: boolean test(T t)" - проверяет подошло или нет
        // distinct - уникальные, sorted - сортировка,
        // peek - "Consumer: void accept(T t)" - выполняет действие для элементов потока без его изменения:
        // вывести на печать, посчитать, добавить в другую коллекцию, вывест лог каждого элемента

        List<String> elements = new ArrayList<>();
        Collections.addAll(elements, "one", "two"); // удобный метод для добавления нескольких элементов
        Stream<String> stream = elements.stream()   // Создание потока из списка элементов
                .distinct() // удаляет дубликаты из потока
                .sorted()   // все операции возвращают поток // сортирует элементы в естественном порядке
                .filter(inputString -> inputString.length() < 5) // фильтрация элементов
                .skip(1)    //  пропускает первые N элементов
                .limit(1);  // позволяют связывать функцию в цепочку; ограничивает количество элементов в потоке

        // Виды операций
        // map
        Stream<String> strStream = Stream.of("1", "2", "3"); // создает поток строк "1", "2", "3"
        Stream<Integer> numStream = strStream.map(Integer::valueOf); // преобразует в новый поток с числами
        // filter
        Stream<String> strStream1 = Stream.of("one", "two", "three", "four") // создает поток строк
                .filter(inputStr -> inputStr.length() > 3); // фильтр по условию длина больше 3

        // Терминальные операции, завершают поток:
        // reduce - "BinaryOperator: T test(T t1, t2)" (Integer::sum)
        // collect - "Collector: "(Collectors.toList())
        // forEach - Consumer: void accept(T t)"
        List<String> elements1 = new ArrayList<>();
        Collections.addAll(elements1, "one", "two");
        elements1.stream()  // преобразует коллекцию в поток (Stream)
                .distinct() // удаляет повторяющиеся элементы
                .forEach(inputString -> System.out.println(inputString)); // завершает поток,запускает выполнение всех операций
        // Виды операций
        // reduce - проверяет заданное условие:
        Stream<Integer> evenStreamAny = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> evenStreamAll = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> evenStreamNone = Stream.of(1, 2, 3, 4, 5);
        // любой элемент соответствует:
        boolean any = evenStreamAny.anyMatch(number -> number % 2 == 0);
        System.out.println(any);
        // все элементы совпадают
        boolean all = evenStreamAll.allMatch(number -> number % 2 == 0);
        System.out.println(all);
        // ни один их элементов не соответствует
        boolean none = evenStreamNone.noneMatch(number -> number % 2 == 0);
        System.out.println(none);

        // sort
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 7, 6, 3, 4, 5);
        numbers.stream()    // Преобразует список в поток (stream)
                .sorted((firstNumber, secondNumber) -> Integer.compare(firstNumber, secondNumber))
                .forEach(System.out::println); // Сортирует элементы с помощью компаратора, который сравнивает два числа

    }

}
