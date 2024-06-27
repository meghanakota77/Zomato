package com.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.entity.Product;
import com.consumer.service.ProductQueryService;

@RestController
@RequestMapping("/product")
public class ProductQueryController {
	@Autowired
	private ProductQueryService queryService;
	@GetMapping("/")
	public List<Product> fetchAlProduct(){
		return queryService.getAllProducts();
	}

}
