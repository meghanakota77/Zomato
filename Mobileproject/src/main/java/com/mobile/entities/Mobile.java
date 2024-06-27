package com.mobile.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mobileId;
	private String mobileName;
	private Integer employeeId;
	transient List<Sim> Sims;
	
}
