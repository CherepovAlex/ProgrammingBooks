package exercise.Consultation4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Zadacha3 {
    public static void main(String[] args) {
        Deque<String> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Приложение запоминает строки");
        System.out.println("Приложение принимает строки и команды print/revert/exit");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Завершение работы");
                break;
            }
            if (input.equalsIgnoreCase("print")) {
                if (queue.isEmpty()) {
                    System.out.println("нет строк для вывода");
                }
                else {
                    System.out.println("сохраненные строки:");
                    for (String s : queue) {
                        System.out.println(s);
                    }
                }
                continue;
            }
            if (input.equalsIgnoreCase("revert")) {
                if (queue.isEmpty()) {
                    System.out.println("нет строк для удаления");
                }
                else {
                    String removed = queue.removeFirst();
                    System.out.println("Удалена строка:" + removed);
                }
                continue;
            }
            queue.addFirst(input);
            System.out.println("Сохранено: "+input);
        }
        scanner.close();
    }
}