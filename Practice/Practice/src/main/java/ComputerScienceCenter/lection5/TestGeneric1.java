package ComputerScienceCenter.lection5;

import java.util.NoSuchElementException;
// Идея класса: создать типобезопасный контейнер, который явно показывает, что значение может отсутствовать,
// вместо использования null напрямую. Это упрощенный аналог Optional из Java 8.

public class TestGeneric1 {

    // Этот код объявляет общий (generic) статический вложенный класс
    // который реализует концепцию "контейнера, который может содержать значение, а может и не содержать его".

    /**
     * A box which is either empty or contains a non-null value
     */
    static class Option<T> {
        T value;    // Объявление поля value типа T, то место, где хранится наше значение
        // (или null, если значение отсутствует)
        // Конструктор, принимающий значение типа T

        /**
         * Passing null means absent value
         */
        public Option(T value) {
            this.value = value;
        }

        // Метод проверяет, не равно ли значение null; гарантирует, что никогда не вернет null

        /**
         * Never returns null
         */
        public T get() {    // Если null - бросает исключение NoSuchElementException
            if (value == null) throw new NoSuchElementException();
            return value;   // Если не null - возвращает значение
        }

        // метод использует тернарный оператор: null возвращает other (значение по умолчанию), или value
        public T orElse(T other) {
            return value == null ? other : value;
        }

        // проверка наличия значения: true, если значение присутствует (не null), false - отсутствует (null)
        public boolean isPresent() {
            return value != null;
        }
    }

    /**
     * A mutable box which is either empty or contains a non-value
     */
    static class Shmoption<T> {
        T value;

        /**
         * Passing null means absent value
         */
        public Shmoption(T value) {
            this.value = value;
        }

        /**
         * Never returns null
         */
        public T get() {
            if (value == null) throw new NoSuchElementException();
            return value;
        }

        public void set(T newValue) {
            value = newValue;
        }

        public T orElse(T other) {
            return value == null ? other : value;
        }

        public boolean isPresent() {
            return value != null;
        }
    }

    // <> появилась в Java 7
    public static void main(String[] args) {
        Shmoption<String> present = new Shmoption<>("yes");
        Shmoption<String> absent = new Shmoption<>(null);
        System.out.println(present.isPresent());        // true
        System.out.println(present.get());              // yes
        System.out.println(absent.isPresent());         // false
        System.out.println(absent.orElse("no"));  // no

        // может не сработать, если мы используем var
        var present1 = new Shmoption<>("yes");
        var absent1 = new Shmoption<>(null);
        System.out.println(present1.orElse("no").length());
        // System.out.println(absent1.orElse("no").length()); - не сработает length^ нет определённого типа, т.к. Object

        // маскировочный символ (wildcard); "?" = "? extends Object" - сокращение
        // use-site variance (вариативность в точке использования)
        Shmoption<?> present2 = new Shmoption<>("yes");
        System.out.println(present2.isPresent());   // yes
        System.out.println(present2.get());         // вернёт неизвестный тип, подтип Object

        Shmoption<?> present3 = new Shmoption<>("yes");
        System.out.println(present3.isPresent());   // yes
        Object value = present3.get();
        System.out.println(value);
        // present3.set(); // не можем вызвать конкретный тип: "capture of ? newValue"
        present3.set(null); // работает

        // можно заменить на Object и тогда можно передать любой объект в конструктор
        Shmoption<Object> present4 = new Shmoption<>("yes");
        System.out.println(present4.isPresent());
        Object value4 = present4.get();
        System.out.println(value);
        present4.set(123);

        // сложный пример
        Shmoption<? extends Number> number = new Shmoption<>(123);
        Number n = number.get();    // возваращает Number
        //number.set(124); - не будет работать, т.к. не ясно какой именно числовой тип будет в value

        // содадим объекты
        NumberShmoption<?> number5 = new NumberShmoption<>(123);
        Number n5 = number5.get();
//      number5.set(124);   // capture of ?

        IntegerShmoption integer = new IntegerShmoption(123);
        Integer i = integer.get();
        integer.set(124);   // компилятор знает тип Integer

//      number5 = integer;  // можем присвоить, потому что он является надтипом

//      getDoubleValue(new IntegerShmoption(123));
//      не получится, т.к. не является подтипом Shmoption<Number>

        getDoubleValue1(new IntegerShmoption(123));
//      получится, т.к. нам хватит любой подтип от Number

        NumberShmoption<Number> n6 = new NumberShmoption<>(123.45);
//      setInteger(n6); не получится, т.к. мы ждём Integer, а не

        NumberShmoption<Number> n7 = new NumberShmoption<>(123.45);
        setInteger1(n7);
//      получится, т.к. мы вложили суперкласс для Integer

        // параметризованные методы и конструкторы
//        setNotNull(n2, 123);
//        ShmoptionUtils.<Number>setNotNull(n, 123);
    }

    // унаследуем
    static class NumberShmoption<N extends Number> extends Shmoption<N> {
        public NumberShmoption(N value) {super(value);}
    }

    static class IntegerShmoption extends Shmoption<Integer> {
        public IntegerShmoption(Integer value) {super(value);}
    }

    // хотим и объекта shmoption получить double через doubleValue из Number
    static double getDoubleValue(Shmoption<Number> shmopt) {
        return shmopt.get().doubleValue();
    }
    // чтение (producer - extends, что-то, что создаёт значение) - производитель
    static double getDoubleValue1(Shmoption<? extends Number> shmopt) {
        return shmopt.get().doubleValue();
    }

    // хотим метод, который запишет в shmoption значение 42
    static void setInteger(Shmoption<Integer> shmopt) {
        shmopt.set(42);
    }
    // consumer - super, - потребитель
    // хотим метод, который запишет в shmoption значение 42 с типом ? super Integer
    // т.е. можно передавать числа, которое является надтипом для Integer - Number, Object
    static void setInteger1(Shmoption<? super Integer> shmopt) {
        shmopt.set(42);
    }

    // параметризованные методы и конструкторы
    static <T> void setNotNull(Shmoption<? super T> shmoption, T value) {
        if (value == null) throw new IllegalArgumentException();
        shmoption.set(value);
    }

}
