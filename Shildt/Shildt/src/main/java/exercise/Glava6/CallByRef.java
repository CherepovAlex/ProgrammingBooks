package exercise.Glava6;

// Объекты передаются методам по ссылке,
class Test1 {
    int a, b;

    Test1(int i, int j) {
        a = i;
        b = j;
    }

    /* Передача объекта методу. Теперь переменные ob.a b и ob.b
    из передаваемого объекта можно изменить. */
    void change(Test1 ob) {
    ob.a = ob.a + ob.b;
    ob.b = -ob.b;
    }
}
public class CallByRef {
    public static void main(String args[]) {
        Test1 ob = new Test1(15, 20);
        System.out.println("ob.a and ob.b before call: " +
                            ob.a + " " + ob.b);
        ob.change(ob);
        System.out.println("ob.a and ob.b after call: " +
                            ob.a + " " + ob.b);
    }
}