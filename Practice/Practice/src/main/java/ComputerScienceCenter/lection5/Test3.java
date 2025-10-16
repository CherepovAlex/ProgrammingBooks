package ComputerScienceCenter.lection5;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Test3 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // Сохраняем оригинальный поток вывода System.out
        PrintStream oldOutput = System.out;
        // Создаем ByteArrayOutputStream (байтовый поток в памяти) для захвата вывода
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // Заменяем System.out,Устанавливаем новый PrintStream, который пишет в baos (в байтовый массив)
        System.setOut(new PrintStream(baos, false, "UTF-8"));
        try {
            // Вызываем метод, который что-то печатает
            printSomething();
        } finally {
            // гарантируем восстановление оригинального System.out
            System.setOut(oldOutput);
        }
        // Преобразуем захваченные данные в строку (достаём спрятанный байтовый массив)
        String output = baos.toString("UTF-8");
        // Выводим результат на экран
        System.out.println("Захваченный вывод: " + output);
    }

    // Метод, который печатает что-то в System.out
    private static void printSomething() {
        System.out.println("Something");
    }
}
