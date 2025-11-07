package ru.yandex;
// Задача 2: "Дневник настроений"
// Цель: Написать программу, которая записывает твоё настроение каждый день и в конце недели
// выводит записи в том порядке, в котором ты их добавлял

import java.util.LinkedHashMap;
import java.util.Map;

public class Main1 {
    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<>(Map.of("Понедельник", "Бодрое",
                "Вторник", "Сонное",
                "Среда", "Продуктивное",
                "Четверг", "Веселое",
                "Пятница", "Предвкушающее выходные",
                "Суббота", "Расслабленное",
                "Воскресенье", "Ленивое"));

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " ");
        }

        // добавление новой записи в дневник (и удаление самой старой)
        for (String entry : map.keySet()) {
            map.remove(entry);
            break;
        }

        map.put("Понедельник 88 сентября", "Учебное");

        // через итератор
        String key = map.keySet().iterator().next();
        map.remove(key);

        map.put("Понедельник 15 сентября", "Учебное");

    }
}

