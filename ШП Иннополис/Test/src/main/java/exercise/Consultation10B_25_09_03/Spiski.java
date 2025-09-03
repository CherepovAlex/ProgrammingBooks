package exercise.Consultation10B_25_09_03;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Spiski {
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> users = new CopyOnWriteArrayList<>();
        users.add("Пользователь 1"); // O(n), создается новая копия списка

// Получение элемента по индексу
        System.out.println(users);
    }
}