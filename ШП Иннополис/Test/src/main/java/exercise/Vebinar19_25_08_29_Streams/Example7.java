package exercise.Vebinar19_25_08_29_Streams;

import java.util.stream.IntStream;

// сумма четных чисел в промежутке от 1 до 100 включительно
public class Example7 {

    public static void main(String[] args) {

        // SumNumbers
        System.out.println(
                IntStream.range(1, 101)                 // создает поток целых чисел от 1 до 100 включительно
                        .filter(i -> i % 2 == 0) // оставляет в потоке только элементы, удовлетворяющие условию
//                      .sum()                       // Прямой метод для вычисления суммы всех элементов потока
                        .reduce(0, Integer::sum)    // выполняет свертку потока: 0 - начальное значение (аккумулятор)
                                                           // Integer::sum - ссылка на метод, эквивалентная (a, b) -> a + b
                // берет начальное значение 0 и последовательно складывает его с каждым элементом потока
        );
    }
}
