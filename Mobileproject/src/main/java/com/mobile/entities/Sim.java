package com.mobile.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Sim {

	private Integer simId;
	private String simName;
	private Integer mobileId;
}
