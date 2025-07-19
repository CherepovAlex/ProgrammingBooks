package exercise.Glava6;

// Усовершенствованный класс очереди, предназначенной
// для хранения символьных значений,
public class Queue {
    // Следующие члены класса теперь являются закрытыми,
    private char[] q; // Массив для хранения элементов очереди
    private int putloc, getloc; // Индексы размещения и извлечения
                                // элементов очереди

    Queue(int size) {
        q = new char[size+1];   //  выделить память для очереди
        putloc = getloc = 0;
    }

    // поместить символ в очередь
    void put(char ch) {
        if(putloc==q.length-1) {
            System.out.println(" - Queue is full.");
            return;
        }
        putloc++;
        q[putloc] = ch;
    }

    // извлечь символ из очереди
    char get() {
        if(getloc == putloc) {
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }
        getloc++;
        return q[getloc];
    }
}