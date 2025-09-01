package exercise.Vebinar13_25_08_08_OOP1.oop;

// класс может быть final - не позволяет себя наследовать
public class Person {
    protected String fio;
    protected String address;

    public Person(String fio, String address) {
        this.fio = fio;
        this.address = address;
    }
    // если метод сделать final, то его нельзя переопределять в классах наследниках
    protected void sleep () {
        System.out.println("I'm sleeping");
    }

    @Override
    public String toString() {
        return "Person{" +
                "fio='" + fio + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
