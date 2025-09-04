package exercise.Vebinar20_25_09_03_AbstractClassNInterfaces.Generics;

import java.util.List;

public class EmployeeRepository implements GenericRepository<Employee> {


    @Override
    public Employee getById(Integer id) {
        Employee employee = new Employee();
//        Connection connection = Connection.connect();
//        connection.executeQuery("select * from employees where id = ?", id, employee);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return List.of();
    }

    @Override
    public Employee create(Employee newRow) {
        return null;
    }

    @Override
    public Employee update(Employee update, Integer id) {
        return null;
    }

    @Override
    public void delete(Employee entity) {

    }
}
