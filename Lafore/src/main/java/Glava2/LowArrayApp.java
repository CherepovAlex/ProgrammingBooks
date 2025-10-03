package Glava2;

// lowArray.java
// класс массива с низкоуровневым интерфейсом
class LowArray {

    private long[] a;           // ссылка на массив a

    //---------------------------------------------------------
    public LowArray(int size) { // конструктор
        a = new long[size];     // создание массива
    }

    //---------------------------------------------------------
    public void setElem(int index, long value) {  // Запись элемента
        a[index] = value;
    }

    //---------------------------------------------------------
    public long getElem(int index) {               // чтение элемента
        return a[index];
    }
    //---------------------------------------------------------
    // конец класса LowArray
}

class LowArrayApp {
    public static void main(String[] args) {
        LowArray arr;                    // ссылка
        arr = new LowArray(100);    // создание объекта LowArray
        int nElems = 0;                  // количество элементов в массиве
        int j;                           // переменная цикла

        arr.setElem(0, 77);  // вставка 10 элементов
        arr.setElem(1, 99);
        arr.setElem(2, 44);
        arr.setElem(3, 55);
        arr.setElem(4, 22);
        arr.setElem(5, 88);
        arr.setElem(6, 11);
        arr.setElem(7, 00);
        arr.setElem(8, 66);
        arr.setElem(9, 33);
        nElems = 10;                    // Массив содержит 10 элементов

        for (j = 0; j < nElems; j++)    // Вывод элементов
            System.out.print(arr.getElem(j) + " ");
        System.out.println("");

        int searchKey = 26;             // Поиск элемента
        for (j = 0; j < nElems; j++)     // Для каждого элемента
            if (arr.getElem(j) == searchKey)    // Значение найдено?
                break;
        if (j == nElems)                // Нет
            System.out.println("Can't find " + searchKey);
        else System.out.println("Found " + searchKey);

        // удаление элемента с ключом 55
        for (j = 0; j < nElems; j++)   // поиск удаляемого элемента
            if (arr.getElem(j) == 55) break;
        for (int k = j; k < nElems; k++)   // сдвиг последующих элементов
            arr.setElem(k, arr.getElem(k + 1));
        nElems--;                       // уменьшение размера массива

        for (j = 0; j < nElems; j++)    // вывод содержимого
            System.out.print(arr.getElem(j) + " ");
        System.out.println("");
    }
    // конец класса LowArrayApp
}
