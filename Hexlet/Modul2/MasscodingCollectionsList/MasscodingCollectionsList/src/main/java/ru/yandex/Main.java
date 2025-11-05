package ru.yandex;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        ResizingArray list = new ResizingArray();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        System.out.println(list.size());
        System.out.println(list.toString());

        for (int item : list) {
            System.out.print(item + ", ");
        }

//        Iterator it = list.iterator();
//        while (it.hasNext()) {
//            int elem = it.next();
//            System.out.println(elem);
//        }

    }
}

class ResizingArray implements Iterable<Integer>{
    private static final int CAPACITY = 10;
    private int n;
    private int[] items;

    public ResizingArray() {
        this.items = new int[CAPACITY];
        n = 0;
    }

    public ResizingArray(int capacity) {
        this.items = new int[capacity];
        n = 0;
    }

    public String toString() {
        String result = "";
        for (int item : items) {
            result += item + ", ";
        }
        return result;
    }

    public void resize(int capacity) {
        int[] newArr = new int[capacity];
        for (int i = 0; i < n; i++) {
            newArr[i] = items[i];
        }
        items = newArr;
    }

    public void add(int item) {
        if (items.length == n) {
            resize(items.length * 2);
        }
        items[n++] = item;
    }

    public int size() {
        return n;
    }

    public Iterator<Integer> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Integer> {

        private int currentIndex;

        public ReverseArrayIterator() {
            currentIndex = n - 1;
        }

        public boolean hasNext() {
            if (currentIndex < 0) {
                return false;
            }
            return currentIndex >= 0;
        }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();

            return items[currentIndex--];
        }
    }
}
