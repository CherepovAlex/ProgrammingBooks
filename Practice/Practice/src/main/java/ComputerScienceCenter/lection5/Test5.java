package ComputerScienceCenter.lection5;

import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Test5 {
    // стандартный метод из API
    public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toMap (
            Function<? super T, ? extends K> keyMapper,
            Function<? super T, ? extends U> valueMapper,
            BinaryOperator<U> mergeFunction,
            Supplier<M> mapFactory) {return null;}

    public static void main(String[] args) {

    }
}
