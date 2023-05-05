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
    public static int maxCollectionSize = 10;

    public static Employee addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        int collectionSize = Employee.employees.size();
        if (collectionSize < maxCollectionSize) {
            if (Employee.employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            Employee.employees.add(employee);
            System.out.println("Добавлена запись" + employee.toString());
        } else {
            throw new EmployeeStorageIsFullException();
        }
        return employee;
    }

    public static String printEmployee() {
        for (int i = 0; i < Employee.employees.size(); i++) {
            System.out.println("Фамилия " + Employee.employees.get(i).getLastName() + "Имя " + Employee.employees.get(i).getFirstName());
        } 
        return null;
    }

    public static Employee delEmployee(String lastName, String firstName) {
       Employee tempEmployee =new Employee(lastName,firstName);
        if (!Employee.employees.contains(tempEmployee)){
            throw new EmployeeNotFoundException();
        }else {
            Employee.employees.remove(tempEmployee);
            System.out.println("Удалена запись " + tempEmployee.toString());
        }
        return tempEmployee;
    }


    public static Employee findEmployee(String lastName, String firstName) {
        Employee tempEmployee =new Employee(lastName,firstName);
        if (Employee.employees.contains(tempEmployee)){
            System.out.println("Искомый элемент "+ tempEmployee+" присутствует в списке ");
        }else {
            throw new EmployeeNotFoundException();
        }
        return tempEmployee;
    }
}




