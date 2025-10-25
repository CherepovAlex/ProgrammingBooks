package Glava5;
// Работа со связанным списком
public class LinkListApp {
    public static void main(String[] args) {
        LinkList3 theList = new LinkList3();    // Создание нового списка
        theList.insertFirst(22, 2.99);   // Вставка четырёх элементов
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();                  // Вывод содержимого списка

        while (!theList.isEmpty())  {           // Пока остаются элементы
            Link3 aLink = theList.deleteFirst();// Удаление элемента
            System.out.print("Deleted ");       // Вывод удалённого элемента
            aLink.displayLink();
            System.out.println("");
        }
        theList.displayList();                  // Вывод содержимого списка
    }
    // Конец класс LinkListApp
}

class Link3 {
    public int iData;       // Данные (ключ)
    public double dData;    // Данные
    public Link3 next;       // Следующий элемент в списке
//-------------------------------------------------------
    public Link3(int id, double dd) {   // Конструктор
        iData = id;         // Инициализация данных
        dData = dd;         // ('next' автоматически присваивается null)
    }
//-------------------------------------------------------
    public void displayLink() { // Вывод содржимого элемента
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}   // Конец класса Link3

class LinkList3 {
    private Link3 first;         // Ссылка на первый элемент списка
//-------------------------------------------------------
    public LinkList3() {        // Конструктор
        first = null;           // Список пока не содержит элементов
    }
//-------------------------------------------------------
    public boolean isEmpty() {  // true, если список пуст
        return (first == null);
    }
//-------------------------------------------------------
    // Вставка элемента в начало списка
    public void insertFirst(int id, double dd) {
        Link3 newLink = new Link3(id, dd);      // Создание нового элемента
        newLink.next = first;                   // newLink--> старое значение first
        first = newLink;                        // frst-->newLink
    }
//-------------------------------------------------------
    // Удаление первого элемента
    public Link3 deleteFirst() {        // Удаление первого элемента (предполагается, что список не пуст)
        Link3 temp = first;             // Сохранение ссылки
        first = first.next;             // Удаление: first-->ссылка на второй элемент
        return temp;                    // Метод возаращает ссылку на удалённый элемент
    }
//-------------------------------------------------------
    public void displayList() {
        System.out.print("List (first-->last): ");
        Link3 current = first;          // От начала списка
        while (current != null) {       // Перемещение до конца списка
            current.displayLink();      // Вывод данных
            current = current.next;     // Переход к следующему элементу
        }
        System.out.println("");
    }
    // Конец класс LinkList3
}