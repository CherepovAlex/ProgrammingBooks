package exercise.Vebinar21_25_09_05_Stream_API;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMiniTasks {

    public static void main(String[] args) {
        // 1. Фильтровать: оставить слово на 'b' длиной >= 4
        {
            List<String> words = List.of("bee", "book", "at", "ball", "be", "bonus");
            List<String> result = words.stream()
                    .filter(w -> w.startsWith("b"))
                    .filter(w -> w.length() >= 4)
                    .toList();
            System.out.println("1) " + result);
        }

        // 2. Квадрат чисел (map)
        {
            List<Integer> digits = List.of(1, 2, 3, 4, 5);
            List<Integer> result = digits.stream()
                    .map(x -> x * x)                // преобразование (apply)
                    .toList();
            System.out.println("2) " + result);
            // version 2
            List<Integer> result2 = IntStream.of(1, 2, 3, 4, 5)
                    .map(x -> x * x)
                    .boxed()                // преобразует IntStream -> Stream<Integer>
                    .toList();
            System.out.println("2) " + result2);
        }

        // 3. flatMap: уникальное слово из фраз
        {
            List<String> phrases = List.of("java streams", "hello world", "java lambdas");
            List<String> result = phrases.stream()
                    .flatMap(p -> Arrays.stream(p.split("\\s+")))  // каждую фразу режем на слова и помещаем в поток
                    .map(String::toLowerCase)
                    .distinct()     // уникальные
                    .sorted()
                    .toList();
            System.out.println("3) " + result);
        }

        // 4. Убрать дубли
        {
            List<Integer> nums = List.of(1, 2, 2, 3, 3, 4, 5, 5, 6);
            System.out.println("4) " + nums.stream().distinct().toList());
        }

        // 5. sorted: по длина, по алфавиту
        {
            List<String> words = List.of("pear", "apple", "kiwi", "banana");
            List<String> result = words.stream()
                    .sorted(Comparator.comparingInt(String::length)
                            .thenComparing(Comparator.naturalOrder()))
                    .toList();
            System.out.println("5) " + result);
        }

        // 6. skip + limit: пропустить 2, взять 3
        {
            List<Integer> digits = List.of(10, 20, 30, 40, 50, 60).stream()
                    .skip(2)
                    .limit(3)
                    .toList();
            System.out.println("6) " + digits);
        }

        // 7. takeWhile / dropWhile
        {
            List<Integer> src = List.of(1, 2, 3, 0, 4, 5);
            // берём элементы с начала списка, пока n < 3
            var take = src.stream().takeWhile(n -> n < 3).toList();
            // пропуская элементы сначала, пока n < 3
            var drop = src.stream().dropWhile(n -> n < 3).toList();
            System.out.println("7) take = " + take + " drop = " + drop);
        }

        // 8. peek: "подглядывание" в поток (для откладки)
        {
            List<Integer> r = IntStream.rangeClosed(1, 6).boxed()
                    .peek(n -> {
                    })
                    .filter(n -> n % 2 == 0)
                    .peek(n -> System.out.println("peek " + n + " "))
                    .toList();
            System.out.println("8) " + r);
        }

        // 9. суммарная длина слов (mapToInt + sum)
        {
            int sum = List.of("a", "ab", "abc").stream()
                    .mapToInt(String::length)
                    .sum();
            System.out.println("9) " + sum);
        }

        // 10. сводка по числам
        {
            IntSummaryStatistics st = IntStream.of(3, 7, 2, 10)
                    .summaryStatistics();   // считаем sum/count/avg/min/max
            System.out.println("10) " + st);
        }

        // 11. findFirst / Optional
        {
            Optional<String> firstLen = Stream.of("a", "bb", "ccc")
                    .filter(s -> s.length() == 2)
                    .findFirst();
            System.out.println("11) " + firstLen.orElse("not found"));
        }

        // 12. anyMatch / allMatch / noneMatch
        {
            List<Integer> l = List.of(1, 2, 3, 4);
            // есть ли элементы больше 3?
            boolean any = l.stream().anyMatch(n -> n > 3);
            // все ли элементы меньше 5?
            boolean all = l.stream().allMatch(n -> n < 5);
            // нет ли элементов меньше 0?
            boolean none = l.stream().noneMatch(n -> n < 0);
            System.out.println("12) any = " + any + " all = " + all + " none = " + none);
        }

        // 13. min/max с компаратором (своим условием сравнения)
        {
            List<String> w = List.of("alpha", "bet", "gamma");
            String minLength = w.stream()
                    .min(Comparator.comparingInt(String::length))
                    .orElse("");
            System.out.println("13) " + minLength);
        }

        // 14. reduce - произведение чисел
        {
            int prod = Stream.of(1, 2, 3, 4, 5)
                    .reduce(1, (a, b) -> a * b);
            System.out.println("14) " + prod);
        }

        // 15. collect (joining)
        {
            String csv = Stream.of("a", "b", "c", "d")
                    .collect(Collectors.joining(","));
            System.out.println("15) " + csv);
        }

        // 16) iterate / generate - первые 5 четных чисел
        {
            List<Integer> evens = Stream.iterate(0, n -> n + 2)
                    .limit(5)
                    .toList();
            System.out.println("16) " + evens);
        }

        // 17) параллельныве стримы
        {
            System.out.println("17) Parallel stream");
            IntStream.rangeClosed(1, 10)
                    .parallel()
                    .forEach(System.out::print);
            System.out.println(" (different order)");
        }

        // 18) сохранение порядка в параллельном стриме
        {
            System.out.println("18) Parallel stream ordered");
            IntStream.rangeClosed(1, 10)
                    .parallel()
                    .forEachOrdered(System.out::print);
            System.out.println(" (same order)");
        }

        // 19. parallel reduce
        {
            int sumSquares = IntStream.rangeClosed(1, 5)
                    .parallel()
                    .map(x -> x * x)
                    .sum();
            System.out.println("19) " + sumSquares);
        }

    }
}
