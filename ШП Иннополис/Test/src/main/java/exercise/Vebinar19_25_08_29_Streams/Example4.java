package exercise.Vebinar19_25_08_29_Streams;

import java.util.List;

public class Example4 {
    public static void main(String[] args) {

        List<String> myPlaces = List.of("Nepal, Pokhara ", "Nepal, Kathmandu ", "India, Delhi",
                "USA, New York", "Africa, Nigeria");
        myPlaces.stream()
                .filter(place -> place.startsWith("Nepal"))
//              .map(place -> place.toUpperCase())
                .map(String::toUpperCase)   // method-reference
                .map(String::trim)   // method-reference
                .sorted()                   // сортировка по семантике
                .forEach(System.out::println);  // терминирующий метод
    }
}
