package com.employee.entities;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {

	private Integer mobileId;
	private String mobileName;
	private Integer employeeId;
	transient List<Sim> Sims;
}
