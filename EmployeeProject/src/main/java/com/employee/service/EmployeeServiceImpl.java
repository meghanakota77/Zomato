package com.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entities.Employee;
import com.employee.repositories.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private MobileClient mobileClient;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepo.findAll();
		List<Employee> newEmployeeList = employees.stream().map(employee -> {
			employee.setMobiles(mobileClient.getMobilesOfEmployeeId(employee.getEmployeeId()));
			return employee;
		}).collect(Collectors.toList());
		return employees;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
		employee.setMobiles(mobileClient.getMobilesOfEmployeeId(employee.getEmployeeId()));
		return employee;
	}

}
