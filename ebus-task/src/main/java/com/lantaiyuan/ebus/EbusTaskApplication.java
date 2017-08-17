package com.lantaiyuan.ebus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EbusTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbusTaskApplication.class, args);
	}
	
}
