package com.example.demo.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "api/v1/Employee")
public class EmployeeController {
    private EmployeeBsl employeeBsl;

    @Autowired
    EmployeeController(EmployeeBsl employeeBsl) {
        this.employeeBsl = employeeBsl;
    }

    @PostMapping(value = "/New")
    public String createNewEmployee(@RequestBody Employee employee){
        return employeeBsl.createNewEmployee(employee);
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeeBsl.deleteEmployee(id);
    }

    @PostMapping(value = "/update")
    public String updateEmployee(@RequestBody Employee employee) {
        return employeeBsl.updateEmployee(employee);
    }

    // Get Employee info Using ID
    @GetMapping(value = "/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeBsl.getEmployeeById(id);
    }

    // Get Employee Name Using ID
    @GetMapping(value = "/getEmployeeNameById/{id}")
    public String getEmployeeNameById(@PathVariable int id) {
        return employeeBsl.getEmployeeNameById(id);
    }

    // Get Employee Name Using ID
    @GetMapping(value = "/getAllEmployees")
    public ArrayList<Employee> getAllEmployees() {
        return employeeBsl.getAllEmployees();
    }
}
