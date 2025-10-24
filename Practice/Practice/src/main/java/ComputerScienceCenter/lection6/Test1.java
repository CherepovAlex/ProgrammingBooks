package ComputerScienceCenter.lection6;

import java.util.Objects;

// varargs появились в Java 5
// внутри это массив
public class Test1 {
    static void printAll(Object... objects) {
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    // varargs + generics: полезно, но осторожно

    static <T> boolean isOneOf(T value, T... options) {
        for (T option : options) {
            if (Objects.equals(value, option)) // библиотечный метод, при значении null игнорирует NPE
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        printAll("a", 1, "b", 2.0);

        Object[] objects = {"a", 1, "b", 2.0};
        printAll(objects);

        // неоднозначность
        printAll(null, null);
        printAll(null); // так лучше не писать, но если надо то лучше привести к Object или Object[]
    }


}
