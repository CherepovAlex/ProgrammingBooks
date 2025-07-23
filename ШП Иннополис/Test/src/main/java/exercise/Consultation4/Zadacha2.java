package exercise.Consultation4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Zadacha2 {

    public static void main(String[] args) {
        final int count=10000;
        List<Integer> arList = new ArrayList<>();
        long t1 = System.nanoTime();
        for (int i=0; i<count; i++) {
            arList.add(i);
        }
        long t2 = System.nanoTime();
        long d1 = (t2-t1)/1_000_000;
        System.out.println("ArrayList, добавление заняло: " + d1);

        List<Integer> linkList = new LinkedList<>();
        long t3 = System.nanoTime();
        for (int i=0; i<count; i++) {
            linkList.add(i);
        }
        long t4 = System.nanoTime();
        long d2 = (t4-t3)/1_000_000;
        System.out.println("LinkList, добавление заняло: " + d2);
    }
}