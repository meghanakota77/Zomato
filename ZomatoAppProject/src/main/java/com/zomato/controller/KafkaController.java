package com.zomato.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zomato.service.KafkaService;

@RestController
@RequestMapping("/location")
public class KafkaController {

	@Autowired
	private KafkaService kafkaService;
	
	@PostMapping("/update")
	public ResponseEntity<?> updateLocation(){
		for(int i=1;i<10000;i++) {
		kafkaService.updateLocation(" ( "+(int)(Math.random()*100)+" , "+(int)(Math.random()*100)+" )");
		}
		return new ResponseEntity<> (Map.of("Message", "Produced Successfully"), HttpStatus.OK);
	}
}
