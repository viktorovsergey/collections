package pro.sky.collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections.Employee;
import pro.sky.collections.sirvice.EmployeeService;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/add")
    public Employee adding(@RequestParam String lastName, @RequestParam String firstName) {
        return  EmployeeService.addEmployee(lastName,firstName);
    }
    @GetMapping(path = "/printList")
    public String print() {
        System.out.println("_______________________________");
        EmployeeService.printEmployee();
        System.out.println("_______________________________");
        return null;
    }
    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam String lastName, @RequestParam String firstName) {
         return EmployeeService.delEmployee(lastName,firstName);
    }
    @GetMapping(path = "/find")
    public Employee find(@RequestParam String lastName, @RequestParam String firstName) {
        return EmployeeService.findEmployee(lastName, firstName);
    }
    @GetMapping(path = "/all")
    public Collection<Employee> printAll() {
        return new ArrayList<>(Employee.employees);
    }

}



