package com.oshancc.springbootfirstapp.service;

import com.oshancc.springbootfirstapp.exeption.UserNotFoundExeption;
import com.oshancc.springbootfirstapp.model.Employee;
import com.oshancc.springbootfirstapp.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {

        this.employeeRepo = employeeRepo;
    }

    public void addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){

        return employeeRepo.findAll();
    }

    public void updateEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){

        employeeRepo.deleteById(id);
    }

    public Employee findEmployee(Long id){
        //return employeeRepo.findById(id).get();
        return employeeRepo.findById(id).orElseThrow(() -> new UserNotFoundExeption("User by id" + id + "was not found"));
    }
}
