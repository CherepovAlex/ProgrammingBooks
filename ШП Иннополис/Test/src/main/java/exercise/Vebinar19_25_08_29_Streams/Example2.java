package exercise.Vebinar19_25_08_29_Streams;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example2 {

    public static void main(String[] args) {

        // Stream<T> обобщенный тип потока
        // from collection
        List<Integer> numberList = new ArrayList<>();
        Stream<Integer> numberStream = numberList.stream(); // Создание потока (Stream) из коллекции numberList
        // from array
        int inputStringLength = 10;
        String[] inputStringArray = new String[inputStringLength];
        Stream<String> inputStringStream = Arrays.stream(inputStringArray); // Создание потока из массива
        // from Hashmap
        HashMap<String, String> namesMap = new HashMap<>();
        Stream<Map.Entry<String, String>> objEntriesStream = namesMap.entrySet().stream(); // Создание потока из всех пар "ключ-значение" HashMap
        Stream<String> objEntriesKeys = namesMap.keySet().stream(); // Создание потока только из ключей HashMap
        Stream<String> objEntriesValues = namesMap.values().stream(); // Создание потока только из значений HashMap

        // any type of stream
        List<String> inputStringList = new ArrayList<>();
        Stream<String> inputStringStream1 = inputStringList.stream();

        List<Integer> numbersList = new ArrayList<>();
        Stream<Integer> numbersStream = numbersList.stream();

        List<Object> objectsList = new ArrayList<>();
        Stream<Object> objectStream = objectsList.stream();

        // stream of primitives
        int[] ints = {1, 2, 3, 4};
        IntStream intStream = IntStream.of(ints); // создает поток из массива примитивов
        // IntStream работает с примитивными int, что эффективнее чем Stream<Integer>
        List<Integer> numbersList2 = new ArrayList<>();
        IntStream mappedIntStream = numbersList2.stream()   // создает обычный Stream<Integer> из коллекции
                .mapToInt(number -> Integer.valueOf(number)); // преобразует Stream<Integer> в специализированный IntStream
                // преобразования объектного потока в примитивный; Возвращает примитивный int
    }
}
