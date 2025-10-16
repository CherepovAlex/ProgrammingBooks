package Glava4;

// Работа со стеком

class StackX {
    private int maxSize;        // Размер массива
    private long[] stackArray;
    private int top;            // Вершина стека
//------------------------------------------------------------
    public StackX(int s) {      // Конструктор
        maxSize = s;            // Определение размера стека
        stackArray = new long[maxSize]; // Создание массива
        top = -1;               // Пока нет ни одного элемента
    }
//------------------------------------------------------------
    public void push(long j) {  // Размещение элемента на вершине стека
        stackArray[++top] = j;  // Увеличение top, вставка элемента
    }
//------------------------------------------------------------
    public long pop() {             // Извлечение элемента с вершины стека
        return stackArray[top--];   // Извлечение элементы, уменьшение top
    }
//------------------------------------------------------------
    public long peek() {            // Чтение элемента с вершины стека
        return stackArray[top];
    }
//------------------------------------------------------------
    public boolean isEmpty() {      // True, если стек пуст
        return (top == -1);
    }
//------------------------------------------------------------
    public boolean isFull() {       // True, если стек полон
        return (top == maxSize - 1);
    }
//------------------------------------------------------------
// Конец класса StackX
}

public class StackApp {
    public static void main(String[] args) {
        StackX theStack = new StackX(10);   // Создание нового стека
        theStack.push(20);                  // Занесение элементов с стек
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while (!theStack.isEmpty()) {       // Пока стек не станет пустым
            long value = theStack.pop();    // Удалить элемент из стека
            System.out.print(value);        // Вывод содержимого
            System.out.print(" ");
        }
        System.out.println("");

//        перед вставкой элемента, пользователь должен проверить наличие свободных ячеек
//        if(!theStack.isFull()) insert(item);
//        else System.out.println("Can't insert, stack is full");
    }
//  Конец класса StackApp
}


