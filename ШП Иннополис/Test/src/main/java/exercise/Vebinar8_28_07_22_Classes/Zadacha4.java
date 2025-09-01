package exercise.Vebinar8_28_07_22_Classes;

import java.util.LinkedList;
import java.util.Scanner;

public class Zadacha4 {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку text~num/print~num или exit");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Завершение работы");
                break;
            }
            String[] parts = input.split("~");
            if (parts.length != 2) {
                System.out.println("Неверный формат команды");
                continue;
            }
            String command = parts[0];
            String numPart = parts[1];
            int position;
            try {
                position = Integer.parseInt(numPart);
            }
            catch (NumberFormatException e) {
                System.out.println("Число позиции надо неверно "+numPart);
                continue;
            }

            if (command.equalsIgnoreCase("print")) {
                try {
                String removed = queue.remove(position);
                System.out.println("получено "+removed);
                }
                catch (Exception e) {
                    System.out.println("Нет элемента на позиции "+position);
                }
            }
            else {
                try {
                    queue.add(position, command);
                }
                catch (Exception e) {
                    System.out.println("Невозможно добавить на позицию "+position);
                    System.out.println("Допустимый диапазон от 0.."+queue.size());

                }
            }
        }
        scanner.close();
    }
}