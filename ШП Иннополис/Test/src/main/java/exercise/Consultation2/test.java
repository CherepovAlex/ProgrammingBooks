package exercise.Consultation2;

public class test {
    int a = 18;

    public static void main(String[] args) {
        int a = 20;
        System.out.println(a);

        test t = new test();

        System.out.println(t.a);

        t.privet(t, a);

    }

    public void privet(test t, int a) {
        System.out.println(t.a);
    }
}
