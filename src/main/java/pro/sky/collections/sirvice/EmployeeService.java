package pro.sky.collections.sirvice;

import org.springframework.stereotype.Service;
import pro.sky.collections.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections.exceptions.EmployeeNotFoundException;
import pro.sky.collections.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    public static int maxCollectionSize = 3;
    static ArrayList<String> employeersList = new ArrayList<>();
    public static String addEmployee(String lastName, String firstName) {
        String newEmployee = lastName + firstName;
        int collectionSize= employeersList.size();
        if (collectionSize<maxCollectionSize){
            if (EmployeeService.employeersList.contains(newEmployee)) {
                throw new EmployeeAlreadyAddedException();
            }
                employeersList.add(newEmployee);
            } else {
                throw new EmployeeStorageIsFullException();
            }

        return employeersList.get(0);

        }
    public static String printEmployee() {
        for (int i = 0; i < employeersList.size(); i++) {
            System.out.println("employeerList(" + i + ")= " + employeersList.get(i));
        }
        System.out.println(employeersList);
        return null;
    }
    public static void delEmployee(String lastName, String firstName) {
       String delEmployee = lastName+firstName;
        EmployeeService.employeersList.remove(delEmployee);
    }
    public static void findEmployee(String lastName, String firstName) {
        String findEmployee = lastName+firstName;
        if (EmployeeService.employeersList.contains(findEmployee)){
            System.out.println("Искомый элемент "+ findEmployee+" присутствует в списке ");
        }else {
            throw new EmployeeNotFoundException();
        }
    }
}




