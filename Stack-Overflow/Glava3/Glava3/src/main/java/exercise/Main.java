package exercise;

public class Main {
    public static void main(String[] args) {

    }
}

class Person {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name != null && name.length() > 2)
            this.name = name;
    }

    public String getName1() {
    if (getName().length() > 16)
        return "Слишком длинное имя!";
    else
        return name;
}
}

class CountHolder {
    private int count = 0;

    public int getCount() { return count;}
    public void setCount(int c) { count = c;}
}

class CountHolder1 {
    public int count = 0;
}

class CountHolder2 {
    private int count = 0;

    public synchronized int getCount() {return count;}
    public synchronized void setCount(int c) { count = c;}
}

class Sample {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}