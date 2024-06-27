package com.sim.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sim.entities.Sim;



public interface SimRepo  extends JpaRepository<Sim,Integer>{
	 
		 List<Sim> findByMobileId(Integer mobileId);

	}


