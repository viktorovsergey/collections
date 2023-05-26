package pro.sky.collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections.sirvice.DepartmentService;

@RestController
@RequestMapping("/department")

public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/Min")
    public void minWage(@RequestParam int department) {

    }

    @GetMapping("/Max")
    public void maxWage(@RequestParam int department) {

    }

    @GetMapping("/All")
    public void allDepartment(@RequestParam int department) {

    }

    @GetMapping("/All")
    public void all() {

    }
}

