package exercise;

public class GC {
    public static GC doStuff() {
        GC newGC = new GC();
        doStuff1(newGC);
        return newGC;
    }

    private static void doStuff1(GC copyGC) {
        GC localGC;
    }

    public static void main(String[] args) {
        GC gc1;
        GC gc2 = new GC();
        GC gc3 = new GC();
        GC gc4 = gc3;
        gc1 = doStuff();
    }

}
