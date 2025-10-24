package ComputerScienceCenter.lection5;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;

public class TestGeneric3 {
    public static void main(String[] args) {

    }
    // параметризованные методы: две ссылки в сигнатуре
    <T> T getT() {
        return null;
    }

    // странный код
    Object obj;

    // практическое правило: если имеется метод типа getT() с параметром T,
    // то он может использовать как минимум 2 раза:
    // например, как граница другого параметра, как возвращаемый тип, как параметр возращаемого типа,
    // как тип одного из обычным параметров метода
    @SuppressWarnings("unchecked")
        <T> T getT1() {
        return (T)obj;
    }

    void test() {
        // тип Т определяется в момент вызова
        // с точки зрения JVM тип - Object
        String str = getT1();
        // будет исключение, т.к. тип уже String
        Integer integer = getT1();
    }

    // пример из стандартной библиотеки
    // параметр А мешает или делает невозможныи применение этого метода
//    public static <T, U, A, R> Collector<T, ?, R> mapping (
//            Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream) {
//        BiConsumer<A, ? super U> downstreamAccumulator = downstream.accumulator();
//        return new CollectorImpl<>(downstream.supplier(),
//                (r, t) -> downstreamAccumulator.accept(r, mapper.apply(t)),
//                downstream.combiner(), downstream.finisher(), downstream.characteristics());
//    }
//
//    public static <T, U, A, R> Collector<T, ?, R> mapping2 (
//            Function<? super T, ? extends U> mapper, Collector<? super U, ?, R> downstream) {
//        return mappingImpl(mapper, downstream);
//    }
}
