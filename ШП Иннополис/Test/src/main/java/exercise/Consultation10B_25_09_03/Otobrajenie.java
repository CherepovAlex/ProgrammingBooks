package exercise.Consultation10B_25_09_03;

import java.util.LinkedHashMap;
import java.util.Map;

public class Otobrajenie {
    public static void main(String[] args) {
        // Создаем LinkedHashMap
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        // Добавляем элементы
        lhm.put("one", 1);
        lhm.put("two", 2);
        lhm.put("three", 3);

        // Все элементы будут выведены в порядке вставки
        for(Map.Entry<String, Integer> entry : lhm.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}