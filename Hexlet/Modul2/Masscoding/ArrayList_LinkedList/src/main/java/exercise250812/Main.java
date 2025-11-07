package exercise250812;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // в очередь на кассу выстроилась группа людей
        // кого обслужили - уходят, а новые покупатели становятся в конец очереди

        MyQueue queue = new MyQueue();
        queue.add("Марина");
        queue.add("Олег");
        queue.add("Валентин");
        queue.add("Kseniya");
        queue.add("Roman");
        queue.add("Arseniy");

        queue.serve();
        queue.serve();
        queue.serve();

        System.out.println(queue.toString());
    }
}

class MyQueue {
    LinkedList<String> queue;

    MyQueue() {
        this.queue = new LinkedList<>();
    }

    public void add(String name) {
        queue.addLast(name);
    }

    public void serve() {
        queue.removeFirst();
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                ", queue=" + queue +
                '}';
    }
}