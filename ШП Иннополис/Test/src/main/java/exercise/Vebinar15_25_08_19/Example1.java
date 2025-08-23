package exercise.Vebinar15_25_08_19;

import java.lang.reflect.Method;
import java.lang.ClassLoader;

public class Example1 {
    public static void main(String[] args) {

        // Пример 1: Динамическая загрузка и создание объектов
        try {
            // Загружаем класс ArrayList
            Class<?> arrayListClass = loadClass("java.util.ArrayList");

            // Создаем экземпляр
            Object list = arrayListClass.getDeclaredConstructor().newInstance();

            // Вызываем метод add
            Method addMethod = arrayListClass.getMethod("add", Object.class);
            addMethod.invoke(list, "Hello");
            addMethod.invoke(list, "World");

            // Вызываем метод toString
            Method toStringMethod = arrayListClass.getMethod("toString");
            String result = (String) toStringMethod.invoke(list);

            System.out.println("Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Пример 3: Получение информации о загрузчиках
        // получаем системный загрузчик
        ClassLoader systemLoader = getSystemClassLoader();
        System.out.println("System loader: " + systemLoader);

        // Получаем загрузчик текущего класса
        ClassLoader currentClassLoader = Example1.class.getClassLoader();
        System.out.println("Loader Example1: " + currentClassLoader);

        // Показываем иерархию загрузчиков
        System.out.println("\nIerarhy of loaders:");
        ClassLoader loader = currentClassLoader;
        int level = 1;

        while (loader != null) {
            System.out.println(level + ". " + loader.getClass().getSimpleName() + ": " + loader);
            loader = loader.getParent();
            level++;
        }
        System.out.println(level + ". Bootstrap ClassLoader (native code)");

    }

    // статический метод, возвращающий ссылку на стандартный системный загрузчик приложения
    public static ClassLoader getSystemClassLoader() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader(); //  это вызов системного метода
        // Возвращает: Системный загрузчик приложения, Тот загрузчик, который установлен по умолчанию для приложения
        return classLoader;
    }

    // статический метод для получения ClassLoader; метод загружает конкретный класс с заданным именем
    public static Class loadClass(String name) throws ClassNotFoundException {
        ClassLoader classLoader = Example1.class.getClassLoader();
        return classLoader.loadClass(name);
    }
    // Методы ClassLoader:
        // обычные ресурсы
    // public URL getResource(String name); - получить ресурс, инфо из интернета
    // public InputStream getResourceAsStream(String name); - получить ресурс - файл для чтения
    // public Enumeration<URL> getResources(String name); - получить ресурс - список
        // системные процессы
    // public static URL getSystemResource(String name)
    // public static InputStream getSystemResourceAsStream(String name)
    // public static Enumeration<URL> getSystemResources(String name)

}
