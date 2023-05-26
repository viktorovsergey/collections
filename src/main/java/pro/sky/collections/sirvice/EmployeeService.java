package pro.sky.collections.sirvice;
import org.springframework.stereotype.Service;
import pro.sky.collections.Employee;
import pro.sky.collections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections.exceptions.EmployeeNotFoundException;
import pro.sky.collections.exceptions.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeService {
    private static final int MAX_COLLECTION_SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    public Employee addEmployee(String lastName, String firstName, int department, int wage) {
        if (employees.size() > MAX_COLLECTION_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var key = (firstName + " " + lastName).toLowerCase();
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            Employee employee = new Employee(lastName, firstName, department, wage);
            employees.put(key, employee);
            System.out.println("Добавлена запись " + key);
            return employee;
        }
    }
    public Employee delEmployee(String lastName, String firstName) {
        var key = (firstName + " " + lastName).toLowerCase();
        var removed = employees.remove(key);
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
        System.out.println("Удалена запись" + key);
        return removed;
    }
    public Employee findEmployee(String lastName, String firstName) {
        var key = (firstName + " " + lastName).toLowerCase();
        var find = employees.get(key);
        if (find == null) {
            throw new EmployeeNotFoundException();
        }
        System.out.println("Найдена запись" + key);
        return find;
    }
    public Collection<Employee> getEmployee() {

        return employees.values();
    }
}





