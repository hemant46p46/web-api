package com.ex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.model.Employee;
import com.ex.service.EmployeeService;

@RestController
//@RequestMapping("/emp-api")
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://127.0.0.1:5500")// Adjust for front-end, But in future can be changed where front-end is hosted url
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    
    @GetMapping("/welcome")
    public String welcome() {
    	return "Welcome to employee api";
    }
    
//    @GetMapping("/employees")
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

//    @PostMapping("/employees")
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

//    @DeleteMapping("/employees/{id}")
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}
