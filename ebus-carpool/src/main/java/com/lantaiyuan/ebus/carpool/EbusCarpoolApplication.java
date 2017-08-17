package com.lantaiyuan.ebus.carpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lantaiyuan.ebus.carpool.configure.Swagger2Configuration;


@SpringBootApplication
public class EbusCarpoolApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EbusCarpoolApplication.class, args);
	}
	
	@Bean
	public Swagger2Configuration getSwagger2Configuration() {
		return new Swagger2Configuration();
	}
	
}
