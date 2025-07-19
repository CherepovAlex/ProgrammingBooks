package exercise.Glava6;

// Добавление варианта метода f(byte).
class Overload3 {
    void f(byte x) {
        System.out.println("Inside f(byte): " + x) ;
    }

    void f(int x) {
        System.out.println("Inside f(int) : " + x);
    }

    void f(double x) {
        System.out.println("Inside f(double): " + x);
    }
}

class TypeConv1 {
    public static void main(String args[]) {
        Overload3 ob = new Overload3();

        int i = 10;
        double d = 10.1;

        byte b = 99;
        short s = 10;
        float f = 11.5F;

        ob.f(i); // Вызов метода ob.f(int)
        ob.f(d); // Вызов метода ob.f(double)

        ob.f(b); // Вызов метода ob.f(byte) без преобразования типов

        ob.f(s) ; // Вызов метода ob.f (int) с преобразованием (типов
        ob.f(f) ; // Вызов метода ob.f(double) с преобразованием типов
    }
}