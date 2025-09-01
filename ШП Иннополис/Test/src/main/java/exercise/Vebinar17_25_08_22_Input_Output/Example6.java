package exercise.Vebinar17_25_08_22_Input_Output;

import java.io.File;

// вывести имена и размеры всех файлов в каталоге "Files-and-Streams"
// пропустите дочерние директории
public class Example6 {

    public static void main(String[] args) {
        File file = new File("C:\\Files-and-Streams");
        // проверяем существует ли такой путь
        if (file.exists()) {
            // проверяем существует ли такая директория
            if (file.isDirectory()) {
                // считывает все файлы в этой директории
                File[] files = file.listFiles();
                // запускаем цикл
                for (File f : files) {
                    // если элемент в списке не директория
                    if (!f.isDirectory()) {
                        // то печатаем размер
                        System.out.println(f.getName() + " " + f.length());
                    }
                }
            }
        }
    }
}
