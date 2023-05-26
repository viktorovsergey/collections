package pro.sky.collections.sirvice;

import org.springframework.stereotype.Service;
import pro.sky.collections.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public Employee max(int department){
        return employeeService.getEmployee()
                .stream()
                .filter(employee -> employee.getDepartment()==department)
                .max(Comparator.comparing(Employee::getWage))
                .orElse(null);
    }
    public Employee min(int department){
        return employeeService.getEmployee()
                .stream()
                .filter(employee -> employee.getDepartment()==department)
                .min(Comparator.comparing(Employee::getWage))
                .orElse(null);
    }
    public Collection<Employee> all(int department) {
        return employeeService.getEmployee()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    public Map<Integer, List<Employee>> all() {
        return employeeService.getEmployee()
                .stream()
                .collect(groupingBy(Employee::getDepartment));
    }
}
