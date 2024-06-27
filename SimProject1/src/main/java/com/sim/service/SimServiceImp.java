package com.sim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sim.entities.Sim;
import com.sim.repositories.SimRepo;

@Service
public class SimServiceImp implements SimService {
	@Autowired
	private SimRepo simRepo;
	@Override
	public Sim add(Sim sim) {
		// TODO Auto-generated method stub
		return  simRepo.save(sim);
	}

	@Override
	public List<Sim> getAllSims() {
		// TODO Auto-generated method stub
		return simRepo.findAll();	}

	@Override
	public Sim getSimById(Integer id) {
		// TODO Auto-generated method stub
		return simRepo.findById(id).orElseThrow(() -> new RuntimeException("simmid not found"));
	}

	@Override
	public List<Sim> getSimByMobileId(Integer mobileId) {
		// TODO Auto-generated method stub
		return simRepo.findByMobileId(mobileId);
	}

	public SimServiceImp(SimRepo simRepo) {
		super();
		this.simRepo = simRepo;
	}
	

}
