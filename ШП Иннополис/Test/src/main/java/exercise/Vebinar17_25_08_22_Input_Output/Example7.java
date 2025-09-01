package exercise.Vebinar17_25_08_22_Input_Output;
// на входе папка с именем "Files-and-Streams"
// в папке перечислить имена папок, начиная с корневой
// вывести количество папок в последней строчке (включая корневую)

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class Example7 {

    public static void main(String[] args) {
        // Указываем путь к корневой папке для анализа
        String path = "C:\\Files-and-Streams";
        // Создаем объект File, представляющий корневую директорию
        File root = new File(path);
        // Создаем двустороннюю очередь (дек) для хранения директорий
        // Используется как обычная очередь (FIFO - First In, First Out)
        // Очередь обеспечивает обход на одном уровне вложенности перед переходом на следующий
        Deque<File> directories = new ArrayDeque<>();
        // Добавляем корневую директорию в конец очереди для начала обхода
        directories.offer(root);

        int count = 0; // Инициализируем счетчик для подсчета количества папок
        // Основной цикл: выполняется пока в очереди есть директории
        while (!directories.isEmpty()) {
            // Извлекаем первую директорию из начала очереди (FIFO)
            File current = directories.poll();
            System.out.println(current.getName());// Выводим имя текущей директории
            count++; // Увеличиваем счетчик папок на 1
                            // считывает все директории/файлы в этой директории
            for (File dir : current.listFiles()) {
                // Проверяем, является ли текущий элемент директорией
                if (dir.isDirectory()) {
                    // Если это директория, добавляем ее в конец очереди для последующего обхода
                    directories.offer(dir);
                }
            }
        }
        System.out.println("Total directories: " + count);
    }
}
