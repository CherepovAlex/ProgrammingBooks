package exercise;

public class TestDuck {

    public static void main(String[] args) {
        int weight = 8;
        float density = 2.3F;
        String name = "Дональд";
        long[] feathers = {1, 2, 3, 4, 5, 6};
        boolean canFly = true;
        int airspeed = 22;

        Duck1[] d = new Duck1[7];
        d[0] = new Duck1();
        d[1] = new Duck1(density, weight);
        d[2] = new Duck1(name, feathers);
        d[3] = new Duck1(canFly);
        d[4] = new Duck1(3.3F, airspeed);
        d[5] = new Duck1(false);
        d[6] = new Duck1(airspeed, density);
    }

}

class Duck1 {
    int pounds = 6;
    float floatability = 2.1F;
    String name = "Универсальная";
    long[] feathers = {1, 2, 3, 4, 5, 6, 7};
    boolean canFly = true;
    int maxSpeed = 25;

    public Duck1() {
        System.out.println("Утка типа 1");
    }
     public Duck1(boolean fly) {
        canFly = fly;
         System.out.println("Утка типа 2");
     }

    public Duck1(String n, long[] f) {
        this.name = n;
        this.feathers = f;
        System.out.println("Утка типа 3");
    }

    public Duck1(int w, float f) {
        this.pounds = w;
        this.floatability = f;
        System.out.println("Утка типа 3");
    }

    public Duck1(float density, int max) {
        this.floatability = density;
        this.maxSpeed = max;
        System.out.println("Утка типа 5");
    }
}