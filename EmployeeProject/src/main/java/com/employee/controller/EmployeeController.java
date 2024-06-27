package com.employee.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.Employee;
import com.employee.entities.Mobile;
import com.employee.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@GetMapping("/")
	@CircuitBreaker(name = "mobileBreaker", fallbackMethod = "mobileAllFallback")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	public Employee mobileFallback(Integer id, Exception ex) {
		//logger.info("Fallback Method executing because service is down: {}"+ex.getMessage());
		Employee employee1 = new Employee();
		Mobile mobile1 = new Mobile();
		Mobile mobile2 = new Mobile();
		mobile1.setMobileName("samsung");
		mobile1.setMobileId(0);
		mobile1.setEmployeeId(id);
		mobile2.setMobileId(0);
		mobile2.setMobileName("samsung");
		mobile2.setMobileId(0);
		mobile2.setEmployeeId(id);
		employee1.setEmployeeName("megahan");
		employee1.setEmployeeId(id);
		employee1.setMobiles(Arrays.asList(mobile1, mobile2));
		return employee1;
	}

	public List<Employee> mobileAllFallback(Exception ex) {
		//logger.info("Fallback Method executing because service is down: {}" +ex.getMessage());
		Employee employee1 = new Employee();
		Mobile mobile1 = new Mobile();
		Mobile mobile2 = new Mobile();
		mobile1.setMobileName("samsung");
		mobile1.setMobileId(0);
		mobile1.setEmployeeId(0);
		mobile2.setMobileId(0);
		mobile2.setMobileName("samsung");
		mobile2.setMobileId(0);
		mobile2.setEmployeeId(0);
		employee1.setEmployeeName("megahan");
		employee1.setEmployeeId(0);
		employee1.setMobiles(Arrays.asList(mobile1, mobile2));
		 List<Employee> asList = Arrays.asList(employee1);
		return asList;
	}

	int retryCount = 1;

	@GetMapping("/{id}")
	//@CircuitBreaker(name = "mobileBreaker", fallbackMethod = "mobileFallback")
	@Retry(name = "mobileRetry", fallbackMethod = "mobileFallback")
	public Employee getEmployeeById(@PathVariable Integer id) {
		logger.info("Retry count:{}", retryCount);
		retryCount++;
		return employeeService.getEmployeeById(id);
	}
}
