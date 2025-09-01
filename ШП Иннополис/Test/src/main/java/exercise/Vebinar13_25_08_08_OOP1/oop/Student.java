package exercise.Vebinar13_25_08_08_OOP1.oop;

public class Student extends Person {
    private School school;

    public Student(String fio, String address, School school) {
        super(fio, address); // вызов родительского конструктора
        this.school = school;

        // можно получить ко всем, кроме private
        super.address = address; // обращение к полям класса-родителя
        super.fio = address;     // обращение к полям класса-родителя

    }
    // переопределение метода
    @Override
    protected void sleep () {
        super.sleep();
        System.out.println("Student is sleeping");
    }

    // собственный метод класса
    public void study() {
        System.out.println("I'm studying");
    }

    @Override
    public String toString() {
        return "Student{" +
                "school=" + school +
                ", fio='" + fio + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
