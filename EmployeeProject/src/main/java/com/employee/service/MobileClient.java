package com.employee.service;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee.entities.Mobile;

 
@FeignClient(url = "http://localhost:8081", value = "Mobile-Client")
public interface MobileClient {
    @GetMapping("/mobile/employee/{employeeId}")
    List<Mobile> getMobilesOfEmployeeId(@PathVariable Integer employeeId);

	
}

