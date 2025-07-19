package exercise.Glava6;

/* Автоматическое преобразование типов может оказывать влияние
   на выбор перегружаемого метода.
*/
class Overload2 {
    void f(int x) {
        System.out.println("Inside f(int): " + x) ;
    }

    void f(double x) {
        System.out.println("Inside f(double): " + x) ;
    }
}

class TypeConv {
    public static void main(String args[])  {
        Overload2 ob = new Overload2();

        int i = 10;
        double d = 10.1;
        byte b = 99;
        short s = 10;
        float f = 11.5F;

        ob.f(i); // Вызов метода оb.f(int)
        ob.f(d); // Вызов метода ob.f(double)
        ob.f(b); // Вызов метода oh.f(int) с преобразованием типов
        ob.f(s); // Вызов метода ob.f(int) с преобразованием типов
        ob.f(f); // Вызов метода ob.f(double) с преобразованием типов
    }
}