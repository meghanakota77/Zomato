
package com.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springdoc.core.models.GroupedOpenApi;
@Configuration

public class SpringDocConfig {

	@Bean
	public GroupedOpenApi controllerApi() {
		return GroupedOpenApi.builder().group("employee-api").packagesToScan("com.employee.controller") 
		.build();
	}

}
