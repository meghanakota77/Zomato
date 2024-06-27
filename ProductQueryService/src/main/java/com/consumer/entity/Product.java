package com.consumer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PRODUCT_QUERY")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private Integer id;
 private String name;
 private String description;
 private Double price;


	
}
