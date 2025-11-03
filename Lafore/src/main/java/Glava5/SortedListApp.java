package Glava5;
// Работа с сортированным списком
public class SortedListApp {
    public static void main(String[] args) {
        SortedList theSortedList = new SortedList();    // Создание нового списка
        theSortedList.insert(20);                  // Вставка двух элементов
        theSortedList.insert(40);

        theSortedList.displayList();                    // Вывод содержимого списка

        theSortedList.insert(10);                   // Вставка трёъ элементов
        theSortedList.insert(30);
        theSortedList.insert(50);

        theSortedList.displayList();                     // Вывод содержимого списка

        theSortedList.remove();                          // Удаление элемента

        theSortedList.displayList();                     // Вывод содержимого списка
    }
    // Конец класса Sortedlist
}

class Link8 {
    public long dData;      // Данные
    public Link8 next;      // Ссылка на следующий элемент списка
//----------------------------------------------------------------
    public Link8(long dd) { // Конструктор
        dData = dd;
    }
//----------------------------------------------------------------
    public void displayLink() {     // Вывод содержимого элемента
        System.out.print(dData + " ");
    }
    // конец класса Link
}

class SortedList{
    private Link8 first;        // Ссылка на первый элемент списка
//----------------------------------------------------------------
    public SortedList() {       // Конструктор
        first = null;
    }
//----------------------------------------------------------------
    public boolean isEmpty() {  // true, если список пуст
        return (first == null);
    }
//----------------------------------------------------------------
    public void insert(long key) {  // Вставка в порядке сортировки
        Link8 newLink = new Link8(key); // Создание нового элемента
        Link8 previous = null;      // От начала списка
        Link8 current = first;
                                        // До конца списка
        while (current != null && key > current.dData) {    // или если key > current
            previous = current;
            current = current.next;     // Перейти к следующему элементу
        }
        if (previous == null)         // В начале списка
            first = newLink;            // first --> newLink
        else
            previous.next = newLink;    // старое значение prev --> newLink
        newLink.next = current;         // newLink --> старое значение current
    }
//----------------------------------------------------------------
    public Link8 remove() {             // Удаление первого элемента (предполагается, что список не пуст)
        Link8 temp = first;             // Сохранение ссылки
        first = first.next;             // Удаление: first-->ссылка на второй элемент
        return temp;                    // Метод возвращает ссылку на удалённый элемент
    }
//----------------------------------------------------------------
    public void displayList() {
        System.out.print("List (first-->last): ");
        Link8 current = first;          // От начала списка
        while (current != null) {       // Перемещение до конца списка
            current.displayLink();      // Вывод данных
            current = current.next;     // Переход к следующему элементу
        }
        System.out.println("");
    }
    // Конец класса SortedList
}