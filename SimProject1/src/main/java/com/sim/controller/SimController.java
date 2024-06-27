package com.sim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sim.entities.Sim;
import com.sim.service.SimService;

@RestController
@RequestMapping("/sim")
public class SimController {
	@Autowired
	private SimService simService;

	@PostMapping("/")
	public Sim addSim(@RequestBody Sim sim) {
		return simService.add(sim);
	}

	@GetMapping("/")
	public List<Sim> getAllSims() {
		return simService.getAllSims();
	}

	@GetMapping("/{id}")
	public Sim getSimById(@PathVariable Integer id) {
		return simService.getSimById(id);
	}

	@GetMapping("/mobile/{mobileId}")
	public List<Sim> getSimByMobileId(@PathVariable Integer mobileId) {
		return simService.getSimByMobileId(mobileId);
	}
}
