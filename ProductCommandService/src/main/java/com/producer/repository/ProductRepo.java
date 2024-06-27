package com.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.producer.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{
	
}
