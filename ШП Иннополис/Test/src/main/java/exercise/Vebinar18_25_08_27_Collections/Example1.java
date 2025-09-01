package exercise.Vebinar18_25_08_27_Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Example1 {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>(){{
            add("Andrew");
            add("Vika");
            add("Anton");
            add("Milana");
        }};

        names.add("Alexandr");
        names.remove(0);
        names.remove(1);
        names.remove("Dmitiy");
        names.addAll(Arrays.asList("Karina", "Timati"));
        names.add(3, "Marsel");
        names.add(2, "Ildus");
        System.out.println(names);

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(5, -3, 10, 25));

        nums.add(55); // 5, -3, 10, 25, 55
        System.out.println(nums.get(0));    // 5
        System.out.println(nums);   // [5, -3, 10, 25, 55]
        nums.remove(2); // 5, -3, 25, 55
        nums.set(0, 101);   // 101, -3, 25, 55
        System.out.println(nums);   // [101, -3, 25, 55]

        Set<String> nameSet = new TreeSet<>();
        nameSet.add("Dmitriy");
        nameSet.add("Vlad");
        nameSet.add("Ildus");
        nameSet.add("Aysily");
        nameSet.add("Viktoria");
        nameSet.add("Ildus");
        nameSet.remove("Vlaad");
        System.out.println(nameSet);



    }
}
