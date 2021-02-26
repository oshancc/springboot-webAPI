package com.oshancc.springbootfirstapp.controller;

import com.oshancc.springbootfirstapp.model.Employee;
import com.oshancc.springbootfirstapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

   @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @PutMapping("/edit/{id}")
    public void updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
       Employee existEmployee = employeeService.findEmployee(id);
       existEmployee.setEmail(employee.getEmail());
        existEmployee.setImageUrl(employee.getImageUrl());
        existEmployee.setJobTitle(employee.getJobTitle());
        existEmployee.setName(employee.getName());
        existEmployee.setPhone(employee.getPhone());
        employeeService.updateEmployee(existEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Long id){
        return employeeService.findEmployee(id);
    }

}
