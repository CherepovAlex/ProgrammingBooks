package exercise.junior;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> data = List.of("Max", "Dustin", "Mike", "Steeve", "Billy");
        String result = "";
    // Преобразуем List в массив для сортировки
        String[] arr = data.toArray(new String[0]);

        // Сортируем массив строк (лексикографически)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Если текущая строка "больше" следующей, меняем местами
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Собираем строку через запятую
        result = String.join(", ", arr);

        System.out.println(result);
    }

}