package com.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producer.dto.ProductEvent;
import com.producer.entity.Product;
import com.producer.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/")
	public Product addProduct(@RequestBody ProductEvent product) {
		return productService.saveProduct(product);
	}

	@PutMapping("/{id}")
	public Product modifyProduct(@PathVariable Integer id, @RequestBody ProductEvent product) {
		return productService.updateProduct(id, product);
	}
}
