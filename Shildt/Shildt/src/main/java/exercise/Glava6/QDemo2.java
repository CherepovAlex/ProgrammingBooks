package exercise.Glava6;

// Усовершенствованный класс очереди, предназначенной
// для хранения символьных значений,
class Queue1 {
    // Следующие члены класса теперь являются закрытыми,
    private char[] q; // Массив для хранения элементов очереди
    private int putloc, getloc; // Индексы размещения и извлечения
    // элементов очереди

    Queue1(int size) {
        q = new char[size + 1];   //  выделить память для очереди
        putloc = getloc = 0;
    }

    // Конструктор, строящий один объект типа Queue на основании другого.
    Queue1(Queue1 ob) {
        putloc = ob.putloc;
        getloc = ob.getloc;
        q = new char[ob.q.length];

        // копировать элементы очереди
        for(int i = getloc + 1; i <= putloc; i++)
            q[i] = ob.q[i];
    }

    Queue1(char a[])   {
    putloc = 0;
    getloc = 0;
    q = new char[a.length+1];

    for(int i = 0; i < a.length; i++) put(a[i]);
    }


    // поместить символ в очередь
    void put(char ch) {
        if (putloc == q.length - 1) {
            System.out.println(" - Queue is full.");
            return;
        }
        putloc++;
        q[putloc] = ch;
    }

    // извлечь символ из очереди
    char get() {
        if (getloc == putloc) {
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }
        getloc++;
        return q[getloc];
    }
}

// продемонстрировать класс Queue в действии
public class QDemo2 {
    public static void main(String args[]) {
        // построить пустую очередь для хранения 10 элементов
        Queue1 q1 = new Queue1(10);

        char name[] = {'Т', 'o', 'm'};
        // построить очередь из массива
        Queue1 q2 = new Queue1(name);

        char ch;
        int i;
        // поместить ряд символов в очередь q1
        for(i=0; i < 10; i++)
            q1.put((char) ('A' + i));

        // построить одну очередь из другой очереди
        Queue1 q3 = new Queue1(q1);

        // показать очереди
        System.out.print("Contents of ql: ");
        for(i=0; i < 10; i++)   {
            ch = q1.get();
            System.out.print(ch);
        }

        System.out.println("\n");

        System.out.print("Contents of q2: ");
        for(i=0; i < 3; i++) {
            ch = q2.get();
            System.out.print(ch);
        }

        System.out.println("\n");

        System.out.print("Contents of q3: ");
        for(i=0; i < 10; i++)   {
            ch = q3.get();
            System.out.print(ch);
        }
    }
}