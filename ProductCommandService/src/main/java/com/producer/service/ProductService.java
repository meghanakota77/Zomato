package com.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.producer.dto.ProductEvent;
import com.producer.entity.Product;
import com.producer.repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private KafkaTemplate<String, Object> template;

	public Product saveProduct(ProductEvent productEvent) {
		Product savedProduct = productRepo.save(productEvent.getProduct());
		ProductEvent event = new ProductEvent("CreateEvent",savedProduct);
		template.send("product-event-topic", event);
		return savedProduct;
	}

	public Product updateProduct(Integer id, ProductEvent productEvent) {
		Product existingProduct = productRepo.findById(id).get();
		Product product = productEvent.getProduct();
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		productRepo.save(existingProduct);
		ProductEvent event = new ProductEvent("UpdateEvent", existingProduct);
		template.send("product-event-topic", event);
		return existingProduct;
	}
}
