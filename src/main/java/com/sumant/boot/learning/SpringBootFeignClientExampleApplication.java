package com.sumant.boot.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootFeignClientExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFeignClientExampleApplication.class, args);
	}

}
