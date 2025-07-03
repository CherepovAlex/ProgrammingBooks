package exercise;

abstract class Animal1 {

    private String name;

    public Animal1(String theName) {
        name = theName;
    }

    public String getName() {
        return name;
    }
}

class Hippo1 extends Animal1 {
    public Hippo1(String name) {
        super(name);
    }
}

public class MakeHippo {
    public static void main(String[] args) {
        Hippo1 h = new Hippo1("Баффи");
        System.out.println(h.getName());
    }
}