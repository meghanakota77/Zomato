package com.mobile.service;

import java.util.List;

import com.mobile.entities.Mobile;

public interface MobileService {
	public Mobile add(Mobile mobile);

	public List<Mobile> getAllMobiles();

	public Mobile getMobileById(Integer id);

	public List<Mobile> getMobilesByEmployeeId(Integer employeeId);

}
