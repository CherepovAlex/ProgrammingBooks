package ru.yandex;

class Mail {
    static void print(Number x) {
        System.out.println("Number");
    }

    void print(Integer x) {
        System.out.println("Integer");
    }

    void print(Object x) {
        System.out.println("Object");
    }
}

public class Main6 {
    public static void main(String[] args) {
        Number n = Integer.valueOf(42);
        Mail.print(n);   // "Number" - выбор сделан компилятором
                         // статическому типу переменной (Number),
                         // не по фактическому (Integer)
    }
}
