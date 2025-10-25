package Glava5;
// Работа с двусторонним списком
public class firstLastList {
}

class FirstLastApp {
    public static void main(String[] args) {
        FirstLastList theList = new FirstLastList();

        theList.insertFirst(22);         // Вставка в начало списка
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);          // Вставка в конец списка
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayList();                // Вывод содержимого списка

        theList.deleteFirst();                // Удаление первых двух элементов
        theList.deleteFirst();

        theList.displayList();                // Повторный вывод
    }
    // Конец класса FirstLastApp
}

class Link5 {
    public long dData;      // Данные
    public Link5 next;      // Следующий элемент в списке
//-------------------------------------------------------
    public Link5(long d) {  // Конструктор
        dData = d;
    }
//-------------------------------------------------------
    public void displayLink() { // Вывод содержимого элемента
        System.out.print(dData + " ");
    }
//-------------------------------------------------------
    // Конец класса Link5
}

class FirstLastList {
    private Link5 first;        // Ссылка на первый элемент
    private Link5 last;         // Ссылка на последний элемент
//-------------------------------------------------------
    public FirstLastList() {    // Конструктор
        first = null;           // Список пока не содержит элементов
        last = null;
    }
//-------------------------------------------------------
    public boolean isEmpty() {  // true, если список пуст
        return first == null;
    }
//-------------------------------------------------------
    public void insertFirst(long dd) { // Вставка элемента в начало списка
        Link5 newLink = new Link5(dd);  // Создание нового элмента
        if (isEmpty())                  // Если список пуст
            last = newLink;             // newLink <-- last
        newLink.next = first;           // newLink --> старое значение first
        first = newLink;                // first --> newLink
    }
//-------------------------------------------------------
    public void insertLast(long dd) {    // Вставка элемента в конец списка
        Link5 newLink = new Link5(dd);      // Создание нового элемента
        if (isEmpty())                  // Если список пуст
            first = newLink;            // first --> newLink
        else
            last.next = newLink;        // Старое значение last --> newLink
        last = newLink;                 // newLink <-- last
    }
//-------------------------------------------------------
    public long deleteFirst() {         // Удаление первого элемента списка (предполагается, что список не пуст)
        long temp = first.dData;
        if (first.next == null)         // Если только один элемент
            last = null;                // null <-- last
        first = first.next;             // first --> старое значение next
        return temp;
    }
//-------------------------------------------------------
    public void displayList() {
        System.out.print("List (first-->last): ");
        Link5 current = first;          // От начала списка
        while (current != null) {       // Перемещение до конца списка
            current.displayLink();      // Вывод данных
            current = current.next;     // Переход к следующему элементу
        }
        System.out.println("");
    }
//-------------------------------------------------------
    // Конец класса FirstLastList
}