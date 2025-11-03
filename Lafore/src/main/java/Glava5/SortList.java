package Glava5;

public class SortList {

    public void insert(long key) {   // Вставка в порядке сортировки
        Link6 first = null;
        Link6 newLink = new Link6(key); // Создание нового элемента
        Link6 previous = null;          // От начала списка
        Link6 current = first;
                                                        // До конца списка
        while (current != null && key > current.dData) {    // или если key > current
            previous = current;
            current = current.next;     // Перейти к следующему элементу
        }
        if (previous == null)         // В начале списка
            first = newLink;            // first --> newLink
        else                            // Не в начале
            previous.next = newLink;    // старое значение prev --> newLink
        newLink.next = current;         // neLink --> старое значение current
    }
}
