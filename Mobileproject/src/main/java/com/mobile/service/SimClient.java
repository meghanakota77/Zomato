package com.mobile.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mobile.entities.Sim;

@FeignClient(url = "http://localhost:8083", value = "Sim-Client")
public interface SimClient {
	@GetMapping("/sim/mobile/{mobileId}")
	
	    List<Sim> getSimsOfMobileId(@PathVariable Integer mobileId); 
		// TODO Auto-generated method stub
		
	
}