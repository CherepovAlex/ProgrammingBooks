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
        List<Class<?>> result = getAllInterfaces(D.class); // метод для получения, отдаём объект Class
        result.forEach(res -> System.out.println(res.getName()));
    }
    /**
     * Метод по получению всех интерфейсов класса
     * @param cls текущий класс
     * @return список интерфейсов
     */
    private static List<Class<?>> getAllInterfaces(Class<?> cls) {
        Set<Class<?>> interfaces = new HashSet<>(); // чтобы были уникальные
        collectAllInterfaces(cls, interfaces);  // будем использовать рекурсию
        return new ArrayList<>(interfaces); // вернём list
    }
    // собираем все интерфейсы, в том числе классов родителей
    private static void collectAllInterfaces(Class<?> cls, Set<Class<?>> interfaces) {
        // проверка на null или Object
        if (cls == null || cls == Object.class) return;
        // ищем интерфейсы текущего класса
        for (Class<?> iface : cls.getInterfaces()) { // получаем все реализованные интерфейсы
            interfaces.add(iface);  // добавляем в коллекцию
            // рекурсивно добавляем родительский интерфейсы
            collectAllInterfaces(iface, interfaces);
        }
        // переходим и ищем в родительском классе
        collectAllInterfaces(cls.getSuperclass(), interfaces);
    }
}
