package Glava4;
// работа с очередью

public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5);  // Очередь из 5 ячеека

        theQueue.insert(10);            // Вставка 4 элементов
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove();                  // Извлечение 3 элементов
        theQueue.remove();                  // (10, 20, 30)
        theQueue.remove();

        theQueue.insert(50);             // Вставка ещё 4 элементов
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        while (!theQueue.isEmpty()) {       // Извлечение и вывод
            long n = theQueue.remove();     // всех элементов
            System.out.print(n);          // (40, 50, 60, 70, 80)
            System.out.print(" ");
        }
        System.out.println("");
    }
    // Конец класса QueueApp
}

class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;
//------------------------------------------------------------
    public Queue(int s) {  // Конструктор
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
//------------------------------------------------------------
    public void insert(long j) {    // Вставка элемента в конец очереди
        if (rear == maxSize - 1)    // Циклический перенос
            rear = -1;
        queArray[++rear] = j;       // Увеличение rear и вставка
        nItems++;                   // Увеличение количества элементов
    }
//------------------------------------------------------------
    public long remove() {          // Извлечение элемента в начале очереди
        long temp = queArray[front++];  // Выборка и увеличение front
        if (front == maxSize)           // Циклический перенос
            front = 0;
        nItems--;                   // Уменьшение количества элементов
        return temp;
    }
//------------------------------------------------------------
    public long peekFront() {       // Чтение элемента в начале очереди
        return queArray[front];
    }
//------------------------------------------------------------
    public boolean isEmpty() {      // true, если очередь пуста
        return (nItems == 0);
    }
//------------------------------------------------------------
    public boolean isFull() {       // true, если очередь заполнена
        return (nItems == maxSize);
    }
//------------------------------------------------------------
    public int size() {             // Количество элементов в очереди
        return nItems;
    }
//------------------------------------------------------------
    // Конец класса Queue
}

// реализация очереди без счетчика элементов
class AlterQueue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
//------------------------------------------------------------
    public AlterQueue(int s) {          // Конструктор
        maxSize = s + 1;                // Массив на одну ячейку больше
        queArray = new long[maxSize];   // требуемого размера
        front = 0;
        rear = -1;
    }
//------------------------------------------------------------
    public void insert(long j) {        // Вставка элемента в конец очереди
        if (rear == maxSize - 1)
            rear = -1;
        queArray[++rear] = j;
    }
//------------------------------------------------------------
    public long remove() {              // Извлечение элемента в начале очереди
        long temp = queArray[front++];
        if (front == maxSize)
            front = 0;
        return temp;
    }
//------------------------------------------------------------
    public long peek() {                // Чтение элементв в начале очереди
        return queArray[front];
    }
//------------------------------------------------------------
    public boolean isEmpty() {          // true, если очередь пуста
        return (rear + 1 == front || (front + maxSize - 1 == rear));
    }
//------------------------------------------------------------
    public boolean isFull() {               // true, если очередь заполенена
        return (rear + 2 == front || (front + maxSize - 2 == rear));
    }
//------------------------------------------------------------
    public int size() {                     // предпалагаем, что очередь не пуста
        if (rear >= front)                  // непрерывная последовательность
            return rear - front + 1;
        else                                // Несвязная последовательность
            return (maxSize - front) + (rear + 1);
    }
//------------------------------------------------------------
    // Конец класса Queue
}
