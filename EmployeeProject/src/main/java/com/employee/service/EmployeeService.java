package com.employee.service;



import java.util.List;

import com.employee.entities.Employee;
import com.employee.entities.Mobile;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id);
    
    
}

