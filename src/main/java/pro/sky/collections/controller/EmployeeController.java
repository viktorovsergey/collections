package pro.sky.collections.controller;

import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections.sirvice.EmployeeService;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String adding(@RequestParam String lastName, @RequestParam String firstName) {
        EmployeeService.addEmployee(lastName, firstName);
        return null;

    }

    @GetMapping(path = "/printList")
    public String adding() {
        EmployeeService.printEmployee();
        return null;
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam String lastName, @RequestParam String firstName) {
        EmployeeService.delEmployee(lastName, firstName);
        return null;
    }
    @GetMapping(path = "/find")
    public String find(@RequestParam String lastName, @RequestParam String firstName) {
        EmployeeService.findEmployee(lastName, firstName);
        return null;
    }
    @GetMapping(path = "/employee/add")
    public String add(@RequestParam String lastName, @RequestParam String firstName) {
        return  EmployeeService.addEmployee(lastName, firstName);


    }
}



