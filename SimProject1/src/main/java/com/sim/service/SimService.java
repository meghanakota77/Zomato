package com.sim.service;

import java.util.List;

import com.sim.entities.Sim;

;

public interface SimService {
	public Sim add(Sim sim);

	public List<Sim> getAllSims();

	public Sim getSimById(Integer id);

	public List<Sim> getSimByMobileId(Integer mobileId);
}
