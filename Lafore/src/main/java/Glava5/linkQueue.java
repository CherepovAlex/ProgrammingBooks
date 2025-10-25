package Glava5;

// Реализация очереди на базе двустороннего списка
public class linkQueue {
}

class LinkQueueApp {
    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20);        // Вставка элементов
        theQueue.insert(40);

        theQueue.displayQueue();        // Вывод содержимого очереди

        theQueue.insert(60);        // Вставка элеменотов
        theQueue.insert(80);

        theQueue.displayQueue();        // Вывод содержимого очереди

        theQueue.remove();              // Удаление элементов
        theQueue.remove();

        theQueue.displayQueue();        // Вывод содержимого очереди
    }
}

class Link7 {
    public long dData;          // Данные
    public Link7 next;          // Следующий элемент в списке

    //-------------------------------------------------------
    public Link7(long d) {      // Конструктор
        dData = d;
    }

    //-------------------------------------------------------
    public void displayLink() { // Вывод содержимого элемента
        System.out.print(dData + " ");
    }
//-------------------------------------------------------
    // Конец класса Link7
}

class FirstLastList7 {
    private Link7 first;        // Ссылка на первый элемент
    private Link7 last;         // Ссылка на последний элемент

    //-------------------------------------------------------
    public FirstLastList7() {   // Конструктор
        first = null;           // Список пока не содержит элементов
        last = null;
    }

    //-------------------------------------------------------
    public boolean isEmpty() {  // true, если список пуст
        return first == null;
    }

    //-------------------------------------------------------
    public void insertLast(long dd) {   // Вставка элемента в конец списка
        Link7 newLink = new Link7(dd);  // Создание нового элемента
        if (isEmpty())                  // Если список пуст,
            first = newLink;            // first--> newLink
        else
            last.next = newLink;        // Старое значение last --> newLink
        last = newLink;                 // newLink <-- last
    }

    //-------------------------------------------------------
    public long deleteFirst() {         // Удаление первого элемента (предполагается, что список не пуст)
        long temp = first.dData;        // Сохранение ссылки
        if (first.next == null)
            last = null;                // null <-- last
        first = first.next;             // first --> старое значение next
        return temp;
    }

    //-------------------------------------------------------
    public void displayList() {
        Link7 current = first;          // От начала списка
        while (current != null) {       // Перемещение до конца списка
            current.displayLink();      // Вывод данных
            current = current.next;     // Переход к следующему элементу
        }
        System.out.println("");
    }
//-------------------------------------------------------
    // Конец класса FirstLastList
}

class LinkQueue {
    private FirstLastList7 theList;

    //-------------------------------------------------------
    public LinkQueue() {                // Конструктор
        theList = new FirstLastList7(); // Создание 2-стороннего списка
    }

    //-------------------------------------------------------
    public boolean isEmpty() {
        return theList.isEmpty();       // true, если очередь пуста
    }

    //-------------------------------------------------------
    public void insert(long j) {        // Вставка элемента в конец очереди
        theList.insertLast(j);
    }

    //-------------------------------------------------------
    public long remove() {              // Удаление элемента в начале очереди
        return theList.deleteFirst();
    }

    //-------------------------------------------------------
    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }
//-------------------------------------------------------
    // Конец класса LinkQueue
}

