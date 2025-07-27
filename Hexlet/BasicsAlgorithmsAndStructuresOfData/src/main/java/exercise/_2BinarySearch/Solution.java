package exercise._2BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {

    public static String run(List<Map<String, String>> list, String name) {
        var first = 0;
        var last = list.size() - 1;

        if (list.isEmpty()) {
            return "Phonebook is empty!";
        }

        while (first <= last) {
            int middle = (first + last) / 2;
            Map<String, String> element = list.get(middle);
            if (name.equals(element.get("name"))) {
                return element.get("number");
            }
            if (name.compareTo(element.get("name")) < 0) {
                last = middle - 1;
            } else {
                first = middle + 1;
            }
        }
        return "Name not found!";
    }

    public static void main(String[] args) {

        List<Map<String, String>> phonebook = new ArrayList<>();

        // Телефонная книга пока пуста
        System.out.println(Solution.run(phonebook, "Alex Bowman")); // "Phonebook is empty!"

        phonebook.add(Map.of("name", "Alex Bowman", "number", "48-2002"));
        phonebook.add(Map.of("name", "Aric Almirola", "number", "10-1001"));
        phonebook.add(Map.of("name", "Bubba Wallace", "number", "423-1111"));

        System.out.println(Solution.run(phonebook, "Alex Bowman")); // "48-2002"
        System.out.println(Solution.run(phonebook, "none")); // "Name not found!"

    }

}
