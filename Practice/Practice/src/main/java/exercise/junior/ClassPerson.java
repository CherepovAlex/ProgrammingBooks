package exercise.junior;

// Реализуйте класс Person с полями name и age, а также методами для вывода информации
// о человеке и изменения его возраста.

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Person person = new Person("Alice", 25);
        person.printInfo();
        person.setAge(30);
        person.printInfo();
    }
}

public class ClassPerson {
    public static void main(String[] args) {

    }
}

