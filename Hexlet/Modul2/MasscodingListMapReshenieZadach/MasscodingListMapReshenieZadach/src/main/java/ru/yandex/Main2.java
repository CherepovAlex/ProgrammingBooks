package ru.yandex;

import java.util.HashMap;
import java.util.Map;

// Для решения задачи можно воспользоваться дополнительной структурой данных на выбор: ArrayList, LinkedList, HashMap
public class Main2 {
    public static void main(String[] args) {
        // Дан список Учеников, посчитать сколько ученико сдали ЕГЭ на 100, 90, 80, 70 баллов
        // Водичкина Жанна Петровна, 100
        // Дуплетов Артём Владимирович, 70
        // Арбузов Игорь Валентинович, 80
        // Горелый Олег Николаевич, 100
        // Мешкова Марина Иннокентьевна, 80
        // Яковлев Роман Юрьевич, 90
        // Неповоротов Денис Денисович, 60
        // Богатырёв Владимир Олегович, 80

        Map<String, Integer> students = new HashMap<>();
        students.put("Водичкина Жанна Петровна", 100);
        students.put("Дуплетов Артём Владимирович", 70);
        students.put("Арбузов Игорь Валентинович", 80);
        students.put("Горелый Олег Николаевич", 100);
        students.put("Мешкова Марина Иннокентьевна", 80);
        students.put("Яковлев Роман Юрьевич", 90);
        students.put("Неповоротов Денис Денисович", 60);
        students.put("Богатырёв Владимир Олегович", 80);

        Map<Integer, Integer> res = getStudents(students);

        System.out.println(res.toString());
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }

    public static Map<Integer, Integer> getStudents(Map<String, Integer> students) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entryStudent : students.entrySet()) {
            result.put(entryStudent.getValue(), result.getOrDefault(entryStudent.getValue(), 0) + 1);
        }
        return result;
    }
}
