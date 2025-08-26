package exercise.Vebinar13_25_08_08;

public class Example1 {

    public static void main(String[] args) {
        // выможете получить доступ к унаследованным методам как к обычным
        Student student = new Student("Alex", new School());
        student.sleep();

        Employee employee = new Employee("Emp");
        employee.sleep();
    }
}
// классы и интерфейсы не могут быть protected
class Person {
    private String id;
    // инкапсуляция
    private int age;
    public String name;
    protected String address; // защищённая, имеют доступ классы-наследники
    // final методы не могут быть наследованы
    public Person(String name) {this.name = name;}
    // геттер
    public int getAge(){ return age;}
    // сеттер
    public void setAge(int age) {this.age = age;}
    // protected могут быть доступны только подклассам в другом пакете
    public void sleep() {}
}

// java поддерживает наследование с помощью ключевого слова extends (расширяет)
// конструкторы не наследуются
// конструкторы могут быть повторно использованы дочерними классами

class Student extends Person {
    private School school;
    // вызов конструктора должен быть первым
    public Student(String name, School school) {
        // super означает обращение к классу-родителю (здесь к переменной)
        super(name);
        this.school = school;
    }
}

class Employee extends Person {
    public Employee(String name) {
        super(name);
    }
    void fire(String reasons) {
        // super не указывает ни на какой объект, не может быть передан как аргумент
        System.out.println(super.name + " got fired because " + reasons);
    }
}

class CollegeStudent extends Student{

    public CollegeStudent(String name, School school) {
        super(name, school);
    }
}

class School {}