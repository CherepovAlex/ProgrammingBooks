package exercise.junior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main1{
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(6.1, "Olga"));
        list.add(new Student(5.5, "Maksim"));
        list.add(new Student(6.8, "Artem"));

        Collections.sort(list, new StudentComparator());

        for (Student student : list) {
            System.out.println(student.name);
        }
    }

    static class Student {
        private final double progress;
        private final String name;

        public Student(double progress, String name) {
            this.progress = progress;
            this.name = name;
        }
    }

    static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return Double.compare(o2.progress, o1.progress);
        }
    }
}