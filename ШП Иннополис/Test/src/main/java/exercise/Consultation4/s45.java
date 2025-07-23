package exercise.Consultation4;

public class s45 {
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=0) {
            this.age = age;
        }
    }
    public void SayHello() {
        System.out.println("Здравствуйте, мое имя "+name+" и мой возраст "+age+".");
    }
    public static void main(String[] args){
        Person p=new Person("Alex",30);
        p.SayHello();
    }
}