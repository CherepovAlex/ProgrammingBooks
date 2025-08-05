package Zadacha1;

public class Zadacha1 {
    public static void main(String[] args) {

    }
}

class DynamicArray {

    private int[] array;
    private int size;
    private int capacity;

    public DynamicArray(int capacity) {
        if (capacity <=0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public int get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[i];
    }

    public void set(int i, int n) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        array[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }
        array[size] = n;
        size++;
    }

    public int popback() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Array is empty");
        }
        int lastElement = array[size - 1];
        size--;
        return lastElement;
    }

    private void resize() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
