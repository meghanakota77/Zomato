package com.sim.entities;



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
public class Sim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer simId;
	private String simName;
	private Integer mobileId;
}
