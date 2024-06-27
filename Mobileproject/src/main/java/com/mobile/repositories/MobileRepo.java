package com.mobile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobile.entities.Mobile;

public interface MobileRepo  extends JpaRepository<Mobile,Integer>{
	 List<Mobile> findByEmployeeId(Integer employeeId);

}
