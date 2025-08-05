package Zadacha2;

import java.util.ArrayList;

public class Zadacha2 {

    public static void main(String[] args) {

    }
}

class LinkedList {
    // Каждый элемент списка — это объект Node.
    private Node head;  // начало списка (null, если список пуст); head указывает на первый узел
                        // последний узел имеет next = null.
    private int size;   // head указывает на первый узел,

    private static class Node {
        int val;    // Значение узла - хранит целочисленное значение узла.
        Node next;  // Ссылка на следующий узел (null, если это последний элемент).
        Node(int val) { // создаёт узел с заданным значением. cвязь между узлами осуществляется через next.
            this.val = val; // Инициализация значения
        }
    }
    // Инициализирует пустой список.
    public LinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {   // Проверка границ
            return -1;
        }
        Node current = head;                // Начинаем с головы
        for (int i = 0; i < index; i++) {   // Перемещаемся до нужного узла
            current = current.next;
        }
        return current.val;                 // Возвращаем значение
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);   // Создаём узел
        newNode.next = head;            // Новый узел ссылается на старую голову
        head = newNode;                 // Голова теперь новый узел
        size++;                         // Увеличиваем размер
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);           // Создаём узел
        if (head == null) {                     // Если список пуст
            head = newNode;                     // Новый узел становится головой
        }  else {
            Node current = head;
            while (current.next != null) {      // Идём до последнего узла
                current = current.next;
            }
            current.next = newNode;             // Добавляем узел в конец
        }
        size++;                                 // Увеличиваем размер
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {       // Проверка границ
            return false;
        }
        if (index == 0) {                       // Удаление головы
            head = head.next;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) { // Идём до узла перед удаляемым
                prev = prev.next;
            }
            prev.next = prev.next.next;         // "Пропускаем" удаляемый узел
        }
        size--;                                 // Уменьшаем размер
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node current = head;
        while (current != null) {           // Проходим по всем узлам
            values.add(current.val);        // Добавляем значения в список
            current = current.next;
        }
        return values;                      // Возвращаем массив значений
    }
}
