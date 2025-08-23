package exercise.Vebinar15_25_08_19.Reflection;

/*
interface A extends U
interface B {}
interface U {}
class C implements A {}
class D extends C implements B {}
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Получить все интерфейсы класса, включая интерфейсы от классов-родителей,
Не включать интерфейсы родительских интерфейсов
 */
public class Reflection {
    public static void main(String[] args) {
        List<Class<?>> result = getAllInterfaces(D.class);
        result.forEach(res -> System.out.println(res.getName()));

    }

    private static List<Class<?>> getAllInterfaces(Class<?> cls) {
        List<Class<?>> interfaces = new ArrayList<>();

        while (cls != Object.class) { // пока не достигнем главного класса
            interfaces.addAll(Arrays.asList(cls.getInterfaces())); // add interface B from D
            cls = cls.getSuperclass();  // get parent for С, D и так далее

        }
        return interfaces;
    }
}
