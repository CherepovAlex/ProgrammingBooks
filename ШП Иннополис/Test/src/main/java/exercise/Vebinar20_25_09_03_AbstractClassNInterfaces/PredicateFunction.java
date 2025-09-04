package exercise.Vebinar20_25_09_03_AbstractClassNInterfaces;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateFunction {

    public static void main(String[] args) {
        // Функциональный интерфейс всегда имеет ровно 1 публичный абстрактный метод

        // Предикаты: принимает 1 аргумент и возвращает boolean
        Predicate<String> predicate = (s) -> s.length() > 0;

        // Функции: принимает 1 аргумент и возвращает некоторый результат (объект)
        Function<String, Integer> toInteger = (str) -> Integer.valueOf(str);

    }

}
