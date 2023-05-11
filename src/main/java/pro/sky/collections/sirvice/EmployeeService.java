package pro.sky.collections.sirvice;

import org.springframework.stereotype.Service;
import pro.sky.collections.Employee;
import pro.sky.collections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections.exceptions.EmployeeNotFoundException;
import pro.sky.collections.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MaxCollectionSize = 10;
    public final ArrayList<Employee> employees = new ArrayList<Employee>();


    public Employee addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        if (employees.size() > MaxCollectionSize) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.add(employee);
            System.out.println("Добавлена запись" + employee.toString());
            return employee;
        }
    }

    public Employee delEmployee(String lastName, String firstName) {
        Employee tempEmployee = new Employee(lastName, firstName);
        if (employees.contains(tempEmployee)) {
            employees.remove(tempEmployee);
            System.out.println("Удалена запись" + tempEmployee.toString());
          return tempEmployee;
        }
            throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String lastName, String firstName) {
        Employee tempEmployee = new Employee(lastName, firstName);
        if (employees.contains(tempEmployee)) {
            System.out.println("Найдена запись" + tempEmployee.toString());
            return tempEmployee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    public List<Employee> printEmployees(){
        return employees;
    }

}




