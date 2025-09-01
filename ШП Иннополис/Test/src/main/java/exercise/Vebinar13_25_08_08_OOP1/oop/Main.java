package exercise.Vebinar13_25_08_08_OOP1.oop;

public class Main {
    public static void main(String[] args) {
        School school = new School("School 556", "Saint-Petersburg");
        School school1 = new School("School 556");
        School school2 = new School("School 556", "Saint-Petersburg");

        Person p = new Person("", ""); // не можем привести к Student
        Person myPerson = new Student("Gavrilov Andrey", "Bishkek", school);
        System.out.println(myPerson);
        myPerson.sleep();
        ((Student) myPerson).study();
        // myPerson.study(); - т.к. тип объекта - Person
    }
}
