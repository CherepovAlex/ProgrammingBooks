package Glava3;
// Сортировка объектов (с применением сортировки методом вставки)

class Person {
    private String lastName;
    private String firstName;
    private int age;
    //-----------------------------------------------------

    public Person(String last, String first, int a) {   // Конструктор
        lastName = last;
        firstName = first;
        age = a;
    }
    //-----------------------------------------------------

    public void displayPerson() {
        System.out.print("    LastName: " + lastName);
        System.out.print(", FirstName: " + firstName);
        System.out.println(", Age: " + age);
    }
    //-----------------------------------------------------

    public String getLast() {   // Получение фамилии
        return lastName;
    }   // Конец класса Person
}

class ArrayInOb {
    private Person[] a;     // Ссылка на массив a
    private int nElems;     // Количество элементов данных
    //-----------------------------------------------------

    public ArrayInOb(int max) { // Конструктор
        a = new Person[max];    // Создание массива
        nElems = 0;             // Пока нет ни одного элемента
    }
    //-----------------------------------------------------

    public void insert(String last, String first, int age) {
        a[nElems] = new Person(last, first, age);
        nElems++;               // Увеличение размера
    }
    //-----------------------------------------------------

    public void display() {     // Вывод содержимого массива
        for (int j = 0; j < nElems; j++)        // Для каждого элемента
            a[j].displayPerson();               // Вывод
        System.out.println("");
    }
    //-----------------------------------------------------

    public void insertionSort() {
        int in, out;

        for (out = 1; out < nElems; out++) {    // out - разделительный маркер
            Person temp = a[out];               // Скопировать помеченный элемент
            in = out;                           // Начать перемещения с out

            while (in > 0 && a[in-1].getLast().compareTo(temp.getLast()) > 0) { // пока не найден меньший элемент
                a[in] = a[in - 1];              // Сдвинуть элемент вправо
                --in;
            }
            a[in] = temp;                       // Вставить помеченный элемент
        }
    }   // конец класса ArrayInOb
}

public class ObjectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;                      // Размер массива
        ArrayInOb arr;                          // ССылка на массив
        arr = new ArrayInOb(maxSize);           // Создание массива

        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Yee", "Tom", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        System.out.println("Before sorting: ");
        arr.display();                          // Вывод содержимого
        arr.insertionSort();                    // Сортировка методом вставки

        System.out.println("After sorting: ");
        arr.display();                          // Повторный вывод
    }   // Конец класса ObjectSortApp
}
