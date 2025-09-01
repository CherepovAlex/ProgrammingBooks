package exercise.Vebinar17_25_08_22_Input_Output;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example8 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String path = "C:\\output.ser";
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "Mimi", "Gosho");

        try (// Сериализация - сохранение объектов в файл
             FileOutputStream fos = new FileOutputStream(path);
             // эта строка сохранит (открывает поток) файл с расширнием "**.ser" - output.ser
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            // запись в файл
            oos.writeObject(names);
        }

        try (// Десериализация - загрузить объекты из файла в java
             FileInputStream fis = new FileInputStream(path);
             // открывает поток
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            // записывает объекты из файла
            List<String> names2 = (List<String>) ois.readObject();

            System.out.println("Names: " + names2);
        }
    }
}
