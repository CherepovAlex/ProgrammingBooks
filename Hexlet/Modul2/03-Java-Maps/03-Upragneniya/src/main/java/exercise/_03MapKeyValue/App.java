package exercise._03MapKeyValue;

import java.util.Map;

public class App {

    public static void main(String[] args) {
        var cities = Map.of(
                "White River", 114958,
                "Kashmor", 210451,
                "Oxford", 152450
        );

        System.out.println(App.getMostPopulatedCity(cities)); // Kashmor
    }

    private static String getMostPopulatedCity(Map<String, Integer> cities) {
        int maxPopulation = 0;
        String mostPopulated = null;
        // 1 вариант
        var values = cities.values();
        var keys = cities.keySet();
        for (var value : values) {
            if (value > maxPopulation) {
                maxPopulation = value;
            }
        }
        for (String key : keys) {
            if (cities.get(key) == maxPopulation) {
                mostPopulated = key;
            }
            ;
        }
        // 2 вариант
        for (Map.Entry<String, Integer> entry : cities.entrySet()) {
            if (entry.getValue() > maxPopulation) {
                maxPopulation = entry.getValue();
                mostPopulated = entry.getKey();
            }
        }
        // 3 вариант
//        return cities.entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null);
        return mostPopulated;
}
}
