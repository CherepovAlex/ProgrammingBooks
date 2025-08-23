package exercise.Vebinar14_25_08_13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

// класс Modifier
// public Filed getModifiers()
// значение возвращаемое методом getModifiers соответствующего объекта класса Field будет:
// Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL -

// класс Field
// public Class<?> getField() - возвращает объект класса Class, отвечающий типу текущего поля
// set, get - позволяют считывать текущее значение поля, а также задавать новое

// класс Method
// public Class getReturnedType()
// public Class[] getParameterTypes()
// public Class[] getExceptionTypes()
// public Object invoke(Object onThis, Object[] args) throws IllegalArgumentException,
//  IllegalAccessException, InvocationTargetException - это вызов метода нашего класса

// класс Constructor

// класс Package
// public Package getPackage() - описание пакета
// public Package getName() - полное имя текущего пакета

public class Main1 {

    public Short age = 25;
    public Short count = 100;
    public static Short MAX_VALUE = 1000;

    public static final int POWER = 10;

    public static void printField(Object obj, String name) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getField(name);
        // Object value = field.get(obj) - для разных числовых типов
        Short value = (Short) field.get(obj);   // get получает значение поля
        System.out.println(value);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Main1 obj = new Main1();

        // печать полей экземпляра
        printField(obj, "age");
        printField(obj, "count");

        // печать статических полей
        printField(obj, "MAX_VALUE");

        // работа с классом и получение его частей: имени, конструктора
        Class<Main1> myPersonClass = Main1.class; // получаем объект типа класс
        System.out.println(myPersonClass.getName()); // получить имя класса
        System.out.println(Arrays.toString(myPersonClass.getConstructors())); // распечатать имя конструктора
        Constructor<?> myPersonConstructor = myPersonClass.getConstructors()[0]; // получаем массив конструкторов
        myPersonConstructor.newInstance(); // создаём объект
    }

}
