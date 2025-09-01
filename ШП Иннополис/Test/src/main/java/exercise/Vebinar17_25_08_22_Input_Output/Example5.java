package exercise.Vebinar17_25_08_22_Input_Output;

import java.io.File;

public class Example5 {

    public static void main(String[] args) {
        // методы для быстрого и легкого манипулирования файлами

        // Создает новый объект File, представляющий файл по указанному абсолютному пути
        File file = new File("C:\\input.txt");
        // Проверяет, существует ли файл или директория по указанному пути
        boolean isExisting = file.exists(); // true
        System.out.println(isExisting);
        // Возвращает размер файла в байтах, или вернёт OL
        long length = file.length(); // 475
        System.out.println(length);
        // Проверяет, представляет ли объект File директорию (папку), а не обычный файл
        boolean isDirectory = file.isDirectory();   // false
        System.out.println(isDirectory);
        // Потенциально проблемная строка:
        // Если объект file представляет директорию, возвращает массив File[] с содержимым директории
        // Если объект file представляет файл или путь не существует, возвращает null
        // Может вызвать NullPointerException если вызван для не-директории
        File[] files = file.listFiles();
        // if (file.isDirectory()) {
        //    File[] files = file.listFiles();
        //    дальнейшая работа с файлами
        //}
    }
}
