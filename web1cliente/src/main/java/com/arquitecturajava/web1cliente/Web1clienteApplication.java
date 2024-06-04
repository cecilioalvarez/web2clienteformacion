package com.arquitecturajava.web1cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Web1clienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(Web1clienteApplication.class, args);
	}

	@Bean
	public RestTemplate getPlantilla() {
		
		return new RestTemplate();
	}
}
