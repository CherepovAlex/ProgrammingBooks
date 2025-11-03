package Glava5;

public class ListInsertionSort {
    public static void main(String[] args) {
        int size = 10;

        Link9[] linkArray = new Link9[size]; // Создание массива

        for (int j = 0; j < size; j++) {                    // Заполнение массива
            int n = (int)(java.lang.Math.random() * 99);    // Случайные числа
            Link9 newLink = new Link9(n);                   // Создание элемента
            linkArray[j] = newLink;                         // Сохранение в массиве
        }

        System.out.print("Unsorted array: ");               // Вывод содержимого массива
        for (int j = 0; j < size; j++)
            System.out.print(linkArray[j].dData + " ");
        System.out.println("");
                                // Создание нового списка, инициализированного содержимым массива
        SortedList9 theSortedList = new SortedList9(linkArray);

        for (int j = 0; j < size; j++)  // links from list to array
            linkArray[j] = theSortedList.remove();

        System.out.print("Sorted Array: "); // Вывод содержимого массива
        for (int j = 0; j < size; j++)
            System.out.print(linkArray[j].dData + " ");
        System.out.println("");
    }
//------------------------------------------------------
    // Конец класса ListInsertionSort
}

class Link9 {
    public long dData;      // Данные
    public Link9 next;      // Следующий элемент списка
//------------------------------------------------------
    public Link9(long dd) { // Конструктор
        dData = dd;
    }
//------------------------------------------------------
    // Конец класса Link9
}

class SortedList9 {
    private Link9 first;    // Ссылка на первый элемент списка
//------------------------------------------------------
    public SortedList9() {  // Конструктор (без аргументов)
        first = null;       // Инициализация списка
    }
//------------------------------------------------------
    public SortedList9(Link9[] linkArr) {   // Конструктор (аргумент - массив)
        first = null;                       // Инициализация списка
        for (int j = 0; j < linkArr.length; j++) {  // Копирование массива
            insert(linkArr[j]);             // в список
        }
    }
//------------------------------------------------------
    public void insert(Link9 k) {           // Вставка (в порядке сортировки)
        Link9 previous = null;              // От начала списка
        Link9 current = first;              // До конца списка
        while (current != null && k.dData > current.dData) {    // или если ключ > current
            previous = current;
            current = current.next;         // Перейти к следующему элементу
        }
        if (previous == null)               // В начале списка
            first = k;                      // first --> k
        else                                // Не в начале
            previous.next = k;              // старое значение prev --> k
        k.next = current;                   // k --> старое значение current
    }
//------------------------------------------------------
    public Link9 remove() {              // Возвращает и удаляет первую ссылку (предполагается не пустой список)
        Link9 temp = first;             // Сохранение ссылки
        first = first.next;             // Удаление первого элемента
        return temp;                    // Метод возвращает ссылку на удалённый элемент
    }
//------------------------------------------------------
    // Конец класса SortedList9
}
