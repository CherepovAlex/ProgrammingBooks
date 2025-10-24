package Glava4;
// Разбор постфиксных арифметических выражений
import java.io.*;
public class PostfixApp {
    public static void main(String[] args) throws IOException {
        String input;
        int output;

        while (true) {
            System.out.print("Enter postfix: ");
            System.out.flush();
            input = getString();            // Ввод строки с клавиатура
            if(input.equals(""))            // Завершение, если нажата клавиша
                break;                      // [Enter]
            // Создание объкта для разбора выражения
            ParsePost aParser = new ParsePost(input);
            output = aParser.doParse();     // Обработка выражения
            System.out.println("Evaluates to " + output);
        }
    }
//----------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
//----------------------------------------------
    // Конец класса Postfix
}

class StackXP{
    private int maxSize;
    private int[] stackArray;
    private int top;
//----------------------------------------------
    public StackXP(int size) {  // Конструктор
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }
//----------------------------------------------
    public void push(int j) {   // Размещение элемента на вершине стека
        stackArray[++top] = j;
    }
//----------------------------------------------
    public int pop() {          // Извлечение элемента с вершины стека
        return stackArray[top--];
    }
//----------------------------------------------
    public int peek() {         // Чтение элемента на вершине стека
        return stackArray[top];
    }
//----------------------------------------------
    public boolean isEmpty() {  // true, если стек пуст
        return (top == -1);
    }
//----------------------------------------------
    public boolean isFull() {   // true, если стек заполнен
        return (top == maxSize - 1);
    }
//----------------------------------------------
    public int size() {         // Текущий размер стека
        return top + 1;
    }
//----------------------------------------------
    public int peekN(int n) {   // Чтение элемента с индексом n
        return stackArray[n];
    }
//----------------------------------------------
    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println("");
    }
//----------------------------------------------
    // Конец класса StackXP
}

class ParsePost{
    private StackXP theStack;
    private String input;
//----------------------------------------------
    public ParsePost(String s) {
        input = s;
    }
//----------------------------------------------
    public int doParse() {
        theStack = new StackXP(20);     // Создание объекта стека
        char ch;
        int j;
        int num1, num2, interAns;

        for (j = 0; j < input.length(); j++) {  // Для каждого символа
            ch = input.charAt(j);               // Чтение символа
            theStack.displayStack("" + ch + " ");   // *диагностика*
            if (ch >= '0' && ch <= '9')             // Если это цифра
                theStack.push((int)(ch - '0'));     // Занести в стек
            else {
                num2 = theStack.pop();          // Извлечение операнда
                num1 = theStack.pop();          // извлечение второго операнда
                switch (ch) {                   // Выполнение арифметической операции
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }
                theStack.push(interAns);        // Занесение промежуточного
            }                                   // результата в стек
        }
        interAns = theStack.pop();              // Получение результата
        return interAns;
    }
//----------------------------------------------
    // Конец класса ParsePost
}