package com.zomato.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
	@Bean
	public NewTopic createTopic() {
		return TopicBuilder.name(AppConstants.LOCATION_TOPIC).partitions(3).build();
	}
}
