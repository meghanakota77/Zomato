package com.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.consumer.entity.Product;

public interface ProductQueryRepository extends JpaRepository<Product,Integer> {

}
