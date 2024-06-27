package com.zomato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public boolean updateLocation(String location) {
		kafkaTemplate.send(AppConstants.LOCATION_TOPIC, location);
		return true;
	}
}
