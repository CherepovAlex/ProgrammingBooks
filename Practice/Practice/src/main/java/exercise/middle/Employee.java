package exercise.middle;

//Реализуйте класс Employee, который будет представлять сотрудника компании. Класс должен содержать поля name,
// salary и department, а также методы для повышения зарплаты, перевода в другой отдел и вывода информации о сотруднике.

public class Employee {
}

class EmployeeTest {
    private String name;
    private double salary;
    private String department;

    public EmployeeTest(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public void raiseSalary(double amount) {
        if (amount > 0) {
            salary += amount;
        }
    }

    public void changeDepartment(String newDepartment) {
        if (newDepartment != null && !newDepartment.isEmpty()) {
            department = newDepartment;
        }
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", Salary: " + salary + ", Department: " + department);
    }

    public static void main(String[] args) {
        EmployeeTest emp = new EmployeeTest("John Doe", 50000, "IT");
        emp.printInfo();
        emp.raiseSalary(5000);
        emp.changeDepartment("HR");
        emp.printInfo();
    }
}
