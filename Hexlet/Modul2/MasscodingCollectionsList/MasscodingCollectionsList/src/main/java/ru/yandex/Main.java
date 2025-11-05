package ru.yandex;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        // Создание объекта ResizingArray с начальной емкостью по умолчанию
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
        list.add(11); // Этот элемент вызовет увеличение размера массива

        System.out.println(list.size()); // Вывод текущего количества элементов в списке
        System.out.println(list.toString());// Вывод строкового представления всего массива (включая пустые ячейки)

        for (int item : list) {              // Использование enhanced for-loop для итерации по элементам
            System.out.print(item + ", ");   // Будет выводить элементы в обратном порядке из-за реализации итератора
        }
        // Закомментированный альтернативный способ итерации с использованием явного итератора
//        Iterator it = list.iterator();
//        while (it.hasNext()) {
//            int elem = it.next();
//            System.out.println(elem);
//        }
    }
}

class ResizingArray implements Iterable<Integer>{
    private static final int CAPACITY = 10; // Константа - начальная емкость массива по умолчанию
    private int n;                          // Текущее количество элементов в массиве
    private int[] items;                    // Сам массив для хранения элементов

    public ResizingArray() {                // Конструктор по умолчанию - создает массив начального размера
        this.items = new int[CAPACITY];
        n = 0;      // Инициализация счетчика элементов
    }

    public ResizingArray(int capacity) {    // Конструктор с заданной начальной емкостью
        this.items = new int[capacity];
        n = 0;      // Инициализация счетчика элементов
    }

    public String toString() {              // Метод для преобразования массива в строку
        String result = "";
        for (int item : items) {            // Проход по ВСЕМ элементам массива (включая пустые)
            result += item + ", ";
        }
        return result;
    }

    public void resize(int capacity) {      // Метод для изменения размера массива
        int[] newArr = new int[capacity];   // Создание нового массива заданного размера
        for (int i = 0; i < n; i++) {       // Копирование существующих элементов в новый массив
            newArr[i] = items[i];
        }
        items = newArr;                     // Замена старого массива новым
    }

    public void add(int item) {              // Метод добавления элемента в массив
        if (items.length == n) {             // Проверка: если массив заполнен, увеличиваем его размер в 2 раза
            resize(items.length * 2);
        }
        items[n++] = item;                   // Добавление элемента и увеличение счетчика
    }

    public int size() {                      // Метод возвращает текущее количество элементов
        return n;
    }

    public Iterator<Integer> iterator() {    // Реализация метода интерфейса Iterable - возвращает итератор
        return new ReverseArrayIterator();   // Текущий индекс для итерации
    }
                                        // Внутренний класс итератора, который проходит элементы в обратном порядке
    private class ReverseArrayIterator implements Iterator<Integer> {

        private int currentIndex;       // Текущий индекс для итерации

        public ReverseArrayIterator() { // Конструктор итератора - начинает с последнего элемента
            currentIndex = n - 1;
        }

        public boolean hasNext() {      // Проверка наличия следующего элемента
            if (currentIndex < 0) {
                return false;
            }
            return currentIndex >= 0;
        }

        public Integer next() {         // Возвращает следующий элемент и уменьшает индекс
            if (!hasNext()) throw new NoSuchElementException();
                                        // Если следующего элемента нет - бросаем исключение
            return items[currentIndex--];  // Возвращаем текущий элемент и уменьшаем индекс
        }
    }
}
