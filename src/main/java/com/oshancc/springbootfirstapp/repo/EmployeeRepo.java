package com.oshancc.springbootfirstapp.repo;

import com.oshancc.springbootfirstapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
