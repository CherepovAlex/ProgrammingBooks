package exercise.Consultation6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*1. Создайте HashSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6, 3}.
Распечатайте содержимое данного множества.
2. Создайте LinkedHashSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6, 3}.
Распечатайте содержимое данного множества.
3. Создайте TreeSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6, 3}.
 Распечатайте содержимое данного множества.
8*/
class SetExamples {
    public static void main(String[] args){
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(9);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(2);//
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(6);
        hashSet.add(3);//
        System.out.println("hashSet");
        System.out.println(hashSet);

        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(9);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        linkedHashSet.add(2);//
        linkedHashSet.add(4);
        linkedHashSet.add(5);
        linkedHashSet.add(6);
        linkedHashSet.add(3);//
        System.out.println("linkedHashSet");
        System.out.println(linkedHashSet);

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(9);
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(2);//
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);
        treeSet.add(3);//
        System.out.println("treeSet");
        System.out.println(treeSet);
    }
}