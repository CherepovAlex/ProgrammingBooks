package Glava5;

public class LinkList {
    private Link first;     // Ссылка на первый элемент списка
//-------------------------------------------------------
    public void LinkList() {    // Конструктор
        first = null;           // Список пока не содержит элементов
    }
//-------------------------------------------------------
    public boolean isEmpty() {  // true, если список пуст
        return (first == null);
    }
//-------------------------------------------------------
    // ... Другие методы

    // Вставка элемента в начало списка
    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);    // Создание нового элемента
        newLink.next = first;               // newLink --> старое значение first
        first = newLink;                    // first --> newLink
    }

    // Удаление первого элемента
    public Link deleteFirst() {     // Удаление первого элемента (предполагается, что список не пуст)
        Link temp = first;          // Сохранение ссылки
        first = first.next;         // Удаление: first-->ссылка на второй элемент
        return temp;                // Метод возвращает ссылку на удалённый элемень
    }

    // Вывод всего списка
    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;           // От начала списка
        while (current != null) {       // Перемещение до конца списка
            current.displayLink();      // Вывод данных
            current = current.next;     // Переход к следующему элементу
        }
        System.out.println("");
    }


}

class Link {
    public int iData;       // Данные
    public double dData;    // Данные
    public Link next;       // Следующий элемент в списке
//-------------------------------------------------------
    public Link(int id, double dd) {    // Конструктор
        iData = id;         // Инициализация данных
        dData = dd;         // ( 'next' автоматически присваивается null )
    }
//-------------------------------------------------------
    public void displayLink() {     // Вывод содержимого элемента
        System.out.print("{" + iData + ", " + dData + "} ");
    }
    // Конец класса Link
}
