package exercise.Vebinar15_25_08_19.Reflection;

/*
interface A extends U
interface B {}
interface U {}
class C implements A {}
class D extends C implements B {}
 */

import java.util.*;

/*
Получить все интерфейсы класса, включая интерфейсы от классов-родителей,
и включить интерфейсы родительских интерфейсов
 */
public class ReflectionAnd {
    public static void main(String[] args) {
        List<Class<?>> result = getAllInterfaces(D.class);
        result.forEach(res -> System.out.println(res.getName()));

    }

    /**
     * Метод по получению всех интерфейсов класса
     * @param cls текущий класс
     * @return список интерфейсов
     */
    private static List<Class<?>> getAllInterfaces(Class<?> cls) {
        Set<Class<?>> interfaces = new HashSet<>();
        collectAllInterfaces(cls, interfaces);
        return new ArrayList<>(interfaces);
    }

    private static void collectAllInterfaces(Class<?> cls, Set<Class<?>> interfaces) {
        if (cls == null || cls == Object.class) {return;}

        // ищем интерфейсы текущего класса
        for (Class<?> iface : cls.getInterfaces()) {
            interfaces.add(iface);
            // рекурсивно добавляем родительский интерфейсы
            collectAllInterfaces(iface, interfaces);
        }

        // ищем в родительском классе
        collectAllInterfaces(cls.getSuperclass(), interfaces);
    }
}
