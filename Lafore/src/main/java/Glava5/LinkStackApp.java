package Glava5;
// Реализация стека на базе связанного списка
public class LinkStackApp {
    public static void main(String[] args) {
        LinkStack theStack = new LinkStack();   // Создание стека

        theStack.push(20);                  // Вставка элементов
        theStack.push(40);

        theStack.displayStack();               // Вывод содержимого стека

        theStack.push(60);                  // Вставка элементов
        theStack.push(80);

        theStack.displayStack();               // Вывод содержимого стека

        theStack.pop();                         // Извлечение элементов
        theStack.pop();

        theStack.displayStack();                // Вывод содержимого стека
    }
    // Конец класса LinkStackApp
}

class Link6 {
    public long dData;      // Данные
    public Link6 next;      // Следующий элемент в списке
//-------------------------------------------------------
    public Link6(long dd) { // Конструктор
        dData = dd;
    }
//-------------------------------------------------------
    public void displayLink() { // Вывод содержимого элемента
        System.out.print(dData + " ");
    }
    // Конец класса Link6
}

class LinkList6 {
    private Link6 first;        // Ссылка на первый элемент в списке
//-------------------------------------------------------
    public LinkList6() {        // Конструктор
        first = null;           // Список пока не содержит элементов
    }
//-------------------------------------------------------
    public boolean isEmpty() {  // true, если список пуст
        return (first == null);
    }
//-------------------------------------------------------
    public void insertFirst(long dd) {  // Вставка элемента в начало списка
        Link6 newLink = new Link6(dd);
        newLink.next = first;           // newLink --> старое название first
        first = newLink;                // first --> newLink
    }
//-------------------------------------------------------
    public long deleteFirst() {         // Удаление первого элемента (предполагается, что список не пуст)
        Link6 temp = first;             // Сохранение ссылки
        first = first.next;             // Удаление: first --> ссылка на второй элемент
        return temp.dData;              // Метод возвращает данные удаленного элемента
    }
//-------------------------------------------------------
    public void displayList() {
        Link6 current = first;          // От начала списка
        while (current != null) {       // Перемещение до конца списка
            current.displayLink();      // Вывод данных
            current = current.next;     // Переход к следующему элементу
        }
        System.out.println("");
    }
//-------------------------------------------------------
    // Конец класса LinkedList
}

class LinkStack {
    private LinkList6 theList;
//-------------------------------------------------------
    public LinkStack() {                // Конструктор
        theList = new LinkList6();
    }
//-------------------------------------------------------
    public void push(long j) {          // Размещение элемента на вершине стека
        theList.insertFirst(j);
    }
//-------------------------------------------------------
    public long pop() {                 // Изслечение элемента с вершиты стека
        return theList.deleteFirst();
    }
//-------------------------------------------------------
    public boolean isEmpty() {          // true, если стек пуст
        return (theList.isEmpty());
    }
//-------------------------------------------------------
    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }
//-------------------------------------------------------
    // Конец класса LinkStack
}

