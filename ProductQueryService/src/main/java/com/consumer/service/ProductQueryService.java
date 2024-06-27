package com.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


import com.consumer.entity.Product;
import com.consumer.repository.ProductQueryRepository;
import com.producer.dto.ProductEvent;


@Service
public class ProductQueryService {
@Autowired
private ProductQueryRepository repo;
 
public List<Product> getAllProducts(){
	return repo.findAll();
}
	@KafkaListener(topics="product-event-topic",groupId="product-event-group")
	public void proceessedEvents(ProductEvent productEvent) {
		Product product=productEvent.getProduct();
		if(productEvent.getEventType().equals("CreateEvent")) {
			repo.save(product);
			
		}
		if(productEvent.getEventType().equals("UpdateEvent")) {
			Product existingProduct=repo.findById(product.getId()).get();
			existingProduct.setName(product.getName());
			existingProduct.setDescription(product.getDescription());
			existingProduct.setPrice(product.getPrice());
			repo.save(existingProduct);
	}
}
}