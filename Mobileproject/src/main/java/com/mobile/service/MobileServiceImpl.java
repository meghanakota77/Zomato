package com.mobile.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.entities.Mobile;
import com.mobile.repositories.MobileRepo;

@Service
public class MobileServiceImpl implements MobileService {
	@Autowired
	private MobileRepo mobileRepo;
	@Autowired
	private SimClient simClient;

	@Override
	public Mobile add(Mobile mobile) {
		return mobileRepo.save(mobile);

	}

	@Override
	public List<Mobile> getAllMobiles() {

		List<Mobile> mobiles = mobileRepo.findAll();
		List<Mobile> newMobileList = mobiles.stream().map(mobile -> {
			mobile.setSims(simClient.getSimsOfMobileId(mobile.getMobileId()));
			return mobile;
		}).collect(Collectors.toList());
		return newMobileList;
	}

	@Override
	public Mobile getMobileById(Integer id) {

		Mobile mobile = mobileRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Mobile not found with id: " + id));
		mobile.setSims(simClient.getSimsOfMobileId(mobile.getMobileId()));
		return mobile;
	}

	@Override
	public List<Mobile> getMobilesByEmployeeId(Integer employeeId) {
		 List<Mobile> findByEmployeeId = mobileRepo.findByEmployeeId(employeeId);
		 List<Mobile> collect = findByEmployeeId.stream().map(sim-> {
				sim.setSims(simClient.getSimsOfMobileId(sim.getMobileId()));
				return sim;
			}).collect(Collectors.toList());
		return   collect;
	}

	

}
