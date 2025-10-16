package Glava4;

import java.io.*;

public class ReverseApp {
    // Использование стека для перестановки символов строки
    public static void main(String[] args) throws IOException{
        String input, output;
        while (true) {
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString();    // Чтение строки с клавиатуры
            if (input.equals("")) break;    // Завершение, если [Enter]

            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev();   // Использование
            System.out.println("Reversed: " + output);
        }
    }
//------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
//------------------------------------------------------------
    // Конец класса ReverseApp
}

class StackXX {
    private int maxSize;
    private char[] stackArray;
    private int top;
//------------------------------------------------------------
    public StackXX(int max) {    // Конструктор
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }
//------------------------------------------------------------
    public void push(char j) {  // Размещение элемента на вершине стека
        stackArray[++top] = j;
    }
//------------------------------------------------------------
    public char pop() {     // Извлечение элемента с вершины стека
        return stackArray[top--];
    }
//------------------------------------------------------------
    public char peek() {    // Чтение элемента с вершины стека
        return stackArray[top];
    }
//------------------------------------------------------------
    public boolean isEmpty() {  // True, если стек пуст
        return (top == -1);
    }
//------------------------------------------------------------
    // Конец класс StackX
}

class Reverser {
    private String input;       // Входная строка
    private String output;      // Выходная строка
//------------------------------------------------------------
    public Reverser(String in) {    // Конструктор
        input = in;
    }
//------------------------------------------------------------
    public String doRev() {         // Перестановка символов
        int stackSize = input.length();     // Определние размера стека
        StackXX theStack = new StackXX(stackSize);  // Создание стека

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);      // Чтение символа из входного потока
            theStack.push(ch);              // Занесение в стек
        }
        output = "";
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();       // Извлечение символа из стека
            output = output + ch;           // Присоединение к входной строке
        }
        return output;
    }
//------------------------------------------------------------
    // Конец класса Reverser
}
