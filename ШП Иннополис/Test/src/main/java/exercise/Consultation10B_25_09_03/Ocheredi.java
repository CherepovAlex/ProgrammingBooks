package exercise.Consultation10B_25_09_03;

import java.util.PriorityQueue;

public class Ocheredi {
    public static void main(String[] args) {
        // Создаем очередь с приоритетом
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Добавляем элементы
        pq.offer(10);
        pq.offer(5);
        pq.offer(7);

        // Извлекаем и удаляем первый элемент (самый маленький)
//        System.out.println(pq.poll()); // Вывод: 5

        // Просматриваем верхний элемент без удаления
        System.out.println(pq); // Вывод: 7
    }
}